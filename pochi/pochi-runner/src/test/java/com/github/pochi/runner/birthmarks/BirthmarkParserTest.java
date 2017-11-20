package com.github.pochi.runner.birthmarks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.github.pochi.kunai.entries.ClassName;
import com.github.pochi.kunai.source.DataSource;
import com.github.pochi.kunai.source.factories.DefaultDataSourceFactory;
import com.github.pochi.runner.birthmarks.entities.Birthmark;
import com.github.pochi.runner.birthmarks.entities.Birthmarks;
import com.github.pochi.runner.birthmarks.entities.Element;
import com.github.pochi.runner.birthmarks.parsers.DefaultBirthmarkParser;
import com.github.pochi.runner.config.ConfigurationBuilder;

public class BirthmarkParserTest {
    public Birthmarks read(String path) throws Exception{
        BirthmarkParser reader = new DefaultBirthmarkParser();
        DataSource source = new DefaultDataSourceFactory().build(Paths.get(path));
        return reader.parse(source, new ConfigurationBuilder().configuration());
    }

    @Test
    public void testBasic() throws Exception{
        Birthmarks birthmarks = read("target/test-classes/resources/commons-cli-1.1-uc.csv");

        assertThat(birthmarks.find(new ClassName("org.apache.commons.cli.Options")).isPresent(), is(true));

        List<Birthmark> list = birthmarks.stream().collect(Collectors.toList());
        assertThat(list.size(), is(22));

        List<Element> elements = new ArrayList<>();
        birthmarks.find(new ClassName("org.apache.commons.cli.Options"))
        .ifPresent(birthmark -> birthmark.forEach(item -> elements.add(item)));

        assertThat(elements.size(), is(15));
        assertThat(elements.get( 0), is(new Element("java.lang.Object")));
        assertThat(elements.get( 1), is(new Element("java.lang.String")));
        assertThat(elements.get( 2), is(new Element("java.lang.StringBuffer")));
        assertThat(elements.get( 3), is(new Element("java.util.ArrayList")));
        assertThat(elements.get( 4), is(new Element("java.util.Collection")));
        assertThat(elements.get( 5), is(new Element("java.util.Collections")));
        assertThat(elements.get( 6), is(new Element("java.util.HashMap")));
        assertThat(elements.get( 7), is(new Element("java.util.HashSet")));
        assertThat(elements.get( 8), is(new Element("java.util.Iterator")));
        assertThat(elements.get( 9), is(new Element("java.util.List")));
        assertThat(elements.get(10), is(new Element("java.util.Map")));
        assertThat(elements.get(11), is(new Element("org.apache.commons.cli.Option")));
        assertThat(elements.get(12), is(new Element("org.apache.commons.cli.OptionGroup")));
        assertThat(elements.get(13), is(new Element("org.apache.commons.cli.Options")));
        assertThat(elements.get(14), is(new Element("org.apache.commons.cli.Util")));
    }
}
