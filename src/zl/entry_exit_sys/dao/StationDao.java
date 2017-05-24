package zl.entry_exit_sys.dao;

import java.util.List;

import zl.entry_exit_sys.entity.StationEntity;

/**
 *  基站站点数据库接口
 *  
 */
public interface StationDao {
	//添加
	public void add(StationEntity station); //添加
	//删除
	public void delete(String id); //删除记录
	//查询
	public List<StationEntity> findAll(); //查看全部记录
	public StationEntity findById(String id); //根据id查看记录
	public String getId(String station);//通过站点查id
	//修改
	public void update(StationEntity station);//根据id查询对应的联系人
}
