package corejava.jihe.map;

public class Employee {
	private String name;
	private double salary;
	
	public Employee(String n){
		name =n;
		salary=0;
	}
	
	public String toString(){
		return "[name="+name+",salrty="+salary+"]";
	}
}
