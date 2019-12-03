package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.BookDAO;
import com.ust.dao.IBookDAO;
import com.ust.dao.IUserDao;
import com.ust.dao.UserDao;
import com.ust.model.Book;
import com.ust.model.Role;
import com.ust.model.User;


//@CrossOrigin("*")
@RestController
public class FrontController {
	
	@Autowired
	IBookDAO bookdao;
	
	@Autowired
	IUserDao userDao;

	//Diaplay all books
	@RequestMapping(value="/api/book",method=RequestMethod.GET)
	@ResponseBody
	public List<Book> getAllBooks() {
	List list=bookdao.list();
	return list;
	}

	//find a book by id
	@RequestMapping(value="/api/book/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Book getBookByid(@PathVariable("id") int id) {
	return bookdao.get(id);
	}

	//insert a book
	/*
	@RequestMapping(value="/api/insertbook",method=RequestMethod.POST)
	public void insertBook(@RequestBody Book b) {
	bookdao.save(b);
	}
	
	//update a book
		@RequestMapping(value="/api/updatebook",method=RequestMethod.PUT)
		public void updateBook(@RequestBody Book b) {
		bookdao.update(b);
		}
   */
	
	//update a book (alternative method)
	@RequestMapping(value="/api/insertbook",method={RequestMethod.POST,RequestMethod.PUT})
	public void updateBook(@RequestBody Book b) {
		System.out.println(b.getId());
		if (b.getId()!=0)
		{
	         bookdao.update(b);
		}else 
		{
			bookdao.save(b);
		}
	}

	//delete a book
	//@CrossOrigin("*")
	@RequestMapping(value="/api/deletebook/{id}",method=RequestMethod.DELETE)
	public void deletebook(@PathVariable("id") int id)
	{System.out.println("hi");
	bookdao.delete(id);
	}
	
	@RequestMapping(value="/api/login/{uname}/{pass}",method=RequestMethod.GET)
	@ResponseBody
	public Role getBookById(@PathVariable("uname")String userName,@PathVariable("pass")String userPassword)
	{
		return userDao.roleChecker(userName,userPassword);
	 
	}
	
	//******************************Member**************************************
	//Diaplay all members
	@RequestMapping(value="/api/member",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllMembers() 
	{
	List list=userDao.list();
	return list;
	}
	
	//find a member by id
		@RequestMapping(value="/api/member/{userId}",method=RequestMethod.GET)
		@ResponseBody
		public User getMemberByid(@PathVariable("userId") int userId) {
		return userDao.get(userId);
		}

		//insert a member
		@RequestMapping(value="/api/insertmember",method=RequestMethod.POST)
		public void insertMember(@RequestBody User u) {
		userDao.save(u);
		}

		//update a book
		@RequestMapping(value="/api/updatemember",method=RequestMethod.PUT)
		public void updateMember(@RequestBody User u) {
		userDao.update(u);
		}

		//delete a book
		//@CrossOrigin("*")
		@RequestMapping(value="/api/deletemember/{userId}",method=RequestMethod.DELETE)
		public void deleteMember(@PathVariable("userId") int userId)
		{System.out.println("hi");
		userDao.delete(userId);
		}
	//*****************************memberview***********************************
		
		//Diaplay all books
		@RequestMapping(value="/api/memberview",method=RequestMethod.GET)
		@ResponseBody
		public List<Book> getMemberView() {
		List list=bookdao.list();
		return list;
		}
	
}

