package br.com.contact;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> get(){return this.contactService.getAllContact();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Contact request){this.contactService.createContact(request);}

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteContact(@RequestParam Long id){this.contactService.removeContact(id);}

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Contact getContactByName(@RequestParam String name){return this.contactService.getByName(name);}


    /*@PutMapping("/contact/{id}")
    public ResponseEntity<Contact>updateContact(@PathVariable(value = "id") Long id, @Validate @RequestBody Contact conta)
    */

    /*@PutMapping("/contact/{id}")
    public void ResponseEntity<Contact> saveContact(@RequestBody Contact contact, @PathVariable("id") Long id){
        ContactRepository.save(id);
        return (ResponseEntity<Contact>) ResponseEntity.ok("resource saved");
    }
    */
}

