package pack1;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		System.out.println("문제 2번");
		// -1,3,5,7,-9 ~99 까지의 합  
		
		int n = 1;
		int k = -1;
		int h = 0;
		
		while(k<99) {
			System.out.println(k);
			n +=2;
			k ++;
			if(k%2!=0) {
				k = n*-1;
			}else {
				k=n*1;
				
			}
			
		}
		h +=k;
		System.out.println(h);
	}
}