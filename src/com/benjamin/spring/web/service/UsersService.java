package com.benjamin.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benjamin.spring.web.dao.Offer;
import com.benjamin.spring.web.dao.OffersDao;
import com.benjamin.spring.web.dao.User;
import com.benjamin.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	
	@Autowired
	public void setOffersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		usersDao.create(user);
		
	}

	

}
