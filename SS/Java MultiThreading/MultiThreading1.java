class MyRunnable implements Runnable{


	public void run(){

		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("Exceptioon");
			}		
		}
	}

}

class MyThreads extends Thread{
	public MyThreads(String str){
		super(str);
	}
	public void run(){
		System.out.println("Start" + getName());
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("Exceptioon");
			}		
		}
		System.out.println("End " + getName());
	}
}
public class MultiThreading1{
	public static void main(String[] args){
		//		Thread thread = new Thread(new MyRunnable("Thread 1"));
		//		thread.start();
		MyThreads thread1 = new MyThreads("thread 1");
		thread1.start();
		MyThreads thread2 = new MyThreads("thread 2");
		thread2.start();
	}

}
