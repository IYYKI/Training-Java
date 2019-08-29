package MyServlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {
    public SecondServlet() {
    }

    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        System.out.println("继承Generic处理请求....");
    }
}
