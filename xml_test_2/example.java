package xml_test_1;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class example {
    public static void main(String[] args) {
        try {
    		Book book = new Book("java program", "MIT", "john", 30);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("books");

            // create sub element
            Element book1 = doc.createElement("book");

            // title
            Element title = (doc.createElement("title"));
            title.appendChild(doc.createTextNode(book.getTitle()+""));
            book1.appendChild(title);
            
            // publisher
            Element publisher= (doc.createElement("publisher"));
            publisher.appendChild(doc.createTextNode(book.getPublisher()+""));
            book1.appendChild(publisher);

            // create author
            Element author = (doc.createElement("author"));
            // create child element in author
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(book.getName()+""));

            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode(book.getAge()+""));

            // append to author
            author.appendChild(name);
            author.appendChild(age);

            book1.appendChild(author);

            // add to root
            rootElement.appendChild(book1);
            // add to doc
            doc.appendChild(rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult consolResult = new StreamResult(System.out);
            transformer.transform(source, consolResult);
        
            
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
