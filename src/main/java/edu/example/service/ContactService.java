package edu.example.service;

import edu.example.dto.ApiResponse;
import edu.example.model.Contact;
import edu.example.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ApiResponse<List<Contact>> getAllContacts(){
        List<Contact> contactList = contactRepository.findAll();
        return  new ApiResponse<>(200,"All contact retreived", contactList);
    }

    public ApiResponse<Contact> addContact(Contact contact){
        Contact savedContact = contactRepository.save(contact);

        return  new ApiResponse<>(200,"Contact Saved",savedContact);
    }

    public ApiResponse<?> deleteContact(int id){
        if(contactRepository.findById(id).isPresent()){
            contactRepository.deleteById(id);
            return new ApiResponse<>(204,"Contact Deleted Successfully", null);
        }
        return new ApiResponse<>(404, "Contact Not Found", null);
    }
    public ApiResponse<Contact> updateContact(int id, Contact updatedData){
        return contactRepository.findById(id)
                .map(existingContact ->{
                    existingContact.setName(updatedData.getName());
                    existingContact.setPhoneNumber(updatedData.getPhoneNumber());
                    contactRepository.save(existingContact);
                    return new  ApiResponse<>(200, "Contact Update Successfully", existingContact);
                })
                .orElse(new ApiResponse<>(404, "Contact Not Found", null));
    }

}
