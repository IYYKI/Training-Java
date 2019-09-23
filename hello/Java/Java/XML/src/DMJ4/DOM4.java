package DMJ4;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM4 {
    public static void write(File file, ArrayList<String[]> arrayList)
            throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element databases = document.createElement("databases");
        try {
            for (String[] strings : arrayList) {
                Element database = document.createElement("database");

                Element url = document.createElement("url");
                Element user = document.createElement("user");
                Element password = document.createElement("password");
                //
                url.setTextContent(strings[0]);
                user.setTextContent(strings[1]);
                password.setTextContent(strings[2]);
                //
                databases.appendChild(database);
                database.appendChild(url);
                database.appendChild(user);
                database.appendChild(password);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        document.appendChild(databases);
        TransformerFactory factory2 = TransformerFactory.newInstance();
        Transformer tran = factory2.newTransformer();
        DOMSource xmlSource = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        tran.transform(xmlSource, result);
    }

    public static ArrayList<String[]> read(File file)
            throws TransformerConfigurationException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fac.newDocumentBuilder();
        Document document = builder.parse(file);
        ArrayList<String[]> arrayList = new ArrayList<String[]>();

        Node root = document.getFirstChild();// root-->databases

        NodeList list = root.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            String[] strings = new String[3];
            Node b = list.item(i);
            NodeList list2 = b.getChildNodes();
            for (int j = 0; j < list2.getLength(); j++) {
                Node n = list2.item(j);

                strings[j] = n.getTextContent();

            }
            arrayList.add(strings);
        }
        return arrayList;



    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {

        File file = new File("/Users/yao/IdeaProjects/hello/Java/XML/src/DMJ4/config.xml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ArrayList<String[]> array = new ArrayList<String[]>(5);

            String[] str = new String[] { "jdbc:mysql://localhost:3306/yyk", "root", "123456" };
            for (int i = 0; i < 5; i++) {
                array.add(str);
            }

            write(file, array);
            Class.forName("com.mysql.cj.jdbc.Driver");
            ArrayList<String[]> arr = read(file);
            for (String[] object : arr) {
                System.out.println(object[0] + object[1] + object[2]);
                Connection connection = DriverManager.getConnection(object[0], object[1], object[2]);
                System.out.println(" ");
                connection.close();
            }

        } catch (TransformerException | SAXException | IOException | SQLException |

                ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
