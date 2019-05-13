package schedule;

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
