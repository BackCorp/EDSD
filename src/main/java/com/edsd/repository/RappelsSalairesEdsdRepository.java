package com.edsd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.RappelsSalairesEdsd;
import com.edsd.model.Requester;


public interface RappelsSalairesEdsdRepository extends JpaRepository<RappelsSalairesEdsd, Integer>, CrudRepository<RappelsSalairesEdsd, Integer> {
	
	@Transactional(readOnly = true)
	public List<RappelsSalairesEdsd> findByBelongsToRequester(Requester belongsToRequester);
	
	public List<RappelsSalairesEdsd> findByStartDateAndEndDateAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
	public List<RappelsSalairesEdsd> findByStartDateBetweenAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
	public List<RappelsSalairesEdsd> findByEndDateBetweenAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
}
