package zl.entry_exit_sys.service;

import java.util.List;

import zl.entry_exit_sys.entity.StationEntity;

public interface StationService {
	public void add(StationEntity station); //添加
	public void delete(String id); //删除记录
	public List<StationEntity> findAll(); //查看全部记录
	public StationEntity findById(String id); //根据id查看记录
	public void update(StationEntity station);//根据id查询对应的联系人
	public String getId(String station);//根据基站查id
}
