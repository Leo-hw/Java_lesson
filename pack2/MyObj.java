package pack2;

//import java.lang.Object; 				// 모든 클래스가 포함하고 있음. 개발사에서 넣어줌...

public class MyObj extends Object{
	
	public MyObj() {
		System.out.println("MyObj");
	}
	
	@Override
	public String toString() {
		return "자격증만세"; 
	}
	
	
	
	
	public static void main(String[] args) {
		MyObj obj=new MyObj();
		System.out.println(obj);
		System.out.println(obj.toString());		// hashcode 
		
	}

}
