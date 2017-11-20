package mycupid.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvController {
	public void outputCsv(String file_name,String file_output,String birthmark) throws IOException{
		CsvSetup set = new CsvSetup();
		File file = new File(file_name);
		BufferedReader br = set.inputFile(file);
		String line;
		Integer count=0;
		while((line = br.readLine()) != null){
			String array[] = line.split(",");
			count += set.search(array,file_output+"_"+birthmark+".csv",birthmark);
		}
		FileWriter fw = new FileWriter(file_output+"_count.csv", true); 
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		pw.println(birthmark +","+ count);
		br.close();
		pw.close();
	}
}
