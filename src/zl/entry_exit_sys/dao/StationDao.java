package zl.entry_exit_sys.dao;

import java.util.List;

import zl.entry_exit_sys.entity.StationEntity;

/**
 *  ��վվ�����ݿ�ӿ�
 *  
 */
public interface StationDao {
	//���
	public void add(StationEntity station); //���
	//ɾ��
	public void delete(String id); //ɾ����¼
	//��ѯ
	public List<StationEntity> findAll(); //�鿴ȫ����¼
	public StationEntity findById(String id); //����id�鿴��¼
	public String getId(String station);//ͨ��վ���id
	//�޸�
	public void update(StationEntity station);//����id��ѯ��Ӧ����ϵ��
}
