package edu.gmu.rcasstev.week12.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An example of a graphical user interface (GUI) in Java.
 * 
 * @author randy
 *
 */
public class Week12Quiz extends JPanel {

	private JButton leftButton;
	private JButton rightButton;

	public Week12Quiz() {
		add(getLeftButton());
		add(getRightButton());
	}

	public JButton getLeftButton() {
		if (leftButton == null) {
			leftButton = new JButton("Left");
			System.err.println("Left Message One");

			leftButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.err.println("Left Message Two");
				}
			});
		}

		return leftButton;
	}

	public JButton getRightButton() {
		if (rightButton == null) {
			rightButton = new JButton(new RightButtonAction());
			System.err.println("Right Message One");
		}

		return rightButton;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Week 12 Quiz");
		JPanel panel = new Week12Quiz();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public class RightButtonAction extends AbstractAction {
		public RightButtonAction() {
			super("Right");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("Right Message Two");
		}
	}
}
