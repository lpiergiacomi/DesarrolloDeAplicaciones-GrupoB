package model;

import java.util.List;

public class PublicTalk extends Talk{

    public PublicTalk(User userTransmitter, User userReceiver){
        super(userTransmitter,userReceiver);
    }

    public List<String> getConversation(User user) {
        return conversation;
    }

}
