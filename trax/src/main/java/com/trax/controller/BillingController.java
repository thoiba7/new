package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Billing;
import com.trax.entities.Contacts;
import com.trax.services.BillingService;
import com.trax.services.ContactService;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;
//i used contactService here to send the contact object to new billing .jsp	
//so that i can auto populate some fields of billing jsp

	@Autowired
	private BillingService billingService;

	@RequestMapping("/createBill")
	public String createBill(@RequestParam("id") long id, ModelMap model) {
		Contacts contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "create_bill";
	}

	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill") Billing bill) {
		billingService.saveBill(bill);
		return "create_bill";
	}

	@RequestMapping("/listAllBills")
	public String listAllBills(ModelMap model) {
		List<Billing> bills = billingService.getAllBills();
		model.addAttribute("bills", bills);
		return "billing_search_result";
	}
}
