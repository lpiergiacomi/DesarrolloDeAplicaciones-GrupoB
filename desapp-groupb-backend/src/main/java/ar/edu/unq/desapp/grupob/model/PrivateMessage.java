package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;

@Entity
public class PrivateMessage extends Message {

    public PrivateMessage(User sender, User receiver, String content){
        super(sender, receiver, content);
    }

    public PrivateMessage(){}

    public boolean isPrivate(){
        return true;
    }
}
