import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person p) {
			return age - p.age;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		List<Person> personList = new ArrayList<Person>();
		String[] str = new String[2];
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			int age = Integer.parseInt(str[0]);
			String name = str[1];
			personList.add(new Person(age, name));
		}
		Collections.sort(personList);
		for(Person p : personList) {
			System.out.println(p.age + " " + p.name);
		}
	}

}
