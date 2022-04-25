// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> arrayList;
    int curr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        curr = -1;
	    arrayList = new ArrayList<>();
        while(iterator.hasNext()) arrayList.add(iterator.next());
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return arrayList.get(curr+1);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    curr++;
        return arrayList.get(curr);
	}
	
	@Override
	public boolean hasNext() {
	    if(curr < arrayList.size()-1) return true;
        else return false;
	}
}