class MyCalendar {
    List<List<Integer>> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(calendar.size() == 0)
        {
            calendar.add(Arrays.asList(start, end));
            return true;
        }
        for(List<Integer> c : calendar)
        {
            int startTime = c.get(0);
            int endTime = c.get(1);
            
            if(end > startTime && start < endTime) return false;
            
        }
        calendar.add(Arrays.asList(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */