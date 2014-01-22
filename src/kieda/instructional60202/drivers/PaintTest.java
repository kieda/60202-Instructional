package kieda.instructional60202.drivers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;
import kieda.graphics.Paintable;
import kieda.graphics.lib.Shapes;
import kieda.instructional60202.input.ValInput;
import kieda.util.ScreenD;

/**
 *
 * @author zkieda
 */
public class PaintTest implements Paintable{
                double ts[] = {-5, 0, 5, 400, 230, 50}; 
                Pattern p = Pattern.compile(".", Pattern.DOTALL);
                
                Point pt = ScreenD.centerScreen();
                AffineTransform at = new AffineTransform();
                Dimension sd = ScreenD.getScreenD();
                @Override
                public void paint(Graphics2D g) {
                    BufferedImage bi = new BufferedImage(160, 90, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = bi.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                        RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.BLACK);
                    g2.drawRect(160/6, 90/4, 2*160/3, 90/2);
//                    g2.drawLine(0, 0, 160, 90);
//                    routine(g2);
                    ;
                    g.drawImage(bi.getScaledInstance(sd.width, sd.height, BufferedImage.SCALE_FAST), null, null);
//                    g.drawLine(0, (int)ts[5], sd.width, (int)ts[5]);
                    
                }
                void routine(Graphics2D g){
                    at.setToRotation(Math.toRadians(ts[0]), pt.x, pt.y);
                    g.setTransform(at);
                    Shapes.drawCenteredEquilateral(g, pt.x, pt.y, (int)ts[3]);
                    
                    at.setToIdentity();
                    g.setTransform(at);
                    g.fillOval(pt.x-2, pt.y-2, 4, 4);
                    at.setToRotation(Math.toRadians(ts[1]), pt.x, pt.y);
                    g.setTransform(at);
                    Shapes.drawCenteredEquilateral(g, pt.x, pt.y, (int)ts[3]);
                    
                    at.setToRotation(Math.toRadians(ts[2]), pt.x, pt.y);
                    g.setTransform(at);
                    Shapes.drawCenteredEquilateral(g, pt.x, pt.y, (int)ts[3]);

                    at.setToIdentity();
                    g.setTransform(at);
                    {
                        int diff = (int)(ts[4]/2);
                        g.drawOval(pt.x-diff, pt.y-diff, (int)ts[4], (int)ts[4]);
                    }
                }
                
                {
                    Thread t = new Thread(new ValInput(ts));
                    t.start();
                }
}
