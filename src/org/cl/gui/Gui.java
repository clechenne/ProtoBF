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
import java.awt.geom.Ellipse2D;
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
        f.setSize(600,400);
        f.setVisible(true);
    } 

}

class SeaPanel extends JPanel implements ActionListener {

    //ShipView redSquare = new ShipView();
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
//    private void moveSquare(int x, int y){
//
//        // Current square state, stored as final variables 
//        // to avoid repeat invocations of the same methods.
//        final int CURR_X = redSquare.getX();
//        final int CURR_Y = redSquare.getY();
//        final int CURR_W = redSquare.getRadius();
//        final int CURR_H = redSquare.getRadius();
//        final int OFFSET = 1;
//
//        if ((CURR_X!=x) || (CURR_Y!=y)) {
//
//            // The square is moving, repaint background 
//            // over the old square location. 
//            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);
//
//            // Update coordinates.
//            redSquare.setX(x);
//            redSquare.setY(y);
//
//            // Repaint the square at the new location.
//            repaint(redSquare.getX(), redSquare.getY(), 
//                    redSquare.getRadius()+OFFSET, 
//                    redSquare.getRadius()+OFFSET);
//        }
//    }

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
        	s.paintSquare(g);
        }

    }  
}

class ShipView {
	
    private Ship ship;
    private boolean selected;
    
    float RADIUS = 10.0f;

    public ShipView(Ship s) {
    	ship = s;
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

    public void paintSquare(Graphics g){
    	Graphics2D ga = (Graphics2D)g;
    	Shape circle = new Ellipse2D.Float(ship.pos.x, ship.pos.y, RADIUS, RADIUS);
    	
        if (selected) {
        	ga.setColor(Color.GREEN);
            ga.fill(circle);
        	ga.setColor(Color.ORANGE);
        	ga.draw(circle);
        } else {
        	ga.setColor(getColor(ship.side));
            ga.fill(circle);
        	ga.setColor(Color.BLACK);
        	ga.draw(circle);
        }
   
        // ship name
        Font font = new Font("Serif", Font.BOLD, 9);
        ga.setFont(font);
        ga.drawString(""+ship.id, ship.pos.x+5, ship.pos.y+RADIUS+10); 
        
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
