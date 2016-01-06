//Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
import java.util.*;

public class Version
{
	private static int compareVersions(float ver1,float ver2)
	{
		if(ver1==ver2) return 0;
		if(ver1>ver2)
			return 1;
		return -1;
	}

	public static void main(String[] args)
	{
		//enter version numbers
		System.out.println("Enter version 1:");
		float ver1 = Float.parseFloat(System.console().readLine());
		System.out.println("Enter version 2:");
		float ver2 = Float.parseFloat(System.console().readLine());
		int result = compareVersions(ver1,ver2);
		System.out.println("The results is :"+result);
	}
}