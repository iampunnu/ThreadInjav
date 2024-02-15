public class CheckStatus {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            try {Thread t=new Thread("t");
              //  t.join();
                for (int i=0;i<10;i++){

                }

                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t");
        thread.start();
        while (true){
            Thread.State state=thread.getState();
            System.out.println(state);
            if (state==Thread.State.TERMINATED){
                break;
            }
        }
    }
}
