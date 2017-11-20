package com.github.pochi.runner.birthmarks.comparators;

import java.util.HashSet;
import java.util.Set;

import com.github.pochi.runner.birthmarks.entities.Birthmark;
import com.github.pochi.runner.birthmarks.entities.Element;

public abstract class IndexBirthmarkComparator extends AbstractBirthmarkComparator {
    public IndexBirthmarkComparator(ComparatorType type){
        super(type);
    }

    Set<Element> union(Birthmark left, Birthmark right){
        Set<Element> union = new HashSet<>();
        left.forEach(union::add);
        right.forEach(union::add);
        return union;
    }

    Set<Element> intersect(Birthmark left, Birthmark right){
        Set<Element> intersection = new HashSet<>();
        right.filter(left::contains)
            .forEach(intersection::add);
        return intersection;
    }
}
