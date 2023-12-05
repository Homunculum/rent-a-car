package com.tobeto.kadir.rentacarsql.repositories;


import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCaseAllIgnoreCase(String firstName, String lastName);
}
