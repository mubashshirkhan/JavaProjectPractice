class MyThread2 extends Thread
{
	public void run(){
		for(int i = 20; i>1; i--)
		{
			System.out.println("run i:"+i);
		}
	}
}

class  Test01
{
	public static void main(String[] args) 
	{
		MyThread2 mt1= new MyThread2();
		mt1.start();
		
		for(int i=1; i<=20;i++){
			System.out.println("main i:"+i);
		}
	}
}
