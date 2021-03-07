package pack;

public class MyInterMain {

	public static void main(String[] args) {
		// Lambda test
		// 1. 인자가 없는 추상 메소드 처리
		// 전통적
		MyInterface interface1 = new MyInterface() {

			@Override
			public void abc() {
				System.out.println("일반적인 익명 클래스의 메소드 오버라이드");
			}
		};

		interface1.abc();

		// 람다식
//		MyInterface interface2 = () -> {System.out.println("일반적인 익명 클래스의 메소드 오버라이드");};
		MyInterface interface2 = () -> System.out.println("일반적인 익명 클래스의 메소드 오버라이드");
		;
		interface2.abc();

		System.out.println();
		MyInterface interface3 = () -> {
			System.out.println("람다식 표현");
			System.out.println("복수 문장인 경우 블럭화 필요");
		};
		interface3.abc();

		System.out.println("==================");

		// 2. 인자가 있는 추상 메소드 처리
		// 전통적
		MyInterArg interArg = new MyInterArg() {

			@Override
			public void def(int m, int n) {
				System.out.println("두 수의 합은 " + (m + n));
			}
		};
		interArg.def(3, 4);

		// 람다식
		MyInterArg interArg2 = (m, n) -> System.out.println("두 수의 합은 " + (m + n));
		interArg2.def(3, 4);
		// MyInterArg interArg2 = (m) ->System.out.println("합은 " + (m+m));
		// MyInterArg interArg2 = m ->System.out.println("합은 " + (m+m)); // 매개 변수가 하나일 경우는 괄호가 없어도 됨.(위와 아래는 같음)
		
		System.out.println("================");
		// 3. 반환 값이 있는 추상 메소드 처리
		// 전통적
		MyInterArgReturn interArgReturn = new MyInterArgReturn() {
			@Override
			public int def(int a, int b) {
				// ...
				return a+b;
			}
		};
		int result = interArgReturn.def(3, 4);
		System.out.println("result : "+result);
		
		System.out.println();
		
		//람다식
		MyInterArgReturn interArgReturn2 = (a,b) -> {
			return a+b;
		};
		int result2 = interArgReturn2.def(3, 4);
		System.out.println("result2 :" +result2);
		
		MyInterArgReturn interArgReturn3 = (a,b) -> a*b;
		int result3 = interArgReturn3.def(3, 4);
		System.out.println("result3 : "+ result3);
	}
}
