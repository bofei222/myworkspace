package corejava.jihe.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,Employee> staff=new HashMap<>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		
		//print all entries
		System.out.println(staff);
		
		//remove an entry
		staff.remove("567-24-2546");
		System.out.println(staff);
		
		//replace an entry
		staff.put("456-62-5527", new Employee("Fracncesca Miller"));
		System.out.println(staff);
		
		//look up a value
		System.out.println(staff.get("157-62-7935"));
		
		//iterator through all entries
		for(Map.Entry<String, Employee> entry:staff.entrySet()){
			String key =entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key="+key+",value"+value);
		}
			
		
		
	}
}
