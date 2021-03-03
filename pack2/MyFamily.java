package pack2;

public class MyFamily {

	public static void main(String[] args) {
		// 상속(is a 관계)
		GrandFa gr	= new GrandFa();
		System.out.println("가보 : " +gr.gabo);
		System.out.println("가훈 : " +gr.gahun);
		System.out.println(gr.say());
		gr.eat();
		System.out.println("할아버지 나이 : " + gr.getNai());
		
		
		System.out.println("----");
		GrandFa gr2	= new GrandFa(888);
		System.out.println("가보 : " +gr2.gabo);
		gr2.eat();
		System.out.println("할아버지2 나이 : " + gr2.getNai());
		
		System.out.println("\n Father------------------------------------------------------------");
		Father fa = new Father();
		System.out.println("가보 : " +fa.gabo);
		System.out.println("가훈 : " +fa.gahun);
		System.out.println(fa.say());
		fa.eat();
		System.out.println("아버지 나이 : "+ fa.getNai());
		System.out.println("집은 "+fa.getHouse());
		fa.showData();
		
		
//		System.out.println();
//		Father fa2 = new Father(77);
//		System.out.println("아버지 나이 : "+ fa2.getNai());
		System.out.println("\n Me------------------------------------------------------------");
		Me me = new Me();
		System.out.println("가보 : " +me.gabo);
		System.out.println("가훈 : " +me.gahun);
		System.out.println(me.say());
		System.out.println("집은 "+me.getHouse());
		me.eat();
	}

}
