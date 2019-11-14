package com.anyungu.authdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anyungu.authdemo.entities.Tokenn;

public interface TokenRepository extends JpaRepository<Tokenn, String> {

}
