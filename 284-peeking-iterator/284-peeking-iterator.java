// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> arrayList;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    arrayList = new LinkedList<>();
        while(iterator.hasNext()) arrayList.add(iterator.next());
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return arrayList.get(0);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int num = arrayList.remove(0);
        return num;
	}
	
	@Override
	public boolean hasNext() {
        return arrayList.size() > 0;
	}
}