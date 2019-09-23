package Day_8_16.Works.run;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Day_8_16.Works.DBUtil.DBUtil;
import Day_8_16.Works.MyDataBase.Database;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

    public static void main(String[] args) throws ParserConfigurationException,IOException, SAXException,SQLException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java/Java_IO/src/Day_8_16/Works/database.xml");
        if (!file.exists()){
            file.createNewFile();
        }
        ArrayList<Database> al = read(file);
        Database db = al.get(1);
        System.out.println(db);
        System.out.println(db.getPassword()+db.getUrl()+db.getUser());
        DBUtil.getCon(db);

    }


    public static ArrayList<Database> read(File file) throws ParserConfigurationException, SAXException,IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        Node root = document.getFirstChild();
        NodeList list = root.getChildNodes();

        ArrayList<Database> al = new ArrayList<>();
        for(int i=0;i<list.getLength();i++) {
            Node d = list.item(i); //database
         //   Element ele = (Element) d;
            //String id = ele.getAttribute("id");
            //System.out.print("id:" + id);
            NodeList list2 = d.getChildNodes();
            Database db = new Database();
            for(int j=0;j<list2.getLength();j++) {
                Node u = list2.item(j); // url user password
                if(j==1) {
                    db.setUrl(u.getTextContent());
                }else if(j==3) {
                    db.setUser(u.getTextContent());
                }else if (j==5){
                    db.setPassword(u.getTextContent());
                }
            }
            al.add(db);
        }
        return al;
    }


    public static void write(File file,ArrayList<Database> al) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element databases = document.createElement("databases");
        for(Database c : al) {
            Element database = document.createElement("database");
            database.setAttribute("id", String.valueOf(c.getId()));
            Element url = document.createElement("url");
            Element user = document.createElement("user");
            Element password = document.createElement("password");
            url.setTextContent(c.getUrl());
            user.setTextContent(c.getUser());
            password.setTextContent(c.getPassword());

            databases.appendChild(database);
            database.appendChild(url);
            database.appendChild(user);
            database.appendChild(password);
        }
        document.appendChild(databases);

        TransformerFactory factory2 = TransformerFactory.newInstance();
        Transformer transformer = factory2.newTransformer();
        DOMSource xmlSource = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(xmlSource,result);
    }
}


