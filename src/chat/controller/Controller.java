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
		view.displayMessage(myChatbot.sayGreeting());

		String userText = view.askQuestion("what do you want to talk about?");
		while (!userText.equals("quit"))
		{
			String response = interactWithChatbot(userText);
			

			
			view.displayMessage(response);
			

			
			userText = view.askQuestion("Keep talking");
		}
		view.displayMessage(myChatbot.sayFarewell());
		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
	}
	
	public String interactWithChatbot(String text)
	{
		String response = " ";
		response += myChatbot.processText(text);
		
		return response;
	}
}
