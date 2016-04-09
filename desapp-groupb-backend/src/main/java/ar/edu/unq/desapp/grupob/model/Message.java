package ar.edu.unq.desapp.grupob.model;

public abstract class Message {
    protected final User receiver;
    protected final User sender;
    protected String content;

    public Message(User sender, User receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }
}
