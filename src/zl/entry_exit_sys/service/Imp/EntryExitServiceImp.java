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

		// �����վʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String entry_time = sdf.format(new Date());
		if (record.getEntry_time() == null) {
			record.setEntry_time(entry_time);
		}
		// �����վ��¼id
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
		// �����վʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String exit_time = sdf.format(new Date());
		if (record.getExit_time() == null) {
			record.setExit_time(exit_time);
		}
		update(record);
	}

	//ͨ���ֻ���ѯ���µĽ�վ��¼
	public EntryExitRecord findByPhone(String phone) {

		//ͨ���ֻ���ȡ���Խ�վ��¼
		List<EntryExitRecord> list = findByPhoneAll(phone);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lastTime = 0;
		EntryExitRecord lastrecord = null;
				
		for (EntryExitRecord record : list) {
			try {
				long temp = sdf.parse(record.getEntry_time()).getTime();
				//ɸѡ���µĽ�վʱ��
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

	//ͨ���ֻ���ѯ���еĽ�վ��¼
	public List<EntryExitRecord> findByPhoneAll(String phone) {
		EntryExitDao dao = new EntryExitDaoImp();
		return dao.findByPhone(phone);
	}

	
	//����վ����Ϣ��ѯ��Ӧ�ֻ��Ž�վ��¼(ɨ���վ)
	public EntryExitRecord findByStationPhone(StationEntity stationEntity, String phone){
		
		//ͨ���ֻ���ȡ���Խ�վ��¼��ͨ���ֻ�ɸѡ��
		List<EntryExitRecord> list = findByPhoneAll(phone);
		
		//��ʱ����
		List<EntryExitRecord> tempList = new ArrayList<EntryExitRecord>();
		
		//��ȡ���ֻ��Ŷ�Ӧվ������Լ�¼��ͨ��վ��ɸѡ��
		for (EntryExitRecord record : list){
			if(stationEntity.getStation().equals(record.getStation())){
				tempList.add(record);
			}
		}
		
		//��ȡ����ʱ��Ľ�վ��¼��ͨ��ʱ��ɸѡ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lastTime = 0;
		EntryExitRecord lastrecord = null;
				
		for (EntryExitRecord record : tempList) {
			try {
				long temp = sdf.parse(record.getEntry_time()).getTime();
				//ɸѡ���µĽ�վʱ��
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
