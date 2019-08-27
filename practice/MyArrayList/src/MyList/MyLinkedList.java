package MyList;

public class MyLinkedList {
    //链的存储结构：一块不连续的存储空间 通过节点之间的关系来描述数据元素关系
    private Node head;//头节点
    private int size;//长度

    public MyLinkedList() {

    }
    //内部类 节点类--封装数据元素
    private class Node {
        Object data;//节点封装 的数据
        Node next;

        public Node(Object data) {
            super();
            this.data = data;
        }
    }

    //增加————
    //       |
    //       |——————》在链表末尾添加元素
    public void add(Object data) {
        Node newNode = new Node(data);//将数据封装成节点
        if (size == 0) {//第一次添加
            head = newNode;//新节点就是头节点
            size++;
        } else {
            Node tmp = head;//将头节点保存在临时节点中
            while (tmp.next != null) {//tmp不是最后一个节点
                tmp = tmp.next;//tmp指向下一个节点
            }
            //循环结束则表示tmp是最后一个节点
            tmp.next = newNode;//将新节点添加到tmp后面
            size++;
        }
    }

    //增加—————
    //        |
    //        |——————》指定位置添加元素
    public void add(Object data, int index) {
        Node newNode = new Node(data);
        if (index==0){
            Node tmp = head;
            head = newNode;
            newNode.next = tmp;
            size++;
        }else {
            newNode.next=getNode(index);
            getNode(index-1).next=newNode;
            size++;
        }
    }
    //删除--删除指定索引元素
    public void remove(int index){
        if (index==0){
            head = head.next;
            size--;
        }else {
            getNode(index - 1).next=getNode(index+1);
            size--;
        }
    }
    //删除--删除第一次出现的指定元素
    public boolean remove(Object data) {
        Node tmp = head;
        int count = 0;
        if (data == null) {
            while (tmp != null) {
                if (tmp.data == data) {
                    remove(count);
                    return true;
                }
                tmp = tmp.next;
                count++;//保存遍历的索引
            }
        } else {
            while (tmp != null) {
                if (tmp.data.equals(data)) {
                    remove(count);
                    return true;
                }
                tmp = tmp.next;
                count++;//保存遍历的索引
            }
        }
        return false;
    }
    //修改
    public void set(int index, Object data){
        getNode(index).data = data;
    }

    //查询
    public Object get(int index){
        return getNode(index).data;
    }

    //获得指定索引的节点
    public Node getNode(int index){
        Node tmp = head;//1
        int count = 0;
        while (count!=index){
            tmp = tmp.next;//2 3
            count++;
        }
        return tmp;
    }
    public int size(){
        return size;
    }



    //toString的重写
    @Override
    public String toString() {
        String str = "[";
        Node tmp = head;
        while (tmp !=null){
            str+=tmp.data+",";
            tmp = tmp.next;
        }
        if (str.length()!=1){
            str=str.substring(0,str.length()-1);
        }
        return str+"]";
    }
}