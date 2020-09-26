package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.CoronaKit;

@Repository
public interface CoronaKitRepository extends JpaRepository<CoronaKit, Integer> {
		
		boolean existsById(String id);
}
