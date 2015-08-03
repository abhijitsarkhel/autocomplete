package in.indigenous.autocomplete.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutoCompleteController {

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String showSearchPage() {
		return "search";
	}

	@RequestMapping(value = "findUsersByPart", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<String> getUserNames(
			@RequestParam(required = false) String term) {
		List<String> names = new ArrayList<String>();
		names.add("Abhijit Sarkhel");
		names.add("Abhijit Sanyal");
		names.add("Abhishek Nayar");
		names.add("Amaresh Dhal");
		names.add("Pradeep Kandikatla");
		List<String> result = new ArrayList<String>();
		for (String name : names) {
			if (name.toLowerCase().contains(term.toLowerCase())) {
				result.add(name);
			}
		}
		return result;
	}
}
