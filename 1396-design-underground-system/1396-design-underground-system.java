class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkin;
    Map<String, Pair<Double, Integer>> routeMap;
    public UndergroundSystem() {
        checkin = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkin.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p = checkin.get(id);
        
        String routeName = p.getKey() + "_" + stationName;
        int duration = t - p.getValue();
        
        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair(0.0, 0));
        routeMap.put(routeName, new Pair(duration + route.getKey(), route.getValue()+1));
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "_" + endStation;
        Pair<Double, Integer> trip = routeMap.get(routeName);
        return trip.getKey()/trip.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */