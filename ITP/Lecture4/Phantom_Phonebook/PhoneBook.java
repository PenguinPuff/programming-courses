package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    // TODO 2.1: Add list of contacts and constructor
    private List<Contact> contacts;
    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    // TODO 2.2: Add getter and setter
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    //TODO 2.3: Implement the findContactNumber(String name) method
    public String findContactNumber(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact.getPhoneNumber();
            }
        }
        return null;
    }

    //TODO 2.4: Implement the addNewContact(String name, String phoneNumber, boolean isSealDeputy) method
    public void addNewContact(String name, String phoneNumber, boolean isSealDeputy) {
        contacts.add(new Contact(name, phoneNumber, isSealDeputy));
    }

    //TODO 2.5 Implement the removeContact(String name) method
    public Contact removeContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                return contact;
            }
        }
        return null;
    }

    //TODO 2.6 Implement updateContactNumber(String name, String newNumber) method
    public Contact updateContactNumber(String name, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhoneNumber(newNumber);
                return contact;
            }
        }
        return null;
    }

    //TODO 2.7 Implement the findSealDeputies() method
    public List<Contact> findSealDeputies() {
        List<Contact> sealDeputies = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getIsSealDeputy()) {
                sealDeputies.add(contact);
            }
        }
        return sealDeputies;
    }

}
