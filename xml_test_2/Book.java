package xml_test_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Book {
	private String title;
	private String publisher;
	private String name;
	private int age;
	public Book() {
	}

	public Book(String title, String publisher, String name, int age) {
		this.title = title;
		this.publisher = publisher;
		this.name = name;
		this.age = age;
	}
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String Title) {
		this.title = Title;
	}
	
	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String Publisher) {
		this.publisher = Publisher;
	}	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Title Book: " + title + " - publisher: " + publisher; 
	}

	public static void main(String[] args) {
		int i1 = 1;
		String s1 = i1+"";
		System.out.println(s1);
	}

}