// Problem 1.6 Compress string aabb -> a2b2. if length of original string is smaller than the compressed string return the original string. 

import java.util.Scanner;
class StringCompression{
	
	public String compress(String s){
		StringBuilder compressedString = new StringBuilder();
		int countConsecutive = 0;
		for(int i = 0; i < s.length(); i++){
			countConsecutive++;
			
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
				compressedString.append(s.charAt(i));
				compressedString.append(countConsecutive);
				countConsecutive = 0;
}
}
		return s.length() >= compressedString.length() ? compressedString.toString() : s;
}	

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		StringCompression ob = new StringCompression();
		System.out.println(ob.compress(s));
}
}
