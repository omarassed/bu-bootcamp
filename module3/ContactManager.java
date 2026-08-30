import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: Add at least five contacts
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 555 867 5309"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 212 555 1234"));
        contacts.put("Margaret Hamilton", new Contact("Margaret Hamilton", "+1 415 555 9876"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 305 555 4321"));

        // Step 5: Look up a contact (Success Case)
        System.out.println("=== Lookup Test (Found) ===");
        Contact foundContact = contacts.get("Ada Lovelace");
        if (foundContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(foundContact);
        }

        // Step 5: Look up a contact (Not Found Case)
        System.out.println("\n=== Lookup Test (Not Found) ===");
        Contact missingContact = contacts.get("John Doe");
        if (missingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missingContact);
        }

        // Step 6: Print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("\n=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}