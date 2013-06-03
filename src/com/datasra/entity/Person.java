package com.datasra.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy= InheritanceType.JOINED)
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cedule;    
    private String name;
    private String password;    
    private String mail;     
    private String address;    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth;     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date death;
    @ManyToMany(cascade= CascadeType.ALL, mappedBy="persons")
    private Collection<Company> companies = new ArrayList<Company>();

    public long getCedule() {
        return cedule;
    }

    public void setCedule(long cedule) {
        this.cedule = cedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public Collection<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Collection<Company> companies) {
        this.companies = companies;
    }    
}
