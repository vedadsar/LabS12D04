import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class reads from .xml type and prints it on console.
 * @author vedadzornic
 *
 */
public class PersonReader {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		//Creating document builder and document which parse our xml document to Document.
		DocumentBuilder docRead = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmldoc = docRead.parse(new File("./XML/people.xml"));
	
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "//person";

		
		//Converting our XML doc to NodeList.
		NodeList xmlPeople = (NodeList) xPath.compile(expression).evaluate(xmldoc, XPathConstants.NODESET);
		//Creating empty linked list of persons where we'll add nodes from xmlPeople nodelist.
		LinkedList<Person> ppl = new LinkedList<Person>();
		//Loop in which we cast Node into Element to get attributes and add into ppl list.
		for(int i=0; i<xmlPeople.getLength(); i++){
			Node current = xmlPeople.item(i);							//Creating current node.
			if(current instanceof Element){								//Checking if node is instance of element.
				Element currentElement = (Element) current;				//Casting node into element
				
				String name = currentElement.getAttribute("name");		//getting name and surname of element (attributes)
				String surname = currentElement.getAttribute("surname");
				int age =Integer.parseInt(current.get);
				Person currentPerson = new Person(name, surname, age);
				ppl.add(currentPerson);						//Adding to a ppl list.
				
			
				/*
				 * Next block is checking if our current person has childs. 
				 * If it has childs we'll create child element from child nodelist.
				 * Once we create child we'll add that child to current person.
				 */
				if(currentElement.hasChildNodes()){		
					NodeList childNodes =  currentElement.getChildNodes();					
					for(int j=0; j<childNodes.getLength();j++){
						Node currentChild = childNodes.item(j);
						if(currentChild instanceof Element){
							Element currentChildElement = (Element) currentChild;
							String childName = currentChildElement.getAttribute("name");
							String childSurname = currentChildElement.getAttribute("surname");
							int childAge = Integer.parseInt(currentChildElement.getAttribute("age"));
							currentPerson.addChild(new Person(childName, childSurname, childAge));							
						}
					
					}
				}
				
			}
		}		
		//Creating iterator and loop for printing our people list on console.
		Iterator<Person> it = ppl.iterator();	
		while(it.hasNext()){
			Person next = it.next();
			System.out.println(next.toString());
			if(next.hasChilds())	//If it has childs, printing childs.
				System.out.println("\t"+next.printChilds());
			
		}
	}
}
