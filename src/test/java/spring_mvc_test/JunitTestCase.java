package spring_mvc_test;

import org.junit.Assert;
import org.junit.Test;

import com.spring.mvc.home.beans.ALLClass;
import com.spring.mvc.home.mapping.UserDAOImpl;



public class JunitTestCase {
	@Test
	public void createTest() {
		// Assert.assertEquals(SpringHibernateMain.startConnection(), true);
		UserDAOImpl user = new UserDAOImpl();
		Assert.assertEquals(UserDAOImpl.startConnection(), true);
		// Assert.assertEquals(user.add(5), true);
		ALLClass all = new ALLClass();
		all.setBatchID(1);
		all.setCampusMindMID(1234);
		all.setCampusMindName("abc");
		all.setLeadMID(1235);
		all.setLeadName("balyan");
		all.setTrack("eai");
		Assert.assertEquals(user.add(all), true);
		Assert.assertEquals(UserDAOImpl.closeConnection(), true);
		// Assert.assertEquals(SpringHibernateMain.addToDatabase(4), true);
	}
}
