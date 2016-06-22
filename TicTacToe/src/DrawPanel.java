import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    	
    	private final int MAIN_MARGIN = 50;
    	private final int SMALL_MARGIN = 17;
    	
    	/** Draw the nine small boards and the one big board **/
        private void doDrawing(Graphics2D g2d) {

            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(10));
            g2d.drawLine(MAIN_MARGIN + 233, MAIN_MARGIN, MAIN_MARGIN + 233, 800 - MAIN_MARGIN);
            g2d.drawLine(MAIN_MARGIN + 233 + 233, MAIN_MARGIN, MAIN_MARGIN + 233 + 233, 800 - MAIN_MARGIN);

            g2d.drawLine(MAIN_MARGIN, MAIN_MARGIN + 233, 800 - MAIN_MARGIN, MAIN_MARGIN + 233);
            g2d.drawLine(MAIN_MARGIN, MAIN_MARGIN + 233 + 233, 800 - MAIN_MARGIN, MAIN_MARGIN + 233 + 233);
            
            g2d.setStroke(new BasicStroke(5));
            
            for (int row = 0; row < 3; row++) {
            	for (int col = 0; col < 3; col++) {
                	int x = (MAIN_MARGIN + SMALL_MARGIN) + 233 * col;
                	int y = (MAIN_MARGIN + SMALL_MARGIN) + 233 * row;
                	
            		g2d.drawLine(x + 66, y, x + 66, y + 200);
            		g2d.drawLine(x + 132, y, x + 132, y + 200);

            		g2d.drawLine(x, y + 66, x + 200, y + 66);
            		g2d.drawLine(x, y + 132, x + 200, y + 132);
            	}
            }

        }

        @Override
        public void paintComponent(Graphics g) {
        	super.paintComponent(g);
        	Graphics2D g2d = (Graphics2D) g;
            doDrawing(g2d);
        }
        
        public void drawCircle(Graphics2D g2d, int x, int y, int radius) {
        	System.out.println("gets here");
        	
        	//Graphics2D g = (Graphics2D)getGraphics();
        	
        	if (g2d == null)
        		System.out.println();
        	
        	
        	//g.setStroke(new BasicStroke(5));
            g2d.setColor(Color.black);
        	g2d.drawOval(x, y, radius * 2, radius * 2);
    		g2d.drawLine(x, 0, 400, y + 66);
    		
    		System.out.println("finished drawing");
        }


    }