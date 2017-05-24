package zl.entry_exit_sys.service.Imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.dao.EntryExitDao;
import zl.entry_exit_sys.dao.Imp.EntryExitDaoImp;

public class EntryExitServiceImp implements EntryExitService {

	public void add(EntryExitRecord record) {

		// 插入进站时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String entry_time = sdf.format(new Date());
		if (record.getEntry_time() == null) {
			record.setEntry_time(entry_time);
		}
		// 插入进站记录id
		record.setId(UUID.randomUUID().toString());

		EntryExitDao dao = new EntryExitDaoImp();
		dao.add(record);

	}

	public void delete(String id) {
		EntryExitDao dao = new EntryExitDaoImp();
		dao.delete(id);

	}

	public List<EntryExitRecord> findAll() {
		EntryExitDao dao = new EntryExitDaoImp();
		return dao.findAll();
	}

	public EntryExitRecord findById(String id) {
		EntryExitDao dao = new EntryExitDaoImp();
		return dao.findById(id);
	}

	public List<EntryExitRecord> findByTime(String beginTime, String endTime) {
		EntryExitDao dao = new EntryExitDaoImp();
		return dao.findByTime(beginTime, endTime);
	}

	public void update(EntryExitRecord record) {
		EntryExitDao dao = new EntryExitDaoImp();
		dao.update(record);

	}

	public void logout(EntryExitRecord record) {
		// 插入出站时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String exit_time = sdf.format(new Date());
		if (record.getExit_time() == null) {
			record.setExit_time(exit_time);
		}
		update(record);
	}

	//通过手机查询最新的进站记录
	public EntryExitRecord findByPhone(String phone) {

		//通过手机获取所以进站记录
		List<EntryExitRecord> list = findByPhoneAll(phone);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lastTime = 0;
		EntryExitRecord lastrecord = null;
				
		for (EntryExitRecord record : list) {
			try {
				long temp = sdf.parse(record.getEntry_time()).getTime();
				//筛选最新的进站时间
				if (temp > lastTime) {
					lastTime = temp;
					lastrecord = record;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return lastrecord;
	}

	//通过手机查询所有的进站记录
	public List<EntryExitRecord> findByPhoneAll(String phone) {
		EntryExitDao dao = new EntryExitDaoImp();
		return dao.findByPhone(phone);
	}

	
	//根据站点信息查询相应手机号进站记录(扫描出站)
	public EntryExitRecord findByStationPhone(StationEntity stationEntity, String phone){
		
		//通过手机获取所以进站记录（通过手机筛选）
		List<EntryExitRecord> list = findByPhoneAll(phone);
		
		//临时数组
		List<EntryExitRecord> tempList = new ArrayList<EntryExitRecord>();
		
		//获取该手机号对应站点的所以记录（通过站点筛选）
		for (EntryExitRecord record : list){
			if(stationEntity.getStation().equals(record.getStation())){
				tempList.add(record);
			}
		}
		
		//获取最新时间的进站记录（通过时间筛选）
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lastTime = 0;
		EntryExitRecord lastrecord = null;
				
		for (EntryExitRecord record : tempList) {
			try {
				long temp = sdf.parse(record.getEntry_time()).getTime();
				//筛选最新的进站时间
				if (temp > lastTime) {
					lastTime = temp;
					lastrecord = record;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return lastrecord;
	}
}
