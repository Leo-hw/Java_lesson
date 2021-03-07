package pack;

public class ThreadLambda {

	public void sendEmail(String ss) {
		System.out.println(ss + "메세지 전송");

	}

	public ThreadLambda() {
		m1();
		m2();
		m3();
		m4();
	}

	void m1() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				sendEmail("m1");
			}
		}).start();
	}
	
	void m2() {
		Thread thread = new Thread(()-> sendEmail("m2"));
		thread.start();
	}
	
	void m3() {
		new Thread(()-> sendEmail("m2")).start();
	}
	
	void m4() {
		Runnable runnable = ()-> sendEmail("m4");
		runnable.run();
	}
	
	public static void main(String[] args) {
		new ThreadLambda();

	}
}
