package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.KitDetail;

@Repository
public interface KitDetailRepository extends JpaRepository<KitDetail, Integer>{
	boolean existsById(String id);
	boolean existsByCoronaKitId(String coronaKitId);
}
