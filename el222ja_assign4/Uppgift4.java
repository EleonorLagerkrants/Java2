package Java2.el222ja_assign4;

import java.util.Random;

public class Uppgift4 {
		//Metod för att sortera en array av integers enligt insertionsort
		public static int[] insertionSort(int [] in) {
			int[] sort = new int[in.length];
			for(int m=0; m<in.length; m++)
				sort[m]=in[m];
		
			for(int i=1; i<sort.length; i++) {
				int temp = sort[i];
				int j=i;
				while(j>0 && temp<sort[j-1]){
					sort[j] = sort[j-1];
					j--;
				}
				sort[j]=temp;
			}
			return sort;
		}
		//Metod för att sortera en array av strängar enligt insertionsort
		public static String[] insertionSort2(String[] in){
			String[] str = new String[in.length];
			for(int k=0; k<in.length; k++) {
				str[k] = in[k];
			}
			String temp="";
			for(int i=1; i<str.length; i++) {
				int j=i-1;
				temp = str[i];
				while((j>=0) && str[j].compareTo(temp)>0) {
					str[j+1] = str[j];
					j--;
				}
				str[j+1] = temp;
				}
			return str;
		}
		//Metod för att sortera en array av integers enligt mergesort
		public static int[] mergeSort(int[] in) 
		{
			if (in.length <= 1) {
	            return in;
	        }
	        
	        int[] first = new int[in.length / 2];
	        int[] second = new int[in.length - first.length];
	        System.arraycopy(in, 0, first, 0, first.length);
	        System.arraycopy(in, first.length, second, 0, second.length);
	        
	        mergeSort(first);
	        mergeSort(second);
	         
	        merge(first, second, in);
	        return in;
		}
		//Hjälp metod för mergeSort, den sätter ihop arrayen i sorterad ordning
		private static void merge(int[] first, int[] second, int [] result) {
	        int iFirst = 0;
	        int iSecond = 0;
	        int j = 0;
	        
	        while (iFirst < first.length && iSecond < second.length) {
	            if (first[iFirst] < second[iSecond]) {
	                result[j] = first[iFirst];
	                iFirst++;
	                } else {
	                result[j] = second[iSecond];
	                iSecond++;
	            }
	            j++;
	        }
	        
	        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
	        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
	    }
		//Metod för att sortera en array av strängar enligt mergesort
		public static String[] mergeSort2(String[] in) {
			if(in.length<=1) {
				return in; 
			}
				
			String[] first = new String[in.length/2];
			String[] second = new String[in.length-first.length];
			
			System.arraycopy(in, 0, first, 0, first.length);
	        System.arraycopy(in, first.length, second, 0, second.length);
			
			mergeSort2(first);
			mergeSort2(second);

			merge2(first, second, in);
			
			return in;
		}
		//Hjälpmetod för mergesort, den sätter ihop arrayen i sorterad ordning
		public static void merge2(String[] first, String[] second, String[] result) {
			int iFirst=0, iSecond=0, j=0;
			while(iFirst<first.length && iSecond<second.length) {
				
				if(first[iFirst].compareTo(second[iSecond])<0) {
					result[j] = first[iFirst];
					iFirst++;
				}
				else {
					result[j] = second[iSecond];
					iSecond++;
				}
				j++;
			}
			 System.arraycopy(first, iFirst, result, j, first.length - iFirst);
		     System.arraycopy(second, iSecond, result, j, second.length - iSecond);
		}
		
		//Metod för att skapa en integer array med slumpmässiga tal.
		//Inparametrar avgör storlek och det högsta talet ett element kan anta
		private static int[] random(int size, int max) {
			Random rand = new Random();
			int[] arr = new int[size];
			for(int i=0; i<size; i++) {
				int n = rand.nextInt(max);
				arr[i]= n;
			}
			return arr;
		}
		//Metod för att skapa en string array med slumpmässiga strängar.
		//Inparametrar avgör storlek och hur långa strängarna ska vara.
		private static String[] randomArray(int size, int wordLength) {
			Random rand = new Random();
			String[] arr = new String[size];
			for(int i=0; i<size; i++) 
			{
				String n = randomString(rand, wordLength);
				arr[i]= n;
			}
			return arr;
		}
		//Metod som skapar strängarna som ska ingå i den slumpmässiga string arrayen
		private static String randomString(Random number, int length) {
			String all = "abcdefghijklmnopqrstuvxyzåäö";
		    char[] text = new char[length];
		    for (int i = 0; i < length; i++) {
		        text[i] = all.charAt(number.nextInt(all.length()));
		    }
		    return new String(text);
		}
		
	public static void main(String[] args) {
		//Skriver ut tiden det tar att sortera en slumpmässig integer array enligt insertionsort
		long startTime = System.nanoTime();
		int[] arr10 = random(28000,40000);
		int[] e = insertionSort(arr10);	
		long elapsedTime = System.nanoTime() - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		System.out.println("Insertion sort int: "+seconds);
		
		//Skriver ut tiden det tar att sortera en slumpmässig string array enligt insertionsort
		long startTime2 = System.nanoTime();
		String[] arr11 = randomArray(12000,10);
		String[] f = insertionSort2(arr11);
		long elapsedTime2 = System.nanoTime() - startTime2;
		double seconds2 = (double)elapsedTime2 / 1000000000.0;
		System.out.println("Insertion sort string: "+seconds2);
		
		//Skriver ut tiden det tar att sortera en slumpmässig integer arry enligt mergsort
		long startTime3 = System.nanoTime();
		int[] arr12 = random(1100000,2000000);
		int[] g = mergeSort(arr12);	
		long elapsedTime3 = System.nanoTime() - startTime3;
		double seconds3 = (double)elapsedTime3 / 1000000000.0;
		System.out.println("Mergs sort int: "+seconds3);
		
		//Skriver ut tiden det tar att sortera en slumpmässig string array enligt mergesort
		long startTime4 = System.nanoTime();
		String[] arr5 = randomArray(400000,10);
		String[] h = mergeSort2(arr5);
		long elapsedTime4 = System.nanoTime() - startTime4;
		double seconds4 = (double)elapsedTime4 / 1000000000.0;
		System.out.println("Merg sort string: "+seconds4);
		}		
}