package TestJavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Strings ending with "i" and convert to uppercase
		Stream.of("Jayashri","Aaditya","Tanvi","Sonya","Smita","Rupali","Shreya")
		.filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println("First List"+s));
		
		
		//Strings starting with "S" and sort them and print
		Stream.of("Jayashri","Aaditya","Tanvi","Sonya","Smita","Rupali","Shreya")
		.filter(s->s.startsWith("S")).sorted().forEach(s->System.out.println("Second List"+s));	
		
		List<String>names1=Arrays.asList("Jayashri","Aaditya","Tanvi","Sonya","Smita","Rupali","Shreya");
		
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
		
		//Merging two different lists
		System.out.println("Third output==============>");
		Stream<String>newstream=Stream.concat(names.stream(), names1.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		System.out.println("Fourth output==============>");
		boolean flag=names.stream().anyMatch(s->s.equalsIgnoreCase("TANVI"));
		System.out.println(flag);
		
		//sort the stream and Collect the output in list and print the first item
		
		System.out.println("Fifth output==============>");
		List<String> ls=names.stream().sorted().collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		System.out.println("sixth output==============>");
		//Print unique nos from the array and sort the array and get the 3rd index
		List<Integer> nos=Arrays.asList(10,20,10,20,30,40,10,50,60);
		List<Integer> li=nos.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

}
