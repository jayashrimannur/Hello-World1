package TestJavaBasics;

public class LongestOcc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a= {1,3,4,5,6,7,8,1,3,4,5,6,7};
		
		int count=0;
		int max=0;
		for(int i=0;i<a.length-1;i++)
		{
			
			if (a[i]+1==a[i+1])
			{
				System.out.println("Compared nos="+a[i]+"and"+a[i+1]);
				count++;
			}
			else
			{	
				System.out.println(count);
				if(max<count)
				{
					max=count+1;
				}
				count=0;
			}
		}
		
	//	if(max<count)
		//	max=count+1;
		System.out.println(max);

	}

}
