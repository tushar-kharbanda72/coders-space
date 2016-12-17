/*
   problem- given numbers and blank spaces between them and rhs. replace spaces with +/- so that the numers evaluated together is equal to rhs;
   1 _ 2 _ 3 _ 5 = 5 ans -> 1 + 2 + 3 + 4 - 5
 */

class ValidEquation{
	public int RHS = 11;
	public boolean validEquationSolution(int[] numbers, char[] sign, int level, int total, int k){
		if(level == k){
			//print(numbers, sign);
			if(total == RHS){
				print(numbers, sign);
				return true;
			}
	}else{
		sign[level-1] = '+';
		if(validEquationSolution(numbers, sign, level+1, total+numbers[level], k)){
			return true;
		}
		sign[level-1] = '-';
		if(validEquationSolution(numbers, sign, level+1, total-numbers[level], k)){
			return true;
		}

	}
	return false;
}

public void print(int numbers[], char[] sign){
	System.out.print(numbers[0] + " ");
	for(int i=1; i<numbers.length; i++){
		System.out.print(sign[i-1] + " " + numbers[i] + " ");
	}
}
public static void main(String[] args){
	int[] numbers = {1, 2, 3, 4, 5};
	char[] sign = new char[numbers.length - 1];
	ValidEquation ob = new ValidEquation();
	ob.validEquationSolution(numbers, sign, 1, numbers[0], 5);

}
}

