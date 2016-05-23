package Java2.el222ja_assign4;

public class Uppgift3 {	
	
	//Skriver ut tiden för hur lång tid det tar att konkatenera korta strängar
	public static void main (String[] args) {
	long startTime = System.nanoTime();
	String str = "";
	String a = "a";
	for(int i=0; i<27000; i++) {
		str = str + a;
	}
	long elapsedTime = System.nanoTime() - startTime;
	double seconds = (double)elapsedTime / 1000000000.0;
	System.out.println("Add short: "+seconds);
	
	// Skriver ut tiden det tar att lägga till strängar med hjälp av StringBuilder append metod
	long startTime2 = System.nanoTime();
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<35000000; i++) {
		sb.append(a);
	}
	String string = sb.toString();
	long elapsedTime2 = System.nanoTime() - startTime2;
	double seconds2 = (double)elapsedTime2 / 1000000000.0;
	System.out.println("Append short: "+seconds2);
	
	//Skriver ut hur lång tid det tar att konkatenera strängar med 80 tecken
	String str2 = "";
	String str3 = "";
	for(int i=0; i<80; i++)
		str2 = str2 + a;
	long startTime3 = System.nanoTime();
	for(int j=0; j<2700; j++) {
		str3 = str3 + str2;
	}
	long elapsedTime3 = System.nanoTime() - startTime3;
	double seconds3 = (double)elapsedTime3 / 1000000000.0;
	System.out.println("Add long: " +seconds3);
	
	//Skriver ut hur lång tid det tar att addera strängar på 80 tecken med hjälp av StringBuilder append metod
	StringBuilder sb2 = new StringBuilder();
	long startTime4 = System.nanoTime();
	for(int i=0; i<2050000; i++) {
		sb2.append(str2);
	}
	String string2 = sb2.toString();
	long elapsedTime4 = System.nanoTime() - startTime4;
	double seconds4 = (double)elapsedTime4 / 1000000000.0;
	System.out.println("Append long: "+seconds4);
	}
}
