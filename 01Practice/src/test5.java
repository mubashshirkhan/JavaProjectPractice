class AddThread extends Thread{
	@Override
	public void run() {
		int sum = 1;
		for(int i =2; i<20 ;i++) {
			sum+=i;
			System.out.println("Summation is: "+sum);
		}
	}
}
class SubThread extends Thread{
	@Override
	public void run() {
		int sub = 1;
		for(int i =2; i<20 ;i++) {
			sub-=i;
			System.out.println("Substraction is: "+sub);
		}
	}
}

public class test5 {
	public static void main(String[] args) {
		System.out.println("Main start");
		
		AddThread at = new AddThread();
		SubThread st = new SubThread();
		
		at.start();
		st.start();
		
		System.out.println("Main end");
	}
}
