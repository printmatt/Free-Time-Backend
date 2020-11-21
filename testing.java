public class testing {
    public static void main(String[] args){
        FreeTimeStamps pair1 = new FreeTimeStamps("Monday",10,0,0,12,30,0);
        FreeTimeStamps pair2 = new FreeTimeStamps("Monday",9,59,0,11,30,0);

        FreeTimeStamps pair3 = new FreeTimeStamps("Monday",8,0,0,12,30,0);
        FreeTimeStamps pair4 = new FreeTimeStamps("Monday",12,59,0,14,30,0);
        System.out.println(pair1.overlaps(pair2));
        System.out.println(pair3.overlaps(pair4));
    }
}
