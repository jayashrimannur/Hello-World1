package Collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		//HashSet,TreeSet and LinkedHashSet
		
		//Set does not accept duplicate values
		//Set does not garuntee the order
		// TODO Auto-generated method stub
		HashSet<String> hs=new HashSet();
		hs.add("Rahu");
		hs.add("Sonal");
		System.out.println(hs);
		hs.add("Priya");
		hs.add("Rahu");
		System.out.println(hs);
		hs.remove("Sonal");
		System.out.println(hs.isEmpty());
		System.out.println(hs.size());
		hs.add("Smita");
		hs.add("snehal");
		hs.add("neeta");
		hs.add("shela");
		Iterator<String> it=hs.iterator();
		while(it.hasNext())
		{
			
			System.out.println(it.next());
		}
	}
	

}
