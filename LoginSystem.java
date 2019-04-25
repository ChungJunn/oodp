import java.util.ArrayList;
import java.util.Scanner;

class LoginSystem {
	ArrayList<Account> myList = new ArrayList<Account>();

	int run() {
		Scanner input = new Scanner(System.in);
		char menu;
		String id;
		String passwd;
		int loggedIn;

		while(true){
			System.out.print("### MENU ###\n"+
			"1)login: l\n"+
			"2)createAccount: c\n\n"+
			"type in a character: ");

			menu = input.next().charAt(0);
			input.nextLine(); //advance scanner to the next line

			System.out.printf("input char: %c\n\n", menu);

			for(Account temp : myList) {
				System.out.printf("%s %s\n", temp.id, temp.passwd);
			}

			switch (menu) {
				case 'c':
					System.out.println("### create new account ###");
					System.out.print("id : ");
					id = input.nextLine();
					System.out.print("passwd : ");
					passwd = input.nextLine();
					createAccount(id, passwd);
					break;

				case 'l':
					System.out.println("### log in ###");
					System.out.print("id : ");
					id = input.nextLine();
					System.out.print("passwd : ");
					passwd = input.nextLine();
					loggedIn = login(id, passwd);

					if(loggedIn == 1) return 1;
					break;
			}
	}
}

	int login(String id, String passwd) {
		//TODO
		for (Account temp : myList) {
			if ( temp.equals(new Account(id, passwd))) {
				System.out.println("logged in");
				return 1;
			}
			else {
				System.out.println("not logged in");
				System.out.printf("input: %s %s\n", id, passwd);
				return 0;
			}
		}
		return 0;
	}

	int createAccount(String id, String passwd) {
		//TODO
		myList.add(new Account(id, passwd));
		return 0;
	}
}

class Account {
	String id;
	String passwd;

	Account(String newId, String newPasswd){
		id = newId;
		passwd = newPasswd;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Account)) {
			return false;
		}

		Account a = (Account) o;

		return id.equals(a.id) && passwd.equals(a.passwd);
	}
}
