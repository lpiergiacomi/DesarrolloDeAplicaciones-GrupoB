package ar.edu.unq.desapp.grupob.model;

import java.util.List;

public class PublicTalk extends Talk{

    public PublicTalk(User sender, User receiver){
        super(sender,receiver);
    }

    public List<String> getConversation(User user) {
        return conversation;
    }

}
