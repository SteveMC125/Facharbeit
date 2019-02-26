import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainGui extends JFrame {

	private Boolean choosen = false, split = false, saved = false, runned = false;
	private JButton btnChoosing;
	private JButton btnSplit;
	private JButton btnSaveSplits;
	private JButton btnRunNN;
	private JLabel lblConsole;
	private JTextArea Console;
	private JButton btnClose;
	private JPanel Image;
	private JScrollPane scroll;

	public MainGui() {
		// title / close operation
		setTitle("Facharbeit Tensorflow");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// layout / size
		setLayout(null);
		setSize(600, 542);
		setResizable(false);

		// init
		initComponents();

		// add components
		add(btnChoosing);
		add(btnSplit);
		add(btnSaveSplits);
		add(btnRunNN);
		add(lblConsole);
		add(scroll);
		add(btnClose);
		add(Image);

		// position / visibility
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		btnChoosing = new JButton("ChooseImage");
		btnChoosing.setBounds(366, 10, 208, 100);
		btnChoosing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChoosing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.choose();
				choosen = true;
			}
		});

		btnSplit = new JButton("Split Image");
		btnSplit.setBounds(366, 121, 208, 100);
		btnSplit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSplit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!choosen) {
					Main.choose();
					choosen = true;
				}
				Main.split();
				split = true;
			}
		});

		btnSaveSplits = new JButton("Save Splits");
		btnSaveSplits.setBounds(366, 232, 208, 100);
		btnSaveSplits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSaveSplits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!split) {
					if (!choosen) {
						Main.choose();
						choosen = true;
					}
					Main.split();
					split = true;
				}
				Main.saveSplits();
				saved = true;
			}
		});

		btnRunNN = new JButton("Run NN");
		btnRunNN.setBounds(366, 343, 208, 100);
		btnRunNN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRunNN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!saved) {
					if (!split) {
						if (!choosen) {
							Main.choose();
							choosen = true;
						}
						Main.split();
						split = true;
					}
					Main.saveSplits();
					saved = true;
				}
				Main.runNN();
				runned = true;
			}
		});

		btnClose = new JButton("Close");
		btnClose.setBounds(10, 454, 564, 39);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.closeApplication();
			}
		});

		lblConsole = new JLabel("Console:");
		lblConsole.setBounds(10, 116, 350, 32);
		lblConsole.setFont(new Font("Tahoma", Font.BOLD, 14));

		Console = new JTextArea();
		Console.setLineWrap(true);
		Console.setWrapStyleWord(true);
		Console.setEditable(false);

		scroll = new JScrollPane(Console, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(10, 161, 350, 282);

		Image = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(ImageLoader.resize(Main.img, Image.getWidth(), Image.getHeight()), 0, 0, null);
			}
		};
		Image.setBounds(10, 10, 350, 100);

	}

	public void log(String str) {
		Console.append(str + "\n");
	}

	public void changeSection() {
		log("-----------------------------------------------------------------------------------");
	}

	public Boolean getChoosen() {
		return choosen;
	}

	public Boolean getSplit() {
		return split;
	}

	public Boolean getSaved() {
		return saved;
	}

	public JButton getBtnChoosing() {
		return btnChoosing;
	}

	public JButton getBtnSplit() {
		return btnSplit;
	}

	public JButton getBtnSaveSplits() {
		return btnSaveSplits;
	}

	public JButton getBtnRunNN() {
		return btnRunNN;
	}

	public JLabel getLblConsole() {
		return lblConsole;
	}

	public JTextArea getConsole() {
		return Console;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JPanel getImage() {
		return Image;
	}

	public Boolean getRunned() {
		return runned;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
}