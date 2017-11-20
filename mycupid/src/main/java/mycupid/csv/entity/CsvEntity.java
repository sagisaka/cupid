package mycupid.csv.entity;

public class CsvEntity {
	private String target_name;
	private int target_count;
	private String target_elements;
	private String group_name;
	private int group_count;
	private String group_elements;
	private double similarity;
	
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public int getTarget_count() {
		return target_count;
	}
	public void setTarget_count(int target_count) {
		this.target_count = target_count;
	}
	public String getTarget_elements() {
		return target_elements;
	}
	public void setTarget_elements(String target_elements) {
		this.target_elements = target_elements;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public int getGroup_count() {
		return group_count;
	}
	public void setGroup_count(int group_count) {
		this.group_count = group_count;
	}
	public String getGroup_elements() {
		return group_elements;
	}
	public void setGroup_elements(String group_elements) {
		this.group_elements = group_elements;
	}
	public double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
}
