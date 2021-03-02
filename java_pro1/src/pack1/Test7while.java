package pack1;

public class Test7while {
		 public static void main(String[] args) {
			//반복문 while(조건){}
			 int w=1;
			 while( w<= 5) {
				 System.out.println("w:"+w);
				 w++;		//반복문 탈출을 위한 작업 필수
				 
			 }
			 System.out.println("탈출 후 w: " +w);
			 
			 System.out.println();
			 w=0;
			 while(true) { //무한 반복
				 w++;
				 if(w==2) continue;
				 if(w==5) break;
				 System.out.println("탈출 후 w: " +w);
			 }
			 
			 System.out.println();
			 w = 1;
			 do {
				 System.out.println("더블유:" +w);
				 w++;
			 }while(w<=5);
			 
			 //문1) 1~100 사이의 숫자 중 3의 배수이나 2의 배수가 아닌 수를 출력하고, 그 합과 건수를 출력
			 
			 // 문2) -1,3,-5,7,-9,11,~ 99 까지의 합?
			 
			 //문3) 키보드로 숫자 입력 : 5
			 // 				5까지의 합 출력
			 //					계속할까요? (1/0)		<=1이면 계속. 0이면 작업 끝
		 }
}
