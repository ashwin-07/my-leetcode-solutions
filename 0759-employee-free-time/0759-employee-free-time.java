/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        
        List<Interval> freeTimes = new ArrayList<>();
        
        TreeMap<Integer, Integer> timeCountsMap = new TreeMap<>(); //count at point of time
        
        for (List<Interval> schedule:schedules) {
            for (Interval interval: schedule) {
                timeCountsMap.put(interval.start, timeCountsMap.getOrDefault(interval.start, 0)+1);
                timeCountsMap.put(interval.end, timeCountsMap.getOrDefault(interval.end, 0)-1);
            }
        }
        
        int startTime = -1, schedulesSum = 0;
        
        for (int time:timeCountsMap.keySet()) {
           schedulesSum+= timeCountsMap.get(time);
            
            if (schedulesSum == 0 && startTime == -1) {
                startTime = time;
            } 
            else if (startTime != -1) {
                freeTimes.add(new Interval(startTime, time));  
                startTime = -1;
            }
        }
        
        return freeTimes;
        
    }
}





