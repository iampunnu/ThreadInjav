public class Stack {
    public int arr[];
    public  int top;
    public Object obj;
    public Stack(int capacity){
       arr= new int[capacity];
       top=-1;
       obj=new Object();
    }
    public void push(int data){
        synchronized (obj){
        System.out.println("inside push "+data);
        if (isFull()){return;}
        top++;
        try {
            Thread.sleep(1000);
        }catch (Exception e){}
        arr[top]=data;

    }}
    public int pop(){
        synchronized (obj){
        System.out.println("inside pop "+arr[top]);

        if (isEmpty()){return Integer.MIN_VALUE;}
        int ans=arr[top];

        arr[top]=Integer.MIN_VALUE;
        try {
            Thread.sleep(1000);
        }catch (Exception e){}
        top--;
        return ans;
    }}

    boolean isFull(){
        return top>=arr.length-1;
    }
    boolean isEmpty(){
        return top<0;
    }
}
