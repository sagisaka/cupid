package com.github.pochi.runner.birthmarks.kgram;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.objectweb.asm.Opcodes;

import com.github.pochi.kunai.entries.ClassName;
import com.github.pochi.kunai.source.DataSource;
import com.github.pochi.kunai.source.factories.DefaultDataSourceFactory;
import com.github.pochi.runner.birthmarks.BirthmarkExtractor;
import com.github.pochi.runner.birthmarks.BirthmarkExtractors;
import com.github.pochi.runner.birthmarks.entities.Birthmark;
import com.github.pochi.runner.birthmarks.entities.BirthmarkType;
import com.github.pochi.runner.birthmarks.entities.Birthmarks;
import com.github.pochi.runner.birthmarks.entities.Element;
import com.github.pochi.runner.config.ConfigurationBuilder;

public class KGramBasedBirthmarkExtractorTest {
    public Birthmarks extract(String path, String type) throws Exception{
        URL location = getClass().getResource(path);
        BirthmarkExtractor extractor = new BirthmarkExtractors().service(new BirthmarkType(type));
        DataSource source = new DefaultDataSourceFactory().build(Paths.get(location.toURI()));
        return extractor.extract(source, new ConfigurationBuilder().configuration());
    }

    @Test
    public void testBasic() throws Exception{
        Birthmarks birthmarks = extract("/resources/HelloWorld.class", "2-gram");

        assertThat(birthmarks.find(new ClassName("HelloWorld")).isPresent(), is(true));

        List<Birthmark> list = birthmarks.stream().collect(Collectors.toList());
        assertThat(list.size(), is(1));

        List<Element> elements = new ArrayList<>();
        list.get(0).forEach(item -> elements.add(item));

        assertThat(elements.size(), is(5));
        assertThat(elements.get(0), is(new Element("25 183")));  // aload(19) invokespecial(b7)
        assertThat(elements.get(1), is(new Element("183 177"))); // invokespecial(b7) return(b1)
        assertThat(elements.get(2), is(new Element("178 18")));  // getstatic(b2) ldc(12)
        assertThat(elements.get(3), is(new Element("18 182")));  // ldc(12) invokevirtual(b6)
        assertThat(elements.get(4), is(new Element("182 177"))); // invokevirtual(b6) return(b1)
    }

    @Test
    public void testBasic2() throws Exception{
        Birthmarks birthmarks = extract("/resources/Fibonacci.class", "3-gram");

        assertThat(birthmarks.find(new ClassName("Fibonacci")).isPresent(), is(true));

        List<Birthmark> list = birthmarks.stream().collect(Collectors.toList());
        assertThat(list.size(), is(1));

        List<Element> elements = new ArrayList<>();
        list.get(0).forEach(item -> elements.add(item));
        assertThat(elements.size(), is(40));

        // Constructor
        assertThat(elements.get(0), is(toElement(Opcodes.ALOAD, Opcodes.INVOKESPECIAL, Opcodes.RETURN)));

        // run method
        assertThat(elements.get(1), is(toElement(Opcodes.ALOAD, Opcodes.BIPUSH, Opcodes.INVOKEVIRTUAL)));
        assertThat(elements.get(2), is(toElement(Opcodes.BIPUSH, Opcodes.INVOKEVIRTUAL, Opcodes.ASTORE)));
        assertThat(elements.get(3), is(toElement(Opcodes.INVOKEVIRTUAL, Opcodes.ASTORE, Opcodes.ALOAD)));
        assertThat(elements.get(4), is(toElement(Opcodes.ASTORE, Opcodes.ALOAD, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(5), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEINTERFACE, Opcodes.ASTORE)));
        assertThat(elements.get(6), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.ASTORE, Opcodes.ALOAD)));
        assertThat(elements.get(7), is(toElement(Opcodes.ASTORE, Opcodes.ALOAD, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(8), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEINTERFACE, Opcodes.IFEQ)));
        assertThat(elements.get(9), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.IFEQ, Opcodes.ALOAD)));
        assertThat(elements.get(10), is(toElement(Opcodes.IFEQ, Opcodes.ALOAD, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(11), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEINTERFACE, Opcodes.CHECKCAST)));
        assertThat(elements.get(12), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.CHECKCAST, Opcodes.ASTORE)));
        assertThat(elements.get(13), is(toElement(Opcodes.CHECKCAST, Opcodes.ASTORE, Opcodes.GETSTATIC)));
        assertThat(elements.get(14), is(toElement(Opcodes.ASTORE, Opcodes.GETSTATIC, Opcodes.ALOAD)));
        assertThat(elements.get(15), is(toElement(Opcodes.GETSTATIC, Opcodes.ALOAD, Opcodes.INVOKEVIRTUAL)));
        assertThat(elements.get(16), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEVIRTUAL, Opcodes.GOTO)));
        assertThat(elements.get(17), is(toElement(Opcodes.INVOKEVIRTUAL, Opcodes.GOTO, Opcodes.RETURN)));

        // stream method
        assertThat(elements.get(18), is(toElement(Opcodes.ICONST_1, Opcodes.NEW, Opcodes.DUP)));
        assertThat(elements.get(19), is(toElement(Opcodes.NEW, Opcodes.DUP, Opcodes.ACONST_NULL)));
        assertThat(elements.get(20), is(toElement(Opcodes.DUP, Opcodes.ACONST_NULL, Opcodes.INVOKESPECIAL)));
        assertThat(elements.get(21), is(toElement(Opcodes.ACONST_NULL, Opcodes.INVOKESPECIAL, Opcodes.INVOKESTATIC)));
        assertThat(elements.get(22), is(toElement(Opcodes.INVOKESPECIAL, Opcodes.INVOKESTATIC, Opcodes.ARETURN)));

        // fibonacci method
        assertThat(elements.get(23), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEVIRTUAL, Opcodes.ILOAD)));
        assertThat(elements.get(24), is(toElement(Opcodes.INVOKEVIRTUAL, Opcodes.ILOAD, Opcodes.I2L)));
        assertThat(elements.get(25), is(toElement(Opcodes.ILOAD, Opcodes.I2L, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(26), is(toElement(Opcodes.I2L, Opcodes.INVOKEINTERFACE, Opcodes.INVOKEDYNAMIC)));
        assertThat(elements.get(27), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.INVOKEDYNAMIC, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(28), is(toElement(Opcodes.INVOKEDYNAMIC, Opcodes.INVOKEINTERFACE, Opcodes.INVOKESTATIC)));
        assertThat(elements.get(29), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.INVOKESTATIC, Opcodes.INVOKEINTERFACE)));
        assertThat(elements.get(30), is(toElement(Opcodes.INVOKESTATIC, Opcodes.INVOKEINTERFACE, Opcodes.CHECKCAST)));
        assertThat(elements.get(31), is(toElement(Opcodes.INVOKEINTERFACE, Opcodes.CHECKCAST, Opcodes.ARETURN)));

        // main method
        assertThat(elements.get(32), is(toElement(Opcodes.NEW, Opcodes.DUP, Opcodes.INVOKESPECIAL)));
        assertThat(elements.get(33), is(toElement(Opcodes.DUP, Opcodes.INVOKESPECIAL, Opcodes.ASTORE)));
        assertThat(elements.get(34), is(toElement(Opcodes.INVOKESPECIAL, Opcodes.ASTORE, Opcodes.ALOAD)));
        assertThat(elements.get(35), is(toElement(Opcodes.ASTORE, Opcodes.ALOAD, Opcodes.INVOKEVIRTUAL)));
        assertThat(elements.get(36), is(toElement(Opcodes.ALOAD, Opcodes.INVOKEVIRTUAL, Opcodes.RETURN)));

        // inner method
        assertThat(elements.get(37), is(toElement(Opcodes.NEW, Opcodes.DUP, Opcodes.ILOAD)));
        assertThat(elements.get(38), is(toElement(Opcodes.DUP, Opcodes.ILOAD, Opcodes.INVOKESPECIAL)));
        assertThat(elements.get(39), is(toElement(Opcodes.ILOAD, Opcodes.INVOKESPECIAL, Opcodes.ARETURN)));
    }

    private Element toElement(int... values){
        return KGramBuilder.from(values)
                .toElement();
    }

    @Test
    public void testBasic3() throws Exception{
        Birthmarks birthmarks = extract("/resources/MazeBuilder.class", "4-gram");

        assertThat(birthmarks.find(new ClassName("MazeBuilder")).isPresent(), is(true));

        List<Birthmark> list = birthmarks.stream().collect(Collectors.toList());
        assertThat(list.size(), is(1));

        List<Element> elements = new ArrayList<>();
        list.get(0).forEach(item -> elements.add(item));

        // assertThat(elements.size(), is(6));
    }

    @Test
    public void testBasic4() throws Exception{
        Birthmarks birthmarks = extract("/resources/MyServer2.class", "5-gram");

        assertThat(birthmarks.find(new ClassName("MyServer2")).isPresent(), is(true));

        List<Birthmark> list = birthmarks.stream().collect(Collectors.toList());
        assertThat(list.size(), is(1));

        List<Element> elements = new ArrayList<>();
        list.get(0).forEach(item -> elements.add(item));

        // assertThat(elements.size(), is(3));
    }
}
