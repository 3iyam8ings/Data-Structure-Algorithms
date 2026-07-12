class Solution {
    //1. 
    public int secondsBetweenTimes(String startTime, String endTime) {
        return converToSeconds(endTime) - converToSeconds(startTime);
    } 
    int converToSeconds(String time){
      int HH = Integer.parseInt(time.substring(0,2));
        int MM = Integer.parseInt(time.substring(3,5));
        int SS = Integer.parseInt(time.substring(6,8));
        
         int totalSeconds = HH*3600 + MM*60 + SS;
        return totalSeconds;
}

}