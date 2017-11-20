package mycupid.research;

import java.util.Collections;
import java.util.List;


public class EachData {
	public double getAverage(List<Integer> target){    
		int ave = 0;
		for(int i = 0; i < target.size(); i++){
			ave += target.get(i);
		}
		return (double)ave / target.size(); 
	}
	public double getDeviationValue(List<Integer> target){    
		double dblAve = getAverage(target);   
		double dblSum = 0.0;
		for(int i = 0; i < target.size(); i++){
			dblSum += Math.pow((dblAve - target.get(i)), 2.0);  
		}
		return Math.sqrt(dblSum / target.size());
	}
	public double getMedium(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		if(target.size() % 2 == 1){
			return target.get(target.size()/2);
		}
		else{
			return (target.get(target.size()/2) + target.get(target.size()/2 - 1)) / 2.0 ;
		}
	}
	public double getMediumHalfUp(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		if(target.size() % 2 == 1){
			return target.get(target.size()/4);
		}
		else{
			return (target.get(target.size()/4) + target.get(target.size()/4 - 1)) / 2.0 ;
		}
	}
	public double getMediumHalfDown(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		if(target.size() % 2 == 1){
			return target.get(target.size()/4*3);
		}
		else{
			return (target.get(target.size()/4*3) + target.get(target.size()/4*3 - 1)) / 2.0 ;
		}
	}
	public double getTen(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		if(target.size() % 2 == 1){
			return target.get(target.size()/10);
		}
		else{
			return (target.get(target.size()/10) + target.get(target.size()/10 - 1)) / 2.0 ;
		}
	}
	public double getHandled(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		if(target.size() % 2 == 1){
			return target.get(target.size()/100);
		}
		else{
			return (target.get(target.size()/100) + target.get(target.size()/100 - 1)) / 2.0 ;
		}
	}
	public double getMax(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		return target.get(0);
	}
	public double getMin(List<Integer> target){
		Collections.sort(target);
		Collections.reverse(target);
		return target.get(target.size()-1);
	}
}
