package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;

@Entity
public class PublicMessage extends Message {

    public PublicMessage(User sender, User receiver, String content){
        super(sender, receiver, content);
    }

    public PublicMessage(){ }

    public boolean isPrivate(){
        return false;
    }
}
