package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.repository.ContactRepository;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepositoryImpl repository = null;
    private Set<Contact> contacts;

    private ContactRepositoryImpl() {
        this.contacts = new HashSet<>();
    }

    private Contact findContact(String contactId) {
        /*return this.contacts.stream()
                .filter(contact -> contact.getNo().trim().equals(contactId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static ContactRepositoryImpl getRepository(){
        if(repository == null) repository = new ContactRepositoryImpl();
        return repository;
    }

    public Contact create(Contact contact){
        this.contacts.add(contact);
        return contact;
    }

    public Contact read(final String contactId){
        //find the student in the set and return it if it exist
        Contact contact = findContact(contactId);
        return contact;
    }

    public Contact update(Contact contact) {
        // find the student, update it and return the updated student
        Contact toDelete = findContact(contact.getContactNo());
        if(toDelete != null) {
            this.contacts.remove(toDelete);
            return create(contact);
        }
        return null;
    }

    public void delete(String contactId) {
        //find the student and delete it if it exists
        Contact contact = findContact(contactId);
        if (contact != null) this.contacts.remove(contact);
    }

    public Set<Contact> getAll(){
        return this.contacts;
    }
}