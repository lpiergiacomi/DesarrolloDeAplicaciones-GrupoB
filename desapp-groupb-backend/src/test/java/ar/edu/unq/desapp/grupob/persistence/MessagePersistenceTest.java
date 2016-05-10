package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Message;
import ar.edu.unq.desapp.grupob.model.PublicMessage;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.MessagesRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-persistence-context.xml" })
public class MessagePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private UserRepository userRepository;

    private PublicMessage publicMessage;
    private User sender;

    @Before
    public void setUp() {
        sender = new User();
        userRepository.save(sender);
        publicMessage = new PublicMessage(sender, sender, "a Message");
        messagesRepository.save(publicMessage);
    }

    @Test
    public void itShouldSaveAMessage() {
        List<Message> messages = messagesRepository.getAll();

        assertEquals(messages.size(), 1);
    }

    @Test
    public void itShouldUpdateAMessage() {
        assertEquals(publicMessage.getContent(), "a Message");

        publicMessage.setContent("Messages");
        messagesRepository.update(publicMessage);

        assertEquals(messagesRepository.find(publicMessage.getId()).getContent(), "Messages");
    }

    @Test
    public void itShouldDeleteAMessage() {
        messagesRepository.delete(publicMessage.getId());

        assertEquals(messagesRepository.getAll().size(), 0);
    }

}
