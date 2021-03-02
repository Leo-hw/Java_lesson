package pack1;

import java.util.Scanner;

public class Test5switch {
	public static void main(String[] args) {
			//알고리즘, 간단한거부터 
		//switch
		int nai = 43;
		nai = nai/10 *10;
		System.out.println("nai : " + nai);
		
		switch(nai) {
		case 20:
			System.out.println("이십대");
			System.out.println("청춘");
			break;
		case 30:
			System.out.println("삼십대");
			break;
		default:
			System.out.println("기타");
			break;
			
		}
		System.out.println();
		String jik = "과장";
		switch (jik) {
		case "대리":
			System.out.println("아하 대리");
			break;
		case "과장":
		System.out.println("와우 과장");
		break;
		
		}
		System.out.println();
		
		//double time = Math.random(	); //난수 발생
		//int time = (int)(Math.random() * 10 );
		int time = (int)(Math.random() * 4)+8;
		System.out.println(time);
		switch(time) {
		case 8:
			System.out.println("출근하자");
			//break;
		case 9:
			System.out.println("회의하자");
			//break;
		case 10:
			System.out.println("program 짜자");
			//break;
		default:
			System.out.println("휴식");
			//break;	
		}
		System.out.println("해당 달의 날 수 출력 ----------");
		//키보드로 년, 월을 각각 입력받아 해당 년 월의 날 수 출력, 윤년 체크.
		// 해당 년이 4의 배수이고, 100의 배수가 아니거나 400의 배수이면 윤년.
	
		
				
		Scanner sc = new Scanner(System.in);
		System.out.println("년 입력 :");
		int year = sc.nextInt();
		System.out.println("월 입력 :");	
		int month = sc.nextInt();
		
		if(month <1 || month >12) {
			System.out.println("월은 1 ~ 12 사이에만 허용!");
			System.out.println("안녕~~~~~~~");
			System.exit(0);
			
		}
		int nalsu = 28;
		String msg ="평년" ;
		
		if (year % 4 == 0 && year % 100 != 0 || year %400 == 0) {
			nalsu =29;
			msg = "윤년";
		}
		switch(month) {
		case 1:
		case 3:
		case 5:	
		case 7:
		case 8:
		case 10:
		case 12:
			nalsu = 31;
			break;
		case 4:	
		case 6:	
		case 9:	
		case 11:
			nalsu = 30;
			break;
		
				}
		System.out.println(year + "년" + month + "월은" + nalsu + "일" + " " + msg);
		
		System.out.println("----종료----");
	}
}
