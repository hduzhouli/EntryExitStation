package zl.entry_exit_sys.service;

import java.util.List;

import zl.entry_exit_sys.entity.StationEntity;

public interface StationService {
	public void add(StationEntity station); //���
	public void delete(String id); //ɾ����¼
	public List<StationEntity> findAll(); //�鿴ȫ����¼
	public StationEntity findById(String id); //����id�鿴��¼
	public void update(StationEntity station);//����id��ѯ��Ӧ����ϵ��
	public String getId(String station);//���ݻ�վ��id
}
