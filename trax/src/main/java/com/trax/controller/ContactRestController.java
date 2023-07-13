package com.trax.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trax.entities.Billing;
import com.trax.entities.Contacts;
import com.trax.repositories.BillingRepository;
import com.trax.repositories.ContactRepository;

@RestController
public class ContactRestController {

	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private BillingRepository billing;

	@GetMapping("/showAll")
	public List<Contacts> showAll() {
		List<Contacts> leads = contactRepo.findAll();
		return leads;
	}
	@PostMapping("saveApi")
	public void saveLead(@RequestBody Billing bill) {
		Optional<Billing> findById = billing.findById(bill.getId());
		Billing bills = findById.get();
		bills.setFirstName(bill.getFirstName());
		bills.setLastName(bill.getLastName());
		bills.setEmail(bill.getEmail());
		bills.setMobile(bill.getMobile());
		bills.setProduct(bill.getProduct());
		bills.setAmount(bill.getAmount());
		billing.save(bills);
	}
	@GetMapping("/showAllBill")
	public List<Billing> showAllBill() {
		List<Billing> leads = billing.findAll();
		return leads;
	}
	@GetMapping("/getApi/{id}")
	public Contacts findOneLead(@PathVariable long id) {
		Optional<Contacts> findById = contactRepo.findById(id);

		try {
			Contacts contacts = findById.get();
			return contacts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
