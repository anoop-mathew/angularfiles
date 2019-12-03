package com.ust.dao;

import java.util.List;

import com.ust.model.Book;

public interface IBookDAO {

	public abstract int save(Book b);

	public abstract Book get(int id);

	public abstract List<Book> list();

	public abstract int update(Book b);

	public abstract int delete(int id);

}