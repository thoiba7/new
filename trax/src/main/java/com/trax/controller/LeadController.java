package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entities.Lead;
import com.trax.services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/startLead")
	public String startLead() {
		return"new_lead";
	}
	
	@RequestMapping(value="/saveLead", method=RequestMethod.POST)
	public String savedDataLead (@ModelAttribute  Lead lead, ModelMap model){
		try {
			leadService.saveLead(lead);
			model.addAttribute("lead", lead);
			return "lead_info";
		} catch (Exception e) {
			//model.addAttribute("EmailError", "duplicate entry not allowed!!!");
			return "error"; //ERROR JSP PAGE
		}
		
	}
	
	@RequestMapping("/listAll")//this will create table of leads
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return"lead_search_result";
	}
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadService.findLeadById(id);
		if (lead!=null) {
			model.addAttribute("lead", lead);
			return "lead_info";
		} else {
			model.addAttribute("error", "this id is not present in database");
			return "error_page";
		}//optional class is used here and its useful if id is null
	}
	@RequestMapping("/delete")//extra delete feature
	public String delete(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteById(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return"lead_search_result";
	}
	

}
