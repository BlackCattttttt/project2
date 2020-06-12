package Database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Save extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textField;
	JButton button;
	
	private long ticks;

	public void init (long ticks) {
		this.ticks = ticks;
		// ------------ create JFrame ------------ //
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));
 
        // ------------ add content ------------ //
 
        int size = 15;
        JLabel name = new JLabel("Your Name");
        name.setHorizontalAlignment(JLabel.CENTER);
        add(name);
        textField = new JTextField(size);
        add(textField);
 
        button = new JButton("Save");
        button.addActionListener(this);
        add(button);
 
        // ------------ display ------------
        pack();
        setLocation(850,500);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String s = textField.getText();
		if (command == "Save") {
			if (s.length()>6) {
				JOptionPane.showMessageDialog(null, "Enter up to 6 characters","Inane error",JOptionPane.ERROR_MESSAGE);
			} else {
				Vector<Object> value = new Vector<>();
				value.add(s);
				value.add(ticks);
				DataQuery data = new DataQuery();
				data.insert("highscore", value);
				JOptionPane.showMessageDialog(null, "Saved successfully","Successfully",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	}

}
