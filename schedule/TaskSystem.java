package schedule;
import java.util.ArrayList;
import java.util.Scanner;

class TaskSystem {
	ArrayList<Task> myList = new ArrayList<Task>();

	int run() {
		Scanner input = new Scanner(System.in);
		char menu;
		String name;
		String memo;
		String dueDate;
		String user;

		while(true){
			System.out.print("### MENU ###\n"+
			"1)New Task: n\n"+
			"2)Show Tasks: s\n"+
			"3)quit: q\n\n"+
			"type in a character: ");

			menu = input.next().charAt(0);
			input.nextLine(); //advance scanner to the next line

			System.out.printf("input char: %c\n\n", menu);

			switch (menu) {
				case 'n':
					System.out.println("### create new task ###");
					System.out.print("name : ");
					name = input.nextLine();
					System.out.print("memo : ");
					memo = input.nextLine();
          System.out.print("dueDate : ");
					dueDate = input.nextLine();
          System.out.print("user : ");
					user = input.nextLine();
					createTask(name, memo, dueDate, user);
					break;

				case 's':
					System.out.println("### Show Tasks ###");
					showTasks();
					break;

        case 'q':
          return 1;
      }
    }
  }

	int showTasks() {
		//TODO
		for (Task temp : myList) {
			System.out.printf("%s\n%s\n%s\n%s\n", temp.name, temp.memo, temp.dueDate, temp.user);
		}
    return 0;
	}

	int createTask(String name, String memo, String dueDate, String user) {
		//TODO
		myList.add(new Task(name, memo, dueDate));
		return 1;
	}
}
class Task {
	String name;
	String memo;
	String dueDate;
	String user;

	Task(String newName, String newMemo, String newDueDate){
		name = newName;
		memo = newMemo;
		dueDate = newDueDate;
	}
}
