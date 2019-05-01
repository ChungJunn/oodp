import login.*;
import draw.*;

public class MainSystem{
	
	public static void main(String[] args) {
		LoginSystem loginSystem = new LoginSystem();
		TaskSystem taskSystem = new TaskSystem();
		
		// Drawing tool (new)
		DrawSystem drawSystem = new DrawSystem();
		
		System.out.println("[main system] This is main system");

		loginSystem.run();
		System.out.println("[main system] login was successful");		
		
		//taskSystem.run();

		//drawing tool (new)
		drawSystem.run();
		System.out.println("[main system] opening drawing pad was successful");
	}
	
	
}
