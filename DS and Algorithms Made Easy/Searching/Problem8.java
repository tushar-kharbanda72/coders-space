// Problem 8 max repeating element.
/*
	problems with the solution
	-> numbers should be positive and within the range 0 - n-1.	
	-> doesn't work if the array is read only.
*/
class Problem8{

	public int maxRepititions(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			arr[arr[i]%n] += n;
		}
		int max = 0, maxIndex = -1;
		for(int i = 0; i < n; i++){
			if((arr[i] / n) > max){
				max = arr[i] / n;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args){
		Problem8 ob = new Problem8();
		int[] arr = {4, 4, 2, 1, 3, 4};
		System.out.println(ob.maxRepititions(arr));
	}
}
