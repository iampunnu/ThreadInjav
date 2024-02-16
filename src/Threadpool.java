import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Threadpool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadList = Executors.newFixedThreadPool(10000);
        List<Future<?>> list = new ArrayList<Future<?>>();
        try {
            for (int i=0;i<1000000;i++){
                int t=i;
                list.add(threadList.submit(()->call(t)));
            }
        }
        catch (Exception i){

        }
        finally {
            threadList.shutdown();
        }
        for (Future future:list){
            String errorMsg = future.get().toString();
            System.out.println(errorMsg);

        }

    }
    public static String call(int i) throws InterruptedException {
        Thread.sleep(1);
       // System.out.println("this is thread pool "+i);
        return "this is thread pool "+i;

    }
}
