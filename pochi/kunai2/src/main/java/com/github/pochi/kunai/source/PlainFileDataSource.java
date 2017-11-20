package com.github.pochi.kunai.source;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import com.github.pochi.kunai.entries.ClassName;
import com.github.pochi.kunai.entries.Entry;
import com.github.pochi.kunai.entries.PathEntry;

public class PlainFileDataSource extends AbstractDataSource implements PathResolver{
    private Path path;

    public PlainFileDataSource(Path path){
        this.path = path;
    }

    @Override
    public Stream<Entry> stream() {
        return Stream.of(new PathEntry(path, this));
    }

    @Override
    public void close() throws IOException {
        // do nothing.
    }

    @Override
    public InputStream openStream(Path path) throws IOException {
        return Files.newInputStream(path);
    }

    @Override
    public ClassName parseClassName(Path path) {
        return null;
    }
}
