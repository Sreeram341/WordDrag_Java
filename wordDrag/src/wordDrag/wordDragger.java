/********************************************************************************************
 * 
 * File Name : Word Dragger.java
 * 
 * Authors : Sreeram Pulavarthi, Sudheer Tindivanam
 * 
 * Group #: 12
 * 
 * Date: 09-22-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates the Main Frame , reads the data from file, 
 * 						Add the JMenu Bar and constructs the BoxWord class. 
 * 
 *********************************************************************************************
 */

package wordDrag;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class wordDragger extends JFrame {

	
	
	public static File InputFile = new File("C:/Users/Sreeram/eclipse-workspace/wordDrag/src/wordDrag/Inputfile.txt");

	public static ArrayList<String> fileData = new ArrayList<String>();

	public static ArrayList<BoxWord> BoxWrd = new ArrayList<BoxWord>();
	
	String NewWord;

	JMenu addLbl;

	// BoxWord BX = new BoxWord();

	public Random rand = new Random();

	public ArrayList<Integer> randArrayY = new ArrayList<Integer>();

	public ArrayList<Integer> randArrayX = new ArrayList<Integer>();

	public String file_read;

	public static ArrayList<String> read_from_file() {

		/*
		
		Reads data from the Input File using scanner class
		
		*/
		
		try {

			Scanner scanner = new Scanner(InputFile);

			try {
				while (scanner.hasNext()) {

					fileData.add(scanner.next());
				}
			}

			catch (Exception e) {

				System.out.println("Error: " + e.getMessage());
			} finally {
				scanner.close();

			}
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
			System.exit(1);
		}

		return fileData;
	}

	
	public void menuBar() {
		
		/*
		
		Creates a new Menu Bar and New Menu Item and add to the current frame
		
		*/

		JMenuBar mnubar =new JMenuBar();
		
		setJMenuBar(mnubar);
		
		JMenu add_item = new JMenu("Add Here");

		JMenuItem add_lbl = new JMenuItem("Add Label");

		add_lbl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				NewWord = JOptionPane.showInputDialog("Enter new Word: ");
				
				add_data(NewWord);
				
			}
		});

		add_item.add(add_lbl);

		mnubar.add(add_item);

		mnubar.setEnabled(true);

		mnubar.setVisible(true);
		
		this.getContentPane().add(mnubar);
		
		
	}

	public wordDragger() {
		// TODO Auto-generated constructor stub
		
		/*
		
		Constructs the word dragger class, It will create the frame for the current Proram,
		
		  Creates list of constructor objects of class Boxword with Action listener attached to each JLabel 
		
		*/

		//ArrayList<JLabel> jlblArrRtn = new ArrayList<JLabel>();

		this.getContentPane().setLayout(null);

		this.getContentPane().setBackground(Color.white);

		this.setTitle("Word Wrap");

		read_from_file();

		menuBar();
		
		this.setSize(800, 800);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
		
		int pickx, picky;

		for (int i = 0; i < fileData.size(); i++) {

			pickx = rand.nextInt(600);

			picky = rand.nextInt(600);

			BoxWord BX = new BoxWord(fileData.get(i), pickx, picky, 40);

			BoxWrd.add(BX);
		}

		for (int i = 0; i < fileData.size(); i++) {

			// System.out.println(BoxWrd.get(i).getName());

			this.getContentPane().add(BoxWrd.get(i));

		}

	}

	public void add_data(String nw) {

		/*
		
		Creates a new look for the frame each time a new label is added 
		
		*/
			
			//System.out.println(nw);
		
			int pickx = rand.nextInt(600);

			int picky = rand.nextInt(600);
			
			BoxWord BX = new BoxWord(nw, pickx, picky, 40);

			this.BoxWrd.add(BX);
			
			this.getContentPane().add(this.BoxWrd.get(this.BoxWrd.size()-1));
			
			this.getContentPane().repaint();
			
			this.getContentPane().revalidate();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new wordDragger();

			}
		});
	}

}
