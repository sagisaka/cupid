package mycupid.delivery;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.script.ScriptException;

import mycupid.Extractor.Extractor;
import mycupid.csv.CsvController;
import mycupid.csv.CsvSetup;


public class Deliverd {
	public void deliverd(String[] args) throws IOException, ScriptException{
		Extractor ext = new Extractor();
		//CsvExtract cext = new CsvExtract();
		CsvController con = new CsvController();
		String file_name =  args[1] +"_result";
		String file_name2 =  args[0] +"_result";
		String file_output = args[1] +"_output";

		ArrayList<String> birthmarks = new ArrayList<String>();
		birthmarks.add("uc");
		birthmarks.add("2-gram");
		birthmarks.add("3-gram");
		birthmarks.add("4-gram");
		birthmarks.add("5-gram");

		ext.extractUser(args[0],args[1],file_name,file_name2,birthmarks);

		File fileExist = new File(file_name+"_Ori.csv");
		File fileExist2 = new File(file_name2+"_Ori.csv");
		Integer size=this.size(fileExist);
		Integer size2=this.size(fileExist2);
		birthmarks.forEach(birthmark->{
			try {
				con.outputCsv(file_name+"_"+birthmark+".csv",file_output,birthmark,size,size2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	public Integer size(File fileExist) throws IOException{
		CsvSetup set = new CsvSetup();
		BufferedReader br = set.inputFile(fileExist);
		Integer size=0;
		while((br.readLine()) != null){
			size++;
		}		
		return size;
	}
}
