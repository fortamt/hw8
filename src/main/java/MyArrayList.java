

public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size;
    Object[] myData;

    public MyArrayList(int capacity){
        if(capacity > 0){
            this.myData = new Object[capacity];
        } else if(capacity == 0){
            this.myData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public MyArrayList(){ this.myData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA; }

    public boolean add(Object value){
        size++;
        Object[] temp = new Object[size];
        if(myData.length > 0) {
            for (int i = 0; i < this.myData.length; i++) {
                temp[i] = this.myData[i];
            }
        }
        temp[temp.length-1] = value;
        myData = temp;
        return true;
    }

    public void remove(int index){
        this.myData[index] = null;
        trim(this.myData);
    }

    public void clear(){
        this.myData = new Object[DEFAULT_CAPACITY];
        trim(this.myData);
    }

    public int size(){
        return this.myData.length;
    }

    public Object get(int index){

        return this.myData[index];
    }



    private void trim(Object[] object){
        int newSize = 0;
        for(Object o : object){
            if(o != null){
                newSize++;
            }
        }
        Object[] temp = this.myData;
        this.myData = new Object[newSize];
        int tempTrimmedArray = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != null){
                this.myData[tempTrimmedArray] = temp[i];
                tempTrimmedArray++;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder result;
        if(this.myData == null){
            result = new StringBuilder("[]");
        } else {
            result = new StringBuilder("[");
            for (Object o : myData) {
                result.append(o);
                result.append(" ");
            }
            result.append("]");
        }
        return result.toString();
    }


}


class Test{
    public static void main(String[] args) {
        MyArrayList my = new MyArrayList();
        my.add("один");
        System.out.println(my);
        my.add("два");
        System.out.println(my);
        my.add("три");
        System.out.println(my);
        my.add("четыре");
        System.out.println(my);
        my.add("пять");
        System.out.println(my);
        my.add("шесть");
        System.out.println(my);
        my.add("семь");
        System.out.println(my);
        my.add("восемь");
        System.out.println(my);
        my.remove(0);
        System.out.println(my);
        System.out.println(my.size());
        System.out.println(my.get(3));
        System.out.println(my);
        my.remove(3);
        System.out.println(my);
        my.clear();
        System.out.println(my);
        System.out.println(my.size());
    }
}