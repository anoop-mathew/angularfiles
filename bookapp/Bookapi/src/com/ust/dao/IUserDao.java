package com.ust.dao;

import java.util.List;

import com.ust.model.Role;
import com.ust.model.User;

public interface IUserDao {

	public abstract Role roleChecker(String userName, String userPassword);

	public abstract List<User> list();

	public abstract int save(User u);

	public abstract User get(int UserId);

	public abstract int delete(int UserId);

	public abstract int update(User u);

}