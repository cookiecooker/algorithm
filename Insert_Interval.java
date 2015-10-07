/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        for(int i = 0;i < intervals.size();i++){
            
            if(newInterval.end < intervals.get(i).start){
                intervals.add(i,newInterval);
                return intervals;
            }else if(newInterval.start > intervals.get(i).end){
                continue;
            }else{
                
                newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
                intervals.remove(i--);
            }
        }
        
        intervals.add(newInterval);
        return intervals;
    }
}
