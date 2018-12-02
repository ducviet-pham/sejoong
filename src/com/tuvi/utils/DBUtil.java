package com.tuvi.utils;

import com.mysql.jdbc.Statement;
import com.tuvi.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	// @SuppressWarnings("unused")
	int __________________ABOUT__________________;

	public static About getAbout(Connection conn, //
			int id) throws SQLException {
		String sql = "Select * from about a" //
				+ " where a.Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String title = rs.getString("Title");
			String content = rs.getString("Content");
			About about = new About();
			about.setId(id);
			about.setTitle(title);
			about.setContent(content);
			return about;
		}
		return null;
	}

	public static int updateAbout(Connection conn, About about)
			throws SQLException {
		String sql = "Update about set Title =?, Content=? where Id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, about.getId());
		pstm.setString(2, about.getTitle());
		pstm.setString(3, about.getContent());
		return pstm.executeUpdate();
	}

	public static int insertAbout(Connection conn, About about)
			throws SQLException {
		String sql = "Insert into about(Id, Title, Content) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, about.getId());
		pstm.setString(2, about.getTitle());
		pstm.setString(3, about.getContent());
		return pstm.executeUpdate();
	}

	public static int deleteAbout(Connection conn, int id) throws SQLException {
		String sql = "Delete From about where Id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		return pstm.executeUpdate();
	}

	// @SuppressWarnings("unused")
	int __________________AdminAccount__________________;

	public static AdminAccount getAdminAccount(Connection conn, //
			int id) throws SQLException {
		String sql = "Select * from adminacount" //
				+ " where UserId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String userName = rs.getString("UserName");
			String password = rs.getString("Password");
			int permission = rs.getInt("Permission");
			AdminAccount adminAccount = new AdminAccount();
			adminAccount.setUserId(id);
			adminAccount.setUserName(userName);
			adminAccount.setPassword(password);
			adminAccount.setPermission(permission);
			return adminAccount;
		}
		return null;
	}

	public static AdminAccount getAdminAccount(Connection conn, //
			String userName) throws SQLException {
		String sql = "Select * from adminacount" //
				+ " where UserName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("UserId");
			String password = rs.getString("Password");
			int permission = rs.getInt("Permission");
			AdminAccount adminAccount = new AdminAccount();
			adminAccount.setUserId(id);
			adminAccount.setUserName(userName);
			adminAccount.setPassword(password);
			adminAccount.setPermission(permission);
			return adminAccount;
		}
		return null;
	}

	public static int updateAdminAccount(Connection conn,
			AdminAccount adminAccount) throws SQLException {
		String sql = "Update adminaccount set UserName =?, Password=?, Permission=? where UserId=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, adminAccount.getUserId());
		pstm.setString(2, adminAccount.getUserName());
		pstm.setString(3, adminAccount.getPassword());
		pstm.setInt(4, adminAccount.getPermission());
		return pstm.executeUpdate();
	}

	public static int insertAdminAccount(Connection conn,
			AdminAccount adminAccount) throws SQLException {
		String sql = "Insert into adminaccount(UserId, UserName, Password, Permission) values (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, adminAccount.getUserId());
		pstm.setString(2, adminAccount.getUserName());
		pstm.setString(3, adminAccount.getPassword());
		pstm.setInt(4, adminAccount.getPermission());
		return pstm.executeUpdate();
	}

	public static int deleteAdminAccount(Connection conn, int id)
			throws SQLException {
		// not implement
		return 0;
	}

	public static List<AdminAccount> queryAdminAccount(Connection conn)
			throws SQLException {
		String sql = "Select * from adminaccount";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<AdminAccount> list = new ArrayList<AdminAccount>();
		while (rs.next()) {
			int userId = rs.getInt("UserId");
			String userName = rs.getString("UserName");
			String password = rs.getString("Password");
			int permission = rs.getInt("Permission");
			AdminAccount adminAccount = new AdminAccount();
			adminAccount.setUserId(userId);
			adminAccount.setUserName(userName);
			adminAccount.setPassword(password);
			adminAccount.setPermission(permission);
			list.add(adminAccount);
		}
		return list;
	}

	int __________________CopyRight__________________;

	public static CopyRight getCopyRight(Connection conn, //
			int id) throws SQLException {
		String sql = "Select * from copyright" //
				+ " where Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String content = rs.getString("Content");
			CopyRight copyRight = new CopyRight();
			copyRight.setId(id);
			copyRight.setContent(content);
			return copyRight;
		}
		return null;
	}

	public static int updateCopyRight(Connection conn, CopyRight copyRight)
			throws SQLException {
		String sql = "Update copyright set Content=? where Id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, copyRight.getId());
		pstm.setString(2, copyRight.getContent());
		return pstm.executeUpdate();
	}

	public static int insertCopyRight(Connection conn, CopyRight copyRight)
			throws SQLException {
		String sql = "Insert into copyright(Id, Content) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, copyRight.getId());
		pstm.setString(2, copyRight.getContent());
		return pstm.executeUpdate();
	}

	public static int deleteCopyRight(Connection conn, int id)
			throws SQLException {
		String sql = "Delete From copyright where Id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		return pstm.executeUpdate();
	}

	int __________________Country__________________;

	public static Country getCountry(Connection conn, //
			int id) throws SQLException {
		// TODO:

		return null;
	}

	public static int updateCountry(Connection conn, AdminAccount adminAccount)
			throws SQLException {
		return 0;
	}

	public static int insertCountry(Connection conn, AdminAccount adminAccount)
			throws SQLException {
		return 0;
	}

	public static int deleteCountry(Connection conn, int id)
			throws SQLException {
		// not implement
		return 0;
	}

	public static List<Country> queryCountry(Connection conn)
			throws SQLException {
		String sql = "Select * from countrylist";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Country> list = new ArrayList<Country>();
		while (rs.next()) {
			int countryId = rs.getInt("CountryId");
			String countryName = rs.getString("CountryName");
			Country country = new Country();
			country.setCountryId(countryId);
			country.setCountryName(countryName);
			list.add(country);
		}
		return list;
	}

	int __________________Event__________________;

	public static Event getEvent(Connection conn, //
			int id) throws SQLException {
		String sql = "Select * from event" //
				+ " where EventId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Timestamp timePlace = rs.getTimestamp("TimePlace");
			Timestamp timeCreated = rs.getTimestamp("TimeCreated");
			String title = rs.getString("Title");
			String content = rs.getString("Content");
			Event event = new Event();
			
			event.setTimeCreated(timeCreated);
			event.setTimePlace(timePlace);
			event.setTitle(title);
			event.setContent(content);
			return event;
		}
		return null;
	}

	public static int updateEvent(Connection conn, Event event)
			throws SQLException {
		String sql = "Update event set TimePlace =?, TimeCreated=?, Title=?, Content=? where EventId=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(5, event.getEvetnId());
		pstm.setTimestamp(1, event.getTimePlace());
		pstm.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		pstm.setString(3, event.getTitle());
		pstm.setString(4, event.getContent());
		return pstm.executeUpdate();
	}

	public static int insertEvent(Connection conn, Event event)
			throws SQLException {
		String sql = "Insert into event(TimePlace, TimeCreated, Title, Content) values (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		pstm.setTimestamp(1, event.getTimePlace());
		pstm.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		pstm.setString(3, event.getTitle());
		pstm.setString(4, event.getContent());
		int result = pstm.executeUpdate();

		ResultSet tableKeys = pstm.getGeneratedKeys();
		tableKeys.next();
		int autoGeneratedID = tableKeys.getInt(1);

		return result;
	}

	public static int deleteEvent(Connection conn, int id) throws SQLException {
		// not implement
		return 0;
	}

	public static List<Event> queryEvent(Connection conn) throws SQLException {
		String sql = "Select * from event";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Event> list = new ArrayList<Event>();
		while (rs.next()) {
			int eventId = rs.getInt("EventId");
			Timestamp timePlace = rs.getTimestamp("TimePlace");
			Timestamp timeCreated = rs.getTimestamp("TimePlace");
			String title = rs.getString("Title");
			String content = rs.getString("Content");
			Event event = new Event();
			event.setEvetnId(eventId);
			event.setTimePlace(timePlace);
			event.setTimeCreated(timeCreated);
			event.setTitle(title);
			event.setContent(content);
			list.add(event);
		}
		return list;
	}
}