package ar.edu.unq.desapp.grupob.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Talk {
    protected final User receiver;
    protected final User sender;
    protected List<String> conversation = new ArrayList<String>();

    public Talk(User sender, User receiver){
        this.sender = sender;
        this.receiver = receiver;
    }

    public void addMessage(String message) {
        conversation.add(message);
    }

    public abstract List<String> getConversation(User user) throws Exception;

    public boolean isUserInConversation(User user) {
        return sender.equals(user) || receiver.equals(user);
    }
}
