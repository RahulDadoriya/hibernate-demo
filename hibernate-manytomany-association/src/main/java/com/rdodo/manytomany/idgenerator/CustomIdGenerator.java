package com.rdodo.manytomany.idgenerator;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Random random = new Random();
        LocalTime localTime = LocalTime.now();
        return random.nextInt(100) + localTime.getSecond() + localTime.getNano();
    }
}
