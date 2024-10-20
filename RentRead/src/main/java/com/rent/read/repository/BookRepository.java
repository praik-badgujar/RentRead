package com.rent.read.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rent.read.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long>{
	
	public Optional<Books> findById(Long bookId);

}
