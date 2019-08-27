package Stack;
public class MyLinkStackTest {

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("ashjsa");
        System.out.println(stack);
        System.out.println("访问栈顶元素：" + stack.peek());
        System.out.println("第一次出栈顶元素：" + stack.pop());
        System.out.println("第二次出栈顶元素：" + stack.pop());
        System.out.println("两次出栈之后的栈：" + stack);
        System.out.println("剩余栈的长度为: "+ stack.length());
        stack.clear();
        System.out.println("清后栈的状态： "+stack);

    }

}