package mycupid.delivery;

import java.io.IOException;
import java.util.ArrayList;

import javax.script.ScriptException;

import mycupid.Extractor.Extractor;
import mycupid.csv.CsvController;


public class Deliverd {
	public void deliverd(String[] args) throws IOException, ScriptException{
		Extractor ext = new Extractor();
		CsvController con = new CsvController();
		String file_name =  args[1] +"_result";
		String file_output = args[1] +"_output";
		
		ArrayList<String> birthmarks = new ArrayList<String>();
		birthmarks.add("uc");
		birthmarks.add("2-gram");
		birthmarks.add("3-gram");
		birthmarks.add("4-gram");
		birthmarks.add("5-gram");

		ext.extractUser(args[0],args[1],file_name,birthmarks);
		birthmarks.forEach(birthmark->{
			try {
				con.outputCsv(file_name+"_"+birthmark+".csv",file_output,birthmark);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
