package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("6023617094");

    public static void main(String[] args) {
        boolean flag = false;
        int choice = 0;
        printInstructions();
        while (!flag) {
            System.out.println("Enter your choice");
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Quitting.....");
                    flag = true;
                    System.exit(-1);
                    break;
                case 2:
                    phone.printContacts();
                    break;
                case 3:
                    Contacts contact = addContact();
                    phone.addContact(contact);
                    break;
                case 4:
                    modifyContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
            }
        }


    }


    public static Contacts addContact() {
        System.out.println("Please enter contact name");
        String name = scan.nextLine();
        scan.nextLine();
        System.out.println("Please enter phone number");
        String number = scan.nextLine();
        Contacts contact = Contacts.createContact(name,number);
        if(phone.addContact(contact)){
            System.out.println(name + number);
        } else
            System.out.println("no");

        return contact;
    }

    public static void modifyContact() {
        System.out.println("Please enter existing contact name");
        String existingName = scan.nextLine();
        scan.nextLine();
        System.out.println("Please enter existing contact number");
        String number = scan.nextLine();

        Contacts oldContact = Contacts.createContact(existingName,number);
        Contacts newContact = addContact();
        phone.modifyContact(oldContact,newContact);

    }
    public static void removeContact() {
        Contacts contact = addContact();
        phone.removeContact(contact);
    }

    public static void searchContact() {
        Contacts contact = addContact();
        phone.searchContact(contact);
    }

    public static void printInstructions() {
        System.out.println("\nPress\n" +
                "1 - to quit\n" +
                "2 - to print contacts\n" +
                "3 - to add contact\n" +
                "4 - to modify contact\n" +
                "5 - to remove contact\n" +
                "6 - to search contact");

    }
}


