package org.m2acsi.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 * Classe entite de l'utilisateur
 * 
 * 
 * @author Gauthier Robert & Loic Mathias
 */

@Entity
public class Utilisateur {

    /**
     * identifiant de l'utilisateur auto-incremente
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * login de l'utilsiateur
     */
    @Column(nullable = false, insertable = false)
    @Size(min = 5, max = 20, message = "Login non conforme !")
    private String login;

    /**
     * mot de passe de l'utilisateur
     */
    @Column(nullable = false)
    @Size(min = 5, max = 20, message = "Mot de passe non conforme !")
    private String motDePasse;

    /**
     * role de l'utilisateur
     * ! ! voir si garder cascade ! !
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;
    
    /**
     * nom de l'utilisateur
     */
    @Size(min = 1, max = 20, message = "Nom vide !")
    private String nom;

    /**
     * prenom de l'utilisateur
     */
    @Size(min = 1, max = 20, message = "Prenom vide !")
    private String prenom;

    /**
     * email de l'utilisateur
     * ! ! expression reguliere du format du mail
     */
    @Size(min = 6, max = 50, message = "Email non conforme !")
    private String email;
    
    /**
     * date de creation du compte de l'utilisateur
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    public Utilisateur() {
    }

    public Utilisateur(String login, String motDePasse, String nom, String prenom, String email) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateCreation = new Date(System.currentTimeMillis());         
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    
}
