package com.demo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.AppUtils.core.XString;
import com.AppUtils.gui.ApplicationScreen;
import com.messages.Message;
import net.miginfocom.swing.MigLayout;

public class DemoApp extends ApplicationScreen {


	private XString codeToParse = new XString();
	private String[] actionsArray = new String[]{"Show an info message in the current content pane",
			"Show an info message","Show an info message with custom title","Show a message with custom title in your current window"};
	private DefaultComboBoxModel<String> actions = new DefaultComboBoxModel<>(actionsArray);
	private JComboBox<String> actionCombo = new JComboBox<>(actions);
	private JTextArea producedCode = new JTextArea(5,34);
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
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
		panel.setLayout(new MigLayout("", "[][][]", "[][][]"));
		panel.add(actionCombo,"cell 0 0");
		actionCombo.addActionListener(e->{
			int index = actionCombo.getSelectedIndex();
			switch(index){
				case 0:
					codeToParse.setText("Message.info(getContentPane(),\"This message sticks to the current window\"");
				case 1:
					codeToParse.setText("Message.info(\"This is a simple info dialog with no custom title\");");	
				break;	
				case 2:
					codeToParse.setText("Message.info(\"Message with custom title\",\"Custom title\");");
				break;
				case 3:
					codeToParse.setText("Message.info(getContentPane()\", \"This is a message that sticks to your window\", \"Custom title here\");");
				break;
			}
			producedCode.setText(codeToParse.toString());
		});
		panel.add(execBtn, "cell 1 0,wrap");
		execBtn.addActionListener(e->{
			int index  = actionCombo.getSelectedIndex();
			switch(index){
				case 0:
					Message.info(getContentPane(),"This message sticks to the current window");
					break;
				case 1:
					Message.info("Message with default title");
				break;
				case 2:
					Message.info("Message with custom title", "Custom title");
				break;
				case 3:
					Message.info(getContentPane(), "This is a message that sticks to your window", "Custom title here");
					
					
			}
		});
		panel.add(scrollPane,"flowx,cell 0 2");
		scrollPane.setViewportView(producedCode);
		setContentPane(panel);
		pack();
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
			new DemoApp("Message Demo App",600,300,false).setVisible(true);
		});
	}

}
