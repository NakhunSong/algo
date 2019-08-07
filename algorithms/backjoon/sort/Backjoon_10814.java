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
		int join;
		
		public Person(int age, String name, int join) {
			this.age = age;
			this.name = name;
			this.join = join;
		}
		@Override
		public int compareTo(Person p) {
			if(age > p.age) {
				return 1;
			} else if(age == p.age) {
				if(join > p.join) {
					return 1;
				}
			}
			return -1;
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
			personList.add(new Person(age, name, i));
		}
		Collections.sort(personList);
		for(Person p : personList) {
			System.out.println(p.age + " " + p.name);
		}
	}

}
