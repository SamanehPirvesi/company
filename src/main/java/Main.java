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
import com.company.service.CompanyService;
import com.company.service.UserService;
import com.company.service.WorkingDayService;

import utility.DateUtil;

public class Main {

	public static void main(String[] args) throws ParseException {
		Company c1 = new Company("fiat", "f3481");
		Address a1 = new Address("torino", "raconigi", "34", "3456");
		Address a2 = new Address("torino", "netro", "8", "35671");
		Address a3 = new Address("torino", "pastrengo", "14", "45345");
		Address a4 = new Address("torino", "lione", "45/b", "13467");
		User u1 = new User("sara", "ahmadi", "saraahmadi", "s1234", "n54678", a1, "011-3456", "38-3245", true, 1200.6);
		User u2 = new User("zoya", "azizi", "zazizi", "z657", "n9876", a2, "011-2356", "39-65758", true, 15.6);
		User u3 = new User("marco", "toserani", "mtoserani", "m786", "n56667", a3, "011-23566754", "39-76443", true,
				13.70);
		User u4 = new User("sara", "sansone", "srsn", "s456", "n6783", a4, "011-276543", "38-43256", true,
				2000.00);
		Date d1 = new Date(12 / 07 / 1980);
		Date d2 = DateUtil.getStringToDate("07/07/2018");
		Date d3 = DateUtil.getStringToDate("25/08/1960");
		Date d4 = DateUtil.getStringToDate("05/06/2018");
		Date d5 = DateUtil.getStringToDate("13/06/1984");
		Date d6 = DateUtil.getStringToDate("06/06/2018");
		Date d7 = DateUtil.getStringToDate("24/11/1975");

		UserService us = new UserService();
		CompanyService cs = new CompanyService();
		WorkingDayService wds = new WorkingDayService();
		WorkingDay wd1 = new WorkingDay();
		WorkingDay wd2 = new WorkingDay();
		WorkingDay wd3 = new WorkingDay();
		WorkingDay wd4 = new WorkingDay();

		u1.setBirthday(d1);
		u2.setBirthday(d3);
		u3.setBirthday(d5);
		u4.setBirthday(d7);

		c1.addUsers(u1);
		u1.setCompany(c1);

		c1.addUsers(u2);
		u2.setCompany(c1);

		c1.addUsers(u3);
			

		LocalTime t1 = LocalTime.of(8, 00);
		LocalTime t2 = LocalTime.of(18, 00);
		wd1.setDate(d4);
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

		LocalTime t5 = LocalTime.of(9, 45);
		LocalTime t6 = LocalTime.of(16, 45);
		LocalTime t7 = LocalTime.of(4, 40);
		wd3.setDate(d2);
		wd3.setInitTime(t5);
		wd3.setFinishTime(t6);
		wd3.setUser(u3);
		u3.addWorkingDays(wd3);
		
		wd4.setDate(d2);
		wd4.setInitTime(t1);
		wd4.setFinishTime(t4);
		u4.addWorkingDays(wd4);
		

		User user = us.getUserById(21);
//		wd4.setUser(user);
//		 wds.createWorkingDay(wd4);
		//
//		 Company company=cs.getCompanyById(1);
//		 user.setCompany(company);
//		 company.addUsers(user);
//		 us.updateUser(user);
//		 cs.updateCompany(company);
//		 u4.setCompany(company);
		// double f=DateUtil.calculateHours(t6, t5);
		//
		// System.out.println(f);
//			us.createUser(u4);
		// cs.createCompany(c1);
//		cs.updateCompanyById(1, "FIAT");
//		 User user1=us.getUserByUserName("saraahmadi");
//		 System.out.println(user1.getUserName()+user1.getMobilenumber());
//		 us.getAllUser().stream().map(m->m.getSurname()).forEach(System.out::println);
//		 System.out.println(us.isUserActive(4));
//		 us.updatePassworldByUsername("zazizi", "1234");
//		us.updateUserById(2,"sara");
//		us.getUsersByName("sara").stream().forEach(s->System.out.println(s.getSurname()+s.getMobilenumber()));
//		 us.activeExsistentUserByUsername("saraahmadi");
//		 us.deactiveExsistentUserByUsername("saraahmadi");
//		 cs.getListOfUserForCompany(1).stream().map(m->m.getSurname()).forEach(System.out::println);
//		 us.deleteUser(user);
//		 WorkingDay w=wds.getWorkingDaywdById(22);
//		 wds.deleteWorkingDay(w);
//		 System.out.println(wds.GetHoursOfUserByMonth(4,6));
//		 System.out.println(wds.getDaysHolidayForUserByMonth(4,6));
//		 System.out.println(wds.GetPermissionHoursForUserByMonth(4, 6));
//		 System.out.println(wds.GetPermissionHoursForUserByYear(4, 2018));
//		 System.out.println(wds.getDaysHolidayForUserByYear(4, 2018));
//		WorkingDay workingday = wds.getWorkingDaywdById(16);
//		workingday.setHoursPermission(t7);
//		wds.updateWorkingDay(workingday);
		//
	}

}
