// Problem 10.2 
import java.util.*;

// Implementation 1 by sorting every single string in string array and then sorting complete array.
class Sorting implements Comparator<String>{
	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}

	private String sortChars(String s){
		char[] str = s.toCharArray();
		Arrays.sort(str);
		return new String(str);
	}

}


class HashMapList extends HashMap<String, String>{
	HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
	public void pu(String key, String s){
		ArrayList<String> al = m.get(key);
		if(al == null){
			al = new ArrayList<String>();
			m.put(key, al);
		}
		al.add(s);
	}

	public Collection values(){
		return m.values();
	}
}

public class GroupAnagrams {

	// Implementation 1.
	public void groupAnagrams1(String[] dict){
		Arrays.sort(dict, new Sorting());
	}


	// Implementation 2.
	private String sortChars(String s){
		char[] str = s.toCharArray();
		Arrays.sort(str);
		return new String(str);
	}

	

	public void groupAnagrams2(String[] dict){
		HashMapList<String, ArrayList<String>> map = new HashMapList<String, ArrayList<String>>();
		for(String s: dict){
			String key = sortChars(s);
			map.pu(key, s);
		}
		for(ArrayList<String> ss: map.values()){
			for(String s: ss){
				System.out.println(s);
			}
		}
	}



	public static void main(String[] args){
		String[] dictionary = {"cat", "dog", "tac", "god"};
		GroupAnagrams ob = new GroupAnagrams();
		/*ob.groupAnagrams1(dictionary);
		for(String s : dictionary){
			System.out.println(s);
		}*/
		ob.groupAnagrams2(dictionary);
		

	}
}