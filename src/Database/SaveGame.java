package Database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.Game;

public class SaveGame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JTextField textField;
	JButton button;
	
	private Player player;
	private Game game;
	private ArrayList<Game> games;
	
	private DataQuery data;
	private int type;
	
	public static final int NEW = 0;
	public static final int LOAD = 1;

	public void save (Player p,int type,Game g) {
		this.player = p;
		this.type = type;
		this.game = g;
		// ------------ create JFrame ------------ //
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));
 
        // ------------ add content ------------ //
 
        int size = 15;
        JLabel name = new JLabel("Name");
        name.setHorizontalAlignment(JLabel.CENTER);
        add(name);
        if (type == NEW) {
        	textField = new JTextField(size);
            add(textField);
        } else {
        	textField = new JTextField(size);
        	textField.setText(g.getName());
        	textField.setEnabled(false);
            add(textField);
        }
        button = new JButton("Save");
        button.addActionListener(this);
        add(button);
 
        // ------------ display ------------
        pack();
        setLocation(850,500);
        setVisible(true);
        games = new ArrayList<Game>();
		data = new DataQuery();
    	String [] cols = {"name", "hp","mn","exp","level","atk/def","crit/arp","hat"
    			,"armor","scepter","shoe","item","mission","time","map","row/col"};
    	ResultSet resultSet = data.view("savegame", cols);
    	try {
    	    while(resultSet.next()){
    	    	Game game = new Game(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
    	    			resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),
    	    			resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),
    	    			resultSet.getString(12),resultSet.getInt(13),resultSet.getInt(14),resultSet.getInt(15),resultSet.getString(16));
    	    	games.add(game);
    	    }     
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String s = textField.getText();
		if (command == "Save") {
			if (s.length()==0) {
				JOptionPane.showMessageDialog(null, "You have not entered the game name","Inane error",JOptionPane.ERROR_MESSAGE);
			} else if (s.length()>6) {
				JOptionPane.showMessageDialog(null, "Enter up to 6 characters","Inane error",JOptionPane.ERROR_MESSAGE);
			} else {
				if (type == NEW) {
					boolean check = true;
					for (int i=0;i<games.size();i++) {
						if (s.equals(games.get(i).getName())) {
							JOptionPane.showMessageDialog(null, "This name already exists","Inane error",JOptionPane.ERROR_MESSAGE);
							check = false;
							break;
						}
					}
					if (check) {
						if (games.size()>=8) {
							Vector<Object> value = new Vector<>();
							value.add(games.get(0).getName());
							String[] col = new String[1];
							col[0] = "name";
							DataQuery data = new DataQuery();
							data.delete("savegame", col, value);
						}
						game = new Game(s,player);
						Vector<Object> value = new Vector<>();
						value.add(s);
						value.add(game.getHp());
						value.add(game.getMn());
						value.add(game.getExp());
						value.add(game.getLevel());
						value.add(game.getAtkdef());
						value.add(game.getCritarp());
						value.add(game.getHat());
						value.add(game.getArmor());
						value.add(game.getScepter());
						value.add(game.getShoe());
						value.add(game.getItem());
						value.add(game.getMission());
						value.add(game.getTime());
						value.add(game.getMap());
						value.add(game.getRowcol());
						DataQuery data = new DataQuery();
						data.insert("savegame", value);
						JOptionPane.showMessageDialog(null, "Saved successfully","Successfully",JOptionPane.PLAIN_MESSAGE);
				}		
				} else {
					Vector<Object> value = new Vector<>();
					value.add(game.getName());
					String[] col = new String[1];
					col[0] = "name";
					DataQuery data = new DataQuery();
					data.delete("savegame", col, value);
					value.clear();
					game = new Game(s,player);
					value.add(s);
					value.add(game.getHp());
					value.add(game.getMn());
					value.add(game.getExp());
					value.add(game.getLevel());
					value.add(game.getAtkdef());
					value.add(game.getCritarp());
					value.add(game.getHat());
					value.add(game.getArmor());
					value.add(game.getScepter());
					value.add(game.getShoe());
					value.add(game.getItem());
					value.add(game.getMission());
					value.add(game.getTime());
					value.add(game.getMap());
					value.add(game.getRowcol());
					data.insert("savegame", value);
					JOptionPane.showMessageDialog(null, "Saved successfully","Successfully",JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		
	}
}
