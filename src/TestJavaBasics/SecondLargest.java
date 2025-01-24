package TestJavaBasics;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,10,4,5,3,1,8,4,5};
		
		for(int i=0;i<a.length;i++)
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		
		for(int i=0;i<a.length-1;i++)
			if(a[i]>a[i+1])
			{
				System.out.println(a[i+1]);
				break;
			}

	}

}
