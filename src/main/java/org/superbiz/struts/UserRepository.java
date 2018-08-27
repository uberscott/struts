package org.superbiz.struts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public User save( User user );
    public User findOne( Long id );
    public List<User> findAll();
}
