package chat.model;

public class Chatbot
{
	private String name;
	
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	public String processText(String text)
	{
		String response = "You said: ";
		
		response += text + "\n";
		
	
		return response;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a Chatbot, my name is: " + name + "\n";
		description += "My favorite topic is: coming soon";
		
		return description;
	}

}
