package WeakHashMap;

import java.util.WeakHashMap;

public class Demo {
	public static void main(String[] args) {
		WeakHashMap<String, Image> imageCache= new WeakHashMap<String, Image>();
		imageCache.put("img1", new Image("Image 1"));
		imageCache.put("img2", new Image("image 2"));
		imageCache.put(new String("img3"), new Image("image3"));
		System.out.println(imageCache);//{img3=Image [name=image3], img1=Image [name=Image 1], img2=Image [name=image 2]}
		simulateApplicationRunnig();
		System.out.println("cache after running (some entris may be clared): "+imageCache);
		//cache after running (some entris may be clared): {img1=Image [name=Image 1], img2=Image [name=image 2]}
		
	}
	private static void simulateApplicationRunnig() {
		System.out.println("simulating appliction running.....");
		try {
			System.gc();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Image{
	private String name;
	public Image(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return "Image [name=" + name + "]";
	}
	
}

//
//The provided Java code makes use of the WeakHashMap, a specific variant of the Map interface 
//that employs weak references to its keys. This allows for dynamic memory management, where
//the garbage collector can reclaim memory associated with entries if the keys are no longer
//strongly reachable. 
//Key Concepts
//
//WeakHashMap:
//
//A WeakHashMap is a map that allows the keys to be garbage collected when no strong references
//to the keys exist. If a key is no longer referenced elsewhere in the program, it becomes 
//eligible for garbage collection, which in turn allows the associated entry in the map to be removed.
//This is particularly useful for caching scenarios where you do not want the existence of cached
//data to hinder garbage collection of objects whose references are no longer held by the application.
//
//Garbage Collection:
//
// garbage collection in Java reclaims memory by identifying and disposing of objects that are no longer
// reachable from any thread in the application.
//In the context of WeakHashMap, entries whose keys (if weakly referenced) become unreachable will be
//eligible for garbage collection.
//Code Execution Flow
//
//Creating a WeakHashMap:
//
//The code creates a WeakHashMap<String, Image> called imageCache. 
//This map is designed to store image objects with their corresponding string labels as keys.
//
//Adding Entries:
//
//Three entries are added to the imageCache:
//"img1" associated with a new Image object named "Image 1".
//"img2" associated with a new Image named "image 2".
//A new String object with the value "img3" (using the new String() constructor to create
//a new instance) associated with another Image named "image3".
//
//
//
//In Java, string literals (e.g., "img1" and "img2") are stored in a special area of memory known as the "String Pool."
//When you declare a string literal, Java checks this pool to see if an identical string already exists. 
//If it does, it does not create a new object; instead, it reuses the existing object from the pool.
//This means that string literals have a strong reference that persists for the duration of the program.
//
//In your code:
//
//"img1" and "img2" are string literals and thus are stored in the String Pool. Consequently,
//they have strong references and will not be eligible for garbage collection as long as the application is running.
//new String("img3"), however, creates a new String object that is not interned in the String Pool, 
//leading to a situation where there are no active strong references to the Image object associated with
//the key "img3". This allows it to be eligible for garbage collection if it is no longer referenced
//by any strong reference.
//Behavior of Your Code
//
//Given the distinction between string literals and newly created strings:
//
//imageCache.put("img1", new Image("Image 1"));
//
//img1 is a string literal, stored in the String Pool, and thus has a strong reference.
//
//imageCache.put("img2", new Image("image 2"));
//
//Similar to img1, img2 is also a string literal, stored in the String Pool, and thus has a strong reference.
//
//imageCache.put(new String("img3"), new Image("image3"));
//
//Here, a new String object for "img3" is created, which will not be interned in the String Pool.
//If no other reference to this String (and the associated Image object) remains, the key can be collected 
//during garbage collection.
//Conclusion
//
//After invoking System.gc() and allowing for some time (with Thread.sleep(10000)), the Image associated with
//the key "img3" may indeed be cleared from the WeakHashMap, while the images associated with "img1" and "img2" 
//remain in the cache due to the strong references residing in the String Pool.
//
//Thus, the output of your program after simulating application running may display something like:
//
//Copy code
//1cache after running (some entries may be cleared): {img1=Image [name=Image 1], img2=Image [name=image 2]}
//
//As "img3" has been garbage collected, but "img1" and "img2" were not.

