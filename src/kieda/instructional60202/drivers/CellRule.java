package kieda.instructional60202.drivers;

/**
 *
 * @author zkieda
 */
public class CellRule {
    public static void main(String[] args) {
        System.out.println((-1+5)%5);
    }
    public static boolean start = false;
    public boolean calculate(boolean me, boolean up, boolean left, boolean down, boolean right){
        if(!start) return me;
        if(left&&right&&down) return !me;
        int neighbors = to(up)+to(left)+to(down)+to(right);
        if(neighbors<=1)return false;
        if(neighbors<=3)return true;
        return false;
    }
    static int to(boolean b){
        return b?1:0;
    }
    
}
