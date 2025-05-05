package LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) {
		
		HashMap<String,Integer> hashmap=new HashMap<>();
		hashmap.put("Orange", 10);
		hashmap.put("apple", 20);
		hashmap.put("guava", 13);
		
		for (Map.Entry<String , Integer> entry:hashmap.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
//		---------------------------------here output will be not in order(order will not maintained)
//		apple : 20
//		guava : 13
//		Orange : 10
		
		LinkedHashMap<String, Integer> linkedHashMap=new LinkedHashMap<String, Integer>(11,0.3f,true);
		
		linkedHashMap.put("Orange", 10);
		linkedHashMap.put("apple", 20);
		linkedHashMap.put("guava", 13);
		
//		linkedHashMap.get("apple"); //by this below order of output will change 
//		linkedHashMap.get("Orange");// it will give lest used first in this case it give guava
		
		
		for (Map.Entry<String , Integer> entry:linkedHashMap.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
//		-----------------------------------here output will be in order (order will be  maintained)
//		Orange : 10
//		apple : 20
//		guava : 13
		
		HashMap<String ,Integer>hashMap2=new HashMap<String, Integer>();
		LinkedHashMap linkedHashMap2=new LinkedHashMap(hashMap2);
		
		hashMap2.put("shubam",91);
		hashMap2.put("bob", 45);
		hashMap2.put("singh", 54);
		Integer res=hashMap2.getOrDefault("vipul", 0);
		System.out.println(res);//0
		hashMap2.put("shubam", 12);
		
		
		System.out.println(hashMap2);//{shubam=12, bob=45, singh=54}
		
		
		
				
	}
}
