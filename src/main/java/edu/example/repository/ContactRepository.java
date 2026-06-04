package edu.example.repository;

import edu.example.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepository {
    private final List<Contact> contactList = new ArrayList<>();
    private int idCounter = 1;

    public List<Contact> findAll() {
        return new ArrayList<>(contactList);
    }
    public Optional<Contact> findById(int id) {
        return contactList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst();
    }
    public  Contact save(Contact contact) {
        if (contact.getId() <= 0) {
            contact.setId(idCounter++);
            contactList.add(contact);
        } else {

        }
        return contact;
    }
    public void deleteById(int id){
        contactList.removeIf(contact-> contact.getId() == id );
    }
}
