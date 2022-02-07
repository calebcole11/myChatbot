package chat.controller;

import java.util.Scanner;
import chat.model.Chatbot;
import chat.view.Popup;
import java.util.ArrayList;

import java.io.*;
import chat.view.ChatFrame;



public class Controller
{
	private Scanner input;
	private Chatbot myChatbot;
	private Popup view;
	private ChatFrame frame;
	
	public Controller()
	{
		this.input = new Scanner(System.in);
		this.myChatbot = new Chatbot ("guy");
		this.view = new Popup();
		this.frame = new ChatFrame(this);
		
	}
	
	public void start()
	{
//		ArrayList<String> input = loadTextToList("user input.txt");
//		myChatbot.setUserInput(input);
//		input = loadTextToList("chat.txt");
//		myChatbot.setChatbotResponses(input);
//		
//		
//		view.displayMessage(myChatbot.sayGreeting());
//
//		String userText = view.askQuestion("what do you want to talk about?");
//		while (!userText.equals("quit"))
//		{
//			String response = interactWithChatbot(userText);
//			
//			view.displayMessage(response);
//			
//			userText = view.askQuestion("Keep talking");
//		}
//		view.displayMessage(myChatbot.sayFarewell());
//		view.displayMessage(myChatbot.getMostCommonWord(myChatbot.getUserInputs()));
//		
//		view.displayMessage("lets save some text");
//		saveListAsText(myChatbot.getUserInputs(),"user input.txt");
//		saveListAsText(myChatbot.getChatbotResponses(),"chat output.txt");
	}
	
	
	public String interactWithChatbot(String text, int buttonNumber)
	{
		String response = "";
		
		if (buttonNumber == 4) //Save Button
		{
			saveListAsText(myChatbot.getUserInputs(), "user input.txt");
			saveListAsText(myChatbot.getChatbotResponses(), "chat output.txt");
			response += "Text Saved\n";
		}
		else if (buttonNumber == 5)
		{
			ArrayList<String> userInput = loadTextToList("user input.txt");
			ArrayList<String> chatResponses = loadTextToList("chat output.txt");
			myChatbot.setUserInput(userInput);
			myChatbot.setChatbotResponses(chatResponses);
			
			for(int index = 0; index < userInput.size() && index < chatResponses.size(); index++)
			{
				response += "User: " + userInput.get(index) + "\n";
				response += "Chatbot " + chatResponses.get(index) + "\n";
			}
			
		}
		else
		{
			response += myChatbot.processText(text,buttonNumber);
		}
		
		response += myChatbot.processText(text, buttonNumber);
		return response;
	}
	
	public String interactWithChatbot(String text)
	{
		String response = " ";
		response += myChatbot.processText(text);
		
		return response;
	}
	
	public void handleError(Exception error)
	{
		String details = "Your error is: " + error.getMessage();
		view.displayMessage(details);
	}
	
	private void saveListAsText(ArrayList<String> responses, String filename)
	{
		File saveFile = new File(filename);
		
		try (PrintWriter saveText = new PrintWriter(saveFile))
		{
			for ( String content : responses)
			{
				saveText.println(content);
			}
		}
	
		catch (IOException errorFromIO)
		{
			handleError(errorFromIO);
		}
		catch (Exception genericError)
		{
		handleError(genericError);
		}
	}
	
	private ArrayList<String>  loadTextToList(String filename)
	{
		ArrayList<String> fileContents = new ArrayList<String>();
		File source = new File(filename);
		try (Scanner fileScanner = new Scanner(source))
		{
			while (fileScanner.hasNextLine())
			{
				fileContents.add(fileScanner.nextLine());
			}
		}
		catch (IOException fileError)
		{
			handleError(fileError);
		}
		catch (Exception error)
		{
			handleError(error);
		}
		return fileContents;
	}
}
