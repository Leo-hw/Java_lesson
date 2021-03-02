package pack1;

import java.util.Scanner;

public class Mun2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=0;
		while(a<100) {
			a++;
			if(a%3==0 ) {
			if(a%2==0) continue;
			b+=a;
			System.out.print(a+" ");
			}
		
		}
		System.out.println();
		System.out.println("합: "+b);
	
		
		  System.out.println("===문제2===");
	/*
		  int aa = 3;
		  int bb = 0;
		  while(aa<= 99) {
			  bb += aa;
			  aa= aa+4;
			  }
		  int cc = -1;
		  int dd = 0;
		  while(cc>= -97) {
			  dd +=cc;
			  cc=cc-4;
		  }
	System.out.println("합은 : " +(bb+dd));
	*/
		  int i =1;
		  int n = 1;
		  int t = 0;
		  while(i <100) {
			 
			  if(n %2 ==0) {
			  t +=i;
			  i++;
			  
		  }else{
			  int k = (-1);
			  if(n%2==1) {
				  t= -k+2;
				  t +=n;
			   
		  }
		  }
	System.out.println("===문제3===");
	Scanner sc = new Scanner(System.in);
	int y = 0;
	int z = 1;
	while(true) {
		System.out.println("키보드로 숫자입력 : ");
		int x = sc.nextInt();// 입력값
		while(z <= x) {
			y += z;
			z++;
		}
		System.out.println("합 출력 : "+(x+y));
		System.out.println("계속할까요?(1/0)");	
		int xx = sc.nextInt();
		if(xx<1) break;
		
	}
		  }

	System.out.println("프로그램 종료");
	}
	}



