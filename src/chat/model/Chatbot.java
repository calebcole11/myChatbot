package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Chatbot
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount=4;
	}
	
	public String processText(String text)
	{
		String response = sayGreeting() + "\nYou said: ";
		
		response += text + "\n";
		
		if (text.toLowerCase().indexOf("date") >= 0 )
		{
			response += getDate();
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			response += getTime();
		}
	
		
		response += sayFarewell();
	
		return response;
	}
	public String sayGreeting()
	{
		String greeting = "";
		
		ArrayList<String> greetings = new ArrayList<String>();
		
		greetings.add("Hi there!");
		greetings.add("Aloha");
		greetings.add("Greetings");
		greetings.add("");
		greetings.add("");
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		if (greetingCount == greetings.size())
		{
			greetingCount = 0;
		}
		return greeting;
	}	
	
	public String sayFarewell()
	{
		String farewell = "";
		
		ArrayList<String> farewells = new ArrayList<String>();
		
		farewells.add(farewells.size(), "Goodbye");
		farewells.add("sayonara");
		farewells.add("Catch you later");
		farewells.add("Bye!");
		farewells.add("See you later!");
		
		farewell = farewells.get(farewellCount);
		farewellCount--;
		if (farewellCount < 0)
		{
			farewellCount = farewells.size() -1;
		}
		
		return farewell;
	}
	
	public boolean isPolite(String content)
	{
		boolean isValid = false;
		
		return isValid;
	}
	
	public boolean isPolitical(String words)
	{
		boolean isValid = false;
		
		return isValid;
	}
	
	public String toString()
	{
		
	}
	
	public String getDate()
	{
		
	}
	
	public String getTime()
	{
		
	}

}
