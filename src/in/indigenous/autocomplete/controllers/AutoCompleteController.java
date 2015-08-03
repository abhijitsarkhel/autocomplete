package in.indigenous.autocomplete.controllers;

import in.indigenous.users.model.User;
import in.indigenous.users.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutoCompleteController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String showSearchPage(Model model) {
		return "search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(@RequestParam(required=false) String search, Model model) {
		model.addAttribute("searchResult", userService.getUsersByName(search));
		return "search";
	}

	@RequestMapping(value = "findUsersByPart", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<String> getUserNames(
			@RequestParam(required = false) String term) {
		List<String> names = new ArrayList<String>();
		for(User user: userService.getUsers()) {
			names.add(user.getName());
		}
		List<String> result = new ArrayList<String>();
		for (String name : names) {
			if (name.toLowerCase().contains(term.toLowerCase())) {
				result.add(name);
			}
		}
		return result;
	}

	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String showAddUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user, Model model) {
		userService.addUser(user);
		model.addAttribute("user", new User());
		return "addUser";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
