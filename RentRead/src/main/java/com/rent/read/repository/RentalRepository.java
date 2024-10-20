package com.rent.read.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rent.read.entity.Rentals;

public interface RentalRepository extends JpaRepository<Rentals, Long>{
	
	long countByUserIdAndReturnDateIsNull(Long userId);
    Rentals findByUserIdAndBookIdAndReturnDateIsNull(Long userId, Long bookId);

}
