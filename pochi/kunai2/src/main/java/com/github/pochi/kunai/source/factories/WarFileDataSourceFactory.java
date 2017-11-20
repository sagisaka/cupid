package com.github.pochi.kunai.source.factories;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import com.github.pochi.kunai.source.DataSource;
import com.github.pochi.kunai.source.WarFileDataSource;
import com.github.pochi.kunai.util.PathHelper;

class WarFileDataSourceFactory extends JarFileDataSourceFactory{
    public WarFileDataSourceFactory(){
    }

    @Override
    public boolean isTarget(Path path, FileSystem system, BasicFileAttributes attributes){
        return PathHelper.endsWith(path, ".war")
                && attributes.isRegularFile();
    }

    @Override
    DataSource buildDataSource(FileSystem system){
        return new WarFileDataSource(system);
    }
}
