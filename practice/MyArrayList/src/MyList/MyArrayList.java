package MyList;

import java.util.Stack;

public class MyArrayList {

    //循序存储结构,由数组来实现(一块连续的存储空间)

    private int size;//长度
    private Object [] obj;//数据元素的集合
    public MyArrayList(){
        obj = new Object[0];
    }


    //增加
    //在末尾增加元素
    public void add(Object data){
        if (size==0){
            obj= new Object[1];
            obj[0]=data;
            size++;
        }else {
            Object [] newObj = new Object[size+1];
            System.arraycopy(obj,0,newObj,0,size);
            newObj[size] = data;
            size++;
            obj=newObj;
        }
    }
    //指定位置增加
    public void add(Object data,int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException(index+">"+size);
        }else {
            Object [] newObj = new Object[size+1];
            //拷贝前半部分
            System.arraycopy(obj,0,newObj,0,index);
            newObj[index]=data;
            //拷贝后半部分
            System.arraycopy(obj,index,newObj,index+1,size-index);
            obj = newObj;
            size++;
        }
    }
    //删除
    //删除指定索引
    public void remove(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException(index+ ">" + size);
        }else {
            Object [] newObj = new Object[size-1];
            //拷贝前半部分数组
            System.arraycopy(obj,0,newObj,0,index);
            //拷贝后半部分
            System.arraycopy(obj,index+1,newObj,index,size-index-1);
            obj = newObj;
            size--;
        }

    }
    //删除第一次出现的指定元素
    public boolean remove(Object data){
        if (data==null){
            for (int i = 0; i<obj.length; i++){
                if (obj[i]==data){//匹配要删除的元素
                    remove(i);
                    return true;//删完结束
                }
            }
        }
        return false;
    }
    //修改
    public void set(int index,Object data){
        obj[index] = data;
    }
    //查询
    public Object get(int index){
        return obj[index];
    }
    //返回长度
    public int size(){
        return size;
    }
    //toString的重写


    @Override
    public String toString() {
        String str = "[";
        for (Object o:obj){
            str+=o+",";
        }
        if (str.length()!=1){
            str = str.substring(0,str.length()-1);
        }
        return str+="]";
    }
}
