package com.github.pochi.runner.ui;

import java.io.IOException;

import javax.script.ScriptException;

import com.github.pochi.runner.scripts.ScriptRunner;
import com.github.pochi.runner.util.LogHelper;

public class Main {
    public Main(String[] commandLineOptions) {
        Arguments args = new ArgumentsBuilder().build(commandLineOptions);
        if (!args.printIfRequired())
            perform(args);
    }

    private void perform(Arguments args) {
        ScriptRunner runner = args.buildRunner();
        try {
            args.perform(runner);
        } catch (IOException | ScriptException e) {
            LogHelper.warn(this, e);
        }
    }

    public static void main(String[] args) {
        new Main(args);
    }
}
