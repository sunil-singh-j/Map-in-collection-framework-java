package sortedMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class Demo {
	public static void main(String[] args) {
		SortedMap< Integer,String> map= new  TreeMap< Integer,String>();
		map.put(98,"vivek");
		map.put(65,"mohit");
		map.put(87, "singh");
		map.put(97,"sunil");
		System.out.println(map);//{65=mohit, 97=sunil, 98=vivek}
		
		System.out.println(map.firstKey());//65
		System.out.println(map.lastKey());//98
		System.out.println(map.headMap(97));//{65=mohit, 87=singh}
		System.out.println(map.containsKey(87));//true  T =log n
		System.out.println(map.containsValue("singh"));//true T= n
		
		SortedMap< Integer,String> map1= new  TreeMap< Integer,String>((a,b)->b-a); 
		//here while creating map we are also passing comparator for odering
		map1.putAll(map);
		System.out.println(map1);//{98=vivek, 97=sunil, 87=singh, 65=mohit}
		
		
	}

}
