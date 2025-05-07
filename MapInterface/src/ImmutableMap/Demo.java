package ImmutableMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) {
		Map<String , Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 1);
		map1.put("B", 3);
		Map<String,Integer> map2 =Collections.unmodifiableMap(map1);
		System.out.println(map2);//{A=1, B=3}
		
		Map<String,Integer> map3 =Map.of("shubum",89,"vivek",94);
		//map3.put("akshit", 99);
		System.out.println(map3);//{vivek=94, shubum=89}
		Map<String ,Integer> map4 = Map.ofEntries(Map.entry("akshit",32),Map.entry("ram", 32));
		System.out.println(map4);//{akshit=32, ram=32}
		
	}
}
