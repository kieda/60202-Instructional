package kieda.instructional60202.drivers;
import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import kieda.graphics.Paintable;
import kieda.graphics.lib.Shapes;
import kieda.instructional60202.input.ValInput;
import kieda.testingframe.KFrame;
import kieda.util.ScreenD;

public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final KFrame d = new KFrame();
        d.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(ke.getKeyChar()==' '){
                    CellRule.start=true;
                }
            }
        });
        
        d.addPaintable(new Paintable() {
            LifePainter k = new LifePainter();
            @Override
            public void paint(Graphics2D g) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, d.getWidth(), d.getHeight());
                AffineTransform at = new AffineTransform();
                at.translate((d.getWidth()-k.width)/2, (d.getHeight()-k.height)/2);
                g.setTransform(at);
                k.paint(g);
            }
        });
//        final Disp d = new Disp();
//        d.addPaintable(
//            new Paintable() {
//                final Dimension sd = ScreenD.getScreenD();
//                final Color BACKGROUND = Color.DARK_GRAY;
//                final Color PAINTBACK = Color.LIGHT_GRAY;
//                final int w = 160, h = 90;
//                
//                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//                
//                
//                @Override
//                public void paint(Graphics2D g) {
//                    g.setColor(BACKGROUND);
//                    g.fillRect(0, 0, sd.width, sd.height);
//                    
//                    
//                    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//                    Graphics2D g2 = bi.createGraphics();
////                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
////                        RenderingHints.VALUE_ANTIALIAS_ON);
//                    g2.setColor(PAINTBACK);
//
//                    g2.fillRect(0, 0, w, h);
//                    g2.setColor(BACKGROUND);
//                    
////                    g2.setColor(WHITE);
////                    g2.fillRect(w/6, h/4, w*2/3, h/2);
////                    kieda.graphics.lib.Shapes.drawEquilateral(g, w, w, w);
//                    g2.setColor(BLACK);
//                    pa(g2);
//                    
//                    Dimension d= getPaintDim();
//                    g.drawImage(bi.getScaledInstance(d.width, d.height, BufferedImage.SCALE_FAST), (sd.width-d.width)/2, (sd.height-d.height)/2, null);
//                }
//                Dimension getPaintDim(){
//                    int ww = sd.width-(sd.width/3);
//                    
//                    return new Dimension(ww, ww*h/w);
//                }
//                AffineTransform at  = new AffineTransform();
//                public void pa(Graphics2D g) {
//                    g.setStroke(new BasicStroke(2));
//
//                    Shape s;
//                    //flip upside down
////                    g.drawOval(51, h/2, 1, 1);
//                    at.rotate(Math.toRadians(180), 51, h/2);
//                    g.setTransform(at);
//                    Shapes.drawEquilateral(g, 51, 24, 51);
//                    at.rotate(Math.toRadians(-180), 51, h/2);
//                    g.setTransform(at);
//
//                    //rightside up
//                    Shapes.drawEquilateral(g, 106, 22, 51);
//                    
//                    int width = 29;
////                    g.setStroke(new BasicStroke(.5f));
//                    s = g.getClip();
//                    g.setClip((int)(51-width/2), (int)(36-width/2), width/2, (int)(width/2+6));
//                    g.drawOval((int)(51-width/2), (int)(36-width/2), width, width);
//                    g.setClip(s);
//                    
////                    g.setStroke(new BasicStroke(1f));
//                    g.drawLine(39, 29, 72, 29);
//                    
////                    g.setStroke(new BasicStroke(.5f));
////                    g.drawOval((int)(106-width/2), (int)(51-width/2), width, width);
//                    
//                    //slope down
//                    g.drawLine((int)72, (int)29, (int)118, (int)59);
//                    
//                    g.drawLine((int)118, (int)59, (int)86, (int)59);
//                    
//                    g.drawLine((int)0, (int)59, (int)46, (int)59);
//                    
//                    g.drawLine(118, (int)59, 118+46,59-30);
//                }
//                double[] t = {1,30,40,50};
//                {
//                    new Thread(new ValInput(t)).start();
//                }
//        } );
        
        d.setFullscreen();
        d.open();
    }
}
