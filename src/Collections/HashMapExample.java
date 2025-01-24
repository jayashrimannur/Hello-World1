package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> hm=new HashMap();
		hm.put(1,"Meha");
		hm.put(2,"Sneha");
		hm.put(3,"Mehavati");
		hm.put(4,"Gouri");
		System.out.println(hm);
		System.out.println(hm.get(3));
		hm.remove(3);
		System.out.println(hm.get(3));
		Set s=hm.entrySet();
		Iterator it=s.iterator();
		while(it.hasNext())
		{
			Map.Entry mp=(Map.Entry)it.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
		}
		
	}

}
