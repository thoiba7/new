package com.trax.services;

import java.util.List;

import com.trax.entities.Contacts;

public interface ContactService {
	public void saveContacts(Contacts contact);
	public List<Contacts> getAllContacts();
	public Contacts findContactById(long id);

}
