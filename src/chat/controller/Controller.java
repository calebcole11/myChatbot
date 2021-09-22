package chat.controller;

import java.util.Scanner;
import chat.model.Chatbot;

public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot ("guy");
		
	}
	
	public void start()
	{
		System.out.println(myChatbot);
	}
}
