package chat.view;

import java.awt.GridLayout;
import javax.swing.*;
import chat.controller.Controller;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private SpringLayout layout;
	
	private JTextArea chatArea;
	private JTextField chatField;
	
	private JButton chatButton;
	private JButton dateButton;
	private JButton timeButton;
	private JButton questionButton;
	private JButton randomChatButton;
	
	private JButton saveButton;
	private JButton loadButton;
	
	
	private Controller app;
	
		public ChatPanel(Controller app)
		{
			super();
			this.app = app;
			
			this.chatButtonPanel = new JPanel(new GridLayout(1,0)); 
			this.ioPanel = new JPanel(new GridLayout(1,0));
			
			this.layout = new SpringLayout();
			
			this.chatArea = new JTextArea(20,40);
			this.chatField = new JTextField(50);
			
			this.chatButton = new JButton("Chat");
			this.dateButton = new JButton("Date");
			this.timeButton = new JButton ("Time");
			this.questionButton = new JButton("Question");
			this.randomChatButton = new JButton ("Random");
			
			this.saveButton = new JButton("Save");
			this.loadButton = new JButton("Load");
		
			setupPanel();
			setupListeners();
			setupLayout();
		}
		private void setupPanel()
		{
			this.setLayout(layout);
			this.add(chatButtonPanel);
			this.add(ioPanel);
			this.add(chatButton);
			this.add(chatArea);
			this.add(chatField);
			ioPanel.add(saveButton);
			ioPanel.add(loadButton);
			
			chatButtonPanel.add(dateButton);
			chatButtonPanel.add(timeButton);
			chatButtonPanel.add(questionButton);
			chatButtonPanel.add(randomChatButton);
			
		}
		private void setupListeners()
		{
		
		}
		private void setupLayout()
		{
			
		}
}
