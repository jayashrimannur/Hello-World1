package Collections;

import java.util.ArrayList;

public class CoreJavaArrayList {
	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		//for(int i=0;i<10;i++)
			al.add("First");
			al.add("SEcond");
			al.add("Thrid");
			al.add("forth");
			al.add("fifth");
			for(int i=0;i<al.size();i++)
				System.out.println(al.get(i));
			if(al.contains("First"))
				System.out.println("First is contained in the arraylist");
	}

}
