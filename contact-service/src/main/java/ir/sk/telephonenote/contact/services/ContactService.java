package ir.sk.telephonenote.contact.services;

import ir.sk.telephonenote.contact.clients.ContactRestTemplateClient;
import ir.sk.telephonenote.contact.clients.GithubRepo;
import ir.sk.telephonenote.contact.model.Contact;
import ir.sk.telephonenote.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sad.kayvanfar on 11/18/2020.
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    ContactRestTemplateClient contactRestTemplateClient;

    public void saveContacts(Contact contact) {

        contactRepository.save(contact);
        //tesrt
        contactRepository.findAll().forEach(contact1 -> {
            System.out.println(contact1.getId());
            System.out.println(contact1.getPhoneNumber());
            System.out.println(contact1.getEmail());
            System.out.println(contact1.getGithub());
        });

        Mono<Collection<GithubRepo>> mono = contactRestTemplateClient.getRepositories(contact.getId(), contact.getGithub());
        mono.subscribe(githubRepo -> {
            String gitHubUserName = ((GithubRepo) ((ArrayList) githubRepo).get(0)).getFullName().split("/")[0];
            Contact contact1 = contactRepository.findByGithub(gitHubUserName);

            contact1.setRepositories(githubRepo.stream().map(githubRepo1 -> githubRepo1.getName()).collect(Collectors.toList()));
            contactRepository.save(contact1);
        });
    }

    public List<Contact> findAll(Contact contact) {
        ExampleMatcher contactMatcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
        return contactRepository.findAll(Example.of(contact, contactMatcher));
    }

}
