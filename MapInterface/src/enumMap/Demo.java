package enumMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) {
		Map<Day,String> map= new HashMap<Demo.Day, String>();//not good practise it will do haching and indexing
		Map<Day,String> map1= new EnumMap<>(Day.class); //here map size will decided by enum size
		//it makes it more efficient
		//ordinal /index is used
		//faster than Hashmap
		//Memory efficient
		map.put(Day.TUESDAY, "gym");
		map.put(Day.MONDAY, "walk");//{TUESDAY=gym, MONDAY=walk}
		System.out.println(map.get(Day.TUESDAY));
		System.out.println(map);
		 
	}
	enum Day{
		MONDAY, TUESDAY,WEDNESSDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
	}

}
