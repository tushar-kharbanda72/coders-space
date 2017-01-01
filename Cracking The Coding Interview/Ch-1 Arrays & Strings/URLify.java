/* problem 1.3 - urlify the given string*/
import java.util.*;
class URLify{

	public void replaceSpaces(char[] str, int length){
		int spaceCount = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' ')
				spaceCount++;
		}
		int newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for(int i = length-1; i >= 0; i--){
			if(str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			}else{
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
	}
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		char[] str = new char[19];
		String s = "tushar kharbanda";
		for(int i = 0; i < s.length(); i++)
			str[i] = s.charAt(i);
		//System.out.println(str.length);
		URLify ob = new URLify();
		System.out.println(new String(str));
		ob.replaceSpaces(str, 16);
		System.out.println(new String(str));
	}
}

