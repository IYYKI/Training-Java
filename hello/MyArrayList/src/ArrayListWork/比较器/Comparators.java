package ArrayListWork.比较器;


import java.util.Comparator;

public class Comparators implements Comparator {

    private String order;
    private String field;

    public Comparators(String order,String field) {
        this.order = order;
        this.field = field;
    }
    public int compare(Object arg0, Object arg1) {
        Person p1 = (Person)arg0;
        Person p2 = (Person)arg1;
        int result = 0;
        if("id".equals(field)) {
            //如果p1.getId()<p2.getId(),result为负，则不需交换位置，升序
            result = p1.getId() - p2.getId();
        }else if("number".equals(field)) {
            //如果p1.getNumber()<p2.getNumber(),result为负，则不需交换位置，升序
            result = p1.getNumber() - p2.getNumber();
        }else if("name".equals(field)) {
            //如果p1.getName()<p2.getName(),result为负，则不需交换位置，升序
            result = p1.getName().compareTo(p2.getName());
        }
        if("降序".equals(order)) {
            result = -result;
        }
        return result;
    }
}