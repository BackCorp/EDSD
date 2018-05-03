package com.edsd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.NonLogementEdsd;
import com.edsd.model.Requester;

public interface NonLogementEdsdRepository extends JpaRepository<NonLogementEdsd, Integer>, CrudRepository<NonLogementEdsd, Integer> {
	
	@Transactional(readOnly = true)
	public List<NonLogementEdsd> findByBelongsToRequester(Requester belongsToRequester);
	
	public List<NonLogementEdsd> findByStartDateBetweenAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
	public List<NonLogementEdsd> findByEndDateBetweenAndBelongsToRequester(Date startDate, Date endDate, Requester belongsToRequester);
	
}
