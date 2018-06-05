import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.dao.WorkingDayDao;
import com.company.model.Address;
import com.company.model.Company;
import com.company.model.User;
import com.company.model.WorkingDay;

import hibernateUtil.DateUtil;

public class Main {

	public static void main(String[] args) throws ParseException {
		Address a1 = new Address("torino", "raconigi", "34", "3456");
		User u1 = new User("sara", "ahmadi", "saraahmadi", "s1234", "n54678", a1, "011-3456", "38-3245", true, 12.6);
		Address a2 = new Address("torino", "netro", "8", "35671");
		User u2 = new User("zoya", "azizi", "zazizi", "z657", "n9876", a2, "011-2356", "39-65758", true,15.6);
		Date d1 = new Date(12/07/1980);
		Date d3=DateUtil.getStringToDate("25/08/1960");
		u1.setBirthday(d1);
		u2.setBirthday(d3);
		UserDao uDao = new UserDao();
		Company c1 = new Company("fiat", "f3481");
		c1.addUsers(u1);
		c1.addUsers(u2);
		u2.setCompany(c1);
		CompanyDao cDao = new CompanyDao();
		u1.setCompany(c1);
		WorkingDay wd1 = new WorkingDay();
		WorkingDayDao wdDao = new WorkingDayDao();
		LocalTime t1 = LocalTime.of(8,00);
		LocalTime t2 = LocalTime.of(18,00);
		Date d2 = new Date(5/6/2018);
		wd1.setDate(d2);
		wd1.setInitTime(t1);
		wd1.setFinishTime(t2);
		wd1.setUser(u1);
		u1.addWorkingDays(wd1);
		WorkingDay wd2 = new WorkingDay();
		LocalTime t3 = LocalTime.of(9,00);
		LocalTime t4 = LocalTime.of(17,45);
		Date d4=DateUtil.getStringToDate("05/06/2018");
		wd2.setDate(d4);
		wd2.setInitTime(t3);
		wd2.setFinishTime(t4);
		wd2.setUser(u2);
		u2.addWorkingDays(wd2);
		
//		wdDao.createWorkingDay(wd1);
		uDao.createUser(u2);
//		cDao.createCompany(c1);
//		cDao.createCompany(c1);
//		User user=uDao.getUserByUserName("saraahmadi");
//		System.out.println(user.getUserName()+user.getMobilenumber());
	}

}
