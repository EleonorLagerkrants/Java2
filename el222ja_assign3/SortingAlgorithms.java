package Java2.el222ja_assign3;

public class SortingAlgorithms {
	/*
	 * Metod som sorterar en array med hj�lp av insertionsSort.
	 * F�rst �verf�rs alla tal i in[] till sort[] i osorterad ordning.
	 * Sedan j�mf�rs f�rsta talet med det andra och det tal som �r minst l�ggs l�ngst fram i arrayen.
	 * Sedan f�r temp v�rdet p� det tal som ligger till h�ger av de testade. Det tredje talet j�mf�rs sedan med de tv� tidigare.
	 * Detta upprepas tills alla tal i arrayen j�mf�rts. 
	 * Jag tog hj�lp av en l�sning p� l�nken: http://www.algolist.net/Algorithms/Sorting/Insertion_sort
	 */
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
	/*
	 * Jag tog hj�lp av kod fr�n sidan http://stackoverflow.com/questions/3917522/insertion-sort-on-an-array-of-strings-in-c-sharp
	 */
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
	/*
	 * Metoden delar upp arrayen i mindre delar tills de bara best�r av ett element.
	 * Sedan s�tts arrayen ihop igen sorterad genom metoden merge.
	 */
	public static int[] mergeSort(int[] in) 
	{
		if (in.length <= 1) {
            return in;
        }
        
        // Split the array in half
        int[] first = new int[in.length / 2];
        int[] second = new int[in.length - first.length];
        System.arraycopy(in, 0, first, 0, first.length);
        System.arraycopy(in, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, in);
        return in;
	}
	/*
	 * Det f�rsta talet i de b�de arrayerna first och second j�mf�rs och det minsta kommer p� f�rsta plats i sort arrayen.
	 * Detta p�g�r till alla tal har g�tts igenom. Tillslut finns det inga tal att j�mf�ras med och d� l�ggs de till i sort.
	 */
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
	/*
	 * Se den metod int[] mergeSort f�r detaljer. Metoden merge2 har comparedTo f�r att kunna sortera str�ngarna i bokstavsordning
	 */
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
	
	public static String toString(int[] in) {
		String str = "";
		for(int i=0; i<in.length; i++){
			str = str + in[i] + " ";
		}
		return str;
	}
	
	public static String toString2(String[] in) {
		String str = "";
		for(int i=0; i<in.length; i++) {
			str = str + in[i] + " ";
		}
		return str;
	}
	
	public static void main(String[] args) {
		int [] a = {1,6,677,2,-7,8};
		int [] b = insertionSort(a);
		System.out.println("InsertionSort: "+toString(b));
		
		int[] c = mergeSort(a);
		System.out.println("MergeSort: "+toString(c));
		
		String[] d = {"E", "B", "D", "A", "C", "F", "X", "Y"};
		String[] e = insertionSort2(d);
		System.out.println("InsertionSort String: "+toString2(e));
		
		String[] f = mergeSort2(d);
		System.out.println("MergeSort String: "+toString2(f));
		
		int[] g = {4,3,2,1};
		int[] h = insertionSort(g);
		System.out.println(toString(h));
		}
	

}
