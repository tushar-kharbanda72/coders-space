// problem 4 - check whether array has duplicate values or not.

/* problems with this solution-
   -> doesn't work when array is read only.
   -> numbers should be positive and within range 0 - n-1.*/

class Problem4{

	public boolean searchDuplicate(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[Math.abs(arr[i])] < 0) 
				return true;
			arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		return false;
	}

	public static void main(String[] args){
		Problem4 ob = new Problem4();
		int[] arr1 = {3, 2, 1, 2, 2, 3};
		int[] arr2 = {5, 3, 2, 1, 0, 4};
		System.out.println(ob.searchDuplicate(arr1));
		System.out.println(ob.searchDuplicate(arr2));
	}
}
