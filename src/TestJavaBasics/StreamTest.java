package TestJavaBasics;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>names=new ArrayList<String>();
		names.add("Streya");
		names.add("Aaditya");
		names.add("Tanvi");
		names.add("Neha");
		names.add("Anup");
		names.add("Anusha");
		names.add("Neeraj");
		names.add("Aaditi");
		names.add("Arnav");
		names.add("Arav");
		//There is no life for intermediate op if there is no terminal op
		//Terminal operation will execute only if intermediate op (filter) returns true
		//we can create stream
		//how to use filter in Stream API
		System.out.println(names.stream().filter(s->s.startsWith("A")).count());
		System.out.println(Stream.of("Aaditya","Sheetal","Raja","Arav").filter(
				s->
				{
				s.startsWith("A");
					return true;
				}
				).count());
				
		//Print all the names of ArrayList where length of string >4
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>5).limit(1).forEach(s->System.out.println(s));
	}

}
