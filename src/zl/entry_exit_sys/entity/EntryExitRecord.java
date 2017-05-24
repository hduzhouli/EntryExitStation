package zl.entry_exit_sys.entity;

public class EntryExitRecord {

	private String id;
	private String city;
	private String region;
	private String station;
	private String entry_time;
	private String exit_time;
	private String reason;
	private String phone;
	
	public EntryExitRecord() {
		super();
		id = null;
		city = null;
		region = null;
		station = null;
		entry_time = null;
		exit_time = null;
		reason = null;
		phone = null;		
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
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getExit_time() {
		return exit_time;
	}
	public void setExit_time(String exit_time) {
		this.exit_time = exit_time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Record [city=" + city + ", region=" + region + ", station="
				+ station + ", entry_time=" + entry_time + ", exit_time=" + exit_time + ",reason=" + reason + ", phone=" + phone
				+ "]";
	}
}
