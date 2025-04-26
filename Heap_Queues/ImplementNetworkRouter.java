package Heap_Queues;

import java.util.*;

public class ImplementNetworkRouter {
}
class Router {
    private Set<String> set = new HashSet<>();
    private Queue<Packet> queue;
    private int size;

    // destination -> list of [timestamp, prefixSum]
    private Map<Integer, List<int[]>> destinationMap;

    public Router(int memoryLimit) {
        this.queue = new LinkedList<>();
        this.size = memoryLimit;
        this.destinationMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + " " + destination + " " + timestamp;
        if (set.contains(key)) return false;

        if (queue.size() >= size) {
            removePacketFromQueue();
        }

        queue.offer(new Packet(source, destination, timestamp));
        set.add(key);

        List<int[]> list = destinationMap.computeIfAbsent(destination, k -> new ArrayList<>());
        if (!list.isEmpty() && list.getLast()[0] == timestamp) {
            list.getLast()[1]++;
        } else {
            int lastSum = list.isEmpty() ? 0 : list.getLast()[1];
            list.add(new int[]{timestamp, lastSum + 1});
        }

        return true;
    }

    public int[] forwardPacket() {
        Packet removed = removePacketFromQueue();
        if (removed == null) return new int[0];
        return new int[]{removed.source, removed.destination, removed.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<int[]> list = destinationMap.get(destination);
        if (list == null || list.isEmpty()) return 0;

        int upper = upperBound(list, endTime);
        int lower = lowerBound(list, startTime - 1);

        return upper >= 0 ? list.get(upper)[1] - (lower >= 0 ? list.get(lower)[1] : 0) : 0;
    }

    private Packet removePacketFromQueue() {
        if (queue.isEmpty()) return null;

        Packet removed = queue.poll();
        String key = removed.source + " " + removed.destination + " " + removed.timestamp;
        set.remove(key);

        List<int[]> list = destinationMap.get(removed.destination);
        if (list != null) {
            // Binary search to find timestamp
            int idx = findIndex(list, removed.timestamp);
            if (idx >= 0) {
                for (int i = idx; i < list.size(); i++) {
                    list.get(i)[1]--;
                }
                if (idx > 0 && list.get(idx)[1] == list.get(idx - 1)[1]) {
                    list.remove(idx);
                } else if (idx == 0 && list.getFirst()[1] == 0) {
                    list.removeFirst();
                }
                if (list.isEmpty()) destinationMap.remove(removed.destination);
            }
        }

        return removed;
    }

    // Binary search for upper bound ≤ time
    private int upperBound(List<int[]> list, int time) {
        int lo = 0, hi = list.size() - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid)[0] <= time) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    // Binary search for lower bound ≤ time
    private int lowerBound(List<int[]> list, int time) {
        int lo = 0, hi = list.size() - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid)[0] <= time) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    // Exact index for timestamp
    private int findIndex(List<int[]> list, int timestamp) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid)[0] == timestamp) return mid;
            else if (list.get(mid)[0] < timestamp) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}

class Packet {
    int source, destination, timestamp;
    public Packet(int s, int d, int t) {
        this.source = s;
        this.destination = d;
        this.timestamp = t;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */