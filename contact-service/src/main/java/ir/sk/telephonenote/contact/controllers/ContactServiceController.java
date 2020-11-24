package ir.sk.telephonenote.contact.controllers;

import ir.sk.telephonenote.contact.model.Contact;
import ir.sk.telephonenote.contact.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sad.kayvanfar on 11/18/2020.
 */
@RestController
@RequestMapping(value = "v1/contacts/")
public class ContactServiceController {

    @Autowired
    private ContactService contactService;

    @PutMapping(value = "/")
    public void saveContacts(@RequestBody Contact contact) {
        contactService.saveContacts(contact);
    }

    @PostMapping(value = "/search/")
    public List<Contact> search(@RequestBody Contact contact) {
        return contactService.findAll(contact);
    }
}
