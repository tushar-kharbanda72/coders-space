>>Problem 10.1 - Merge two sorted arrays a and b into a given a has extra s
import java.util.*;
class SortedMerge{

	public void merge(int[] a, int[] b){
		int mergeIndex = a.length - 1;
		int aIndex = b.length - 1;
		int bIndex = b.length - 1;

		while(bIndex >= 0){
			if(aIndex >= 0 && a[aIndex] > b[bIndex]){
				a[mergeIndex] = a[aIndex];
				aIndex--;
				
			}else{
				a[mergeIndex] = b[bIndex];
				bIndex--;
			}
			mergeIndex--;
		}
	}

	public static void main(String[] args){
		int[] a = new int[8];
		int[] b = {3, 5, 12, 20};
		a[0] = 2;
		a[1] = 7;
		a[2] = 15;
		a[3] = 25;
		SortedMerge ob = new SortedMerge();
		ob.merge(a, b);
		System.out.println(Arrays.toString(a));
	}	
}