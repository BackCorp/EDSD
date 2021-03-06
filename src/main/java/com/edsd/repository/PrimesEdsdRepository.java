package com.edsd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.PrimesEdsd;
import com.edsd.model.Requester;

public interface PrimesEdsdRepository extends JpaRepository<PrimesEdsd, Integer>, CrudRepository<PrimesEdsd, Integer> {
	
	@Transactional(readOnly = true)
	public List<PrimesEdsd> findByBelongsToRequester(Requester belongsToRequester);
	
	public List<PrimesEdsd> findByStartDateAndEndDateAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
	@Transactional(readOnly = true)
	public List<PrimesEdsd> findAll();
	
}
