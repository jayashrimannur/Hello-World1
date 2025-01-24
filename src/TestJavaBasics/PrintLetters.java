
package TestJavaBasics;

public class PrintLetters {
	
	public static void PrintA()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=0;row<=10;row++)
		{
			for(int col=0;col<=20;col++)
			{
				if(col==fp || col==sp || row==10/2 && col>fp && col<sp)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			fp--;
			sp++;
		}
	}
	
	
	public static void PrintE()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=0;row<=10;row++)
		{
			for(int col=0;col<=8;col++)
			{
				if(col==0 || row==0 || row==10/2 || row==10) 
					System.out.print("*");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}
	
	
	public static void PrintB()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=1;row<=10;row++)
		{
			for(int col=1;col<=8;col++)
			{
				if(col==1 || (row==1 || row==10/2 || row==10) && col%2==1 || col==8 && row!=1
						&& row!=10/2 && row!=10) 
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}
	
	
	public static void PrintC()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=1;row<=10;row++)
		{
			for(int col=1;col<=15;col++)
			{
				if((col==1 && row!=1 && row!=10)
						|| (row==1 && col>1 && col%2==1 )
						|| (row==10 && col>1 && col%2==1 ))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}
	

	public static void PrintD()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=1;row<=10;row++)
		{
			for(int col=1;col<=10;col++)
			{
				if(col==1 || (row==1 || row==10) && col%2==1 || col==10 && row!=1
						&&  row!=10) 
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}


	public static void PrintH()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=1;row<=11;row++)
		{
			for(int col=1;col<=10;col++)
			{
				if(col==1 || col==10 || row==5 && col%2==1) 
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}
	
	public static void PrintI()
	{
		int fp=20/2;
		int sp=20/2;
		for(int row=1;row<=11;row++)
		{
			for(int col=1;col<=7;col++)
			{
				if(row==1 || row==11 || col==4) 
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			//fp--;
			//sp++;
		}
	}
	
	
	public static void PrintM()
	{
		int fp=1;
		int sp=15;
		for(int row=1;row<=15;row++)
		{
			for(int col=1;col<=15;col++)
			{
				if(col==1 || col==15 || (row>1 && row<=15/2+1 && (col==fp || col==sp))) 
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			fp++;
			sp--;
		}
	}
	
	public static void main(String[] args)
	{
		PrintM();
	}

}


