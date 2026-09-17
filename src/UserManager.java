package codevault;
import java.util.ArrayList;
//we make the class called usermanager
public class UserManager {
	private final ArrayList<User> users;
	public UserManager() {
		users = FileManager.loadUsers();
	}
	public boolean register(String name, String username, String password) {
		if (findByUsername(username) != null) {
			return false;
		}
		users.add(new User(username, password, name));
		FileManager.saveUsers(users);
		return true;
	}
//getUsers method banaya to get the list of users
	public User login(String username, String password) {
		User user = findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
//findByUsername method banaya to find the user by username
	public User findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		return null;
	}
	public boolean changePassword(User user, String currentPassword, String newPassword) {
		if (!user.getPassword().equals(currentPassword)) {
			return false;
		}
		user.setPassword(newPassword);
		FileManager.saveUsers(users);
		return true;
	}
}
