class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12) hour=0;

        double minAngle=6*minutes;
        double hourAngle=30*hour+0.5*minutes;

        double ans=Math.abs(hourAngle-minAngle);

        return Math.min(ans,360-ans);
    }
}