package Java2.el222ja_assign1;

public class SumMain {
	
	public static int sum(int n) {
		if(n==1) {
			return 1; }
		else {
			return n+sum(n-1);
		}
	}
	public static int sum1(int x, int n) {
		if(n==x)
			return n;
		else {
			return sum1(x,(n+x)/2)+sum1(((x+n)/2)+1,n);
		}
			
	}
	public static void main(String[] args) {
		int n = 5;
		int x = 1;
		System.out.println(sum(n));
		System.out.println(sum1(x,n));
		
	}
	//Denna metod �r mycket sv�rare och l�ngre �n den vanliga metoden f�r summa utr�kning (se metod sum())
	//Jag kan inte se n�gra f�rdelar med denna metoden.

}
