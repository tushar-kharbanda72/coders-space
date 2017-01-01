// problem 1.9 check whether string s2 is a rotation of string s2. e.g - shartu is a rotation of tushar. :D
import java.util.Scanner;
class StringRotation{
	private boolean isSubstring(String s1, String s2){
		int i2 = 0;
		for(int i1 = 0; i1 < s1.length(); i1++){
			if(s1.charAt(i1) == s2.charAt(i2)){
				i2++;
				if(i2 == s2.length())
					return true;
			}else{
				i2 = 0;	
			}
		}
		return false;
	}

	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(s1.length() != s2.length() || len == 0){
			return false;
		}
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		StringRotation ob = new StringRotation();
		System.out.println(ob.isRotation(in.next(), in.next()));
	}
}
