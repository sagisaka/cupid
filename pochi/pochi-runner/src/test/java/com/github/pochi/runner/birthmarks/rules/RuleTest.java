package com.github.pochi.runner.birthmarks.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.github.pochi.runner.birthmarks.rules.Position;
import com.github.pochi.runner.birthmarks.rules.Rule;
import com.github.pochi.runner.birthmarks.rules.Snippet;

public class RuleTest {
    @Test
    public void testStringConstructor() throws Exception{
        Rule rule = new Rule("prefix", "java.");

        assertThat(rule.match("java.lang.String"), is(true));
        assertThat(rule.match("javax.swing.JFrame"), is(false));

        assertThat(rule.toString(), is("PREFIX,java."));
    }

    @Test
    public void testObjectConstructor() throws Exception{
        Rule rule = new Rule(Position.EXACT, new Snippet("java.lang.String"));

        assertThat(rule.match("java.lang.String"), is(true));
        assertThat(rule.match("java.lang.Strings"), is(false));
        assertThat(rule.match("javax.swing.JFrame"), is(false));

        assertThat(rule.toString(), is("EXACT,java.lang.String"));
    }

    @Test
    public void testOthers() throws Exception{
        Rule rule1 = new Rule(Position.REGEX, new Snippet(".*[ST].*"));

        assertThat(rule1.match(getClass().getName()), is(true));
        assertThat(rule1.match("java.lang.Strings"), is(true));
        assertThat(rule1.match("javax.swing.JFrame"), is(false));

        assertThat(rule1.toString(), is("REGEX,.*[ST].*"));

        Rule rule2 = new Rule(Position.SUFFIX, new Snippet("Test"));

        assertThat(rule2.match(getClass().getName()), is(true));
        assertThat(rule2.match("java.lang.Strings"), is(false));
        assertThat(rule2.match("javax.swing.JFrame"), is(false));

        assertThat(rule2.toString(), is("SUFFIX,Test"));
    }
}
