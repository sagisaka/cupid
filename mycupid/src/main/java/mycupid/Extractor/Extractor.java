package mycupid.Extractor;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.script.ScriptException;

import com.github.pochi.runner.scripts.ScriptRunner;
import com.github.pochi.runner.scripts.ScriptRunnerBuilder;


public class Extractor {

	final private String JS = "src/main/resources/extract_and_compare.js";
	final private String JS_E = "src/main/resources/extract.js";

	public void extractUser(String file,String file2,String outputFile,String outputFile2,ArrayList<String> birthmarks) throws IOException, ScriptException {
		ScriptRunner runner = new ScriptRunnerBuilder().build();
		birthmarks.forEach(birthmark->{
			try {
				File fileExist = new File(outputFile+"_Ori.csv");
				File fileExist2 = new File(outputFile2+"_Ori.csv");
				if (!fileExist.exists()){
					runner.runsScript(new String[] { JS_E ,file2 ,outputFile+"_Ori.csv",birthmark});
				}
				if (!fileExist2.exists()){
					runner.runsScript(new String[] { JS_E ,file ,outputFile2+"_Ori.csv",birthmark});
				}
				runner.runsScript(new String[] { JS ,file ,file2 ,outputFile+"_"+birthmark+".csv",birthmark});
			} catch (IOException | ScriptException e) {
				e.printStackTrace();
			}
		});
	}
}
