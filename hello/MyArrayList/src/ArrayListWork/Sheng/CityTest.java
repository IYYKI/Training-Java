package ArrayListWork.Sheng;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CityTest {
    public static void main(String[] args) {
        HashMap hMap=new HashMap<>();
        hMap.put("浙江", "杭州");
        hMap.put("黑龙江", "哈尔滨");
        hMap.put("江苏", "南京");
        hMap.put("湖南", "长沙");
        hMap.put("安徽", "合肥");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要查询的省份");
        String string=scanner.nextLine();
        Set keyset=hMap.keySet();
        boolean flag = false;
        Iterator iterator=keyset.iterator();
        while(iterator.hasNext()) {
            String str =(String)iterator.next();
            if(str.equals(string)) {
                System.out.println(hMap.get(str));
                flag=true;
                break;
            }else {
                //System.out.println("无这样的信息");
                continue;
            }
        }
        if (flag==false){
            System.out.println("无这样的信息");
        }

    }

}