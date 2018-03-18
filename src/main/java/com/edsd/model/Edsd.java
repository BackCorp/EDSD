package com.edsd.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "edsd_id", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"edsd_id", "account_number", "agent_id"}))
public class Edsd {
	
}
