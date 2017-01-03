/* Problem 8.3 - Find The index which is equal to the value at that index. */
public class MagicIndex{
	//#Sol1 - This code works when all numbers are distinct and sorted.
	public int findMagicIndex1(int[] arr, int left, int right){
		if(left > right) return -1;

		int mid = (left + right) / 2;
		if(arr[mid] == mid) return mid;		

		if(arr[mid] > mid){
			return findMagicIndex1(arr, left, mid - 1);
		}else{
			return findMagicIndex1(arr, mid + 1, right); 
		}
	}
	/* #Sol2 - This code works for sorted and repeated numbers. */ 
	public int findMagicIndex2(int[] arr, int left, int right){
		if(left > right) return -1;

		int midIndex = (left + right) / 2;
		int midValue = arr[midIndex];

		if(midIndex == midValue) return midValue;

		/* Search Left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int l = findMagicIndex2(arr, left, leftIndex);
		if(l >= 0) return l;

		/* Search Rigth */ 
		int rightIndex = Math.max(midIndex + 1, midValue);
		int r = findMagicIndex2(arr, rightIndex, right);
		return r;
	}

	public static void main(String[] args){
		int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		MagicIndex ob = new MagicIndex();
		int[] arr1 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println(ob.findMagicIndex1(arr, 0, arr.length - 1));
		System.out.println(ob.findMagicIndex2(arr1, 0, arr1.length - 1));
	}
}
