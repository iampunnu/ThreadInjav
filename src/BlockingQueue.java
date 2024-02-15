import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public boolean add(int data) {
        synchronized (queue) {
            while (queue.size() == capacity) { //we should not use if it will cause problem if mulltiple thread are in wait
                try {
                    queue.wait();
                } catch (Exception e) {
                }
            }
            queue.add(data);
            queue.notifyAll();
            return true;
        }
    }

    public int remove() {

        synchronized (queue) {
            while (capacity == 0)
                try {
                    queue.wait();
                } catch (Exception e) {

                }
               int ele=queue.poll();
            queue.notifyAll();
            return ele;
        }
    }
}
