package com.demo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.AppUtils.gui.ApplicationScreen;
import com.messages.Message;

public class DemoApp extends ApplicationScreen {


	String[] actionsArray = new String[]{"Show an info message"};
	private DefaultComboBoxModel<String> actions = new DefaultComboBoxModel<>(actionsArray);
	private JPanel panel = new JPanel();
	private JButton execBtn = new JButton("Execute");
	public DemoApp(String title, int width, int height, boolean resizable) {
		super(title, width, height, resizable);
		initUIElements();
	}

	@Override
	public JButton[] getButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel[] getLabels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationScreen restart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initUIElements() {
		// TODO Auto-generated method stub
		setLocationRelativeTo(null);
		panel.add(execBtn);
		setContentPane(panel);
		execBtn.addActionListener(e->{
			Message.info("This is a simple info dialog with no custom title");
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(()->{
			new DemoApp("Message Demo App",400,400,false).show();
		});
	}

}
