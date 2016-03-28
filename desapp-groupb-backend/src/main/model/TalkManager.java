package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TalkManager {
    private  User owner;
    private List<Talk> talks = new ArrayList<Talk>();

    public TalkManager(User owner){
        this.owner = owner;
    }

    public void sendMessageTo(User user, String message) {
        Talk talk;
        if(!hasConversationForUser(user)) {
            talk = createNewTalk(user);
        }else {
            talk = getMyConversationFor(user).get(0);
        }
        talk.addMessage(message);
    }

    private List<Talk> getMyConversationFor(User user) {
        return talks.stream().filter(t -> t.isUserInConversation(user))
                .collect(Collectors.toList());
    }

    private Talk createNewTalk(User user) {
        Talk talk = new PublicTalk(owner, user);
        user.addTalk(talk);
        addTalk(talk);
        return talk;
    }

    public void addTalk(Talk talk) {
        talks.add(talk);
    }

    private boolean hasConversationForUser(User user) {
        List<Talk> conversation = getMyConversationFor(user);
        return !conversation.isEmpty();
    }

    public List<Talk> getTalks() {
        return talks;
    }
}
