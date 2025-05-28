package BinarySearch;

import java.util.*;

public class MyCalendarII {
    /*
    ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
    [[],[28,46],[9,21],[21,39],[37,48],[38,50],[22,39],[45,50],[1,12],[40,50],[31,44]]
     */
    public static void main(String[] args) {
        String[] commands = {"MyCalendarTwo","book","book","book","book","book","book","book","book","book","book",
                "book","book","book","book","book","book","book","book","book","book","book","book",
                "book","book","book","book","book","book","book","book"};
        int[][] values = {{},{47,50},{1,10},{27,36},{40,47},{20,27},{15,23},{10,18},{27,36},{17,25},
                {8,17},{24,33},{23,28},{21,27},{47,50},{14,21},{26,32},{16,21},{2,7},{24,33},
                {6,13},{44,50},{33,39},{30,36},{6,15},{21,27},{49,50},{38,45},{4,12},{46,50},
                {13,21}};

        MyCalendarTwo myCalendar = null;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "MyCalendarTwo":
                    myCalendar = new MyCalendarTwo();
                    System.out.println("null");
                    break;
                case "book":
                    int start = values[i][0];
                    int end = values[i][1];
                    boolean result = myCalendar.book(start, end);
                    System.out.println(result);
                    break;
            }
        }
    }
}

class MyCalendarTwo {

    List<Interval> list;

    public MyCalendarTwo() {
        list = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        if(list.isEmpty()) {
            list.add(new Interval(startTime, endTime));
            return true;
        } else {
            list.sort(Comparator.comparing(a -> a.x));
            if(searchIfPresent(list, startTime, endTime)) {
                return false;
            }
            list.add(new Interval(startTime, endTime));
            return true;
        }
    }

    boolean searchIfPresent(List<Interval> list, int stTime, int edTime) {
        int st = 0, ed = list.size()-2;
        while(st<=ed) {
            int mid = (st+ed) >> 1;
            Interval mFirst = list.get(mid);
            Interval mSecnd = list.get(mid+1);
            if(mFirst.x < mSecnd.y && mSecnd.x < mFirst.y
                    && stTime < mFirst.y && mFirst.x < edTime
                    && stTime < mSecnd.y && mSecnd.x < edTime) {
                return true;
            } else if(stTime < mFirst.y && stTime < mSecnd.y) {
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
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */