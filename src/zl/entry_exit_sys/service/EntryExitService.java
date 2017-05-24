package zl.entry_exit_sys.service;

import java.util.List;

import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.entity.StationEntity;

public interface EntryExitService {
	public void add(EntryExitRecord record); //���
	public void delete(String id); //ɾ����¼
	public List<EntryExitRecord> findAll(); //�鿴ȫ����¼
	public EntryExitRecord findById(String id); //����id�鿴��¼
	public EntryExitRecord findByPhone(String phone); //����phone�鿴��¼
	public List<EntryExitRecord> findByPhoneAll(String phone); //����phone�鿴��¼
	public List<EntryExitRecord> findByTime(String beginTime, String endTime); //������ʼʱ��鿴��¼
	public void update(EntryExitRecord record);//����id�޸Ķ�Ӧ�ļ�¼
	public EntryExitRecord findByStationPhone(StationEntity stationEntity, String phone);//��ѯ�ض�վ��ָ���ֻ��ŵ����¼�¼
	public void logout(EntryExitRecord record);//����id��ӳ�վʱ���Ӧ�ļ�¼
}
