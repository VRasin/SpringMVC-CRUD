package spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.Phone;
import spring.service.PhoneService;

@Controller
public class PhoneController {

	private PhoneService phoneService;
	
	@Autowired
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService=phoneService;
	}
	
	
	//List of all phones
	@RequestMapping("/phones")
	public String showPhones(Model model) {
		List<Phone> phones = phoneService.getPhones();
		model.addAttribute("phones",phones);
		return "phones";
	}
	
	// Add new Phone
	@RequestMapping("/newPhone")
	public String insertPhone() {
		return "insertphone";
	}
	
	
	@RequestMapping(value = "/savePhone", method = RequestMethod.POST)
    public ModelAndView savePhone(@ModelAttribute Phone phone) {
           phoneService.createPhone(phone);
        return new ModelAndView("redirect:/phones");
    }
	
	
	// Edit phone
	 @RequestMapping(value = "/editPhone", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Phone phone = phoneService.getPhone(id);
	        ModelAndView model = new ModelAndView("editphone");
	        model.addObject("phone", phone);
	        return model;
	    }
	 
	 @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	    public ModelAndView saveEditedPhone(@ModelAttribute Phone phone) {
	        phoneService.editPhone(phone);
	        return new ModelAndView("redirect:/phones");
	    }
	 
	// Delete phone
	@RequestMapping(value = "/delete")
	public String deletePhone(@RequestParam int id) {
		phoneService.deletePhone(id);
		return "redirect:/phones";
	}
}
