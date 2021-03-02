package pack1;

import java.util.Scanner;		// 현재 패키지가 아닌 다른 패키지에서 가져올 때,

public class Test4if {
	public static void main(String[] args) {
		/*
		// 외부에서 값 얻기1
		if(args.length == 0	) {
			System.out.println("외부에서 값 얻기 실패");
			//System.exit(0);
		}else {
			System.out.println("args: " + args[0]+ " " + args[1]);
		
		}
		//외부에서 값 얻기 2	: 키보드
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력:" );
		String irum = sc.next();
		System.out.print("나이 입력:" );
		int nai = sc.nextInt();
		System.out.println(irum + "님의 나이는" + nai);
		
		*/
		
		// 조건 판단문 if
		int num = 2;
		
		if(num >= 1) {
				System.out.println("크군요");
				System.out.println("자바 만세");
				
		}
		System.out.println();
		
		num = 5;
		if (num <3) {
			System.out.println("작군요");
			System.out.println("참");
		}else {
			System.out.println("작지 않아요");
			
		}
		System.out.println();
		int jumsu = 67;
		if(jumsu >= 70) {
			if(jumsu >=90) {
				System.out.println("우수");
			
			}else {
				System.out.println("보통");
			}
			}else {
				if(jumsu >= 50) {
					System.out.println("저조");
				}else {
				System.out.println("엄청 저조");
			}
			}		
		System.out.println();
		jumsu = 75;
		String re = "";
		if(jumsu >= 90) {
			re ="수";
			}else if(jumsu >= 80) {
					re = "우";
				}else if(jumsu >=70) {
					re ="미";
				}else if(jumsu >=60) {
					re ="양";
				}
				else {
					re ="가";
				}
		
		System.out.println("점수는"+" "+ re);
		
		
		//문: 키보드로부터 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가)를 구하시오.
		// 조건 : 금액이 5만원 이상이면 금액에 10%를 그 외는 금액에 5%를 세금으로 출력
		// 출력 모양 ==> 상품명		금액		세금
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명 입력:" );
		String sangpum = sc.next();
		System.out.print("단가 입력:" );
		int dan = sc.nextInt();
		System.out.print("수량 입력:" );
		int su = sc.nextInt();
		int gum = dan * su;
		double tax;
		if (gum >=50000) {
		 tax = gum *0.1 ;
		}else {
		tax = gum *0.05;
		}
		
		System.out.println("상품명 : " + sangpum + "  " + "금액 : " + gum + "  "+ "세금 : " + tax );
		
		
	
		System.out.println("프로그램 종료");
	}
}