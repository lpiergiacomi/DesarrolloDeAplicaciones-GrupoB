package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TalkTest {
    User userTransmitter;
    User userReceiver;
    PublicTalk publicTalk;
    PrivateTalk privateTalk;

    @Before
    public void setUp() {
        userTransmitter = mock(User.class);
        userReceiver = mock(User.class);
        publicTalk = new PublicTalk(userTransmitter, userReceiver);
        privateTalk = new PrivateTalk(userTransmitter, userReceiver);
    }

    @Test
    public void itShouldCreateTalkWithEmptyMessage(){
        assertEquals(publicTalk.getConversation(userReceiver).size(), 0);
    }

    @Test
    public void itShouldAssertPublicTalkAddMessage(){
        publicTalk.addMessage("My First Message");
        assertEquals(publicTalk.getConversation(userReceiver).size(), 1);
    }

    @Test
    public void itShouldAssertPublicTalkGetConversationForAllUser(){
        User anotherUser = mock(User.class);
        publicTalk.addMessage("My First Message");
        assertEquals(publicTalk.getConversation(anotherUser).size(), 1);
    }

    @Test
    public void itShouldAssertPrivateTalkGetConversationOnlyForUsersWhoAreInsideIt()throws Exception{
        privateTalk.addMessage("My First Message");
        assertEquals(privateTalk.getConversation(userReceiver).size(), 1);
    }

    @Test(expected=Exception.class)
    public void itShouldAssertExceptionPrivateTalkGetConversationOnlyForUsersWhoAreInsideIt()throws Exception{
        User anotherUser = mock(User.class);
        privateTalk.addMessage("My First Message");
        privateTalk.getConversation(anotherUser);
    }
}
