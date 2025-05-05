package lruCache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K,V> extends LinkedHashMap<K, V>{
	
	private int capacity;






	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	
	
	
	
	
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return size()>capacity;
	}






	public static void main(String[] args) {
		LRUCache<String ,Integer> studentMap=new LRUCache<>(3);
		studentMap.put("Bob", 99);
		studentMap.put("alice", 54);
		studentMap.put("ram", 100);
		
		System.out.println(studentMap.get("Bob"));
		
		studentMap.put("singh", 12);
		
		
		
		System.out.println(studentMap);
		
	}

}
