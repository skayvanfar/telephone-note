package ir.sk.telephonenote.contact.clients;

import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 11/20/2020.
 */
public class ContactToRepoDTO {
    private Long contactId;
    private Mono<Collection<GithubRepo>> repositoryNames;

    public ContactToRepoDTO(Long contactId, Mono<Collection<GithubRepo>> repositoryNames) {
        this.contactId = contactId;
        this.repositoryNames = repositoryNames;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Mono<Collection<GithubRepo>> getRepositoryNames() {
        return repositoryNames;
    }

    public void setRepositoryNames(Mono<Collection<GithubRepo>> repositoryNames) {
        this.repositoryNames = repositoryNames;
    }
}
