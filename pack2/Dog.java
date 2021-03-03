package pack2;



public class Dog {						//  개과의 파생 클래스를 위한 수퍼 클래스
	private String name = "댕댕이";
	
	public Dog() {
		
	} 
	
	public Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public String callName() {
		return " 종류 : " + name;
	}
	public void print() {
		System.out.println(name + " : 땅 위에 산다.");
	}
	
}
