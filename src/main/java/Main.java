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

import utility.DateUtil;

public class Main {

	public static void main(String[] args) throws ParseException {
		Company c1 = new Company("fiat", "f3481");
		Address a1 = new Address("torino", "raconigi", "34", "3456");
		Address a2 = new Address("torino", "netro", "8", "35671");
		Address a3 = new Address("torino", "pastrengo", "14", "45345");
		User u1 = new User("sara", "ahmadi", "saraahmadi", "s1234", "n54678", a1, "011-3456", "38-3245", true, 1200.6);
		User u2 = new User("zoya", "azizi", "zazizi", "z657", "n9876", a2, "011-2356", "39-65758", true, 15.6);
		User u3 = new User("marco", "toserani", "mtoserani", "m786", "n56667", a3, "011-23566754", "39-76443", true, 13.70);
		Date d1 = new Date(12 / 07 / 1980);
		Date d2 = new Date(5 / 6 / 2018);
		Date d3 = DateUtil.getStringToDate("25/08/1960");
		Date d4 = DateUtil.getStringToDate("05/06/2018");
		Date d5 = DateUtil.getStringToDate("13/06/1984");
		Date d6 = DateUtil.getStringToDate("06/06/2018");

		UserDao uDao = new UserDao();
		CompanyDao cDao = new CompanyDao();
		WorkingDayDao wdDao = new WorkingDayDao();
		WorkingDay wd1 = new WorkingDay();
		WorkingDay wd2 = new WorkingDay();
		WorkingDay wd3 = new WorkingDay();
		
		u1.setBirthday(d1);
		u2.setBirthday(d3);
		u3.setBirthday(d5);
		
		c1.addUsers(u1);
		u1.setCompany(c1);
		
		c1.addUsers(u2);
		u2.setCompany(c1);
		
		c1.addUsers(u3);
		
				
		LocalTime t1 = LocalTime.of(8, 00);
		LocalTime t2 = LocalTime.of(18, 00);
		wd1.setDate(d2);
		wd1.setInitTime(t1);
		wd1.setFinishTime(t2);
		wd1.setUser(u1);
		u1.addWorkingDays(wd1);
		
		LocalTime t3 = LocalTime.of(9, 00);
		LocalTime t4 = LocalTime.of(17, 45);
		wd2.setDate(d4);
		wd2.setInitTime(t3);
		wd2.setFinishTime(t4);
		wd2.setUser(u2);
		u2.addWorkingDays(wd2);
		
		LocalTime t5 = LocalTime.of(7, 45);
		LocalTime t6 = LocalTime.of(17, 45);
		wd3.setDate(d6);
		wd3.setInitTime(t5);
		wd3.setFinishTime(t6);
		wd3.setUser(u3);
		u3.addWorkingDays(wd3);
		
		Company company=cDao.getCompanyById(1);
		u3.setCompany(company);
		
		// wdDao.createWorkingDay(wd1);
//		uDao.createUser(u3);
//		 cDao.createCompany(c1);
		// cDao.createCompany(c1);
		// User user=uDao.getUserByUserName("saraahmadi");
		// System.out.println(user.getUserName()+user.getMobilenumber());
		uDao.getAllUser().stream().map(m->m.getSurname()).forEach(System.out::println);;
	}

}
