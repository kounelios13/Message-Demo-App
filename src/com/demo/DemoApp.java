package com.demo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.AppUtils.core.XString;
import com.AppUtils.gui.ApplicationScreen;
import com.messages.Message;

public class DemoApp extends ApplicationScreen {


	private XString codeToParse = new XString();
	private String[] actionsArray = new String[]{"Show an info message","Show an info message with custom title"};
	private DefaultComboBoxModel<String> actions = new DefaultComboBoxModel<>(actionsArray);
	private JComboBox<String> actionCombo = new JComboBox<>(actions);
	private JTextArea producedCode = new JTextArea(30,30);
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
		panel.add(actionCombo);
		panel.add(execBtn);
		panel.add(producedCode);
		setContentPane(panel);
		actionCombo.addActionListener(e->{
			int index = actionCombo.getSelectedIndex();
			switch(index){
				case 0:
					codeToParse.setText("Message.info(\"This is a simple info dialog with no custom title\");");	
				break;	
				case 1:
					codeToParse.setText("Message.info(\"Message with custom title\",\"Custom title\");");
				break;
			}
			producedCode.setText(codeToParse.toString());
		});
		execBtn.addActionListener(e->{
			int index  = actionCombo.getSelectedIndex();
			switch(index){
				case 0:
					
			}
			if(actionCombo.getSelectedIndex()==0)
				Message.info("This is a simple info dialog with no custom title");
			else
				Message.info("Message with custom title", "Custom title");
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
			new DemoApp("Message Demo App",400,400,false).setVisible(true);
		});
	}

}
