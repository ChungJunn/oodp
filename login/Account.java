package login;

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