package navigableMap;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Demo {
	public static void main(String[] args) {
		NavigableMap< Integer,String> map= new  TreeMap< Integer,String>();
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
		
		
		System.out.println(map.ceilingEntry(90));//97=sunil
		System.out.println(map.floorKey(75));//65
		System.out.println(map.higherEntry(97));//98=vivek
		System.out.println(map.tailMap(76));//{87=singh, 97=sunil, 98=vivek}
		System.out.println(map1.tailMap(76));//{65=mohit}
		System.out.println(map.descendingKeySet());//[98, 97, 87, 65]
		System.out.println(map.descendingMap());//{98=vivek, 97=sunil, 87=singh, 65=mohit}
		
		
		
		
	}

}
