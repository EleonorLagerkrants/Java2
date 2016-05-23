package Java2.el222ja_assign4;

import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

	@Test
	public void testHeapInsert() {
		BinaryIntHeap a = new BinaryIntHeap();
		assertTrue("Constructor creates empty heap",a.size()==0);
		assertTrue("Constructor creates empty heap",a.isEmpty());
		
		a.insert(1);
		assertTrue("Insert adds int to heap",a.size()==1);
		assertTrue("Insert adds int to heap",BinaryIntHeap.arr[1]==1);
		
		a.insert(2);
		a.insert(7);
		a.insert(4);
		a.insert(5);
		assertTrue("Insert adds int to heap",a.size()==5);
		assertTrue("Insert rearenges heap",BinaryIntHeap.arr[1]==7);
		assertTrue("PullHighest returns and removes the highest",a.pullHighest()==7 && a.arr[1]==5);
		
				
		BinaryIntHeap b = new BinaryIntHeap();
		int[] arr = {100, 12, 136, 15, 26, 723, 6184, 56, 125, 900, 5, 24, 65, 89, 15, 567};
		for( int i : arr)
			b.insert(i);
		assertTrue("Insert rearenges heap",b.arr[1]==6184);
		assertTrue("When inserting more than 8 elements the array resizes",b.size()==16);
	}
}
