// Problem 3.5 - Sort Stack using only 1 temp stack. O(n^2).
import java.util.Stack;
class SortStack{

	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp)
				s.push(r.pop());
			r.push(temp);
		}
		return r;
	}

	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(5);
		s.push(4);
		s.push(3);
		SortStack ob = new SortStack();
		System.out.println(s.toString());
		s = ob.sort(s);
		System.out.println(s.toString());
	}
}
