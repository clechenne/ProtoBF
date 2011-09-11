package org.cl.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.cl.core.TurnRunner;
import org.cl.model.PointBF;
import org.cl.model.Ship;
import org.cl.model.Side;
import org.cl.orders.Order;
import org.cl.orders.OrderParse;

public class Gui {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {

        JFrame f = new JFrame("BF1900");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new SeaPanel());
        f.setSize(1000,800);
        f.setVisible(true);
    } 

}

class SeaPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TurnRunner tr;
	
    ProtoGame game = new ProtoGame();

    List<ShipView> views = new ArrayList<ShipView>();
    JLabel hintBar = new JLabel(" ");
    JTextField textField ;
    
    Point2D selected;
    
    public SeaPanel() {
        
    	super(new BorderLayout());
    	
    	addButtonsBar();
        
        hintBar.setBorder(BorderFactory.createLoweredBevelBorder());
		hintBar.setForeground(Color.RED);
		add(hintBar, BorderLayout.PAGE_END);
        
		// Prepare views.
    	for (Ship s : game.ships) {
    		views.add(new ShipView(s));
        }
        
        setBorder(BorderFactory.createLineBorder(Color.black));

        tr = new TurnRunner(game);
        
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            	select(e.getX(),e.getY());
                //moveSquare(e.getX(),e.getY());
            }

			private void select(int x, int y) {
				selected = new Point(x, y);
		    	
				for (ShipView s : views) {
					double d = selected.distance(s.getX(), s.getY());
					
					if (d < 10) {
						s.setSelected(true);
						hintBar.setText(s.getInfo());
					} else {
						s.setSelected(false);
					}
					repaint(s.getX(), s.getY(), s.getX() + s.getRadius(), s.getY()+s.getRadius() );
		        }
			}
        });
    }

	private void addButtonsBar() {
		JToolBar toolBar = new JToolBar("");
    	JButton button = new JButton("Next");
    	button.setActionCommand("next");
    	button.addActionListener(this);
    	toolBar.add(button);
        
    	textField = new JTextField("");
    	textField.setColumns(10);
    	toolBar.add(textField);

    	button = new JButton("Add");
    	button.setActionCommand("add");
    	button.addActionListener(this);
    	toolBar.add(button);

    	button = new JButton("Show");
    	button.setActionCommand("show");
    	button.addActionListener(this);
    	toolBar.add(button);

    	toolBar.setFloatable(false);
        //toolBar.setRollover(true);
        
        add(toolBar, BorderLayout.PAGE_START);
	}
    
    public void actionPerformed(ActionEvent e) {
        
    	if ("add".equals(e.getActionCommand())) {
    		addAction();
        } else {
            // next
        	tr.end();
        	repaint();
        	hintBar.setText("");
        }
    }

	private void addAction() {
		String text = textField.getText();
		
		if (text.length() !=0) {
			Order o = OrderParse.parse(textField.getText());
			tr.add(o);
			hintBar.setText(hintBar.getText() + "<" + textField.getText() + ">");
		} else {
			hintBar.setText("no order");
		}
	}

    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for (ShipView s : views) {
        	s.paintIt(g);
        }
        
    }
}

class ShipView {
	
    private Ship ship;
    private boolean selected;
    
    int RADIUS = 10;
    int W = 6;
    int H = 15;
    public ShipView(Ship s) {
    	ship = s;
	}

	public String getInfo() {
		return 
			ship.side + ":" + ship.name + 
			", speed:" + ship.getCurrentSpeed() +
			", heading:" + ship.heading;
	}

	public void setSelected(boolean b) {
		selected = b;
		
	}

	public void setX(int xPos){ 
		ship.pos.x = xPos;
    }

    public int getX(){
        return ship.pos.x;
    }

    public void setY(int yPos){
    	ship.pos.y = yPos;
    }

    public int getY(){
        return ship.pos.y;
    }

    public void paintIt(Graphics g){
    	Graphics2D ga = (Graphics2D)g;
    	       
       	if (selected) {
    		ga.setColor(Color.ORANGE);
    	} else {
    		ga.setColor(getColor(ship.side));
    	}
       	
       	ga.setFont(new Font("Serif", Font.PLAIN, 12));
        ga.drawString("+", ship.pos.x, ship.pos.y);
        //ga.setTransform(ga.getTransform());
        
    	AffineTransform orig = ga.getTransform();
        AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(0),ship.pos.x, ship.pos.y);
    	ga.setTransform(transform);
    	
        ga.setFont(new Font("Serif", Font.BOLD, 9));
        ga.drawString(ship.name, ship.pos.x+10, ship.pos.y);
        ga.setTransform(orig);
        
        PointBF [] points = ship.getPath().getAlls();
        int idx = points.length;
        PointBF end = ship.pos;
        while (idx > 0) {
        	PointBF start = points[idx-1]; 
        	Line2D line = new Line2D.Float(end.x, end.y, start.x, start.y);
        	ga.draw(line);
        	end =  start;
        	idx--;
        }
        
       // draw circle center
       PointBF centre =  ship.pos.compute(40, ship.heading+90);
       ga.drawString("s", centre.x, centre.y);
       System.out.println("STAR : ship.heading+90=" +  (ship.heading+90) + "," + centre);
       
       PointBF centreP =  ship.pos.compute(40, ship.heading-90);
       ga.drawString("p", centreP.x, centreP.y);
       System.out.println("PORT : ship.heading-90=" +  (ship.heading-90) + "," + centreP);
       
       int rot = (ship.heading-30);      
       System.out.println("ship.heading" + ship.heading + ", rot="+rot);
//       
       double x1 = centreP.x +  (int)(40*Math.cos(Math.toRadians(rot)));
       double y1 = centreP.y +  (int)(40*Math.sin(Math.toRadians(rot)));
       ga.drawString("1", (int) x1, (int) y1);
	   System.out.println(x1 + "," + y1);
	   
       for (int angle = 0; angle < 360; angle += 5) {
    	   double x = centre.x +  (int)(40*Math.cos(Math.toRadians(angle)));
    	   double y = centre.y +  (int)(40*Math.sin(Math.toRadians(angle)));
    	   ga.drawString(".", (int) x, (int) y);
       }
       
       for (int angle = 0; angle < 360; angle += 5) {
    	   double x = centreP.x +  (int)(40*Math.cos(Math.toRadians(angle)));
    	   double y = centreP.y +  (int)(40*Math.sin(Math.toRadians(angle)));
    	   ga.drawString(".", (int) x, (int) y);
       }
       
    }

	private Color getColor(Side side) {
		if (side == Side.JAPENESE) {
			return Color.RED;
		} else if (side == Side.RUSSIAN) {
			return Color.BLACK;
		}
		return Color.BLACK;
	}

	public int getRadius() {
		return (int)RADIUS;
	}
}
