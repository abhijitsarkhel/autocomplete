package in.indigenous.users.service;

import java.util.List;

import in.indigenous.users.model.User;

public interface UserService {

	List<User> getUsers();

	void addUser(User user);

	List<User> getUsersByName(String name);
}
