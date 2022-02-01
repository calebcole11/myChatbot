package chat.view;

import chat.controller.Controller;
import javax.swing.JFrame;

public class chatFrame extends JFrame
{
private Controller app;
	
	private ChatPanel panel;
	
	public chatFrame(Controller app)
	{
		
		super();
		this.app = app;
		this.panel = new ChatPanel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		
	}
		
}
