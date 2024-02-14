public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("entry in main thread "+Thread.currentThread());
//        Thread thread=new Thread1("thread1");
//        thread.start();
       /* Thread thread1=new Thread(new Thread2(),"thread2");
        thread1.start();
        Thread thread=new Thread(()->{for(int i=0;i<5;i++){
            System.out.println("inside lamda runnable thread "+Thread.currentThread()+" "+i);
        }},"thread3");
        thread.start();*/
        Stack s=new Stack(10);
        Thread t=new Thread(()->{for(int i=0;i<10;i++){
            s.push(i);
        }});
        t.start();
        Thread t1=new Thread(()->{for(int i=0;i<10;i++){
            System.out.println(s.pop());
        }});
        t1.start();
        System.out.println("exiting  the main thread "+Thread.currentThread());


    }
}
