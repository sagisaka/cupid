package mycupid.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvSetup {
	public BufferedReader inputFile(File file) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		return br;
	}
	public Integer search(String[] array,String file_output,String birthmark) throws IOException{
		Judgment judg = new Judgment();
		Integer count = 0;
		if(birthmark.equals("uc")){
			count = judg.judgmentUc(Integer.parseInt(array[1]),Float.parseFloat(array[4]));
		}else if(birthmark.equals("2-gram")){
			count = judg.judgmentTwo(Integer.parseInt(array[1]),Float.parseFloat(array[4]));
		}else if(birthmark.equals("3-gram")){
			count = judg.judgmentThree(Integer.parseInt(array[1]),Float.parseFloat(array[4]));
		}else if(birthmark.equals("4-gram")){
			count = judg.judgmentFour(Integer.parseInt(array[1]),Float.parseFloat(array[4]));
		}else{
			count = judg.judgmentFive(Integer.parseInt(array[1]),Float.parseFloat(array[4]));
		}
		if(count!=0){
			FileWriter fw = new FileWriter(file_output, true); 
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			pw.print(array[0] + ",");
			pw.print(Integer.parseInt(array[1]) + ",");
			pw.print(array[2]+",");
			pw.print(Integer.parseInt(array[3])+",");
			pw.print(Float.parseFloat(array[4])+"\n");
			pw.close();
		}
		return count;
	}
}
