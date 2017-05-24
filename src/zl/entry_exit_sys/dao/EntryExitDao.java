package zl.entry_exit_sys.dao;

import java.util.List;

import zl.entry_exit_sys.entity.EntryExitRecord;

/**
 * ��վ�����¼CURD���ݿ�ӿ�
 *
 */
public interface EntryExitDao {
	//���
	public void add(EntryExitRecord record); //���
	//ɾ��
	public void delete(String id); //ɾ����¼
	//��ѯ
	public List<EntryExitRecord> findAll(); //�鿴ȫ����¼
	public EntryExitRecord findById(String id); //����id�鿴��¼
	public List<EntryExitRecord> findByPhone(String phone); //����phone�鿴��¼
	public List<EntryExitRecord> findByTime(String beginTime, String endTime); //������ʼʱ��鿴��¼
	//�޸�
	public void update(EntryExitRecord record);//����id��ѯ��Ӧ����ϵ��
}
