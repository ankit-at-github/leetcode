class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] reservedSeats = new int[n];
        
        for(int[] booking : bookings)
        {
            int start = booking[0]-1;
            int end = booking[1]-1;
            int seats = booking[2];
            
            reservedSeats[start]+= seats;
            if(end+1 < n)
                reservedSeats[end+1]+= -seats;
        }
        
        for(int i=1; i<n; i++)
        {
            reservedSeats[i]+= reservedSeats[i-1]; 
        }
        
        return reservedSeats;
    }
}