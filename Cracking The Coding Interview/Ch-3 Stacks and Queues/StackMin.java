import java.util.Stack;
//Problem 3.2 - implement stack with min() O(1).

//Implementation1 using more extra space creating object.
class StackMin1 extends Stack<StackNode>{

	public void push(int data){
		int minValue = Math.min(data, min());
		super.push(new StackNode(data, minValue));
	}

	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return peek().min;
		}
	}

}

class StackNode{
	int data;
	int min;
	public StackNode(int data, int min){
		this.data = data;
		this.min = min;
	}
}

//Implementation2 uses less extra space as both values and min values are separated.
class StackMin2 extends Stack<Integer>{
	Stack<Integer> s2;
	public StackMin2(){
		s2 = new Stack<Integer>();
	}
	public void push(int val){
		if(val <= min()){
			s2.push(val);
		}
		super.push(val);
	}

	public int min(){
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}

	public Integer pop(){
		int val = super.pop();
		if(min() == val)
			s2.pop();
		return val;
	}
}
public class StackMin{
	public static void main(String[] args){
		StackMin1 s1 = new StackMin1();
		s1.push(4);
		s1.push(6);
		s1.push(2);
		System.out.println(s1.min());
		StackMin2 s2 = new StackMin2();
		s2.push(4);
		s2.push(6);
		s2.push(2);
		s2.push(10);
		s2.pop();
		System.out.println(s2.min());
	}
}
