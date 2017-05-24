package zl.entry_exit_sys.dao;

import java.util.List;

import zl.entry_exit_sys.entity.EntryExitRecord;

/**
 * 基站出入记录CURD数据库接口
 *
 */
public interface EntryExitDao {
	//添加
	public void add(EntryExitRecord record); //添加
	//删除
	public void delete(String id); //删除记录
	//查询
	public List<EntryExitRecord> findAll(); //查看全部记录
	public EntryExitRecord findById(String id); //根据id查看记录
	public List<EntryExitRecord> findByPhone(String phone); //根据phone查看记录
	public List<EntryExitRecord> findByTime(String beginTime, String endTime); //根据起始时间查看记录
	//修改
	public void update(EntryExitRecord record);//根据id查询对应的联系人
}
