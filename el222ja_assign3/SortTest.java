package Java2.el222ja_assign3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

public class SortTest {
	
	private int[] random(int size, int max) {
		Random rand = new Random();
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			int n = rand.nextInt(max);
			arr[i]= n;
		}
		return arr;
	}
	private String[] randomArray(int size, int wordLength) {
		Random rand = new Random();
		String[] arr = new String[size];
		for(int i=0; i<size; i++) 
		{
			String n = randomString(rand, wordLength);
			arr[i]= n;
		}
		return arr;
	}
	
	private static String randomString(Random number, int length) {
		String all = "abcdefghijklmnopqrstuvxyzåäö";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++) {
	        text[i] = all.charAt(number.nextInt(all.length()));
	    }
	    return new String(text);
	}
	
	@Test public void testInsertionSorting() {
		int[] arr1 = new int[0];
		int[] a = SortingAlgorithms.insertionSort(arr1);
		assertEquals(0,a.length);
		
		int[] arr2 = {7};
		int[] b = SortingAlgorithms.insertionSort(arr2);
		assertEquals(1,b.length);
		assertEquals(7,b[0]);
		
		int[] arr3 = {7,7,7};
		int[] c = SortingAlgorithms.insertionSort(arr3);
		assertEquals(3,c.length);
		for (int i : c)
			assertEquals(7,i);
		
		int[] arr4 = {4,3,2,1};   
		int[] d = SortingAlgorithms.insertionSort(arr4);
		assertEquals(4,d.length);
		assertEquals(1,d[0]);
		assertEquals(4,d[3]);
		
		int[] arr5 = random(100,100);
		int[] e = SortingAlgorithms.insertionSort(arr5);	
		for(int i=0; i<e.length-1; i++) 
			assertTrue(e[i]<=e[i+1]);
		
		int[] arr6 = random(10000,10000);
		int[] f = SortingAlgorithms.insertionSort(arr6);
		for(int i=0; i<f.length-1; i++)
			assertTrue(f[i]<=f[i+1]);
	}
	
	@Test public void TestMergeSorting() {
		int[] arr1 = new int[0];
		int[] a = SortingAlgorithms.mergeSort(arr1);
		assertEquals(0,a.length);
		
		int[] arr2 = {7};
		int[] b = SortingAlgorithms.mergeSort(arr2);
		assertEquals(1,b.length);
		assertEquals(7,b[0]);
		
		int[] arr3 = {7,7,7};
		int[] c = SortingAlgorithms.mergeSort(arr3);
		assertEquals(3,c.length);
		for (int i : c)
			assertEquals(7,i);
		
		int[] arr4 = {4,3,2,1};   
		int[] d = SortingAlgorithms.mergeSort(arr4);
		assertEquals(4,d.length);
		assertEquals(1,d[0]);
		assertEquals(4,d[3]);
		
		int[] arr5 = random(100,100);
		int[] e = SortingAlgorithms.mergeSort(arr5);	
		for(int i=0; i<e.length-1; i++) 
			assertTrue(e[i]<=e[i+1]);
		
		int[] arr6 = random(10000,10000);
		int[] f = SortingAlgorithms.mergeSort(arr6);
		for(int i=0; i<f.length-1; i++)
			assertTrue(f[i]<=f[i+1]);
	}
	
	@Test public void testInsertionSortingString() {
		String[] arr1 = new String[0];
		String[] a = SortingAlgorithms.insertionSort2(arr1);
		assertEquals(0,a.length);
		
		String[] arr2 = {"Hej"};
		String[] b = SortingAlgorithms.insertionSort2(arr2);
		assertEquals(1,b.length);
		assertEquals("Hej",b[0]);
		
		String[] arr3 = {"hej","hej","hej"};
		String[] c = SortingAlgorithms.insertionSort2(arr3);
		assertEquals(3,c.length);
		for (String i : c)
			assertEquals("hej",i);
		
		String[] arr4 = {"Detta","Cirka","Bara","Alla"};   
		String[] d = SortingAlgorithms.insertionSort2(arr4);
		assertEquals(4,d.length);
		assertEquals("Alla",d[0]);
		assertEquals("Detta",d[3]);
		
		String[] arr5 = randomArray(100,100);
		String[] e = SortingAlgorithms.insertionSort2(arr5);	
		for(int i=0; i<e.length-1; i++) 
			assertTrue(e[i].compareTo(e[i+1]) <= 0);
		
		String[] arr6 = randomArray(10000,10000);
		String[] f = SortingAlgorithms.insertionSort2(arr6);
		for(int i=0; i<f.length-1; i++)
			assertTrue(f[i].compareTo(f[i+1]) <= 0);
	}
	
	@Test public void TestMergeSortingString() {
		String[] arr1 = new String[0];
		String[] a = SortingAlgorithms.mergeSort2(arr1);
		assertEquals(0,a.length);
		
		String[] arr2 = {"Hej"};
		String[] b = SortingAlgorithms.mergeSort2(arr2);
		assertEquals(1,b.length);
		assertEquals("Hej",b[0]);
		
		String[] arr3 = {"hej","hej","hej"};
		String[] c = SortingAlgorithms.mergeSort2(arr3);
		assertEquals(3,c.length);
		for (String i : c)
			assertEquals("hej",i);
		
		String[] arr4 = {"Detta","Cirka","Bara","Alla"};   
		String[] d = SortingAlgorithms.mergeSort2(arr4);
		assertEquals(4,d.length);
		assertEquals("Alla",d[0]);
		assertEquals("Detta",d[3]);
		
		String[] arr5 = randomArray(100,100);
		String[] e = SortingAlgorithms.mergeSort2(arr5);	
		for(int i=0; i<e.length-1; i++) 
			assertTrue(e[i].compareTo(e[i+1]) <= 0);
		
		String[] arr6 = randomArray(10000,10000);
		String[] f = SortingAlgorithms.mergeSort2(arr6);
		for(int i=0; i<f.length-1; i++)
			assertTrue(f[i].compareTo(f[i+1]) <= 0);
	}

}
