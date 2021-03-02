package pack1;

import java.util.Scanner;

public class Machine {
	
	CoinIn money;
	MachineUse use = new MachineUse();
	
	
	int coin = money.coin;
	Scanner sc = new Scanner(System.in);
	int cupcount = sc.nextInt();
	
	
	public void showData() {
		
		if(money.jandon >=0) {
			System.out.println("커피 " + cupcount + " 잔과 잔돈"+ money.jandon + "원");
			
		}else {
			System.out.println("잔돈이 부족합니다.");
		}
	}
	
		
}
