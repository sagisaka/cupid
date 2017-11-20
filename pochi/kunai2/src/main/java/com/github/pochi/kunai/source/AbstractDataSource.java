package com.github.pochi.kunai.source;

public abstract class AbstractDataSource implements DataSource{
    int getLastIndex(String name, String extension){
        return name.lastIndexOf(extension);
    }

    int getStartIndex(String name){
        if(name.startsWith("/"))
            return 1;
        return 0;
    }

    String parseClassName(String name){
        int start = getStartIndex(name);
        int last = getLastIndex(name, ".class");
        return trimName(name, start, last);
    }

    String trimName(String name, int start, int last){
        if(start >= 0 && start < last)
            return name.substring(start, last);
        return name;
    }
}
