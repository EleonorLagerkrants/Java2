package Java2.el222ja_assign3.count_words;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Scanner;

public class WordCount1Main {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Temp\\words.txt");
			Scanner scan = new Scanner((file));
			HashSet<Word> hashset = new HashSet<Word>();
			TreeSet<Word> treeset = new TreeSet<Word>();
			ArrayList<Word> list = new ArrayList<Word>();
			String[] arr;
			while(scan.hasNext()) {
				String str = scan.nextLine();
				arr = str.split(" ");
				for(int i=0; i<arr.length; i++) {
					Word word = new Word(arr[i]);
					hashset.add(word);
					treeset.add(word);
					list.add(word);
				}
			}
			System.out.println("Hashset size: "+hashset.size());
			System.out.println("Treeset size: "+treeset.size());
			System.out.println("ArrayList size: "+list.size());
			Iterator<Word> it = treeset.iterator();
			while(it.hasNext())
				System.out.print(it.next().toString()+" ");
			scan.close();
			}
		
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
