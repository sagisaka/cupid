package com.github.pochi.runner.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.script.ScriptException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import com.github.pochi.runner.config.Classpath;
import com.github.pochi.runner.config.Configuration;
import com.github.pochi.runner.config.ConfigurationBuilder;
import com.github.pochi.runner.scripts.ScriptRunner;
import com.github.pochi.runner.scripts.ScriptRunnerBuilder;
import com.github.pochi.runner.util.LogHelper;

public class Arguments {
    @Option(name = "-e", usage = "one line of script. -engine option is required in use of this option. ")
    private String expression;

    @Option(name = "-cp", usage = "specify classpaths.")
    private String classpath;

    @Option(name = "-engine", usage = "specify the script engine name. default value is JavaScript. available values are: JavaScript, Groovy.")
    private String engineName = ScriptRunner.DEFAULT_SCRIPT_ENGINE_NAME;

    @Option(name = "-config", usage = "specify the configuration file.")
    private String configuration = null;

    @Option(name = "-help", aliases = { "--help", "-h" }, usage = "print this message.")
    private boolean help = false;

    @Option(name = "-version", usage = "print the version.")
    private boolean version = false;

    @Option(name = "-license", usage = "print the license.")
    private boolean license = false;

    @Argument
    private List<String> args = new ArrayList<>();

    public boolean printIfRequired() {
        return new InformationPrinter().printIfRequired(version, help, license);
    }

    public void printHelp(CmdLineParser parser) {
        System.out.println("java -jar pochi-1.0.jar [OPTIONS] [SCRIPTS <ARGS...>]");
        parser.printUsage(System.out);
    }

    public void perform(ScriptRunner runner) throws IOException, ScriptException {
        if (expression != null) {
            runner.oneLiner(expression);
            return;
        } else if (!args.isEmpty()) {
            runner.runsScript(args.toArray(new String[args.size()]));
            return;
        }
        runner.startInteraction();
    }

    public Configuration configuration() {
        ConfigurationBuilder initializer = new ConfigurationBuilder(configFile());
        Configuration config = initializer.configuration();
        Optional.ofNullable(classpath).ifPresent(path -> updateClasspaths(path, config));
        return config;
    }

    private void updateClasspaths(String classpath, Configuration config) {
        Arrays.stream(classpath.split(File.pathSeparator)).forEach(path -> config.add(new Classpath(path)));
    }

    private Optional<URL> configFile() {
        return Optional.ofNullable(configuration).flatMap(item -> convertToUrl(Paths.get(item)));
    }

    public ScriptRunner buildRunner() {
        Configuration configurationObject = configuration();
        ScriptRunnerBuilder builder = new ScriptRunnerBuilder(configurationObject);
        return builder.build(toMap());
    }

    private Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("engine", engineName);
        map.put("args", args.toArray(new String[args.size()]));
        return map;
    }

    private Optional<URL> convertToUrl(Path path) {
        try {
            return Optional.of(path.toUri().toURL());
        } catch (MalformedURLException e) {
            LogHelper.warn(this, e);
        }
        return Optional.empty();
    }

    public boolean isSpecifiedScriptFile() {
        return !args.isEmpty();
    }
}
