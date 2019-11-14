package com.anyungu.authdemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anyungu.authdemo.entities.UserRegister;

//Repository interface to write functional queries to mysql UserRegister table

public interface UserRegisterRepository extends JpaRepository<UserRegister, Integer> {

	Optional<UserRegister> findByMail(String mail);

	Optional<UserRegister> findByPhone(String phone);

}
