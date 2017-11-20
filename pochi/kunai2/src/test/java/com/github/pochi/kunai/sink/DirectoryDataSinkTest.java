package com.github.pochi.kunai.sink;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pochi.kunai.entries.Entry;
import com.github.pochi.kunai.source.DataSource;
import com.github.pochi.kunai.source.factories.DefaultDataSourceFactory;
import com.github.pochi.kunai.util.PathHelper;

public class DirectoryDataSinkTest {
    @Before
    public void setUp() throws Exception{
        Path path = Paths.get("target/test-classes/hello/target/hello-1.0-SNAPSHOT.jar");
        try(DataSource source = new DefaultDataSourceFactory().build(path)){
            try(DataSink sink = new DirectoryDataSink(Paths.get("dir"))){
                sink.consume(source);
            }
        }
    }

    @Test
    public void testCreatedDirectory() throws Exception{
        DataSource source = new DefaultDataSourceFactory().build(Paths.get("dir"));

        List<Entry> list = new ArrayList<>();
        source.forEach(entry -> list.add(entry));

        assertThat(list.size(), is(2));
    }

    @After
    public void tearDown() throws Exception{
        PathHelper.deleteAll(Paths.get("dir"));
    }
}
