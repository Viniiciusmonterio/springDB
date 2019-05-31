package br.edu.unibratec.psc.dbdemo.user;

import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    
}