package view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import listener.HeaderListener;
import listener.MyListener;

public class MainView {

    private JFrame jframe;
    private DefaultTableModel tModel;
    private JTable table;
    private JScrollPane jsp;
    private PlusView pv;


    public MainView() {
        init();
    }

    public void init() {
        //新建plus表
        pv = new PlusView(this);
        jframe = new JFrame("人事管理系统");
        Container con = jframe.getContentPane();
        con.setLayout(new FlowLayout());

        //1.菜单栏
        JMenuBar bar = new JMenuBar();

        JMenu jmFile = new JMenu("文件");
        JMenuItem jmHelp = new JMenuItem("帮助");
        //“文件”下的子菜单
        JMenuItem jmAdd = new JMenuItem("增加");
        JMenuItem jmRef = new JMenuItem("更新");
        JMenuItem jmDel = new JMenuItem("删除");
        JMenuItem jmUpd = new JMenuItem("修改");
        JMenuItem jmSel = new JMenuItem("查询");
        JMenuItem jmInp = new JMenuItem("导入");
        JMenuItem jmOut = new JMenuItem("导出");
        bar.add(jmFile);
        bar.add(jmHelp);
        jmFile.add(jmAdd);
        jmFile.add(jmRef);
        jmFile.add(jmDel);
        jmFile.add(jmUpd);
        jmFile.add(jmSel);
        jmFile.add(jmInp);
        jmFile.add(jmOut);
        jframe.setJMenuBar(bar);

        MyListener ml = new MyListener(this,pv);
        jmAdd.addActionListener(ml);
        jmRef.addActionListener(ml);
        jmDel.addActionListener(ml);
        jmUpd.addActionListener(ml);
        jmSel.addActionListener(ml);
        jmInp.addActionListener(ml);
        jmOut.addActionListener(ml);

        //2.顶部文本
        JLabel topLab = new JLabel("人事管理系统");
        con.add(topLab);

        //3.表格
        Object[] colName = {"编号","姓名","性别","部门","工资"};
        //表格模型
        tModel = new DefaultTableModel(colName, 0);
        //新建表格
        table = new JTable(tModel);
        //滚动容器
        jsp = new JScrollPane(table);
        con.add(jsp);

        //给表头添加鼠标监听
        JTableHeader tableHeader = table.getTableHeader();
        HeaderListener hl = new HeaderListener(this);
        tableHeader.addMouseListener(hl);

        //4.添加按钮
        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("增加");
        JButton btnDel = new JButton("删除");
        JButton btnUpd = new JButton("修改");
        JButton btnSel = new JButton("查询");
        JButton btnRef = new JButton("更新");
        btnPanel.add(btnAdd);
        btnPanel.add(btnDel);
        btnPanel.add(btnUpd);
        btnPanel.add(btnSel);
        btnPanel.add(btnRef);
        con.add(btnPanel);


        btnAdd.addActionListener(ml);
        btnDel.addActionListener(ml);
        btnUpd.addActionListener(ml);
        btnSel.addActionListener(ml);
        btnRef.addActionListener(ml);

        jframe.setLocation(400,50);
        jframe.setSize(520, 600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }

    public DefaultTableModel gettModel() {
        return tModel;
    }

    public void settModel(DefaultTableModel tModel) {
        this.tModel = tModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    public void setJsp(JScrollPane jsp) {
        this.jsp = jsp;
    }

    public PlusView getPv() {
        return pv;
    }

    public void setPv(PlusView pv) {
        this.pv = pv;
    }


}
