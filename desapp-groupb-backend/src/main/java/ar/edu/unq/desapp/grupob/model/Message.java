package ar.edu.unq.desapp.grupob.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Message {

    protected Integer id;
    protected User receiver;
    protected User sender;
    protected String content;

    public Message(User sender, User receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Message(){}

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }

    public abstract boolean isPrivate();

    public void setPrivate(boolean isPrivate){

    }
}
