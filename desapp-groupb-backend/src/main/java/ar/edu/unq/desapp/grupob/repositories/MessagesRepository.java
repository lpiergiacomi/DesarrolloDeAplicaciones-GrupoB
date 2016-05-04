package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Message;

public class MessagesRepository extends GenericRepository<Message>{

    @Override
    protected Class<Message> getDomainClass() {
        return Message.class;
    }
}
