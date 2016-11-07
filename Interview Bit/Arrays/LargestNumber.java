/*Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
       List<String> l = new ArrayList<String>();
       for(int n:a){
           l.add(Integer.toString(n));
       }
       Collections.sort(l, new sorting());
       StringBuilder s = new StringBuilder();
       boolean flag =true;
       for(String temp:l){
           if(temp.equals("0") && flag)
                continue;
            flag = false;
           s.append(temp);
       }
       if(flag == true)
        s.append("0");
       return s.toString();
    }
}

class sorting implements Comparator<String>{
    public int compare(String a, String b){
        String ab = a + b;
        String ba = b + a;

        return -1 * ab.compareTo(ba);
    }
}
