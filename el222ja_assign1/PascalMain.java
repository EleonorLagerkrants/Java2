package Java2.el222ja_assign1;

public class PascalMain {
	
	public static int[] PascalTriangle(int n) {
		int[] pt = new int[n+1];
		if(n==0) {
			pt[0]=1;
			return pt;
		}
		
		else {
			int[] ppt = PascalTriangle(n-1);
			pt[0]=pt[n]=1;
			for(int i=1; i<ppt.length; i++) {
				pt[i]=ppt[i-1]+ppt[i]; 
			}
		return pt;
		}
	}
	
	public static String toString(int[] pt) {
		StringBuilder buf = new StringBuilder();
		for(int i=0; i<pt.length; i++){
			buf.append(pt[i]+" ");
		}
		String str = buf.toString();
		return str;
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println(toString(PascalTriangle(n)));

	}

}
