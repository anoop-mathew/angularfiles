package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Book;
import com.ust.model.Role;
import com.ust.model.User;

public class UserDao implements IUserDao  {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;

	}

	
	/* (non-Javadoc)
	 * @see com.ust.dao.IUserDao#roleChecker(java.lang.String, java.lang.String)
	 */
	@Override
	public Role roleChecker(String userName, String userPassword) {
		
		String sql ="select roleId, roleName from tblRole where roleId=(select roleId from tblUser where userName='"+userName+"'and userPassword='"+userPassword+"')";
		
		return (Role) template.queryForObject(sql, new Object[]{},
				new BeanPropertyRowMapper<Role>(Role.class));
		
		/*try {
			role = (String) template.queryForObject(sql, new Object[]{},String.class);
			return role;
		} catch (Exception e) {
			return role;
		}*/
		
	}
		/* (non-Javadoc)
		 * @see com.ust.dao.IUserDao#list()
		 */

	@Override
	public int save(User u) {
		/*System.out.println(u.getUserId());
		System.out.println(u.getUserName());
		System.out.println(u.getUserPassword());
		System.out.println(u.getRoleId());*/
		String sql = "insert into tblUser values("+u.getUserId()+",'"+u.getUserName()+"','"+u.getUserPassword()+"',"+u.getRoleId()+")";
		return template.update(sql);
	}
	
	
	@Override
	public User get(int UserId) {
		String sql = "select userId, userName, userPassword, roleId from tblUser where userId=?";
		return (User) template.queryForObject(sql, new Object[] {UserId},
				new BeanPropertyRowMapper<User>(User.class));
	}
	
		@Override
		public List<User> list() {
			return template.query("select userId,userName,userPassword,roleId from tblUser",
					new RowMapper<User>() {

						public User mapRow(ResultSet rs, int row)
								throws SQLException {
							User u = new User();
							u.setUserId(rs.getInt(1));
							u.setUsername(rs.getString(2));
						    u.setUserPassword(rs.getString(3));
						    u.setRoleId(rs.getInt(4));
							return u;
						}
					});
		}
		
		@Override
		public int update(User u) {
			String sql = "update tblUser set userName='"+u.getUserName()+"',userPassword='"+u.getUserPassword()+"',roleId="+u.getRoleId()+" where userId="+u.getUserId()+"";
			return template.update(sql);
		}
		
		@Override
		public int delete(int UserId) {
			
			String sql="delete from tblUser where userId="+UserId+"";
			return template.update(sql);
			}
	}
