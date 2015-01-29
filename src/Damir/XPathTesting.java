package Damir;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class XPathTesting {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File xmlFile = new File("/Users/vedadzornic/Desktop/plakari.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document xmlDocument = db.parse(xmlFile);
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();
		String protuctCountString = xpath.evaluate("count(/products/product)", xmlDocument);
		System.out.println("Broj proizvoda je: " +protuctCountString);
		
		
		String firstProductUrl = xpath.evaluate("/products/product/@url", xmlDocument);
		System.out.println("First products: " +firstProductUrl);
		Scanner s = new Scanner(System.in);
		
		while(true){
			System.out.println("Unesite XPath");
			String xPathExpression = s.nextLine();
			if(xPathExpression.isEmpty())
				break;
			String result = xpath.evaluate(xPathExpression, xmlDocument);
			System.out.printf("Rezultat je %s\n", result);
		}
	}
}
