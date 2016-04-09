package ar.edu.unq.desapp.grupob.model;

public class PrivateMessage extends Message {

    public PrivateMessage(User sender, User receiver, String content){
        super(sender, receiver, content);
    }

}
