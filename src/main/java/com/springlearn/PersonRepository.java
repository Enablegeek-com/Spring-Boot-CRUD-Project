package com.springlearn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository
        extends JpaRepository<Person, Integer> {
    public final Person person = null;

}
