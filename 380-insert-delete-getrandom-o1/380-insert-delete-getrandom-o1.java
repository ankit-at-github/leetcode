class RandomizedSet {

    Set<Integer> st = new HashSet<>();
    public RandomizedSet() {
    }
    
    public boolean insert(int val) {
        if(!st.contains(val))
        {
            st.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(st.contains(val))
        {
            st.remove(val);
            return true;
        }
        return false;
        
    }
    
    public int getRandom() {
        Integer[] array = st.toArray(new Integer[st.size()]);
        Random rand = new Random();
        int randNum = rand.nextInt(st.size());
        return array[randNum];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */