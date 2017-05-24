package zl.entry_exit_sys.entity;

public class StationEntity {
	private String id;
	private String city;
	private String region;
	private String station;

	public StationEntity() {
		super();
		id = null;
		city = null;
		region = null;
		station = null;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}
}
