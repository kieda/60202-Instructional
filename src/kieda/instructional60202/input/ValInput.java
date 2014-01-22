package kieda.instructional60202.input;

import java.util.Scanner;

/**
 * @author zkieda
 */
public class ValInput implements Runnable {
    double[] ts;
    public ValInput(double[] ts) {
        this.ts = ts;
    }
    
    private Scanner in = new Scanner(System.in);
    @Override
    public void run() {
        while(true)
        if(in.hasNextLine()){
            String[] sp = in.nextLine().split("\\s");

            for(String s : sp){
                try{
                String[] is = s.split("=");
                ts[Integer.parseInt(is[0])] = Float.parseFloat(is[1]);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            System.out.print("Values are:");
            for (int i = 0; i < ts.length; i++) {
                System.out.print(" t"+i+"="+ts[i]);
            }
            System.out.println();
        }
    }

}
