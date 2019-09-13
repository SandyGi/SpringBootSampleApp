package com.sandy.example.BootDemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();
	private static int userCount =4;
	
	static{
		userList.add(new User(1, "Pawan", "Pune", new Date()));
		userList.add(new User(2, "Pwan", "Mumbai", new Date()));
		userList.add(new User(3, "Paw", "Satara", new Date()));
		userList.add(new User(4, "Pawa", "Sangli", new Date()));		
	}
	
	public List<User> getAllUsers(){
		return userList;
	}
	
	public User saveUser(User user){
		if (user.getId() == 0) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	
	public User getUser(int id){
		for(User user : userList){
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id){
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
