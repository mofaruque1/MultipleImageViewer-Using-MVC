package eecs2030MultypleImageViewer;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewerView extends JFrame {

	private JLabel img;
	private JButton next;
	private JButton prev;
	private JFileChooser fc;
	private File[] files;

	/**
	 * String for the action command for opening files.
	 */
	public static final String OPEN = "OPEN";
	/**
	 * String for the action command for clearing all of the images.
	 */
	public static final String CLEAR = "CLEAR";
	/**
	 * String for the action command for showing the previous image.
	 */
	public static final String PREVIOUS = "PREVIOUS";
	/**
	 * String for the action command for showing the next image.
	 */
	public static final String NEXT = "NEXT";

	public ViewerView(ActionListener listener) {
		super("Image Viewer");
		// 2. Choose what happens when the frame closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. Create components and put them in the frame
		this.makeLabel();
		//this.makeFileChooser();
		this.makeMenu(listener);
		this.makeButtons(listener);
		this.add(this.prev);
		this.add(this.next);
		this.add(this.img);
		// 4. Size the frame
		this.setMinimumSize(new Dimension(600, 400));
		this.pack();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		// 5. Show the view
		// we'll let ViewerApp do this
	}

	private void makeLabel() {
		this.img = new JLabel("");
		this.getContentPane().add(this.img);
	}

	public void makeFileChooser() {
		this.fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		int result = fc.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			files = fc.getSelectedFiles();
		}

	}
	
	public File[] getFilesToOpen() {
		return files;
		
	}

	private void makeMenu(ActionListener listener) {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem openMenuItem = new JMenuItem("Open...");
		openMenuItem.setActionCommand(ViewerView.OPEN);
		openMenuItem.addActionListener(listener);
		fileMenu.add(openMenuItem);
		JMenuItem clear = new JMenuItem("Clear");
		clear.setActionCommand(ViewerView.CLEAR);
		clear.addActionListener(listener);
		fileMenu.add(clear);
		this.setJMenuBar(menuBar);
	}

	private void makeButtons(ActionListener listener) {
		this.prev = new JButton("Previous");
		this.prev.setActionCommand(ViewerView.PREVIOUS);
		this.prev.addActionListener(listener);
		this.next = new JButton("Next");
		this.next.setActionCommand(ViewerView.NEXT);
		this.next.addActionListener(listener);
	}

	public void setImage(ImageIcon icon) {
		if (this.img.getIcon() != icon) {
			this.img.setIcon(icon);
			this.pack();
		}
	}

}
