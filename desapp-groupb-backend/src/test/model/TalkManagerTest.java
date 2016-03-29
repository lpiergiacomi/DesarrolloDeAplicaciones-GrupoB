package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TalkManagerTest {
    TalkManager talkManager;
    boolean isPrivate;

    @Before
    public void setUp() {
        talkManager = new TalkManager(mock(User.class));
        isPrivate = false;
    }

    @Test
    public void itShouldSendFirstMessageForAnotherUser() {
        User anotherUser = mock(User.class);
        String message = "Hello World";
        talkManager.sendMessageTo(anotherUser, message, isPrivate);
        assertEquals(talkManager.getTalks().size(), 1);
    }

    @Test
    public void itShouldSendMessageForUserWithConversationStarted() {
        User anotherUser = mock(User.class);
        talkManager.sendMessageTo(anotherUser, "Hello World", isPrivate);
        talkManager.sendMessageTo(anotherUser, "Bye World", isPrivate);
        assertEquals(talkManager.getTalks().size(), 1);
    }

    @Test
    public void itShouldSendTwoMessageUsers() {
        User anotherUser = mock(User.class);
        User otherUser = mock(User.class);
        talkManager.sendMessageTo(anotherUser, "Hello World", isPrivate);
        talkManager.sendMessageTo(otherUser, "Bye World", isPrivate);
        assertEquals(talkManager.getTalks().size(), 2);
    }
}
