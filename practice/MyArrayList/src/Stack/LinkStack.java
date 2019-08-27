package Stack;

/**
 * ��ջ
 * <p>
 * Created by ietree
 * 2017/4/29
 */
public class LinkStack {

    // ����һ���ڲ���Node��Nodeʵ��������ջ�Ľڵ�
    private class Node {
        // ����ڵ������
        private Object data;
        // ָ���¸��ڵ������
        private Node next;

        // �޲ι�����
        public Node() {
        }
        // ��ʼ��ȫ�����ԵĹ�����
        public Node(Object data, Node next) {

            this.data = data;
            this.next = next;
        }
    }

    // �������ջ��ջ��Ԫ��
    private Node top;
    // �������ջ���Ѱ����Ľڵ���
    private int size;

    // ��������ջ
    public LinkStack() {
        // ����ջ��top��ֵΪnull
        top = null;

    }

    // ��ָ������Ԫ����������ջ������ջֻ��һ��Ԫ��
    public LinkStack(Object element) {
        top = new Node(element, null);
        size++;

    }

    // ������ջ�ĳ���
    public int length() {
        return size;
    }

    // ��ջ
    public void push(Object element) {
        // ��topָ���´�����Ԫ�أ���Ԫ�ص�next����ָ��ԭ����ջ��Ԫ��
        top = new Node(element, top);
        size++;

    }

    // ��ջ
    public Object pop() {
        Node oldTop = top;
        // ��top����ָ��ԭջ��Ԫ�ص���һ��Ԫ��
        top = top.next;
        // �ͷ�ԭջ��Ԫ�ص�next����
        oldTop.next = null;
        size--;
        return oldTop.data;

    }

    // ����ջ��Ԫ�أ�����ɾ��ջ��Ԫ��
    public Object peek() {
        return top.data;
    }
    // �ж���ջ�Ƿ�Ϊ��ջ
    public boolean empty() {
        return size == 0;

    }
    // �����ջ
    public void clear() {

        top = null;
        size = 0;

    }

    public String toString() {

        // ��ջΪ��ջʱ
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