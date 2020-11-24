package ir.sk.telephonenote.contact.repository;

import ir.sk.telephonenote.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sad.kayvanfar on 11/18/2020.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByGithub(String github);
}
