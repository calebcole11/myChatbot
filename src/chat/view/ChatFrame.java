package chat.view;

import chat.controller.Controller;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private Controller app;
	
	private ChatPanel panel;
	
	public ChatFrame(Controller app)
	{
		
		super();
		this.app = app;
		this.panel = new ChatPanel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setVisible(true);
		this.setContentPane(panel);
		this.setTitle("make a cool window");
		this.setSize(800,600);
		this.setResizable(false);
	}
		
}
