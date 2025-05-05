package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
	public static void main(String[] args) {
		
		Map<String, Integer> map1= new HashMap<String, Integer>();
		map1.put("singh", 90);//hashcode1--->index1
		map1.put("ram", 98);  //hashcode2--->index2
		map1.put("singh", 99);////hashcode1--->index1-->equals()--replace
		//here we are by hashcode will generated based upon the values not memory address
		System.out.println(map1);//{singh=99, ram=98}
		
		
		
		HashMap<Person, String>map= new HashMap<Person, String>();
		Person p1= new Person("alice",1);
		Person p2=new Person("bob",2);
		Person p3 =new Person("alice",1);
		
//		map.put(p2, "Engineer");//hashcode 1--->index 1
//		map.put(p2, "Designer");//hashcode 2--->index 2
//		map.put(p3, "Manager"); //hashcode 3--->index 3
		//here for person object by default the hashcode is generated through memory address not based on vlaues
		// so we need to overide it hascode method in person class
		
//		System.out.println("hash map Size : "+map.size());//3
//		System.out.println(map);//{hashMap.Person@90f6bfd=Manager, hashMap.Person@4157f54e=Designer}
		
		
		map.put(p2, "Engineer");//hashcode 1--->index 1
		map.put(p2, "Designer");//hashcode 2--->index 2
		map.put(p3, "Manager"); //hashcode 1--->index 1--->equals -->replace
		//here for person object now after overridng hashcode and equals method  the hashcode is generated through
		//	based on vlaues so for p3 it will not create a new object insted it will update p1
	
		
		System.out.println("hash map Size : "+map.size());//2
		System.out.println(map);//{Person [name=bob, id=2]=Designer, Person [name=alice, id=1]=Manager}
		
		

		
		
		
		
	}

}

class Person{
	private String name;
	private int id;
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name,id);
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Person other=(Person)obj;
		return id=other.getId()&&Objects.equals(name, other.getName());
		
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
		
}