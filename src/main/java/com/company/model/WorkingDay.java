package com.company.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkingDay {
	@Id
	private Date date;
	private LocalTime initTime;
	private LocalTime finishTime;
	private boolean ferie;
	private LocalTime hoursPermission;

	public WorkingDay() {

	}

	public WorkingDay(Date date, LocalTime initTime, LocalTime finishTime, boolean ferie, LocalTime hoursPermission) {

		this.date = date;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.ferie = ferie;
		this.hoursPermission = hoursPermission;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getInitTime() {
		return initTime;
	}

	public void setInitTime(LocalTime initTime) {
		this.initTime = initTime;
	}

	public LocalTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}

	public boolean isFerie() {
		return ferie;
	}

	public void setFerie(boolean ferie) {
		this.ferie = ferie;
	}

	public LocalTime getHoursPermission() {
		return hoursPermission;
	}

	public void setHoursPermission(LocalTime hoursPermission) {
		this.hoursPermission = hoursPermission;
	}

}
