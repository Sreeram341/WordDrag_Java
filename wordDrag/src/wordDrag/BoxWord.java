/********************************************************************************************
 * 
 * File Name : BoxWord.java
 * 
 * Authors : Sreeram Pulavarthi
 * 
 * Group #: 12
 * 
 * Date: 09-22-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates the JLabels , for each word received from file, 
 * 						
 * 						Also adds the Mouse Handler for each Label created	
 * 			
 * 						Handles all the Mouse handles for each Label 
 * 
 *********************************************************************************************
 */

package wordDrag;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class BoxWord extends JLabel implements MouseListener, MouseMotionListener {

	int XCordStrt, XCordRlsd, YCordRlsd, YCordStrt, NewXCord, NewYCord;

	public BoxWord(String name, int x, int y, int htt) {
		// TODO Auto-generated constructor stub
		
		/*
		
			Creates a new label when ever called from wordDragger class.
		
		*/
		
		this.setText(name);
		this.setName(name);
		this.setOpaque(true);
		this.setBackground(Color.blue);
		this.setForeground(Color.white);
		this.setFont(this.getFont().deriveFont(16.f));
		this.setBounds(x, y, (int) (this.getPreferredSize().getWidth()) + 2, htt);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		/*
		
			HANDLES THE DOUBLE CLICK EVENT FOR EVERY LABEL WHEN PRESSED 
		
		*/
		
		int GetClkCnt = e.getClickCount();
		
		if (GetClkCnt==2)
		{
			JLabel lbl = (JLabel) e.getSource();
			
			String CurrLbl = lbl.getText();
			
			JOptionPane.showConfirmDialog(this,"Do you want to delete?","Delete", JOptionPane.YES_NO_OPTION, GetClkCnt);
			
			this.setEnabled(false);
			
			this.setOpaque(false);
			
			this.setText("");
			
			wordDragger.BoxWrd.remove(this);
			
			wordDragger.fileData.remove(CurrLbl);
		
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JLabel lbl = (JLabel) e.getSource();
		
		lbl.setToolTipText("Press here to Drag");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JLabel lbl = (JLabel) e.getSource();
		
		lbl.setToolTipText("");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		XCordStrt = e.getX();
		YCordStrt = e.getY();
		
		JLabel lbl = (JLabel) e.getSource();
		
		lbl.setBackground(Color.red);
		
		//lbl.setFont(font.Italic);
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		//JLabel lbl = (JLabel) e.getSource();
		
		XCordRlsd = e.getX();
		YCordRlsd = e.getY();	
		
		JLabel lbl = (JLabel) e.getSource();
		
		lbl.setBackground(Color.blue);
		
		// lbl.setBounds(XCordRlsd, YCordRlsd, (int) (this.getPreferredSize().getWidth()) + 2, 40);
		// this.setLocation(XCordRlsd,YCordRlsd);

	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		/*
		
		DRAGS THE LABEL FROM STARTING POSITION TO THE END POSITION TILL MOUSE IS RELEASED 
		
		*/
		
		JLabel lbl = (JLabel) me.getSource();
		Point p = me.getPoint();
	
		 int  dragLabelWidthDiv2 = lbl.getWidth() / 2;
          int  dragLabelHeightDiv2 = lbl.getHeight() / 2;

           int x = me.getPoint().x - dragLabelWidthDiv2;
           int y = me.getPoint().y - dragLabelHeightDiv2;
           lbl.setLocation(x, y);
		/*
		

		NewXCord = me.getX();
		NewYCord = me.getY();
		
		lbl.setBounds(NewXCord, NewYCord, (int) (this.getPreferredSize().getWidth()) + 2, 40);
		*/
		lbl.repaint();
				
		lbl.revalidate();
	}
}
