package zl.entry_exit_sys.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zl.entry_exit_sys.dao.StationDao;
import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.util.JdbcUtil;

public class StationDaoImp implements StationDao {

	public void add(StationEntity station) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();

			String sqlQuery = "select * from city_region_table where city=? && region=?";
			stmt = conn.prepareStatement(sqlQuery);
			stmt.setString(1, station.getCity());
			stmt.setString(2, station.getRegion());
			// 执行
			rs = stmt.executeQuery();

			stmt = null;
			String sql = "insert into station_table(id,station,city_id) values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, station.getId());
			stmt.setString(2, station.getStation());
			if (rs.next()) {
				stmt.setString(3, rs.getString("id"));
			}

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
			String sql = "delete from station_table where id=?";
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

	public List<StationEntity> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT " 
					+ "station_table.id id,"
					+ "city_region_table.city city,"
					+ "city_region_table.region region,"
					+ "station_table.station station " 
					+ "FROM "
					+ "city_region_table," 
					+ "station_table " 
					+ "WHERE "
					+ "station_table.city_id=city_region_table.id";
			stmt = conn.prepareStatement(sql);
			// 执行
			rs = stmt.executeQuery();

			List<StationEntity> list = new ArrayList<StationEntity>();
			StationEntity stationEntity = null;
			while (rs.next()) {
				stationEntity = new StationEntity();
				stationEntity.setId(rs.getString("id"));
				stationEntity.setCity(rs.getString("city"));
				stationEntity.setRegion(rs.getString("region"));
				stationEntity.setStation(rs.getString("station"));

				list.add(stationEntity);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public StationEntity findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sqlQuery = "(SELECT " 
				+ "station_table.id id,"
				+ "city_region_table.city city,"
				+ "city_region_table.region region,"
				+ "station_table.station station " 
				+ "FROM "
				+ "city_region_table," 
				+ "station_table " 
				+ "WHERE "
				+ "station_table.city_id=city_region_table.id)";
			String sql = "select * from "+sqlQuery+"station"+" where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			// 执行
			rs = stmt.executeQuery();

			StationEntity stationEntity = null;
			if (rs.next()) {
				stationEntity = new StationEntity();
				stationEntity.setId(rs.getString("id"));
				stationEntity.setCity(rs.getString("city"));
				stationEntity.setRegion(rs.getString("region"));
				stationEntity.setStation(rs.getString("station"));
			}
			return stationEntity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public void update(StationEntity station) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "update station_table set station=? where id=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, station.getStation());
			stmt.setString(2, station.getId());
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);	
		}
	}

	public String getId(String station) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select id from station_table where station=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, station);
			//执行
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("id");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(stmt, conn);	
		}
		return null;
	}
}
