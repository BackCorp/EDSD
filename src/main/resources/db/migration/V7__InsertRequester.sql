INSERT INTO `edsd`.`requester`
(
`account_number`,
`last_name`,
`first_name`,
`region`,
`health_district`,
`structure`,
`genre`,
`dob`,
`place_of_birth`,
`status`,
`field_of_work`,
`recruitment_date`,
`grade_at_recruitment`,
`current_grade`,
`current_category`,
`current_index`,
`current_situation`)
VALUES
('621914-Y','DIN DIKA','LOUIS','LITTORAL','DRSP LITTORAL',
	'BRIGADE DE CONTRÔLE DES ACTIVITES ET DES SOINS DE SANTE',
	'M',STR_TO_DATE('12-07-1980', '%m-%d-%Y'),'DOUALA','FONCTIONNAIRE','MEDECIN',
	STR_TO_DATE('12-07-2020', '%m-%d-%Y'),'MEDECIN','MEDECIN','A2',1,'En Activité');


INSERT INTO `edsd`.`requester`
(
`account_number`,
`last_name`,
`first_name`,
`region`,
`health_district`,
`structure`,
`genre`,
`dob`,
`place_of_birth`,
`status`,
`field_of_work`,
`recruitment_date`,
`grade_at_recruitment`,
`current_grade`,
`current_category`,
`current_index`,
`current_situation`,
`rank_position`,
`occupied_organic_position`,
`date_of_appointment_or_assignment`,
`appointment_type`,
`reference_appointment_or_assignment`)
VALUES
('364943-S','TANGOUFO','JUSTIN','OUEST','DS BAFANG',
	'DS BAFANG','M',STR_TO_DATE('1-10-1965', '%m-%d-%Y'),'BABETE','FONCTIONNAIRE','Infirmier',
	STR_TO_DATE('11-3-1986', '%m-%d-%Y'),'Infirmier Adjoint','Infirmier','B1',445,'En Activité',
	'CHEF_DE_BUREAU_DE_LADMINISTRATION_CENTRALE','CHEF DE BUREAU DES AFFAIRES ADMINISTRATIVES ET FINANCIERES',
	STR_TO_DATE('9-20-2001', '%m-%d-%Y'),'Décision','00345/MSP');
