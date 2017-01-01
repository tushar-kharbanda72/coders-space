import java.util.*;
// Problem 1.4 - check whether there is permutation of a string which is palindroe
public class PalindromePermutation{


	private int[]  buildFrequencyTable(String s){
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c: s.toCharArray()){	
			int index = getIndex(c);
			if(index != -1){
				table[index]++;
			}
		}
		return table;
	}


	private int getIndex(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		int val = Character.getNumericValue(c);

		if(val >= a && val <= z)
			return val - a;
		if(val >= A && val <= Z)
			return val - A;
		return -1;
	}


	private boolean scanTable(int[] table, boolean isEven){
		for(int i = 0; i < table.length; i++){
			if(table[i] % 2 != 0){
				if(isEven){
					return false;
				}else{
					isEven = true;
				}
			}
		}
		return true;
	}

	// method 1
	public boolean findPalindrome1(String s){
		int[] table = buildFrequencyTable(s);
		return scanTable(table, s.length() % 2 == 0);
	}	

	// method 2
	public boolean findPalindrome2(String s){
		int count = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		for(char c : s.toCharArray()){
			int index = getIndex(c);
			if(index != -1){
				table[index]++;
				if(table[index] == 1){
					count++;
				}else{
					count--;
				}
			}
		}
		return count <= 1;
	}

	// method 3 using bit vector
	public boolean findPalindrome3(String s){
		int bitVector = 0;
		for(char c : s.toCharArray()){
			int index = getIndex(c);
			if(index < 0)
				continue;
			int mask = 1 << index;
			if((mask & bitVector) != 0)
				bitVector &= ~(mask);
			else
				bitVector |= mask;

		}
		return (bitVector == 0 || (bitVector & (bitVector - 1)) == 0);
	}	
	public static void main(String[] args){
		PalindromePermutation ob = new PalindromePermutation();
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(ob.findPalindrome1(s));
		System.out.println(ob.findPalindrome2(s));
		System.out.println(ob.findPalindrome3(s));
	}
}
