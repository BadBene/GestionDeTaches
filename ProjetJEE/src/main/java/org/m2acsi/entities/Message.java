package org.m2acsi.entities;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe entite de la timeline pour une tache
 *
 *
 * @author Gauthier Robert & Loic Mathias
 */
@Entity
public class Message {

    /**
     * identifiant de la tache auto-incremente
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * message d'un utilisateur pour une tache
     */
    @Column(nullable = false)
    private String message;

    /**
     * date d'emmission d'un message
     */
    @Column(nullable = false)
    private Date dateMessage;

    /**
     * utilisateur ayant creer le message
     */
    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Utilisateur utilisateur;

    public Message() {
    }

    public Message(String message, Utilisateur utilisateur) {
        this.message = message;
        this.utilisateur = utilisateur;
        this.dateMessage = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    
}
