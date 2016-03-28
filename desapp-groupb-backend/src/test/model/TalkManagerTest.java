package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TalkManagerTest {
    TalkManager talkManager;

    @Before
    public void setUp() {
        talkManager = new TalkManager(mock(User.class));
    }

    @Test
    public void itShouldSendFirstMessageForAnotherUser() {
        User anotherUser = mock(User.class);
        String message = "Hello World";
        talkManager.sendMessageTo(anotherUser, message);
        assertEquals(talkManager.getTalks().size(), 1);
    }

    @Test
    public void itShouldSendMessageForAnotherUserWithConversationStarted() {
        User anotherUser = mock(User.class);
        talkManager.sendMessageTo(anotherUser, "Hello World");
        talkManager.sendMessageTo(anotherUser, "Bye World");
        assertEquals(talkManager.getTalks().size(), 1);
    }

    @Test
    public void itShouldSSendTwoMessageUsers() {
        User anotherUser = mock(User.class);
        User otherUser = mock(User.class);
        talkManager.sendMessageTo(anotherUser, "Hello World");
        talkManager.sendMessageTo(otherUser, "Bye World");
        assertEquals(talkManager.getTalks().size(), 2);
    }
}
