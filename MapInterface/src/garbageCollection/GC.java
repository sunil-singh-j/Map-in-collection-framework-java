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
		System.out.println("after few secords strong refrence after garbage collection "+phone);
		
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


