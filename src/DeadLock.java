public class DeadLock {

    public static void main(String[] args) {

        String lock1="praveen";
        String lock2="singh";
        Thread t=new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(100);
                    synchronized (lock2){
                        System.out.println("inside thread");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1");
        Thread t1=new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(100);
                    synchronized (lock1){
                        System.out.println("inside thread two");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread2");
        t.start();
        t1.start();
    }
}
