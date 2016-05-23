package Java2.el222ja_assign4;

import java.util.NoSuchElementException;

//För denna uppgift har jag tagit hjälp av föreläsningsanteckningar och boken.
public class BinaryIntHeap {
	public static int size; 
	public static int[] arr;
	
	//Creates empty heap
	public BinaryIntHeap() {
		arr = new int[8];
		size = 0;
	}
	//Inserts an element and rearranges the heap 
	public void insert (int n) {
		if(size >= arr.length-1) {
			resize(); 
		}
		int index = size+1;
		arr[index] = n;
		for(; index > 1; index /= 2) {
			if(arr[index] > arr[index/2]) {
				int tmp = arr[index];
				arr[index] = arr[index/2];
				arr[index/2] = tmp;
			}
		}
		size++;
	}
	//Metod för att dubbla längden på arrayen
	public void resize() {
		int[] tmp = new int[arr.length*2];
		for(int i = 0; i < arr.length; i++)
			tmp[i] = arr[i];
		arr = tmp;
	}
	//Metod som retunerar och tar bort det högsta talet
	public int pullHighest() {
		if(!isEmpty()) {
			int a = arr[1];
			if(size > 1)
				arr[1] = arr[size];
			size--;
			int index = 1;
			while(index*2 < size) {
				if( arr[index] < arr[index*2] || arr[index] < arr[(index*2)+1]) {
					if(arr[index*2] > arr[(index*2)+1]) {
						int tmp = arr[index];
						arr[index] = arr[index*2];
						arr[index*2] = tmp;
						index = index*2;
					}
					else {
						int tmp = arr[index];
						arr[index] = arr[(index*2)+1];
						arr[(index*2)+1] = tmp;
						index = index*2+1;
					}
				}
			}
			return a;
		}
		throw new NoSuchElementException();
	}
	//Retunerar storleken på arrayen
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
