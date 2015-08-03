package in.indigenous.users.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.indigenous.users.model.User;
import in.indigenous.users.service.UserService;

public class UserServiceImpl implements UserService {

	private List<User> _users;

	public UserServiceImpl() {
		_users = new ArrayList<User>();
	}

	@Override
	public List<User> getUsers() {
		List<User> users = Collections.unmodifiableList(_users);
		return users;
	}

	@Override
	public void addUser(User user) {
		_users.add(user);
	}

	@Override
	public List<User> getUsersByName(String name) {
		List<User> result = new ArrayList<User>();
		for(User user: _users) {
			if(name.equals(user.getName())) {
				result.add(user);
			}
		}
		return result;
	}

}
