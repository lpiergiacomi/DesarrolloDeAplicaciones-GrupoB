package ar.edu.unq.desapp.grupob.model;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MessageTest {
    User sender;
    User receiver;
    PublicMessage publicMessage;
    String message;

    @Before
    public void setUp() {
        sender = mock(User.class);
        receiver = mock(User.class);
        message = "Hello";
        publicMessage = new PublicMessage(sender, receiver, message);
    }

    @Test
    public void itShouldGetItSender(){
        assertEquals(publicMessage.getSender(), sender);
    }

   /* @Test
    public void itShouldGetItReceiver(){
        assertEquals(publicMessage.getReceiver(), receiver);
    }*/

    @Test
    public void itShouldGetItContent(){
        assertEquals(publicMessage.getContent(), message);
    }

}
