/* problem 1.2 - check permutation*/
import java.util.*;
class CheckPermutation{
	/* method-1 by sorting both strings*/
	private String sort(String str){
		char[] s = str.toCharArray();
		Arrays.sort(s);
		return new String(s);
	}
	public boolean permutation(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}
	/* method-2 by mapping*/
	private boolean permutationMap(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		int[] map = new int[128];

		for(char c:s1.toCharArray()){
			map[c]++;
		}
		for(int i = 0; i < s2.length(); i++){
			int c = (int)s2.charAt(i);
			map[c]--;
			if(map[c] < 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		String s1 = "tushar";
		String s2 = "rushar";
		CheckPermutation ob = new CheckPermutation();
		System.out.println(ob.permutation(s1, s2));
		System.out.println(ob.permutationMap(s1, s2));
	}
}
