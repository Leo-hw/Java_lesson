package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JIkwonMain {
	static ArrayList<Jikwon> jikwons = new ArrayList<Jikwon>();
	
	static {
		jikwons.add(new Jikwon(3, "홍길동", "111-1111"));
		jikwons.add(new Jikwon(1, "고길동", "222-1111"));
		jikwons.add(new Jikwon(2, "신길동", "333-1111"));
		System.out.println("정렬 전 : " + jikwons.toString());
		
		
	}
	
	public static void main(String[] args) {
		// collection 을 이용해 sort
		// 1. 익명 클래스
		Collections.sort(jikwons, new Comparator<Jikwon>() {
			@Override
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.bunho - o2.bunho;
			};
		});
		System.out.println("정렬결과 : " + jikwons);
		
		System.out.println();
		
		// 2. 람다
		Collections.sort(jikwons, (o1, o2)-> o1.bunho -o2.bunho);
		System.out.println("정렬결과 : " + jikwons.toString());
		
		System.out.println(" ---------------------------- ");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			arr.add(i);
			
		}
		for(Integer i : arr) {
			System.out.println(i);
			
		}
		System.out.println("-----");
		
		arr.forEach(i ->{
			System.out.println(i);
		}
		);
	}

}
