package mycupid.research;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mycupid.csv.CsvSetup;

public class CsvExtract {
	
	public List<Integer> answer(String file_name) throws IOException{
		EachData ed = new EachData();
		List<Integer> answer = new ArrayList<Integer>();
		List<Integer> target = this.outputCsvInteger(file_name);
//		answer.add((int)Math.floor(ed.getAverage(target)));
//		System.out.println(ed.getAverage(target));
//		answer.add((int)Math.floor(ed.getDeviationValue(target)));
//		System.out.println(ed.getDeviationValue(target));
		answer.add((int)Math.floor(ed.getMax(target)));
		System.out.println("MAX,"+ed.getMax(target));
		answer.add((int)Math.floor(ed.getHandled(target)));
		System.out.println("1%,"+ed.getHandled(target));
		answer.add((int)Math.floor(ed.getTen(target)));
		System.out.println("10%,"+ed.getTen(target));
		answer.add((int)Math.floor(ed.getMediumHalfUp(target)));
		System.out.println("25%,"+ed.getMediumHalfUp(target));
		answer.add((int)Math.floor(ed.getMedium(target)));
		System.out.println("50%,"+ed.getMedium(target));
		answer.add((int)Math.floor(ed.getMediumHalfDown(target)));
		System.out.println("75%,"+ed.getMediumHalfDown(target));
		answer.add((int)Math.floor(ed.getMin(target)));
		System.out.println("MIN,"+ed.getMin(target));
		return answer;
	}
	
	
	public List<Integer> outputCsvInteger(String file_name) throws IOException{
		CsvSetup set = new CsvSetup();
		File file = new File(file_name);
		List<Integer> target = new ArrayList<Integer>();
		BufferedReader br = set.inputFile(file);
		String line;
		while((line = br.readLine()) != null){
			String array[] = line.split(",");
			target.add(Integer.parseInt(array[1]));
		}
		br.close();
		return target;
	}
}
