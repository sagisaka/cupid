package mycupid.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvController {
	public void outputCsv(String file_name,String file_output,String birthmark,Integer size,Integer size2) throws IOException{
		CsvSetup set = new CsvSetup();
		Judgment judg = new Judgment();
		File file = new File(file_name);
		BufferedReader br = set.inputFile(file);
		String line;
		Integer count=0;
		while((line = br.readLine()) != null){
			String array[] = line.split(",");
			count += set.search(array,file_output+"_"+birthmark+".csv",birthmark);
		}
		FileWriter fw = new FileWriter(birthmark+"_count.csv", true); 
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		if(size>size2){
			size=size2;
		}
		String rank = judg.rank(count,size);
		pw.println(file_name +","+birthmark +","+ count +","+rank );
		br.close();
		pw.close();
	}
}
