package Day16_7_31_Wednesday.Shen;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class City {
    private HashMap hashMap;
    public City(){
        hashMap = new HashMap<>();
        hashMap.put("京","北京");
        hashMap.put("沪","上海");
        hashMap.put("津","天津");
        hashMap.put("渝","重庆");
        hashMap.put("黑","哈尔滨");

    }
    public HashMap getHashMap(){
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }
    public void getCity(String string){
        Set key = hashMap.keySet();
        Iterator iterator = key.iterator();
        while (iterator.hasNext()){
            String s = (String)iterator.next();
            if (s.equals(string)){
                System.out.println("省会："+ hashMap.get(s));
            }else System.out.println("NONE!");
        }
    }
}
