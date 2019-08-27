package MyList;

import java.util.Stack;

public class MyArrayList {

    //ѭ��洢�ṹ,��������ʵ��(һ�������Ĵ洢�ռ�)

    private int size;//����
    private Object [] obj;//����Ԫ�صļ���
    public MyArrayList(){
        obj = new Object[0];
    }


    //����
    //��ĩβ����Ԫ��
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
    //ָ��λ������
    public void add(Object data,int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException(index+">"+size);
        }else {
            Object [] newObj = new Object[size+1];
            //����ǰ�벿��
            System.arraycopy(obj,0,newObj,0,index);
            newObj[index]=data;
            //������벿��
            System.arraycopy(obj,index,newObj,index+1,size-index);
            obj = newObj;
            size++;
        }
    }
    //ɾ��
    //ɾ��ָ������
    public void remove(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException(index+ ">" + size);
        }else {
            Object [] newObj = new Object[size-1];
            //����ǰ�벿������
            System.arraycopy(obj,0,newObj,0,index);
            //������벿��
            System.arraycopy(obj,index+1,newObj,index,size-index-1);
            obj = newObj;
            size--;
        }

    }
    //ɾ����һ�γ��ֵ�ָ��Ԫ��
    public boolean remove(Object data){
        if (data==null){
            for (int i = 0; i<obj.length; i++){
                if (obj[i]==data){//ƥ��Ҫɾ����Ԫ��
                    remove(i);
                    return true;//ɾ�����
                }
            }
        }
        return false;
    }
    //�޸�
    public void set(int index,Object data){
        obj[index] = data;
    }
    //��ѯ
    public Object get(int index){
        return obj[index];
    }
    //���س���
    public int size(){
        return size;
    }
    //toString����д


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
