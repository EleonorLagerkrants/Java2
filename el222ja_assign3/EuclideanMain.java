package Java2.el222ja_assign3;

public class EuclideanMain {
	/*
	 * En rekursiv metod som r�knar ut 2 heltals st�rsta gemensamma n�mnare med hj�lp av euklides algoritm.
	 * Om q=0 blir p den st�rsta gemensamma n�mnaren.
	 * Om s� inte �r falet r�knas samma sak ut mellan q och p mod q.
	 */
	public static int gcd(int p, int q) {
		if(q==0)
			return p;
		return gcd(q, p%q);
	}

	public static void main(String[] args) {
		int n=gcd(42,56);
		System.out.println("St�rsta gemensamma delaren mellan 42,56: "+n);
		

	}

}
