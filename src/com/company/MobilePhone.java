package com.company;

import java.util.ArrayList;

/**
 * Created by carlopelosi on 7/15/17.
 */
public class MobilePhone {

    ArrayList<Contacts> arrayContacts = new ArrayList<Contacts>();
    String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        arrayContacts = new ArrayList<>();
    }

    public boolean addContact(Contacts contact) {
        if(findContact(contact) >= 0){
            System.out.println("already exist");
            return false;
        }
        arrayContacts.add(contact);
        return true;

    }

    public void removeContact(Contacts contact) {
        int position = findContact(contact);
        if(position >= 0){
            arrayContacts.remove(position);
        System.out.println("Contact was deleted");}
            else {
            System.out.println("Doesn't exist");
        }
    }

    public boolean modifyContact(Contacts existingContact, Contacts newContact) {
        int position = findContact(existingContact);
        if (position >= 0) {
            arrayContacts.add(position, newContact);
            System.out.println("Contact was replaced");
            return true;
        }
            else{
                System.out.println("Contact not found");
                return false;
            }
        }


    private int findContact(Contacts contact) {
    return arrayContacts.indexOf(contact);
    }

    private int findContact (String contactName) {
        for(int i=0; i<this.arrayContacts.size(); i++){
            Contacts contact = this.arrayContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String searchContact(Contacts contact) {
        int position = findContact(contact);
        if(position >= 0) {
            return contact.getName();
        }
        return null;
    }

    public void printContacts () {
        for(int i= 0; i <arrayContacts.size(); i++){
            System.out.println(arrayContacts.get(i).toString());
        }
    }
}
