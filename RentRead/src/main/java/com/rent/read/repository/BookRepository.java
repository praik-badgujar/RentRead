package com.rent.read.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rent.read.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long>{

}
