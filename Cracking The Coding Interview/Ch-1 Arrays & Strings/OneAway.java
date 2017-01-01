import java.util.Scanner;
class OneAway{

	public boolean OneEditAway(String first, String second){
		if(Math.abs(first.length() - second.length()) > 1)
			return false;

		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int i1 = 0, i2 = 0;
		boolean foundDifference = false;
		while(i1 < s1.length() && i2 < s2.length()){
			if(s1.charAt(i1) != s2.charAt(i2)){
				System.out.println("hello");
				if(foundDifference) return false;
				foundDifference = true;

				if(s1.length() == s2.length()){
					i1++;
				}
			}else{
				i1++;
			}
			i2++;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		OneAway ob = new OneAway();
		System.out.println(ob.OneEditAway(s1, s2));
	}
}
