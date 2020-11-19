
public class FreeTimeStamps {
    private String weekday;
    private TimeStamp start;
    private TimeStamp end;
    
    // constructor for pair of time stamps
    public FreeTimeStamps (String weekday,int starthour, int startminute, int startsecond,int endhour, int endminute, int endsecond){
        this.weekday = weekday;
        start = new TimeStamp(weekday,starthour,startminute,startsecond);
        end = new TimeStamp(weekday, endhour, endminute, endsecond);
        
    }

    // default constructor
    public FreeTimeStamps(){
        start = new TimeStamp();
        end = new TimeStamp();
    }

    // Calculate how much time overlaps
    public double overlaps(FreeTimeStamps other){
        double timefree;
        // ( ) : starting and ending time stamps for this object
        // [ ] : starting and ending time stamps for the other object
        // Case 1: overlap of [ (----] )
        if (this.start.isAfter(other.start) && this.start.isBefore(other.end) && this.end.isAfter(other.end)){
            double deltahour = other.end.getHour() - this.start.getHour();
            int deltaminute = other.end.getMinute() - this.end.getMinute();
            timefree = deltahour + (double)deltaminute / 60.0;
        }
        // same as case 1 but other way around: ( [----) ]
        else if (this.start.isBefore(other.start) && this.end.isAfter(other.start) && this.end.isBefore(other.end)){
            double deltahour = this.end.getHour() - other.start.getHour();
            int deltaminute = this.end.getMinute() - other.end.getMinute();
            timefree = deltahour + (double)deltaminute / 60.0;
        }
        // case 2: one happens in another
        // 									[ (----) ]
        else if (this.start.isAfter(other.start) && this.end.isBefore(other.end)){
            double deltahour = this.end.getHour() - this.start.getHour();
            int deltaminute = this.end.getMinute() - this.start.getMinute();
            timefree = deltahour + (double)deltaminute / 60.0;
        }
        // 	same as case 2					( [----] )
        else if (other.start.isAfter(this.start) && other.end.isBefore(this.end)){
            double deltahour = other.end.getHour() - other.start.getHour();
            int deltaminute = other.end.getMinute() - other.start.getMinute();
            timefree = deltahour + (double)deltaminute / 60.0;
        }
        // there is no overlapping 
        else{
            return -1;
        }
        return timefree;
    }
    
    public TimeStamp getStart(){
        return start;
    }
    
    public TimeStamp getEnd(){
        return end;
    }
    
}
