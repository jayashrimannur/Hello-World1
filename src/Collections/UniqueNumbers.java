package Collections;

import java.util.ArrayList;

public class UniqueNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a= {10,10,5,2,1,3,4,3,2,3,1,3,4,5,7};
		ArrayList<Integer> l=new ArrayList();
		for(int i=0;i<a.length;i++)
		{
			int count=0;
			if(!l.contains(a[i]))
			{	
				l.add(a[i]);
			for(int j=0;j<a.length;j++)
			{
			
				if(a[i]==a[j])
				{
				
					count++;
				}
			}
			
			if(count==1)
				System.out.println(a[i]+"is unique");
			else
				System.out.println(a[i]+"value contains"+count+"times" );
			}
			
		}
			
		}
	}


