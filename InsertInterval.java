import java.util.*;

class Interval
{
	int start;
	int end;

	Interval()
	{}
	Interval(int st,int en)
	{
		this.start = st;
		this.end = en;
	}
	public String toString()
	{
		StringBuilder intervalString = new StringBuilder();
		intervalString.append("[");
		intervalString.append(this.start);
		intervalString.append(",");
		intervalString.append(this.end);
		intervalString.append("]");	
		return intervalString.toString();
	}
}


public class InsertInterval
{

	private static ArrayList<Interval>  mergeIntervals(ArrayList<Interval> intervalList)
	{	
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervalList.get(0);
		for(int i=1;i<intervalList.size();i++)
		{
			Interval current = intervalList.get(i);
			if(current.start<=prev.end)
			{
				Interval mergedInterval = new Interval(prev.start,Math.max(current.end,prev.end));
				prev = mergedInterval;
			}
			else
			{
				prev = current;
			}
			result.add(prev);
		}
		return result;

	}

	private static ArrayList<Interval> insertAndMergeInterval(ArrayList<Interval> intervalList,Interval newInterval)
	{
		ArrayList<Interval> result = new ArrayList<Interval>();
		boolean added = false;
		// Assumptions : List of intervals is sorted
		// Iterate thru the list until newInterval.start>listItem.start
		for(int i=0;i<intervalList.size();i++)
		{
			Interval currentItem = intervalList.get(i);
			if(newInterval.start<=currentItem.start && !added)
			{
				result.add(newInterval);
				added = true;

			}
			result.add(currentItem);
		}
		result = mergeIntervals(result);
		return result;
	}

	public static void main(String[] args)
	{
		//enter the intervals
		ArrayList<Interval> intervalList = new ArrayList<Interval>();
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(6,9);
		intervalList.add(interval1);
		intervalList.add(interval2);
		System.out.println("The original list:");
		for(Interval interval:intervalList)
		{
			System.out.println(interval.toString());
		}
		//enter the interval to be inserted
		Interval newInterval = new Interval(2,5);
		System.out.println("The interval to be added:");
		System.out.println(newInterval.toString());
		ArrayList<Interval> resultList  = insertAndMergeInterval(intervalList,newInterval);
		System.out.println("The list with inserted interval is:");
		for(Interval interval:resultList)
		{
			System.out.println(interval.toString());
		}
	}
}