package pack1;

public class Ex4 {
public static void main(String[] args) {
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
}
}
