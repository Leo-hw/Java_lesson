package pack1;

public class Ex5book {
		public static void main(String[] args) {
			System.out.println("==예제3==");
			int hap =0;
			for(int  a=1; a<100; a++) {
						if(a % 3 == 0) {
				System.out.print(a+"\t");
				hap += a;	
			}
						
			}
			System.out.println();
			System.out.println(hap);
			System.out.println();
			System.out.println("=예제4=");
			
			int i = (int)(Math.random()*6+1);
			int j = (int)(Math.random()*6+1);
			int sum = i+j;
			while(sum ==5)  {
				System.out.println("("+i+" , " +j+")");
			
				System.out.println("=예제5=");
			
				
			}
			}
}
