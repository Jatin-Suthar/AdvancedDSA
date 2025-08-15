package Heap_Queues;

import java.util.*;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        System.out.println(new Solution().mostBooked(n, meetings));
    }
    static class Solution {
        public int mostBooked(int n, int[][] meetings) {
            int size = meetings.length, ans = 0, max = 0;
            Map<Integer, List<Integer>> meetingEndMap = new HashMap<>();
            int[] rooms = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int k=0;
            PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
            for(int i=0; i<n; i++) availableRooms.add(i);
            for(int time=0; time<=500000; time++) {
                while(k<size && meetings[k][0] == time) {
                    pq.add(k++);
                }
                if(meetingEndMap.get(time)!=null) {
                    availableRooms.addAll(meetingEndMap.get(time));
                    meetingEndMap.remove(time);
                }
                while(!availableRooms.isEmpty()) {
                    if(!pq.isEmpty()) {
                        int room = availableRooms.poll();
                        rooms[room]++;
                        int[] meet = meetings[pq.poll()];
                        meetingEndMap.computeIfAbsent(meet[1] + (time-meet[0]), key -> new ArrayList<>()).add(room);
                    } else {
                        if(k>size) return ans;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                if(rooms[i] > max) {
                    max = rooms[i];
                    ans = i;
                }
            }
            return ans;
        }
    }
}
