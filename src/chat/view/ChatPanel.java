package chat.view;

import java.awt.GridLayout;
import javax.swing.*;
import chat.controller.Controller;
import java.awt.Color;
import java.awt.Dimension;

public class ChatPanel extends JPanel
{
	private JPanel chatButtonPanel;
	private JPanel ioPanel;
	
	private JScrollPane chatPane;
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
			this.chatPane = new JScrollPane();
			this.chatField = new JTextField(50);
			
			this.chatButton = new JButton("Chat");
			this.dateButton = new JButton("Date");
			this.timeButton = new JButton ("Time");
			this.questionButton = new JButton("Question");
			this.randomChatButton = new JButton ("Random");
			
			this.saveButton = new JButton("Save");
			this.loadButton = new JButton("Load");
			
			setupChatPane();
			setupPanel();
			setupListeners();
			setupLayout();
		}
		
		private void setupChatPane()
		{
			chatArea.setLineWrap(true);
			chatArea.setWrapStyleWord(true);
			chatArea.setEnabled(false);
			chatPane.setViewportView(chatArea);
			chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		}
		
		private void setupPanel()
		{
			
			this.setPreferredSize(new Dimension(800, 600));
			this.setBackground(Color.MAGENTA);
			
			this.setLayout(layout);
			this.add(chatButtonPanel);
			this.add(ioPanel);
			this.add(chatButton);
			this.add(chatPane);
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
			chatButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText())));
			dateButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 1)));
			timeButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 2)));
			questionButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 0)));
			randomChatButton.addActionListener(click -> chatArea.append(app.interactWithChatbot(chatField.getText(), 3)));


			
		}
		private void setupLayout()
		{
			layout.putConstraint(SpringLayout.NORTH, ioPanel, 10, SpringLayout.SOUTH, chatButtonPanel);
			layout.putConstraint(SpringLayout.SOUTH, chatPane, -175, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.WEST, ioPanel, 0, SpringLayout.WEST, chatPane);
			layout.putConstraint(SpringLayout.EAST, ioPanel, 0, SpringLayout.EAST, chatPane);
			layout.putConstraint(SpringLayout.WEST, chatButtonPanel, 0, SpringLayout.WEST, chatPane);
			layout.putConstraint(SpringLayout.EAST, chatButtonPanel, 0, SpringLayout.EAST, chatPane);
			layout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.EAST, chatPane, -10, SpringLayout.EAST, this);
			
			layout.putConstraint(SpringLayout.NORTH, chatField, 10, SpringLayout.SOUTH, chatPane);
			layout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
			layout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
			layout.putConstraint(SpringLayout.NORTH, chatButtonPanel, 10, SpringLayout.SOUTH, chatButton);
			layout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, chatField);
			layout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatField);
			layout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatField);
			
		}
}
