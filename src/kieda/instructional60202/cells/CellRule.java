package kieda.instructional60202.cells;

import java.util.Random;

/**
 * @author zkieda
 */
public class CellRule {
    public static void main(String[] args) {
        System.out.println((-1+5)%5);
    }
    public static boolean start = false;
    private Random r = new Random();
    public boolean calculate(boolean me, boolean up, boolean left, boolean down, boolean right){
        if(!start) return me;
//        if(left&&right&&down) return !me;
        int neighbors = to(up)+(r.nextBoolean()?2:-2)*to(left)+to(down)*2-to(right);//+to(me);
        if(neighbors<=1)return false;
        if(neighbors<=3)return true;
        return false;//!me;
    }
    static int to(boolean b){
        return b?1:0;
    }
    
}
