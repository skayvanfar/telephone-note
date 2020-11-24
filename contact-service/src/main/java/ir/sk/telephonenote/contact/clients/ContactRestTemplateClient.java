package ir.sk.telephonenote.contact.clients;

import ir.sk.telephonenote.contact.model.Contact;
import ir.sk.telephonenote.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 11/19/2020.
 */
@Component
public class ContactRestTemplateClient {

  // @Autowired
   // RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    public Mono<Collection<GithubRepo>> getRepositories(Long contactId, String GitHubUserName) {
        System.out.println("Starting NON-BLOCKING Controller!");

        Mono<Collection<GithubRepo>> repositoryNames = webClient.get()
                .uri("users/{userName}/repos", GitHubUserName)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Collection<GithubRepo>>() {});

        return repositoryNames;
    }
}

