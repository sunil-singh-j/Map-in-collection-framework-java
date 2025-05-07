package concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class Demo {
	public static void main(String[] args) {
		ConcurrentHashMap<String , Integer> concurrentHashMap= new ConcurrentHashMap<String, Integer>();
		//java 7 -->segmanet based locking -->16 segmanets -->smaller hashmaps
		//only the segmant being written or read from is locked
		//read: do not require locking unless there is a write operation happening on the same segment
		// write :lock
		
		//java 8  --> no segmentation
		//        -->compare And swap  approach -->no locking except resizing or collision
		//thread A last saw --> X=42
		//thread A work   --> x to 50
		//if x is still 42 ,then change it to 50 else don't change and retry
		//put  --->index 
		
		//Map -->Sorted--->Thread Safe --> ConcurrentSkiplistMap
	}
}
