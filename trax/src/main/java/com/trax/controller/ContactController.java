package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Contacts;
import com.trax.entities.Lead;
import com.trax.services.ContactService;
import com.trax.services.LeadService;


@Controller
public class ContactController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contacts")
	public String saveContact(@RequestParam("id")long id, ModelMap model) {
		
		//this is the method for converting lead to contacts & saving contact then delete lead
		//then return to list of contacts
		
			try {
				Lead lead=leadService.findLeadById(id);
				
				Contacts contact =new Contacts();
				
				contact.setFirstName(lead.getFirstName());
				contact.setLastName(lead.getLastName());
				contact.setLeadSource(lead.getLeadSource());
				contact.setEmail(lead.getEmail());
				contact.setMobile(lead.getMobile());
				
				contactService.saveContacts(contact);
				
				leadService.deleteLeadById(id);
				
				List<Contacts> contacts = contactService.getAllContacts();
				model.addAttribute("contacts", contacts);
			} catch (Exception e) {
				model.addAttribute("msg", "duplicate data available in contacts!!!");
				return"contact_search_result";
			}
		
		return"contact_search_result";
	}
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id") long id, ModelMap model) {
		Contacts contact=contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
	@RequestMapping("/listAllContacts")//this will create table of contacts
	public String listAllContacts(ModelMap model) {
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return"contact_search_result";
	}
	
}
