package chat.controller;

import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;

public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	private Popup view;
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot ("guy");
		this.view = new Popup();
		
	}
	
	public void start()
	{
	//	System.out.println(myChatbot);
		view.displayMessage(myChatbot.toString());
//		System.out.println("What do you want to talk about?");
//		
//		String userText = input.nextLine();
		String userText = view.askQuestion("what do you want to talk about?");
		while (!userText.equals("quit"))
		{
			String response = interactWithChatbot(userText);
			
//			System.out.println(response);
			
			view.displayMessage(response);
			
//			System.out.println("Keep talking?");
//			userText = input.nextLine();
			
			userText = view.askQuestion("Keep talking");
		}
	}
	
	public String interactWithChatbot(String text)
	{
		String response = " ";
		response += myChatbot.processText(text);
		
		return response;
	}
}
