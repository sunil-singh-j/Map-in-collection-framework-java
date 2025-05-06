package HashTable;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo {
	public static void main(String[] args) {
		Hashtable<Integer, String> hashtable= new Hashtable<Integer, String>();
		//hashtable is synchronized
		// no null key and no null values
		//Legacy class replaced by ConcurrentHashMap
		//slower than HashMap
		//only linked list in case of collision
		//all Methods are synchronized 
		hashtable.put(1, "apple");
		hashtable.put(2, "samsung");
		hashtable.put(4, "motoroal");
		System.out.println(hashtable);//{4=motoroal, 2=samsung, 1=apple}
		System.out.println("value for the key 2 is "+hashtable.get(2));//value for the key 2 is samsung
		System.out.println(hashtable.contains(3));//false
		System.out.println(hashtable.remove(4));//motoroal
		System.out.println(hashtable);//{2=samsung, 1=apple}
//		hashtable.put(null, "value"); //throws exception
//		hashtable.put(4, null);//throws exception
		
		HashMap<Integer, String> map= new HashMap<Integer, String>();
		Thread thread1= new Thread(()->{
			for(int i=0;i<1000;i++) {
				map.put(i, "Thread1");
			}
		});
		Thread thread2= new Thread(()->{
			for(int i=1000;i<2000;i++) {
				map.put(i, "Thread2");
			}
		});
		
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<------------------output with hashMap------------->");
		
		
		System.out.println("final size of the HashMap : "+ map.size());//final size of the HashMap : 1045
		//every time we will get different ouput because hashMap is not thread safe for we should use HashTable
		
		System.out.println("<------------------output with hashTable------------->");
		
		Hashtable<Integer, String> map1= new Hashtable<Integer, String>();
		
		Thread thread3= new Thread(()->{
			for(int i=0;i<1000;i++) {
				map1.put(i, "Thread1");
				
			}
		});
		Thread thread4= new Thread(()->{
			for(int i=1000;i<2000;i++) {
				map1.put(i, "Thread2");
				
			}
		});
		
		thread3.start();
		thread4.start();
		try {
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("final size of the HashMap : "+ map1.size());//final size of the HashMap : 1045
		
	}
}
