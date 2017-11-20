package com.github.pochi.runner.birthmarks.comparators;

import java.util.Objects;
import java.util.stream.Stream;

import com.github.pochi.runner.birthmarks.BirthmarkComparator;
import com.github.pochi.runner.birthmarks.PairMaker;
import com.github.pochi.runner.birthmarks.entities.Birthmark;
import com.github.pochi.runner.birthmarks.entities.Birthmarks;
import com.github.pochi.runner.config.Configuration;

public abstract class AbstractBirthmarkComparator implements BirthmarkComparator{
    private ComparatorType type;

    public AbstractBirthmarkComparator(ComparatorType type){
        this.type = type;
    }

    @Override
    public Comparison compare(Birthmark left, Birthmark right, Configuration config){
        Similarity similarity = similarity(left, right, config);
        return new Comparison(left, right, similarity);
    }

    @Override
    public Comparisons compare(Birthmarks results, PairMaker maker, Configuration config){
        return new Comparisons(compareWith(results, maker, config));
    }

    @Override
    public Comparisons compare(Birthmarks birthmarks1, Birthmarks birthmarks2, PairMaker maker, Configuration config){
        return new Comparisons(compareWith(birthmarks1, birthmarks2, maker, config));
    }

    private Stream<Comparison> compareWith(Birthmarks extractedBirthmarks, PairMaker maker, Configuration config){
        return maker.pairUpWith(extractedBirthmarks)
                .map(pair -> compare(pair, config));
    }

    private Stream<Comparison> compareWith(Birthmarks birthmarks1, Birthmarks birthmarks2, PairMaker maker, Configuration config){
        return maker.pairUpWith(birthmarks1, birthmarks2)
                .map(pair -> compare(pair, config));
    }

    public boolean is(ComparatorType otherType){
        return Objects.equals(type, otherType);
    }

    @Override
    public ComparatorType type(){
        return type;
    }
}
