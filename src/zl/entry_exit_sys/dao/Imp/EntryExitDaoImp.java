package zl.entry_exit_sys.dao.Imp;

import zl.entry_exit_sys.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zl.entry_exit_sys.dao.EntryExitDao;
import zl.entry_exit_sys.entity.EntryExitRecord;

public class EntryExitDaoImp implements EntryExitDao {

	public void add(EntryExitRecord record) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into entry_exit_station_table(id,city,region,station,entry_time,exit_time,reason,phone) values(?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, record.getId());
			stmt.setString(2, record.getCity());
			stmt.setString(3, record.getRegion());
			stmt.setString(4, record.getStation());
			stmt.setString(5, record.getEntry_time());
			stmt.setString(6, record.getExit_time());
			stmt.setString(7, record.getReason());
			stmt.setString(8, record.getPhone());

			// 执行
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}

	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from entry_exit_station_table where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			// 执行
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	public List<EntryExitRecord> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from entry_exit_station_table";
			stmt = conn.prepareStatement(sql);
			// 执行
			rs = stmt.executeQuery();

			List<EntryExitRecord> list = new ArrayList<EntryExitRecord>();
			EntryExitRecord record = null;
			while (rs.next()) {
				record = new EntryExitRecord();
				record.setId(rs.getString("id"));
				record.setCity(rs.getString("city"));
				record.setRegion(rs.getString("region"));
				record.setStation(rs.getString("station"));
				record.setEntry_time(rs.getString("entry_time"));
				record.setExit_time(rs.getString("exit_time"));
				record.setReason(rs.getString("reason"));
				record.setPhone(rs.getString("phone"));

				list.add(record);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public EntryExitRecord findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from entry_exit_station_table where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			// 执行
			rs = stmt.executeQuery();

			EntryExitRecord record = null;
			if (rs.next()) {
				record = new EntryExitRecord();
				record.setId(rs.getString("id"));
				record.setCity(rs.getString("city"));
				record.setRegion(rs.getString("region"));
				record.setStation(rs.getString("station"));
				record.setEntry_time(rs.getString("entry_time"));
				record.setExit_time(rs.getString("exit_time"));
				record.setReason(rs.getString("reason"));
				record.setPhone(rs.getString("phone"));
			}
			return record;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public List<EntryExitRecord> findByTime(String beginTime, String endTime) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from entry_exit_station_table";
			stmt = conn.prepareStatement(sql);
			// 执行
			rs = stmt.executeQuery();

			List<EntryExitRecord> list = new ArrayList<EntryExitRecord>();
			EntryExitRecord record = null;
			while (rs.next()) {
				record = new EntryExitRecord();
				record = new EntryExitRecord();
				record.setCity(rs.getString("id"));
				record.setCity(rs.getString("city"));
				record.setRegion(rs.getString("region"));
				record.setStation(rs.getString("station"));
				record.setEntry_time(rs.getString("entry_time"));
				record.setExit_time(rs.getString("exit_time"));
				record.setReason(rs.getString("reason"));
				record.setPhone(rs.getString("phone"));

				list.add(record);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public void update(EntryExitRecord record) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "update entry_exit_station_table set city=?,region=?,station=?,entry_time=?,exit_time=?,reason=?,phone=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, record.getCity());
			stmt.setString(2, record.getRegion());
			stmt.setString(3, record.getStation());
			stmt.setString(4, record.getEntry_time());
			stmt.setString(5, record.getExit_time());
			stmt.setString(6, record.getReason());
			stmt.setString(7, record.getPhone());
			stmt.setString(8, record.getId());
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);	
		}
	}

	public List<EntryExitRecord> findByPhone(String phone) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from entry_exit_station_table where phone=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, phone);
			// 执行
			rs = stmt.executeQuery();

			List<EntryExitRecord> list = new ArrayList<EntryExitRecord>();
			EntryExitRecord record = null;
			while (rs.next()) {
				record = new EntryExitRecord();
				record.setId(rs.getString("id"));
				record.setCity(rs.getString("city"));
				record.setRegion(rs.getString("region"));
				record.setStation(rs.getString("station"));
				record.setEntry_time(rs.getString("entry_time"));
				record.setExit_time(rs.getString("exit_time"));
				record.setReason(rs.getString("reason"));
				record.setPhone(rs.getString("phone"));

				list.add(record);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

}
