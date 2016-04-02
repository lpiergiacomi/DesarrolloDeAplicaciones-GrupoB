package ar.edu.unq.desapp.grupob.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TalkTest {
    User sender;
    User receiver;
    PublicTalk publicTalk;
    PrivateTalk privateTalk;

    @Before
    public void setUp() {
        sender = mock(User.class);
        receiver = mock(User.class);
        publicTalk = new PublicTalk(sender, receiver);
        privateTalk = new PrivateTalk(sender, receiver);
    }

    @Test
    public void itShouldAssertANewTalkHasNoMessages(){
        assertEquals(publicTalk.getConversation(receiver).size(), 0);
    }

    @Test
    public void itShouldAddANewMessageToATalk(){
        publicTalk.addMessage("My First Message");
        assertEquals(publicTalk.getConversation(receiver).size(), 1);
    }

    @Test
    public void itShouldRetrievePublicTalksMessagesForAnyUser(){
        User anotherUser = mock(User.class);
        publicTalk.addMessage("My First Message");
        assertEquals(publicTalk.getConversation(anotherUser).size(), 1);
    }

    @Test
    public void itShouldRetrievePrivateTalksMessagesOnlyForUsersInvolved()throws Exception{
        privateTalk.addMessage("My First Message");
        assertEquals(privateTalk.getConversation(receiver).size(), 1);
    }

    @Test(expected=Exception.class)
    public void itShouldNotRetrievePrivateTalksMessagesForUsersNotInvolve()throws Exception{
        User anotherUser = mock(User.class);
        privateTalk.addMessage("My First Message");
        privateTalk.getConversation(anotherUser);
    }
}
