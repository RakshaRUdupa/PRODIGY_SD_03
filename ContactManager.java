import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    public String name;
    public String phoneNumber;
    public String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

public class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(newContact);
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void editContact() {
        System.out.print("Enter the name of the contact you want to edit: ");
        String searchName = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Enter new information for the contact:");

                System.out.print("Enter new name: ");
                contact.name = scanner.nextLine();

                System.out.print("Enter new phone number: ");
                contact.phoneNumber = scanner.nextLine();

                System.out.print("Enter new email address: ");
                contact.emailAddress = scanner.nextLine();

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public void deleteContact() {
        System.out.print("Enter the name of the contact you want to delete: ");
        String searchName = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        int choice;

        do {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = contactManager.scanner.nextInt();
            contactManager.scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    contactManager.editContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (choice != 5);
    }
}
