package org.cl.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
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
import org.cl.model.Ship;
import org.cl.model.Side;
import org.cl.orders.Order;
import org.cl.orders.OrderParse;
import org.cl.util.TurnCalculator;

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
        f.setSize(600,400);
        f.setVisible(true);
    } 

}

class SeaPanel extends JPanel implements ActionListener {

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
        }
    }

	private void addAction() {
		String text = textField.getText();
		
		if (text.length() !=0) {
			Order o = OrderParse.parse(textField.getText());
			tr.add(o);
		
			hintBar.setText("<" + textField.getText() + ">");
		} else {
			hintBar.setText("no order");
		}
	}

    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        //g.drawString("This is my custom Panel!",10,20);
        for (ShipView s : views) {
        	s.paintIt(g);
        }

    }  
}

class Circle {

    public final Point center;
    public final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    
    public Point toScreenPoint(Point center, int width, int height) {
        int screenX = center.x + (width / 2);
        int screenY = -(center.y - (height / 2));
        return new Point(screenX, screenY);
    }
    
    public void drawOn(Graphics g, int width, int height) {
        // translate Cartesian(x,y) to Screen(x,y)
        Point screenP = toScreenPoint(center, width, height);
        int r = (int) Math.rint(radius);
        g.drawOval((int) screenP.x - r, (int) screenP.y - r, r + r, r + r);
    }

    @Override
    public String toString() {
        return String.format("{center=%s, radius=%.2f}", center, radius);
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
    	
    	// current pos
    	// Shape circle = new Ellipse2D.Float(ship.pos.x, ship.pos.y, RADIUS, RADIUS);
    	
    	RoundRectangle2D rect = new RoundRectangle2D.Float((float)ship.pos.x, (float)ship.pos.y, W, H, 2, 2);

    	AffineTransform orig = ga.getTransform();
    	// 
    	AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(ship.heading),rect.getCenterX(), rect.getCenterY() );
    	ga.setTransform(transform);
    	
    	if (selected) {
    		ga.setColor(Color.GREEN);
    		ga.fill(rect);
    		ga.setColor(Color.ORANGE);
    		ga.draw(rect);
    	} else {
    		ga.setColor(getColor(ship.side));
    		ga.fill(rect);
    		ga.setColor(Color.BLACK);
    		ga.draw(rect);  		
    	}
        
    	// moving circle
//    	Shape circle = new Ellipse2D.Float(ship.pos.x+5, ship.pos.y-20, 40, 40);
//    	
//    	int x = (int) circle.getBounds2D().getCenterX();
//    	int y = (int) circle.getBounds2D().getCenterY();
//    	
//    	ga.drawLine(x-50, y, x+50, y);
//    	
//    	ga.setColor(Color.BLACK);
//    	ga.draw(circle);
//    	ga.draw(circle.getBounds());
        // drawing       
        for (int d=0; d < 138; d+=10) {
        	TurnCalculator tc = new TurnCalculator(new org.cl.model.Point(ship.pos.x, ship.pos.y), true, d);
        	org.cl.model.Point p = tc.execute();
        	Shape pC = new Ellipse2D.Float(p.x, p.y, 5, 5);
        	ga.fill(pC);
        	ga.setColor(Color.BLACK);
        	ga.draw(pC);
        }
        
        for (int d=0; d < 138; d+=10) {
        	TurnCalculator tc = new TurnCalculator(new org.cl.model.Point(ship.pos.x, ship.pos.y), false, d);
        	org.cl.model.Point p = tc.execute();
        	Shape pC = new Ellipse2D.Float(p.x, p.y, 5, 5);
        	ga.fill(pC);
        	ga.setColor(Color.BLACK);
        	ga.draw(pC);
        }
        
        Font font = new Font("Serif", Font.BOLD, 9);
        ga.setFont(font);
        ga.drawString(""+ship.id, ship.pos.x+5, ship.pos.y+H+10);
        ga.setTransform(orig);
    }

	private Color getColor(Side side) {
		if (side == Side.JAPENESE) {
			return Color.RED;
		} else if (side == Side.RUSSIAN) {
			return Color.YELLOW;
		}
		return Color.BLACK;
	}

	public int getRadius() {
		return (int)RADIUS;
	}
}
