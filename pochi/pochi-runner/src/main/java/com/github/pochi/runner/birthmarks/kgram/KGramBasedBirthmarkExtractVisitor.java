package com.github.pochi.runner.birthmarks.kgram;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import com.github.pochi.kunai.entries.Entry;
import com.github.pochi.runner.birthmarks.PochiClassVisitor;
import com.github.pochi.runner.birthmarks.entities.Birthmark;
import com.github.pochi.runner.birthmarks.entities.BirthmarkType;
import com.github.pochi.runner.birthmarks.entities.Elements;
import com.github.pochi.runner.birthmarks.entities.Metadata;
import com.github.pochi.runner.config.Configuration;

public class KGramBasedBirthmarkExtractVisitor extends PochiClassVisitor {
    private Map<String, List<Integer>> opcodes = new LinkedHashMap<>();
    private KGramBuilder<Integer> builder;

    public KGramBasedBirthmarkExtractVisitor(ClassVisitor parent, Configuration context, BirthmarkType type, int kvalue) {
        super(parent, context, type);
        builder = new KGramBuilder<>(kvalue);
    }

    @Override
    public Birthmark build(Entry entry) {
        Metadata metadata = Metadata.build(entry, type());
        return new Birthmark(metadata, buildElements(opcodes));
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        List<Integer> list = createList(name + desc);
        return createVisitor(access, name, desc, signature, exceptions, list);
    }

    private List<Integer> createList(String key){
        List<Integer> list = opcodes.getOrDefault(key, new ArrayList<>());
        opcodes.put(key, list);
        return list;
    }

    private MethodVisitor createVisitor(int access, String name, String desc, String signature, String[] exceptions, List<Integer> list) {
        MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);
        return new OpcodeExtractionMethodVisitor(visitor, list);
    }

    private Elements buildElements(Map<String, List<Integer>> map){
        return map.values()
                .stream().map(this::toElements)
                .reduce(Elements.empty(), Elements::merge);
    }

    private Elements toElements(List<Integer> list){
        return new Elements(builder.build(list)
                .map(KGram::toElement));
    }
}
