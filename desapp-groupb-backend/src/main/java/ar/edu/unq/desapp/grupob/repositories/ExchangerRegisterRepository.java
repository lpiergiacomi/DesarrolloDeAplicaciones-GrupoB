package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.ExchangeRegister;

public class ExchangerRegisterRepository
        extends GenericRepository<ExchangeRegister> {

    @Override
    protected Class<ExchangeRegister> getDomainClass() {
        return ExchangeRegister.class;
    }
}
