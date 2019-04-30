public class MainSystem {
	public static void main(String[] args) {
		LoginSystem loginSystem = new LoginSystem();
    TaskSystem taskSystem = new TaskSystem();
		System.out.println("[main system] This is main system");

    loginSystem.run();
    System.out.println("[main system] login was successful");

    taskSystem.run();

  }
}
