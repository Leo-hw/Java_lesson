package pack;

public class MyLambda {
		static class Inner implements HelloInter{
			
			@Override
			public int addData(int a, int b) {
				return a+b;
			}
		}
	
	
	public static void main(String[] args) {
		//전통적 방법
		Inner inner = new Inner();
		System.out.println(inner.addData(3, 4));
		
		
		
		
		// 람다 표현식
		HelloInter hinter = (x,y) -> x +y;
		System.out.println(hinter.addData(3, 4));

		HelloInter hinter2 = (x,y) -> x *y;
		System.out.println(hinter2.addData(3, 4));
	}
}
