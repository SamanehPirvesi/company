import java.time.LocalTime;
import java.util.Date;

import com.company.dao.CompanyDao;
import com.company.dao.UserDao;
import com.company.dao.WorkingDayDao;
import com.company.model.Address;
import com.company.model.Company;
import com.company.model.User;
import com.company.model.WorkingDay;

public class Main {

	public static void main(String[] args) {
		Address a1 = new Address("torino", "raconigi", "34", "3456");
		User u1 = new User("sara", "ahmadi", "saraahmadi", "s1234", "n54678", a1, "011-3456", "38-3245", true, 12.6);
		Date d1 = new Date(12/07/1980);
		u1.setBirthday(d1);
		UserDao uDao = new UserDao();
		Company c1 = new Company("fiat", "f3481");
		c1.addUsers(u1);
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
		wdDao.createWorkingDay(wd1);
		uDao.createUser(u1);
		cDao.createCompany(c1);
	}

}
