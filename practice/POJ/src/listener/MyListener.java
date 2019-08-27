package listener;


/**
 * 增加：57	增加-确认：163
 * 删除：62
 * 修改：75	修改-确认：215
 * 查询：100	查询-确认：274
 * 更新：105
 * 导入：121
 * 导出：153
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dao.EmployeesDao;
import model.Staff;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import view.MainView;
import view.PlusView;

public class MyListener implements ActionListener {
    private MainView mv;
    private PlusView pv;

    public MyListener(MainView mv, PlusView pv) {
        this.mv = mv;
        this.pv = pv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        String title = pv.getJframe().getTitle();

        //点击取消，就将pv窗口隐藏
        if ("取消".equals(str)) {
            pv.getJframe().setVisible(false);
        } else if ("增加".equals(str)) {// 点击mv的增加按钮
            pv.getJframe().setVisible(true);
            pv.getJframe().setTitle(str);
            pv.getJp6().setVisible(false);
            clear();
        } else if ("删除".equals(str)) {// 点击mv的删除按钮
            // 新建staffDao对象
            EmployeesDao staffDao = new EmployeesDao();

            int rowUpd = mv.getTable().getSelectedRow();
            if (rowUpd == -1) {
                //提示框
                JOptionPane.showMessageDialog(null, "请选择一行进行修改！");
            } else {
                // 获取选中的行数
                int[] rows = mv.getTable().getSelectedRows();
                // 遍历删除
                for (int i = rows.length - 1; i >= 0; i--) {
                    // 删除数据库中的内容
                    String id = (String) mv.gettModel().getValueAt(rows[i], 0);
                    staffDao.deleteById(Integer.parseInt(id));
                    // 移除表格中的内容
                    mv.gettModel().removeRow(rows[i]);
                }
            }
        } else if ("修改".equals(str)) {// 点击mv的修改按钮
            // 选中的所在行数
            int rowUpd = mv.getTable().getSelectedRow();
            //未选中任何一行
            if (rowUpd == -1) {
                //提示框
                JOptionPane.showMessageDialog(null, "请选择一行进行修改！");
            } else {
                // 拿到本行中的所有数据
                String id = String.valueOf(mv.gettModel().getValueAt(rowUpd, 0));
                String name = (String) mv.gettModel().getValueAt(rowUpd, 1);
                String sex = (String) mv.gettModel().getValueAt(rowUpd, 2);
                String department = (String) mv.gettModel().getValueAt(rowUpd, 3);
                String salary = String.valueOf(mv.gettModel().getValueAt(rowUpd, 4));
                // 将数据赋值给pv修改框
                pv.getJtf1().setText(id);
                pv.getJtf2().setText(name);
                pv.getJcb3().setSelectedItem(sex);
                pv.getJcb4().setSelectedItem(department);
                pv.getJtf5().setText(salary);

                pv.getJframe().setVisible(true);
                pv.getJframe().setTitle(str);
            }
            pv.getJp6().setVisible(false);
        } else if ("查询".equals(str)) {
            pv.getJframe().setVisible(true);
            pv.getJp6().setVisible(true);
            pv.getJframe().setTitle(str);
            clear();
        } else if ("更新".equals(str)) {
            mv.gettModel().setRowCount(0);
            EmployeesDao staffDao = new EmployeesDao();
            ArrayList<Staff> al = staffDao.selectAll();
            Iterator<Staff> it = al.iterator();

            while (it.hasNext()) {
                Staff staff = it.next();
                String id = String.valueOf(staff.getId());
                String name = staff.getName();
                String sex = staff.getSex();
                String department = staff.getDepartment();
                String salary = String.valueOf(staff.getSalary());
                Object[] dataRow = {id, name, sex, department, salary};
                mv.gettModel().addRow(dataRow);
            }
        } else if ("导入".equals(str)) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            try {
                // 调用read(),将xml数据导入表格
                read(f);
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
            // 是--0 取消--2
            int i = JOptionPane.showConfirmDialog(null, "是否添加到数据库中?",
                    "提示框", JOptionPane.OK_CANCEL_OPTION);
            if (i == 0) {
                // 表格中的行数
                int rows = mv.getTable().getRowCount();

                Staff staff = new Staff();
                EmployeesDao staffDao = new EmployeesDao();
                for (int j = 0; j < rows; j++) {
                    int id = Integer.parseInt((String) mv.gettModel().getValueAt(j, 0));
                    if (staffDao.selectExist(id) != -1) {
                        JOptionPane.showMessageDialog(null, "编号" + id + "已存在");
                        continue;
                    }
                    String name = (String) mv.gettModel().getValueAt(j, 1);
                    String sex = (String) mv.gettModel().getValueAt(j, 2);
                    String department = (String) mv.gettModel().getValueAt(j, 3);
                    int salary = Integer.parseInt((String) mv.gettModel().getValueAt(j, 4));
                    staff.setId(id);
                    staff.setName(name);
                    staff.setSex(sex);
                    staff.setDepartment(department);
                    staff.setSalary(salary);
                    staffDao.addStaff(staff);
                }
            }
        } else if ("导出".equals(str)) {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            File f = chooser.getSelectedFile();
            try {
                // 调用write(),将表格中的数据导入xml
                write(f);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if ("增加".equals(title) && "确认".equals(str)) {// pv的title为“增加”，触发pv的按钮为“确认”
            EmployeesDao staffDao = new EmployeesDao();
            // 拿到PlusView的数据
            String id = pv.getJtf1().getText();
            String name = pv.getJtf2().getText();
            String sex = (String) pv.getJcb3().getSelectedItem();
            String department = (String) pv.getJcb4().getSelectedItem();
            String salary = pv.getJtf5().getText();

            //检验添加的id是否重复，name是否为空，部门是否为空
            //将所有的数字型字符替换为空
            int count = 0;
            String idRep = id.replaceAll("[0-9]", "");
            String salaryRep = salary.replaceAll("[0-9]", "");
            if ("".equals(id)) {
                JOptionPane.showMessageDialog(null, "编号不能为空！");
            } else if ("".equals(name)) {
                JOptionPane.showMessageDialog(null, "名字不能为空！");
            } else if ("".equals(sex)) {
                JOptionPane.showMessageDialog(null, "性别不能为空！");
            } else if ("".equals(department)) {
                JOptionPane.showMessageDialog(null, "部门不能为空！");
            } else if ("".equals(salary)) {
                JOptionPane.showMessageDialog(null, "薪水不能为空！");
            } else if (!(idRep.length() == 0)) {
                JOptionPane.showMessageDialog(null, "编号格式错误，请输入纯数字");
                count++;
            } else if (!(salaryRep.length() == 0)) {
                JOptionPane.showMessageDialog(null, "工资格式错误，请输入纯数字");
                count++;
            }
            if (count == 0) {
                Boolean exist = staffDao.selectIsExist(Integer.parseInt(id));
                if (exist == true) {
                    JOptionPane.showMessageDialog(null, "编号：" + id + "已存在,请更换!");
                } else if (exist == false) {
                    // 数据赋值给数组
                    Object[] rowData = {id, name, sex, department, salary};
                    // 添加至表格模型
                    mv.gettModel().addRow(rowData);
                    // 将数据赋值给对象staff
                    Staff staff = new Staff();
                    staff.setId(Integer.parseInt(id));
                    staff.setName(name);
                    staff.setSex(sex);
                    staff.setDepartment(department);
                    staff.setSalary(Integer.parseInt(salary));
                    // 添加至数据库
                    staffDao.addStaff(staff);
                    pv.getJframe().setVisible(false);
                }
            }
        } else if ("修改".equals(title) && "确认".equals(str)) {
            EmployeesDao staffDao = new EmployeesDao();
            //获得选中的行数
            int rowUpd = mv.getTable().getSelectedRow();
            // 获得原id
            String idOld = (String) mv.gettModel().getValueAt(rowUpd, 0);

            // 拿到PlusView的数据
            String id = pv.getJtf1().getText();
            String name = pv.getJtf2().getText();
            String sex = (String) pv.getJcb3().getSelectedItem();
            String department = (String) pv.getJcb4().getSelectedItem();
            String salary = pv.getJtf5().getText();
            //==================================
            //检验添加的id是否重复，name是否为空，部门是否为空
            //将所有的数字型字符替换为空
            int count = 0;
            String idRep = id.replaceAll("[0-9]", "");
            String salaryRep = salary.replaceAll("[0-9]", "");
            if ("".equals(id)) {
                JOptionPane.showMessageDialog(null, "编号不能为空！");
            } else if ("".equals(name)) {
                JOptionPane.showMessageDialog(null, "名字不能为空！");
            } else if ("".equals(sex)) {
                JOptionPane.showMessageDialog(null, "性别不能为空！");
            } else if ("".equals(department)) {
                JOptionPane.showMessageDialog(null, "部门不能为空！");
            } else if ("".equals(salary)) {
                JOptionPane.showMessageDialog(null, "薪水不能为空！");
            } else if (!(idRep.length() == 0)) {
                JOptionPane.showMessageDialog(null, "编号格式错误，请输入纯数字");
                count++;
            } else if (!(salaryRep.length() == 0)) {
                JOptionPane.showMessageDialog(null, "工资格式错误，请输入纯数字");
                count++;
            }
            if (count == 0) {
                int exist = staffDao.selectExist(Integer.parseInt(id));
                if (exist != -1 && exist != Integer.parseInt(idOld)) {
                    JOptionPane.showMessageDialog(null, "编号：" + id + "已存在,请更换!");
                } else if (exist == -1 || exist == Integer.parseInt(idOld)) {
                    // 数据赋值给数组
                    Object[] rowData = {id, name, sex, department, salary};
                    //删除表格中选中的这一行数据
                    mv.gettModel().removeRow(rowUpd);
                    //增加新数据
                    mv.gettModel().addRow(rowData);
                    // 将数据赋值给对象staff
                    Staff staff = new Staff();
                    staff.setId(Integer.parseInt(id));
                    staff.setName(name);
                    staff.setSex(sex);
                    staff.setDepartment(department);
                    staff.setSalary(Integer.parseInt(salary));
                    // 将数据库信息修改
                    staffDao.updateById(staff, Integer.parseInt(idOld));
                    pv.getJframe().setVisible(false);
                }
            }
        } else if ("查询".equals(title) && "确认".equals(str)) {

            StringBuffer sql = new StringBuffer("select * from staff ");

            // 将非空文本信息纳入hm
            HashMap<Object, Object> hm = new HashMap<>();
            // 非空信息条数
            int num = 0;
            if (!"".equals(pv.getJtf1().getText())) {
                int id = Integer.parseInt(pv.getJtf1().getText());
                hm.put("id", id);
                num++;
            }
            if (!"".equals(pv.getJtf2().getText())) {
                String name = pv.getJtf2().getText();
                hm.put("name", name);
                num++;
            }
            if (!"".equals(pv.getJcb3().getSelectedItem())) {
                String sex = (String) pv.getJcb3().getSelectedItem();
                hm.put("sex", sex);
                num++;
            }
            if (!"".equals(pv.getJcb4().getSelectedItem())) {
                String department = (String) pv.getJcb4().getSelectedItem();
                hm.put("department", department);
                num++;
            }
            if (!"".equals(pv.getJtf5().getText())) {
                int salary = Integer.parseInt(pv.getJtf5().getText());
                hm.put("salary", salary);
                num++;
            }

            // 判断有几条命令可用
            if (num == 0) {// 查询条件为0时
                mv.gettModel().setRowCount(0);
                EmployeesDao staffDao = new EmployeesDao();
                ArrayList<Staff> al = staffDao.selectBySql(sql.toString());

                // 测试，可删
                System.out.println(sql.toString());

                Iterator<Staff> it = al.iterator();
                while (it.hasNext()) {
                    Staff staff = it.next();
                    String id = String.valueOf(staff.getId());
                    String name = staff.getName();
                    String sex = staff.getSex();
                    String department = staff.getDepartment();
                    String salary = String.valueOf(staff.getSalary());
                    Object[] rowData = {id, name, sex, department, salary};
                    mv.gettModel().addRow(rowData);
                }

            } else if (num == 1) {// 查询条件为一个时
                Set<Object> keySet = hm.keySet();
                // 仅会执行一次
                for (Object key : keySet) {
                    Object value = hm.get(key);
                    // 将男女转化为01
                    if ("sex".equals(key)) {
                        value = hm.get(key);
                        if ("男".equals(value)) {
                            value = 1;
                        } else if ("女".equals(value)) {
                            value = 0;
                        }
                    }
                    sql.append("where ").append(key).append(" like ").append("\"%").append(value).append("%\"");
                }
                mv.gettModel().setRowCount(0);

                // 用查询语句将数据库信息 添加至mv表格中
                EmployeesDao staffDao = new EmployeesDao();
                ArrayList<Staff> al = staffDao.selectBySql(sql.toString());

                // 测试，可删
                System.out.println(sql.toString());

                Iterator<Staff> it = al.iterator();
                while (it.hasNext()) {
                    Staff staff = it.next();
                    String id = String.valueOf(staff.getId());
                    String name = staff.getName();
                    String sex = staff.getSex();
                    String department = staff.getDepartment();
                    String salary = String.valueOf(staff.getSalary());
                    Object[] rowData = {id, name, sex, department, salary};
                    mv.gettModel().addRow(rowData);
                }

            } else if (num > 1 && "".equals(pv.getJcb6().getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "请选择查询条件！");
            } else if (num > 1) {
                String andOr = (String) pv.getJcb6().getSelectedItem();
                // hm.put("andOr", andOr);
                Set<Object> keySet = hm.keySet();
                int length = keySet.size();
                // 测试，可删
                System.out.println("查询条件的个数：" + length);
                int count = 0;
                for (Object key : keySet) {
                    count++;
                    Object value = hm.get(key);
                    if ("sex".equals(key)) {
                        value = hm.get(key);
                        if ("男".equals(value)) {
                            value = 1;
                        } else if ("女".equals(value)) {
                            value = 0;
                        }
                    }
                    if (count == 1) {
                        sql.append("where ").append(key).append(" like ").append("\"%").append(value).append("%\" ")
                                .append(andOr).append(" ");
                        continue;
                    }
                    if (count == length) {
                        sql.append(key).append(" like ").append("\"%").append(value).append("%\" ");
                        continue;
                    }
                    sql.append(key).append(" like ").append("\"%").append(value).append("%\" ").append(andOr).append(" ");
                }
                mv.gettModel().setRowCount(0);

                // 用查询语句将数据库信息 添加至mv表格中
                EmployeesDao staffDao = new EmployeesDao();
                ArrayList<Staff> al = staffDao.selectBySql(sql.toString());

                // 测试，可删
                System.out.println(sql.toString());

                Iterator<Staff> it = al.iterator();
                while (it.hasNext()) {
                    Staff staff = it.next();
                    String id = String.valueOf(staff.getId());
                    String name = staff.getName();
                    String sex = staff.getSex();
                    String department = staff.getDepartment();
                    String salary = String.valueOf(staff.getSalary());
                    Object[] rowData = {id, name, sex, department, salary};
                    mv.gettModel().addRow(rowData);
                }
            }
        }
    }

    // 清空PlusView内容
    public void clear() {
        pv.getJtf1().setText("");
        pv.getJtf2().setText("");
        pv.getJtf5().setText("");
        pv.getJcb3().setSelectedIndex(0);
        pv.getJcb4().setSelectedIndex(0);
    }

    // 读xml至表格的操作
    public void read(File file) throws DocumentException {
        // 将表格中的数据清空
        mv.gettModel().setRowCount(0);
        // 1.将文件解析成文档树
        SAXReader r = new SAXReader();
        Document document = r.read(file);

        // 2.遍历
        // 获取根节点
        Element root = document.getRootElement();
        // 获得根节点下的所有子节点
        List<Element> list = root.elements();
        // 存放元素上子节点的子节点的文本内容
        Object[] dataRow = new Object[5];
        for (Element ele : list) {
            // 获得元素上的子节点
            List<Element> ls = ele.elements();
            // 子节点的子节点的文本内容
            for (int i = 0; i < ls.size(); i++) {
                dataRow[i] = ls.get(i).getText();
            }
            // 放入mv表格中
            mv.gettModel().addRow(dataRow);

        }

    }

    // 将表格中的数据写入xml
    public void write(File file) throws IOException {
        ArrayList<Staff> al = new ArrayList<>();
        // 表格中的行数
        int rows = mv.getTable().getRowCount();
        // 拿到所有数据
        for (int i = 0; i < rows; i++) {
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
            // 将数据放至集合中
            al.add(staff);
        }

        // 1.创建空文档树
        Document document = DocumentHelper.createDocument();

        // 2.建立节点和内容并确立关系
        // 建立根节点
        Element staffs = document.addElement("staffs");
        for (Staff s : al) {
            // 建立子节点
            Element staff = staffs.addElement("staff");
            staff.addElement("id").setText(String.valueOf(s.getId()));
            staff.addElement("name").setText(s.getName());
            staff.addElement("sex").setText(s.getSex());
            staff.addElement("department").setText(s.getDepartment());
            staff.addElement("salary").setText(String.valueOf(s.getSalary()));
        }

        // 3.将文档书传输至文件
        // 采用平台默认编码传输 可能出现编码异常
        FileWriter fw = new FileWriter(file);
        // 以utf-8编码格式是进行输出
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
        document.write(osw);
        osw.flush();
        osw.close();
    }
}
