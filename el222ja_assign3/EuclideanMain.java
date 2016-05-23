package Java2.el222ja_assign3;

public class EuclideanMain {
	/*
	 * En rekursiv metod som räknar ut 2 heltals största gemensamma nämnare med hjälp av euklides algoritm.
	 * Om q=0 blir p den största gemensamma nämnaren.
	 * Om så inte är falet räknas samma sak ut mellan q och p mod q.
	 */
	public static int gcd(int p, int q) {
		if(q==0)
			return p;
		return gcd(q, p%q);
	}

	public static void main(String[] args) {
		int n=gcd(42,56);
		System.out.println("Största gemensamma delaren mellan 42,56: "+n);
		

	}

}
