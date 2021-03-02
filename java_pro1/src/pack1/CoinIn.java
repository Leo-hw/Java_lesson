package pack1;

import java.util.Scanner;

public class CoinIn {
	
	Machine mach = new Machine();
	
	Scanner sc = new Scanner(System.in);
	int coin = sc.nextInt();
	int jandon = 0;
	
	public void calc() {
		if(coin >= 200) {
			jandon = coin - (200*mach.cupcount);
		}else {
			System.out.println("요금부족");
		}
	}
}

