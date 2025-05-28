package BinarySearch;

import java.util.*;

public class MyCalendarI {
}

class MyCalendar {
    List<Interval> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if(list.isEmpty()) {
            list.add(new Interval(startTime, endTime));
            return true;
        } else {
            Collections.sort(list, Comparator.comparing(a -> a.x));
            if(searchIfPresent(list, startTime, endTime)) {
                return false;
            }
            list.add(new Interval(startTime, endTime));
            return true;
        }
    }

    boolean searchIfPresent(List<Interval> list, int stTime, int edTime) {
        int st = 0, ed = list.size()-1;
        while(st<=ed) {
            int mid = (st+ed) >> 1;
            Interval mInt = list.get(mid);
            if(stTime < mInt.y && mInt.x < edTime) {
                return true;
            } else if(stTime < mInt.y) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return false;
    }

    static class Interval {
        int x;
        int y;
        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
 /*

10,19,


[10,20],[15,25],[8,9],[3,9],[20,30]

-----------------------------------
10
-----------------------------------
 */