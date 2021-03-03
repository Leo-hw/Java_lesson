package pack2;

public class HouseDog extends Dog{
	private String where = "집";
	
	public HouseDog(String name) {
		super(name);
		
	}
	public void show() {
		System.out.println("어디 사니? "+ where);
		
	}
	@Override
	public void print() {
		System.out.println("........................");
		System.out.println(getName() + " : " + where + "에 산다 ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
}
