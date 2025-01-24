package TestJavaBasics;

import java.util.Arrays;
import java.util.List;

public class WordsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st="I am learning learning java java programming language learning";
		String[] st_strings=st.split(" ");
		List<String>list=Arrays.asList(st_strings);
		String searchstring="learning";
		long count=list.stream().filter(s->s.equals(searchstring)).count();
		System.out.println(count);
	}

}
