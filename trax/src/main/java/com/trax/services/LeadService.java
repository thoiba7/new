package com.trax.services;

import java.util.List;

import com.trax.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public Lead findLeadById(long id);
	public void deleteLeadById(long id);
	public List<Lead> getAllLeads();
	public void deleteById(long id);
}
