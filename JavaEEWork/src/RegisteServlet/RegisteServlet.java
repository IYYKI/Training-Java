package RegisteServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class RegisteServlet extends HttpServlet {
    private void doGate(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Map<String,String[]> map = req.getParameterMap();
        //遍历map
        Set<Map.Entry<String,String[]>> ens = map.entrySet();
        for (Map.Entry<String,String[]>en:ens){
            System.out.println(en.getKey()+"- -"+ Arrays.toString(en.getValue()));
        }
    }

}
