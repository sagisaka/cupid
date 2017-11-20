package mycupid.Extractor;


import java.io.IOException;
import java.util.ArrayList;

import javax.script.ScriptException;

import com.github.pochi.runner.scripts.ScriptRunner;
import com.github.pochi.runner.scripts.ScriptRunnerBuilder;


public class Extractor {
	private String JS = "src/main/resources/extract_and_compare.js";

	public void extractUser(String file,String file2,String outputFile,ArrayList<String> birthmarks) throws IOException, ScriptException {
		ScriptRunner runner = new ScriptRunnerBuilder().build();
		birthmarks.forEach(birthmark->{
			try {
				runner.runsScript(new String[] { JS,file ,file2 ,outputFile+"_"+birthmark+".csv",birthmark});
			} catch (IOException | ScriptException e) {
				e.printStackTrace();
			}
		});
	}
}
