package zl.entry_exit_sys.service.Imp;

import java.util.List;
import java.util.UUID;

import zl.entry_exit_sys.dao.StationDao;
import zl.entry_exit_sys.dao.Imp.StationDaoImp;
import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.StationService;

public class StationServiceImp implements StationService {

	public void add(StationEntity station) {
		
		station.setId(UUID.randomUUID().toString());
		
		StationDao dao = new StationDaoImp();
		dao.add(station);
	}

	public void delete(String id) {
		StationDao dao = new StationDaoImp();
		dao.delete(id);

	}

	public List<StationEntity> findAll() {
		StationDao dao = new StationDaoImp();
		return dao.findAll();
	}

	public StationEntity findById(String id) {
		StationDao dao = new StationDaoImp();
		return dao.findById(id);
	}

	public void update(StationEntity station) {
		StationDao dao = new StationDaoImp();
		dao.update(station);
	}

	public String getId(String station) {
		StationDao dao = new StationDaoImp();
		return dao.getId(station);
	}

}
