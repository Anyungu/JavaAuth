package com.anyungu.authdemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anyungu.authdemo.entities.UserAuth;


//Repository interface to write functional queries to mysql UserAuth table

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

	//Method to generate select query
	Optional<UserAuth> findByMail(String mail);

}
