class M1Thread extends Thread{
	
	public void run() {
		Example.m1();
	}
}
class M2Thread extends Thread{
	
	public void run() {
		Example.m2();
	}
}
class M3Thread extends Thread{
	
	public void run() {
		Example.m3();
	}
}
public class Test4 {
	public static void main(String[] args) {
		System.out.println("Mains starts");
		
		M1Thread mt1 = new M1Thread();
		M2Thread mt2 = new M2Thread();
		M3Thread mt3 = new M3Thread();
		
		mt1.start();
		mt2.start();
		mt3.start();
		
		System.out.println("Mains starts");
	}
}
