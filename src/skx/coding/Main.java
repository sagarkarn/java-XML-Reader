package skx.coding;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("demo.xml");
            read(document);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(Document document) {
//        get Document root tag name
        String rootTag = document.getDocumentElement().getTagName();
        System.out.println("root tag: " + rootTag);

        NodeList nodeList = document.getElementsByTagName("person");
        for(int i = 0; i < nodeList.getLength(); i++){
            Element el = (Element) nodeList.item(i);

//            get attribute value of person element
            String attr = el.getAttribute("id");
            System.out.println("attribute: " + attr);

//            get Tag value
            String name = el.getElementsByTagName("name").item(0).getTextContent();
            String age = el.getElementsByTagName("age").item(0).getTextContent();
            System.out.println("name: " + name);
            System.out.println("age: " + age);
        }
    }

}
