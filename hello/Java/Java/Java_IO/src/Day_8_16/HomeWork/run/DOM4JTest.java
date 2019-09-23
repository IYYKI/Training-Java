package Day_8_16.HomeWork.run;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import Day_8_16.HomeWork.WorkTwo.Student;
import Day_8_16.HomeWork.WorkTwo.StudentDao;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class DOM4JTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java/Java_IO/src/Day_8_16/HomeWork/run/data.xml");
        StudentDao sd = new StudentDao();
        ArrayList<Student> al = sd.selectAllStudent(file);
        write(file,al);
    }



    public static void write(File file,ArrayList<Student> al) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element students = document.addElement("students");
        for(Student s:al) {
            Element student = students.addElement("student");
            student.addAttribute("id",String.valueOf(s.getId()));
            student.addElement("name").setText(s.getName());
            student.addElement("sex").setText(s.getSex());
            student.addElement("age").setText(String.valueOf(s.getAge()));
        }
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
        document.write(osw);
        osw.flush();
        osw.close();
    }

}

