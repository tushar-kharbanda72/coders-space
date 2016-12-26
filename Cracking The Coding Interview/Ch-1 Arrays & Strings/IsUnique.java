/* problem 1.1 - determine if strings have all unique characters.*/
class IsUnique{
	/* using boolean map*/

	public boolean isUnique(String str){
		if(str.length() > 128) return false;

		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;		
			}
			char_set[val] = true;
		}
		return true;
	}
	/* using bit vector. only 32 or less unique char can be checked for e.g - a - z */
	public boolean isUniqueBit(String str){
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= 1 << val;
		}
		return true;
	}

	public static void main(String[] args){
		String s = "tushaar";
		IsUnique ob = new IsUnique();
		System.out.println(ob.isUnique(s));
		System.out.println(ob.isUniqueBit(s));
	}
}
