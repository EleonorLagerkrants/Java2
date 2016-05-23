package Java2.el222ja_assign3.count_words;

public interface WordSet extends Iterable {
	
	public void add(Word word);
	
	public boolean contains(Word word);
	
	public int size();
	
	public String toString();
}
