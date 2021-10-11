package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The model for our Chatbot project, used to explore string methods and text processing. Not a smart chatbot.
 * @author calebcole
 *
 */
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
	
	/**
	 * Processes the supply text and provides a response for external method calls.
	 * @param text The text sent from the user via the Controller.
	 * @return The chatbot's answer to continue the discussion.
	 */
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
	
		if (isPolitical(text))
		{
			
		}
		if (isPolite(text))
		{
			
		}
		
		if (containsQuestion(text))
		{
			response += answerQuestion(text);
		}
		
		response += getRandomTopic();
	
		return response;
	}

/**
 * Greetings which are said when first introducing the chatbot, or as a response.
 * @return Returns a greeting.
 */
	public String sayGreeting()
	{
		String greeting = "";
		
		ArrayList<String> greetings = new ArrayList<String>();
		
		greetings.add("Hi there!");
		greetings.add("Aloha");
		greetings.add("Greetings");
		greetings.add("Hello!");
		greetings.add("Good day!");
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		if (greetingCount == greetings.size())
		{
			greetingCount = 0;
		}
		return greeting;
	}	
	/**
	 * This gets a name.
	 * @return returns "My name is" and then the name.
	 */
	public String getName()

	{
		return "My name is " + this.name;
	}
	
	/**
	 * A list of farewells which are used at the end of the conversations.
	 * @return Returns one of the farewells.
	 */
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
	/**
	 * Determines what is polite and if it is false or not.
	 * @param polite Specifies which words are considered polite.
	 * @return returns whether the phrase is polite or not.
	 */
	private boolean isPolite(String polite)
	{
		boolean isPolite = false;
		
		if (polite.toLowerCase().indexOf("please") >= 0)
		{
			isPolite = true;
		}
		if (polite.toLowerCase().indexOf("thank you") >= 0)
		{
			isPolite = true;
		}
		if (polite.toLowerCase().indexOf("thanks") >= 0)
		{
			isPolite = true;
		}
		return isPolite;
	}
	
	/**
	 * Determines if a phrase or word is a political phrase or word.
	 * @param politics Determines words or phrases related to politics.
	 * @return the conditions for political phrases or words.
	 */
	private boolean isPolitical(String politics)

	{
		boolean isPolitical = false;
		
		if (politics.toLowerCase().indexOf("biden")>= 0)
		{
			isPolitical = true;
		}
		if (politics.toLowerCase().indexOf("election")>= 0)
		{
			isPolitical = true;
		}
		if (politics.toLowerCase().indexOf("politics")>= 0)
		{
			isPolitical = true;
		}
		if (politics.toLowerCase().indexOf("republican")>= 0)
		{
			isPolitical = true;
		}
		if (politics.toLowerCase().indexOf("democrat")>= 0)
		{
			isPolitical = true;
		}
		
		return isPolitical;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a Chatbot, my name is: " + name + "\n";
		description += "My favorite top ic: coming soon";
	
		return description; 
	}
	
	private String getDate()
	{
		String date = "The date is ";
		
		LocalDateTime currentDate = LocalDateTime.now();
		
		String day = currentDate.getDayOfWeek().toString();
		
		date += day + ", the ";
		
		day = currentDate.getDayOfMonth() + "";
		
		date += day;
		
		String month = " of " + currentDate.getMonth().toString();
		
		date += month;
		
		date += ", " + currentDate.getYear() + "\n";
		
		return date;
	}
	
	private String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time+= currentTime.getHour() + ":";
		time += currentTime.getMinute() + "\n";
		
		return time;
	}
	
	private String getRandomTopic()
	{
		String topic = "";
		
		ArrayList<String> randomTopics = new ArrayList<String>();
		
		randomTopics.add("Do you like pineapple?");
		randomTopics.add("How much hot sauce do you like");
		randomTopics.add("Do you like chicken wings?");
		randomTopics.add("How many gallons of gas does your car have?");
		randomTopics.add("I like socccer.");
		randomTopics.add("How often do you brush your teeth?");
		randomTopics.add("I think flossing is good for you.");
		randomTopics.add("I don't like the dentist.");
		randomTopics.add("Do you like to have converstations with me?");
		randomTopics.add("How often do you use the bathroom?");
		
		int randomIndex = (int) (Math.random() * randomTopics.size());
		
		topic = randomTopics.get(randomIndex);
		
		
		return topic;
	}

	public boolean containsQuestion(String question)
	{
		boolean hasQuestion = false;
		
		if(question.toLowerCase().indexOf("can you") >= 0)
		{
			hasQuestion = true;
		}
		
		if (question.toLowerCase().indexOf("will you") >= 0)
		{
			hasQuestion = true;
		}
		if (question.toLowerCase().indexOf("?") >= 0)
		{
			hasQuestion = true;
		}
		return hasQuestion;
	}
	
	public String answerQuestion(String words)
	{
		String answer = "";
		
		int meSpot = words.toLowerCase().indexOf("me");
		int youSpot = words.toLowerCase().indexOf("you");
		
		if (meSpot == -1 && youSpot == -1)
		{
			answer += "You said: " + words;
		}
		else if (meSpot >= 0)
		{
			String response = words.substring(0, meSpot);
			response += "you";
			response += words.substring(meSpot + 2);
			answer += response;
		}
		else
		{
			String response = words.substring(0, youSpot);
			response += "me";
			response += words.substring(youSpot + 3);
			answer += response;
		}
		
		answer += "I think " + getRandomTopic();
		
		return answer;
	}
}
