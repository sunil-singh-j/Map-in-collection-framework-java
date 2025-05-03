package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(292, "Ram");
		map.put(432, "desh");
		map.put(12, "singh");
		map.put(88, "sunil");
		map.put(null, "mohini");
		System.out.println(map);//{432=desh, null=mohini, 292=Ram, 88=sunil, 12=singh}
		System.out.println(map.get(88));//sunil
		System.out.println(map.containsKey(88));//true
		System.out.println(map.containsValue("singh"));//true
		
		Set<Integer>keys=map.keySet();
		for(Object i:keys) {
			System.out.println(map.get(i));
		}
//		desh
//		Ram
//		mohini
//		sunil
//		singh
		
		Set<Map.Entry<Integer, String>> entries=map.entrySet();
		for(Map.Entry<Integer, String> i:entries) {
		System.out.println(i);
		}
//				432=desh
//				292=Ram
//				null=mohini
//				88=sunil
//				12=singh
		
		Set<Map.Entry<Integer, String>> entries1=map.entrySet();
		for(Map.Entry<Integer, String> i:entries1) {
		i.setValue(i.getValue().toUpperCase());
		}

		System.out.println(map);//{432=DESH, null=MOHINI, 292=RAM, 88=SUNIL, 12=SINGH}
		
		System.out.println(map.remove(null));//true
		System.out.println(map);
		
		System.out.println(map.remove(88,"singh"));//false because both key and value should match 
		
	}

}
