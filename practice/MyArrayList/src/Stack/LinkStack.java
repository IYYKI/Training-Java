package Stack;

/**
 * 链栈
 * <p>
 * Created by ietree
 * 2017/4/29
 */
public class LinkStack {

    // 定义一个内部类Node，Node实例代表链栈的节点
    private class Node {
        // 保存节点的数据
        private Object data;
        // 指向下个节点的引用
        private Node next;

        // 无参构造器
        public Node() {
        }
        // 初始化全部属性的构造器
        public Node(Object data, Node next) {

            this.data = data;
            this.next = next;
        }
    }

    // 保存该链栈的栈顶元素
    private Node top;
    // 保存该链栈中已包含的节点数
    private int size;

    // 创建空链栈
    public LinkStack() {
        // 空链栈，top的值为null
        top = null;

    }

    // 以指定数据元素来创建链栈，该链栈只有一个元素
    public LinkStack(Object element) {
        top = new Node(element, null);
        size++;

    }

    // 返回链栈的长度
    public int length() {
        return size;
    }

    // 进栈
    public void push(Object element) {
        // 让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
        top = new Node(element, top);
        size++;

    }

    // 出栈
    public Object pop() {
        Node oldTop = top;
        // 让top引用指向原栈顶元素的下一个元素
        top = top.next;
        // 释放原栈顶元素的next引用
        oldTop.next = null;
        size--;
        return oldTop.data;

    }

    // 访问栈顶元素，但不删除栈顶元素
    public Object peek() {
        return top.data;
    }
    // 判断链栈是否为空栈
    public boolean empty() {
        return size == 0;

    }
    // 请空链栈
    public void clear() {

        top = null;
        size = 0;

    }

    public String toString() {

        // 链栈为空栈时
        if (empty()) {

            return "[]";

        } else {

            StringBuilder sb = new StringBuilder("[");
            for (Node current = top; current != null; current = current.next) {

                sb.append(current.data.toString() + ", ");

            }

            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }

    }

}