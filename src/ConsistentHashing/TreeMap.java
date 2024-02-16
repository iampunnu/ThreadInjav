package ConsistentHashing;

import java.util.SortedMap;

public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<Long, String> ring=new java.util.TreeMap<>();
        ring.put(10l,"a");
        ring.put(15l,"b");

        ring.put(20l,"a");
        ring.put(25l,"b");

        ring.put(30l,"a");
        ring.put(35l,"b");

        ring.put(45l,"c");
        System.out.println("The tailMap is " + ring.tailMap(36l));

        long hash=36;
        if (!ring.containsKey(hash)) {
            SortedMap<Long, String> tailMap = ring.tailMap(hash);
            hash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        }
        System.out.println(ring.get(hash));
    }


}
