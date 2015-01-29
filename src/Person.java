import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that creates person.
 * @author vedadzornic
 *
 */
public class Person {

	private String name;
	private String surname;
	private int age;
	private LinkedList<Person> children;
	
	public Person(String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
		children = new LinkedList<Person>();
		
	}
	
	/**
	 * Basic to string method.
	 */
	public String toString(){
		return surname +" " +name +" " +age;		
	}
	
	/**
	 * Method to add child to person.
	 * @param child
	 */
	public void addChild(Person child){
		children.add(child);
	}
	
	/**
	 * Method checks if our person has childs
	 * @return
	 */
	public boolean hasChilds(){
		if(children.isEmpty())
			return false;
		return true;		
	}
	
	/**
	 * Simple method which print childrrens.
	 * @return
	 */
	public String printChilds(){
		return "Childrens: " +children.toString();
	}
	
	/**
	 * Method which send person list to output stream.
	 * @param people
	 * @param os
	 */
	public static void personToXML(List<Person> people, OutputStream os){
		
		PrintWriter pw = new PrintWriter(os); 			//Creating printwriter.
		pw.println("<?xml version=\"1.0\"?>");		
		pw.println("<people>");
		Iterator<Person> it = people.iterator();
		Person temp = null;
						
		while(it.hasNext()){
			temp = it.next();
			pw.println(" <person name= \""+temp.name +"\" surname=\"" +temp.surname  +"\" >");
			pw.println("  <age >" +temp.age +"</age>");
			//Iterator and loop for adding childs into xml.
			Iterator<Person> childIT = temp.children.iterator();
			while(childIT.hasNext()){
				Person childTemp = childIT.next();
				pw.println("<child name= \""+childTemp.name +"\" surname=\"" +childTemp.surname +"\" age=\"" +childTemp.age  +"\" />");				
			}			
			pw.println("</person>");			
		}
		pw.println("</people>");
		pw.flush();
	}
}
