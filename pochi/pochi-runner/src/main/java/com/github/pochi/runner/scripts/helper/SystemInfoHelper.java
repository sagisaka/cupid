package com.github.pochi.runner.scripts.helper;

public class SystemInfoHelper {
    public String version(){
        Package p = Package.getPackage("com.github.pochi.runner.scripts.helper");
        return p.getImplementationVersion();
    }
}
