import org.junit.Assert;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 */


public class Meeting_Room {

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0;}
        Interval(int s, int e) { start = s; end = e;}
    }

    private boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (Interval o1, Interval o2) -> (o1.start - o2.end));
        Interval prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (prev.end > cur.start) {
                return false;
            }
            prev = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Meeting_Room meeting_room = new Meeting_Room();
        Interval[] intervals = new Interval[] {
            new Interval(0, 30),
            new Interval(5 , 10),
            new Interval(15, 20)
        };
        Assert.assertEquals(meeting_room.canAttendMeetings(intervals), false);


    }
}
