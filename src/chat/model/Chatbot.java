package chat.model;

public class Chatbot
{
	private String name;
	
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a hatbot, my name is: " + name + "\n";
		description += "My favorite topic is: coming soon";
		
		return description;
	}

}
