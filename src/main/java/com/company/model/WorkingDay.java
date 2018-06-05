package com.company.model;

import javax.persistence.Entity;

@Entity
public class WorkingDay {
	 private Date date;
	 private Time initTime;
	 private Time finishTime;
	 private boolean ferie;
	 private Time hoursPermission;

}
