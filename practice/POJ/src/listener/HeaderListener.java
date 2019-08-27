package listener;



import model.Staff;
import view.MainView;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class HeaderListener extends MouseAdapter{

    private MainView mv;

    public HeaderListener(MainView mv) {
        this.mv = mv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //1.获得列的名称
        //获得鼠标点击的次数
        int clickCount = e.getClickCount();
        //获得鼠标点击的坐标
        Point point = e.getPoint();
        //根据坐标获得点击的列的索引
        int column = mv.getTable().columnAtPoint(point);
        //根据索引获得列的名称
        String columnName = mv.getTable().getColumnName(column);

        //2.将表中的记录全部拿出来存放在list中
        //表格中的行数
        int rows = mv.getTable().getRowCount();
        //存放表格数据的集合
        ArrayList<Staff> al = new ArrayList<>();

        //遍历存放
        for(int i=0;i<rows;i++) {
            Staff staff = new Staff();
            int id = Integer.parseInt((String) mv.gettModel().getValueAt(i, 0));
            String name = (String) mv.gettModel().getValueAt(i, 1);
            String sex = (String) mv.gettModel().getValueAt(i, 2);
            String department = (String) mv.gettModel().getValueAt(i, 3);
            int salary = Integer.parseInt((String) mv.gettModel().getValueAt(i, 4));
            staff.setId(id);
            staff.setName(name);
            staff.setSex(sex);
            staff.setDepartment(department);
            staff.setSalary(salary);
            al.add(staff);
        }
        //创建比较器对象
        MyComparator mc = new MyComparator(clickCount,columnName);//bug
        //对al进行mc方式排序
        Collections.sort(al, mc);
        //清空表格
        mv.gettModel().setRowCount(0);

        Iterator<Staff> it = al.iterator();
        while(it.hasNext()) {
            Staff staffNext = it.next();
            String id = String.valueOf(staffNext.getId());
            String name = staffNext.getName();
            String sex = staffNext.getSex();
            String department = staffNext.getDepartment();
            String salary = String.valueOf(staffNext.getSalary());
            Object[] rowData = {id,name,sex,department,salary};
            mv.gettModel().addRow(rowData);
        }

    }

}
//比较器
class MyComparator implements Comparator {
    private int clickCount; //count==1,升序;count>1，降序
    private String columnName;//属性（表头名称）

    public MyComparator(int clickCount,String columnName) {
        this.clickCount = clickCount;
        this.columnName = columnName;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Staff st1 = (Staff)o1;
        Staff st2 = (Staff)o2;
        int result=0;

        if("编号".equals(columnName)) {
            result = st1.getId() -st2.getId();//如果st1<st2，值为负，则不用交换位置。升序
        }else if("姓名".equals(columnName)) {
            result = st1.getName().compareTo(st2.getName());
        }else if("性别".equals(columnName)) {
            result = st1.getSex().compareTo(st2.getSex());
        }else if("部门".equals(columnName)) {
            result = st1.getDepartment().compareTo(st2.getDepartment());
        }else if("工资".equals(columnName)) {
            result = st1.getSalary() - st2.getSalary();
        }
        //鼠标非单击,则降序
        if(clickCount>1) {
            result = -result;
        }
        return result;
    }

}
