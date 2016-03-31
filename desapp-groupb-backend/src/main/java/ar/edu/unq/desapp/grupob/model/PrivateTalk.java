package ar.edu.unq.desapp.grupob.model;

import java.util.List;

public class PrivateTalk extends Talk{

    public PrivateTalk(User userTransmitter, User userReceiver){
        super(userTransmitter,userReceiver);
    }

    public List<String> getConversation(User user) throws Exception {
        if(!isUserInConversation(user)){
            throw new Exception("This talk is private ");
        }
        return conversation;
    }

}
