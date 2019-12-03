package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Book;

public class BookDAO implements IBookDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/* (non-Javadoc)
	 * @see com.ust.dao.IBookDAO#save(com.ust.model.Book)
	 */
	@Override
	public int save(Book b) {
		String sql = "insert into book values(" + b.getId() +",'"
	+ b.getTitle() +"','" + b.getAuthor() +"')";
		return template.update(sql);
	}

	/* (non-Javadoc)
	 * @see com.ust.dao.IBookDAO#get(int)
	 */
	@Override
	public Book get(int id) {
		String sql = "select id,title,author from book where id=?";
		return (Book) template.queryForObject(sql, new Object[] {id},
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	/* (non-Javadoc)
	 * @see com.ust.dao.IBookDAO#list()
	 */
	@Override
	public List<Book> list() {
		return template.query("select id,title,author from book",
				new RowMapper<Book>() {

					public Book mapRow(ResultSet rs, int row)
							throws SQLException {
						Book b = new Book();
						b.setId(rs.getInt(1));
						b.setTitle(rs.getString(2));
						b.setAuthor(rs.getString(3));
						return b;
					}
				});
	}

	/* (non-Javadoc)
	 * @see com.ust.dao.IBookDAO#update(com.ust.model.Book)
	 */
	@Override
	public int update(Book b) {
		String sql = "update book set title='"+b.getTitle()+"',author='"+b.getAuthor()+"'where id="+b.getId()+"";
		return template.update(sql);
	}
	
	/* (non-Javadoc)
	 * @see com.ust.dao.IBookDAO#delete(int)
	 */
	@Override
	public int delete(int id) {
		
		String sql="delete from book where id="+id+"";
		return template.update(sql);
		}

	//****************************MemberView***********************************
	
	
}
