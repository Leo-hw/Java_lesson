package pack2;

public class WolfDog extends Dog {	
	private String where = "산";
	
	public WolfDog(String name) {
		super(name);
	}
	
	public WolfDog(String name, String where) {
		super(name);
		this.where = where;
		
	}
	
	@Override
	public void print() {
		System.out.println("늑대 만세 ~~~");
		System.out.println(getName()+ " :  "+ where + " 에 산다");
	}
	public void display() {
		print();
		this.print();
		super.print();
	}
	
}
