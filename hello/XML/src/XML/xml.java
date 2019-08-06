package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class xml {
    public static void main(String[] args) throws Exception,TransformerException{
        File file= new File("/Users/yao/IdeaProjects/hello/XML/src/XML/book.xml");
        ArrayList<Book> al = new ArrayList<>();
        al.add(new Book(1, "啊", "啊的作者", 39.9));
        al.add(new Book(2, "不", "不的作者", 49.9));
        al.add(new Book(3, "出", "出的作者", 59.9));
        //write(file);
    }


    public static void write(File file, ArrayList<Book> al) throws
            ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();


        /**Element books = document.createElement("books");
         Element book = document.createElement("book");

         book.setAttribute("id","1");
         Element name = document.createElement("name");
         Element author = document.createElement("author");
         Element price = document.createElement("price");

         name.setTextContent("西游记");
         author.setTextContent("吴承恩");
         price.setTextContent("100");

         books.appendChild(book);
         book.appendChild(name);
         book.appendChild(author);
         book.appendChild(price);

         document.appendChild(books);**/
        Element books = document.createElement("books");
        for (Book b : al) {
            Element book = document.createElement("book");
            book.setAttribute("id", String.valueOf(b.getId()));
            Element name = document.createElement("name");
            Element author = document.createElement("author");
            Element price = document.createElement("price");
            name.setTextContent(b.getName());
            author.setTextContent(b.getAuthor());
            price.setTextContent(String.valueOf(b.getPrice()));
            books.appendChild(book);
            book.appendChild(name);
            book.appendChild(author);
            book.appendChild(price);

        }
        document.appendChild(books);

        TransformerFactory factory1 = TransformerFactory.newInstance();
        Transformer transformer = factory1.newTransformer();

        DOMSource xmlSource = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(xmlSource, result);


    }
}