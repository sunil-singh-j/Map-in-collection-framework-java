package identityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		String key1= new  String("key");
		String key2 =new String ("key");
		Map<String, Integer> map= new HashMap<String, Integer>();
		//hashcode is not form Object class and here equls method is used to check equality
		map.put(key1, 1);//key,1
		map.put(key2, 2);//key,2
		System.out.println("map "+map);//map {key=2}
		 
		
		Map<String, Integer> map1= new IdentityHashMap<String, Integer>();
		//here hashcode method is Object class method which is generated using memeory address
		//here == is used to check equality
		map1.put(key1, 1);//key,1
		map1.put(key2, 2);//key,1
		//equals method
		System.out.println("map1 "+map1);//{key=2}//map1 {key=2, key=1}
				
	}
	
//	HashMap:
//
//		HashMap uses the hashCode() method to determine the hash of the keys, and it uses
//		the equals() method to check for key equality.
//		When you insert keys into a HashMap, if two keys produce the same hash code,
//		the equals() method is called to determine if they are actually the same key. 
//		If they are considered equal by equals(), the value for the existing key is updated.
//		IdentityHashMap:
//
//		IdentityHashMap also uses hash codes, but it treats keys as identical if 
//		their references are the same. It uses == operator comparison to determine key 
//		equality, meaning it checks whether the two references point to the same object
//		in memory.
//		This means that even if two objects have the same content (like two separate String 
//		instances containing the same text), they can be treated as different keys as 
//		long as they are distinct objects.
//		
//		HashMap treats two keys with the same content as equal (using equals() for comparison).
//		IdentityHashMap treats keys as equal only if they refer to the same object 
//		in memory (using == for comparison).
}
