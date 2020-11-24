package ir.sk.telephonenote.contact.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/18/2020.
 */
@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;
    @Column(name = "organization")
    private String organization;
    @Column(name = "github")
    private String github;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="repository",
            joinColumns=@JoinColumn(name="ID")
    )
    @Column(name="repository_name")
    private List<String> repositories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public List<String> getRepositories() {
        if (repositories == null)
            return new ArrayList<>();
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }
}
