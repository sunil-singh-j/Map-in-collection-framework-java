package garbageCollection;

import java.lang.ref.WeakReference;

public class GC {

	public static void main(String[] args) {
		Phone phone= new Phone("Appple ","16pro max");
		System.out.println(phone);//Phone [brand=Appple , Model=16pro max]
		
		WeakReference<Phone> weakReference= new WeakReference<Phone>(new Phone("samsung", "s25pro max"));
		
		System.out.println(weakReference.get());//Phone [brand=samsung, Model=s25pro max]
		System.gc();
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("after fewseconds weakRefrence after garbage collection "+ weakReference.get());//after fewseconds weakRefrence after garbage collection null
		System.out.println("after few secords strong refrence after garbage collection "+phone);//after few secords strong refrence after garbage collection Phone [brand=Appple , Model=16pro max]

		
	}
	
}	
	
	class Phone {
		String brand;
		String Model;
		public Phone(String brand, String model) {
			super();
			this.brand = brand;
			Model = model;
		}
		@Override
		public String toString() {
			return "Phone [brand=" + brand + ", Model=" + Model + "]";
		}
		
	}
	
	
//	Key Concepts
//
//	Garbage Collection:
//
//	Garbage collection (GC) is a form of automatic memory management in Java. 
//	The Java Virtual Machine (JVM) automatically identifies and recycles memory that is no longer in use, thereby preventing
//	memory leaks and ensuring efficient memory use.
//	Objects that are no longer strongly reachable from the root of the application
//	(e.g., static variables, active threads) become eligible for garbage collection.
//
//	Strong Reference:
//
//	In Java, when you create an object and assign it to a variable, you create a strong reference.
//	This makes it so that the object will not be garbage collected as long as the reference is alive.
//	In the given code example, Phone phone = new Phone("Appple", "16pro max"); 
//	creates a strong reference to the Phone object.
//
//	Weak Reference:
//
//	A weak reference is a type of reference that does not prevent its referent from being made garbage-collectible.
//	When there are no strong references to an object, and it only has weak references, it becomes eligible for garbage collection.
//	This is demonstrated in the line WeakReference<Phone> weakReference = new WeakReference<Phone>(new Phone("samsung", "s25pro max"));. Here, the Phone object is created and assigned to a weak reference. Once there are no strong references to it (immediately after it is created), it can be garbage collected.
//	Code Execution Flow
//
//	Creation of Strong Reference:
//
//	A Phone object with brand "Appple" and model "16pro max" is created and assigned to a strong reference phone. 
//	This object is not eligible for garbage collection since it has a strong reference.
//
//	Creation of Weak Reference:
//
//	Another Phone object with brand "samsung" and model "s25pro max" is created and assigned to a WeakReference.
//	At this point, since there are no strong references to this second Phone object,
//	it can be collected by the garbage collector if it runs.
//
//	Garbage Collection Call:
//
//	System.gc() is called to suggest that the JVM performs garbage collection.
//	However, it is important to remember this is merely a suggestion to the JVM,
//	and there is no guarantee when garbage collection will occur.
//
//	Post-Garbage Collection:
//
//	After executing System.gc(), the code pauses for a second (Thread.sleep(1000)). 
//	This is often done to allow time for the garbage collector to run.
//	When calling weakReference.get(), if the weakly referenced object has been collected, it will return null.
//	In this case, after garbage collection, we see null printed for the weak reference.
//	In contrast, the strong reference phone still points to its Phone object, so it displays the details of that object.
//	
