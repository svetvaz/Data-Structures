import java.util.*;

//create class for individual interval
	 class Interval{

		 int start;
		 int end;
		Interval()
		{
			this.start = 0;
			this.end = 0;
		}

		Interval(int st,int en)
		{
			this.start = st;
			this.end = en;
		}

		public String toString()
		{
			// return "Start: '" + this.start+ "', End: " + this.end ;
			StringBuilder intervalString = new StringBuilder();
			intervalString.append("[");
			intervalString.append(this.start);
			intervalString.append(",");
			intervalString.append(this.end);
			intervalString.append("]");
			return intervalString.toString();
		}
	}


public class MergeIntervals
{
	

	private ArrayList<Interval> merge(ArrayList<Interval> intervalList)
	{
		if (intervalList == null || intervalList.size() <= 1)
       	return intervalList;
		//create a new ArrayList with the results
		ArrayList<Interval> result = new ArrayList<Interval>();
		// now check for overlaps
		//get the first element
		Interval prev = intervalList.get(0);
		for(int i=1;i<intervalList.size();i++)
		{
			Interval current = intervalList.get(i);
			if(current.start<=prev.end)
			{
				//current and previous are overlapping, so merge them
				Interval merged = new Interval(prev.start,Math.max(prev.end,current.end));
				prev = merged;
			}
			else
			{
				prev = current;
			}
			result.add(prev);
		}
		
		return result;
	}

	public static void main(String[] args)
	{
		MergeIntervals mergeIntervals = new MergeIntervals();
		//create an ArrayList with intervals;
		ArrayList<Interval> intervalList = new ArrayList<Interval>();
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(2,4);
		Interval interval3 = new Interval(8,10);
		Interval interval4 = new Interval(15,18);
		intervalList.add(interval1);
		intervalList.add(interval2);
		intervalList.add(interval3);
		intervalList.add(interval4);
		for(Interval interval:intervalList)
		{
			System.out.println(interval.toString());
		}
		//First sort the ArrayList with the intervals
		Collections.sort(intervalList, new IntervalComparator());
		ArrayList<Interval> result = mergeIntervals.merge(intervalList);
		System.out.println("The merged interval List is: ");
		for(Interval interval:result)
		{
			System.out.println(interval.toString());
		}

	}
}
	 class IntervalComparator implements Comparator<Interval>
	{
		public int compare(Interval interval1,Interval interval2)
		{
			return interval1.start - interval2.start;
		}
	}
