import java.util.*;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class MergeIntervals {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    class comparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start>o2.start)
                return 1;
            else if (o1.start<o2.start)
                return -1;
            else
                return 0;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new LinkedList<Interval>();
        if (intervals==null||intervals.size()==0)
            return result;
        Collections.sort(intervals,new comparator());
        Interval currentInterval=intervals.get(0);
        for (int i=1;i<intervals.size();i++){
            Interval temp=intervals.get(i);
            if (temp.start>currentInterval.end){
                result.add(currentInterval);
                currentInterval=temp;
            }else if (temp.start==currentInterval.end){
                currentInterval=new Interval(currentInterval.start,temp.end);
            }else if (temp.start<currentInterval.end){
                if (temp.end>=currentInterval.end){
                    currentInterval=new Interval(currentInterval.start,temp.end);
                }else if (temp.end<currentInterval.end){
                    currentInterval=currentInterval;
                }
            }
        }
        if (currentInterval!=null)
            result.add(currentInterval);
        return result;
    }


    public static void main(String args[]){
        Interval a=new Interval(1,3);
        Interval b=new Interval(2,6);
        Interval c=new Interval(8,10);
        Interval d=new Interval(15,18);
        List<Interval>list = new LinkedList<Interval>();
        list.add(a);
        list.add(c);
        list.add(b);
        list.add(d);
        MergeIntervals test=new MergeIntervals();
        List<Interval> result=test.merge(list);
        for (Interval one:result){
            System.out.println(one.start+"  , "+one.end);
        }
    }
}
