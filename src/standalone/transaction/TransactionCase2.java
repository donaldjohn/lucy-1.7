package transaction;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import transaction.bo2.UserBO;
import transaction.model.BoardUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/transaction/applicationContext2.xml")
public class TransactionCase2 {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserBO bo;
	
	@Test
	public void testGetById() throws Exception {
		List<BoardUser> list = bo.getBoardUserList(0, 10);
		
		for (BoardUser userElem : list) {
			logger.info(userElem.getId() + "\t" +  userElem.getPasswd() + "\t" + userElem.getUserName() + "\t" +  + userElem.getAge() + "\t" + userElem.getRole());
		}
	}
	
	@Test
	public void testAdd() throws Exception {
		try {
			BoardUser newUser = new BoardUser();
			newUser.setId("id");
			newUser.setPasswd("passwd");
			newUser.setUserName("이름");
			newUser.setAge(30);
			newUser.setRole("ADMIN");
			
			logger.info("" + bo.addBoardUser(newUser));
			logger.info("" + bo.getUserCountById(newUser.getId()));
		} catch(Exception e) {
			logger.info("throw Exception");
		}

		List<BoardUser> list = bo.getBoardUserList(0, 10);
		
		for (BoardUser userElem : list) {
			logger.info(userElem.getId() + "\t" +  userElem.getPasswd() + "\t" + userElem.getUserName() + "\t" +  + userElem.getAge() + "\t" + userElem.getRole());
		}
	}
}