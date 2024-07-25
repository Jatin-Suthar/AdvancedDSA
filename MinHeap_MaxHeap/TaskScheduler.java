package MinHeap_MaxHeap;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        TaskSchedulerSolution solution = new TaskSchedulerSolution();
        System.out.println(solution.leastInterval(tasks, n));

    }

}

class TaskSchedulerSolution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int task: tasks) freq[task-'A']++;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++) {
            if(freq[i]>0) {
                pq.add(freq[i]);
            }
        }
        int time = 0;
        Queue<SchedulePair> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int mostFreq = pq.poll() - 1;
                if (mostFreq != 0) {
                    q.add(new SchedulePair(mostFreq, time + n));
                }
            }
            if(!q.isEmpty() && q.peek().schedule==time) {
                pq.add(q.poll().frequency);
            }
        }
        return time;
    }
}

class SchedulePair {
    int frequency;
    int schedule;
    public SchedulePair(int frequency, int schedule) {
        this.frequency = frequency;
        this.schedule = schedule;
    }
}