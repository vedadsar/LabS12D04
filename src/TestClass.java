import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;


public class TestClass {
	public static void main(String[] args) {
		Person vedad = new Person("Vedad", "Zornic",23);
		Person mustafa = new Person("Mustafa", "Ademovic",21);
		Person emir = new Person("Emir", "Imamovic",22);
		Person gordan = new Person("Gordan", "Sajevic",23);
		Person benjo = new Person("Benjamin", "Talic",24);
		
		vedad.addChild(new Person("Junior Vedad", "Zornic",15));
		vedad.addChild(new Person("Emina", "Muratovic",12));		
		emir.addChild(new Person("Hikmet", "Durgutovic",11));
		emir.addChild(new Person("Saban", "Saulic",18));
		benjo.addChild(new Person("Bitcamp", "Nesto",8));
		
		LinkedList<Person> people = new LinkedList<Person>();
		people.add(benjo);
		people.add(emir);
		people.add(vedad);
		people.add(gordan);
		people.add(mustafa);
		
		//System.out.println(people.toString());
		Person.personToXML(people, System.out);
		
		
		try {
			Person.personToXML(people, new FileOutputStream("./XML/people.xml"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
