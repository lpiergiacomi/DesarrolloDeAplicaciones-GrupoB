package model;

import model.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Talk {
    protected final User userReceiver;
    protected final User userTransmitter;
    protected List<String> conversation = new ArrayList<String>();

    public Talk(User userTransmitter, User userReceiver){
        this.userTransmitter = userTransmitter;
        this.userReceiver = userReceiver;
    }

    public void addMessage(String message) {
        conversation.add(message);
    }

    public abstract List<String> getConversation(User user) throws Exception;

    public boolean isUserInConversation(User user) {
        return userTransmitter.equals(user) || userReceiver.equals(user);
    }
}
