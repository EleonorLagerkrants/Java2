package Java2.el222ja_assign3.count_words;

public class Word implements Comparable <Word> {
	private String word;
	
	public Word(String str) {
		this.word = str;
	}
	
	public String toString() {
		return word;
	}
	
	public int hashCode() {
		String s = word.toLowerCase();
		return s.hashCode();
	}
	
	public boolean equals(Object other) {
		if(other instanceof Word) {
			Word otherWord = (Word) other;
			int w = hashCode();
			int h = otherWord.hashCode();
			return w == h;	
		}
		return false;
	}
	
	public int compareTo(Word w) {
		String r = this.word.toLowerCase();
		String t = w.word.toLowerCase();
		if(r.compareTo(t)<0)
			return -1;
		else if(r.compareTo(t)==0)
			return 0;
		else {
			return 1;
		}
	}
} 