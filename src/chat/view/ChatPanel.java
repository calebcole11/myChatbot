package chat.view;

import java.awt.GridLayout;
import javax.swing.*;
import chat.controller.Controller;
import java.awt.Color;

public class ChatPanel
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
	
	
	
	private Controller app;
	
		public ChatPanel(Controller app)
		{
			super();
			this.app = app;
		
			setupPanel();
			setupListeners();
			setupLayout();
		}
		private void setupPanel()
		{
			
		}
		private void setupListeners()
		{
		
		}
		private void setupLayout()
		{
			
		}
}
