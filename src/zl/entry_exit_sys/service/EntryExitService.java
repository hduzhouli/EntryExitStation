package zl.entry_exit_sys.service;

import java.util.List;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.entity.StationEntity;

public interface EntryExitService {
	public void add(EntryExitRecord record); //添加
	public void delete(String id); //删除记录
	public List<EntryExitRecord> findAll(); //查看全部记录
	public EntryExitRecord findById(String id); //根据id查看记录
	public EntryExitRecord findByPhone(String phone); //根据phone查看记录
	public List<EntryExitRecord> findByPhoneAll(String phone); //根据phone查看记录
	public List<EntryExitRecord> findByTime(String beginTime, String endTime); //根据起始时间查看记录
	public void update(EntryExitRecord record);//根据id修改对应的记录
	public EntryExitRecord findByStationPhone(StationEntity stationEntity, String phone);//查询特定站点指定手机号的最新记录
	public void logout(EntryExitRecord record);//根据id添加出站时间对应的记录
}
