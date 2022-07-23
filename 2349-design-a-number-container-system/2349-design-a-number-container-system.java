class NumberContainers {
    TreeMap<Integer, Integer> tmap;
    public NumberContainers() {
        tmap = new TreeMap<>();
    }
    
    public void change(int index, int number) {
        tmap.put(index, number);
    }
    
    public int find(int number) {
        for(int index : tmap.keySet())
        {
            if(tmap.get(index) == number) return index;
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */