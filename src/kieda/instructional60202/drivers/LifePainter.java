package kieda.instructional60202.drivers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import kieda.graphics.Paintable;

/**
 * @author zkieda
 */
public class LifePainter implements Paintable{
    private static final boolean T=true;
    private static final boolean F=false;
    
    static boolean[][] cells = new boolean[][]{
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, T, F, T, F, T, F, T, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, T, F, T, F, T, F, T, F, T, F, T, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, T, F, T, T, F, F, T, T, F, F, T, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, F, T, T, F, F, T, T, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, F, T, T, F, F, T, T, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, T, F, T, T, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, T, F, T, F, T, F, T, F, T, F, T, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, T, F, T, F, T, F, T, F, T, F, T, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F},
        {F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F},
    };
    int w = 30, h = 25;
    
    
    final int spacing = 5;
    final int cellwidth = 25;
    final Stroke hilS = new BasicStroke(2);
    final Color background = Color.lightGray;
    final Color highl = Color.black;
    
    CellRule rule = new CellRule();
    long waitTime = 300;
    
    @Override
    public void paint(Graphics2D g) {
        g.setStroke(hilS);
        paintBg(g);
        int xpos, ypos=spacing;
        for(int y=0;y<h;y++){
        xpos=spacing;
        for(int x=0; x<w; x++) {
            boolean cur = cells[y][x];
            boolean me = rule.calculate(cur,//this
                cells[(y-1+h)%h][x],//up
                cells[y][(x-1+w)%w],//left
                cells[(y+1)%h][x],//down
                cells[y][(x+1)%w]);//right
            
            //
            if(cur){
                g.setColor(highl);
                
                g.drawRect(xpos, ypos, cellwidth, cellwidth);
                g.setColor(calculateFor(x, y));
            }else{
                g.setColor(blankFor(x, y));
                
            }
            
            g.fillRect(xpos, ypos, cellwidth, cellwidth);
            
            cells[y][x]=me;
            
            xpos+=cellwidth+spacing;
        }
        ypos+=cellwidth+spacing;
        }
    }
    int width = w*(cellwidth+spacing)+spacing, height = h*(cellwidth+spacing)+spacing;
    public void paintBg(Graphics2D g){
        g.setColor(background);
        g.fillRect(0,0,w*(cellwidth+spacing)+spacing,h*(cellwidth+spacing)+spacing);
    }
    final float max = (w/2 + h/2)*1.5f;
    final float maxw = 500*(w+h);
    public Color calculateFor(int x, int y){
        int dist = Math.abs(w/2-x) + Math.abs(h/2-y);
        
        return new Color(Color.HSBtoRGB(0, .2f, .5f*(1-((float)dist/max))));//Color.DARK_GRAY;
    }
    public Color blankFor(int x, int y){
        int dist = x+y;
        return new Color(Color.HSBtoRGB((176f)/255f, .15f, (1-((float)dist/maxw))));//Color.DARK_GRAY;
    }
    public static void main(String[] args) {
        System.out.print("[");
        for(boolean[] b : cells){
            System.out.print("[");
            int i = 0;
        for(boolean n : b){
            if(i==(b.length-1))
            System.out.print(n?1:0);
            else System.out.print(n?1:0+", ");
            i++;
        }
            System.out.print("], ");
        }
    }
}
