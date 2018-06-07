package com.company.service;

import com.company.dao.WorkingDayDao;
import com.company.model.WorkingDay;

public class WorkingDayService {
	private WorkingDayDao workingDayDao=new WorkingDayDao();
	public boolean createWorkingDay(WorkingDay wd) {
		return workingDayDao.createWorkingDay(wd);
	}
	public WorkingDay getWorkingDaywdById(long id) {
		return workingDayDao.getWorkingDaywdById(id);
			}
	public boolean updateWorkingDay(WorkingDay wd) {
		return workingDayDao.updateWorkingDay(wd);
	}
	public int GetHoursOfUserByMonth(long id, int month) {
		return workingDayDao.GetHoursOfUserByMonth(id, month);
	}
	public int getDaysHolidayForUserByMonth(long id, int month) {
		return workingDayDao.getDaysHolidayForUserByMonth(id, month);
	}
	public int getDaysHolidayForUserByYear(long id, int year) {
		return workingDayDao.getDaysHolidayForUserByYear(id, year);
	}
	public int GetPermissionHoursForUserByMonth(long id, int month) {
		return workingDayDao.GetPermissionHoursForUserByMonth(id, month);
	}
	public int GetPermissionHoursForUserByYear(long id, int year) {
		return workingDayDao.GetPermissionHoursForUserByYear(id, year);	
	}
	public boolean deleteWorkingDay(WorkingDay wd) {
		return workingDayDao.deleteWorkingDay(wd);
	}
}
