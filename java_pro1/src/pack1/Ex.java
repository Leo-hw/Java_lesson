package pack1;

import java.util.Scanner;

public class Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명 : ");
		String irum = sc.next();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		System.out.println("갯수 : ");
		
		int ga = sc.nextInt();
		double se;
		int don = price * ga;
		if(don >= 50000){
		 se = 0.1;
		}else {
		se = 0.05;	
		}
		
		double fin = (don* se)+don;
		System.out.println("상품명  : " + irum + " 가격  : " + price + " 갯수 : " + "세금 : "  + se + " 총 금액 : " + fin);
		
		
				
	}	
}