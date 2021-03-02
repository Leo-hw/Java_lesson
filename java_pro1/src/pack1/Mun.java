package pack1;

import java.util.Scanner;

public class Mun {
		public static void main(String[] args) {
			/*
			System.out.println("\n -------문1.----------"	);
			Scanner sc = new Scanner(System.in);
			System.out.println("수 입력");
			int num= sc.nextInt();
		
			if(num <1 || num >9) {
				System.out.println("숫자는 1 ~ 9 사이에만 허용!");
				//System.exit(0); 허용값 제한 시 ascii 코드 이용 가능
			}else {
			for(int count =1; count <10; count ++) {
				System.out.println(" 숫자 * "+count +" = "+(num*count));
		}}
			System.out.println();
			
			System.out.println("\n -------문2.----------"	);
			int a;	
			int hap = 0;		//누적 기억장소 : 초기화 권장
				for(a = 1; a <=100; a++) {
					if(a %3 == 0 && a%5== 0) {
						System.out.print(a + "\t");
				
						hap += a;
						

					}
					
				}System.out.println("합계 :" + hap);
			
					System.out.println("\n -------문3.----------"	);
					for(int m=2; m<=9; m++) {
						System.out.print(m+"단 "+"\n");
						for(int n=2; n<=9; n++) {
							System.out.println(m+" X "+n + " = " + n*m );
						}
						System.out.println();
					}
						System.out.println();
						
							
						System.out.println("\n -------문4.----------"	);

						for(int i=0; i<5; i++){
						     for(int k=0; k<=i; k++){
						         System.out.print(" ");
						     }
						     for(int j=0; j<9-(2*i); j++) {
						         System.out.print("*");
						     } 
						     System.out.println();
						}
						System.out.println("\n -------문5.----------"	);
						
						for(int i=0; i<5; i++){
							for(int j=0; j<9-(i*2); j++) {
						         System.out.print(" ");
						     }
							for(int k=0; k<=i*2; k++){
						         System.out.print("*");
						     }
							 
						     System.out.println();
						}
					
			System.out.println("프로그램 종료");
		*/
		//continue, break;
for(int i =1; i<=10; i++) {
	if(i == 3) continue;
	if(i==5)break;		//for 블럭탈출
	//if(i==5)return;		// method 탈출
	//if(i==5) System.exit(1);//프로그램 종료
	System.out.println(i+" ");
	
}
System.out.println();int kk =0;
for(;;) {	//무한반복
	kk++;
	System.out.println("출력:"+kk);
	if(kk==5) break;
}
System.out.println("종료");
		}
}
			
		

