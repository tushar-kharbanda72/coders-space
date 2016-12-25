class RabinKarp{
	final private int prime = 101;
	public int searchPattern(char[] str, char[] pattern){
		int m = pattern.length;
		int n = str.length;
		long patHash = generateHash(pattern, m);
		long strHash = generateHash(str, m);
		if(strHash == patHash){
			if(checkSameSubs(str, pattern, 0, m, 0, m))
				return 0;
		}
		for(int i=1; i<n-m+1; i++){
			strHash = regenerateHash(str, pattern, i-1, i+m-1, strHash);
			if(patHash == strHash && checkSameSubs(str, pattern, i, i+m, 0, m)){
				return i;
			}			
		}
		return -1;
	}
	private long regenerateHash(char[] str, char[] pattern, int oldIndex, int newIndex, long oldHash){
		oldHash -= str[oldIndex];
		oldHash /= prime;
		oldHash += str[newIndex] * Math.pow(prime, pattern.length-1);
		return oldHash;
	}
	private long generateHash(char[] str, int len){
		long hash = 0;
		for(int i=0; i<len; i++){
			hash += str[i]*Math.pow(prime, i);
		}
		return hash;
	}
	private boolean checkSameSubs(char[] str, char[] pattern, int start1, int end1, int start2, int end2){
		if(end1 - start1 != end2 - start2){
			return false;
		}
		int i=start2, j=start1;
		for(; j<end1 && i<end2; j++, i++){
			if(str[j] != pattern[i]){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		String s = "abcdef";
		String pattern = "def";
		RabinKarp ob = new RabinKarp();
		System.out.println(ob.searchPattern(s.toCharArray(), pattern.toCharArray()));
	}
}
