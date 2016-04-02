package ar.edu.unq.desapp.grupob.model;

import java.util.List;

public class PrivateTalk extends Talk{

    public PrivateTalk(User sender, User receiver){
        super(sender,receiver);
    }

    public List<String> getConversation(User user) throws Exception {
        if(!isUserInConversation(user)){
            throw new Exception("This talk is private ");
        }
        return conversation;
    }

}
