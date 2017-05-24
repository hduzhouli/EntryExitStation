package zl.entry_exit_sys.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import zl.entry_exit_sys.dao.EntryExitDao;
import zl.entry_exit_sys.dao.Imp.EntryExitDaoImp;
import zl.entry_exit_sys.entity.EntryExitRecord;
import zl.entry_exit_sys.entity.StationEntity;
import zl.entry_exit_sys.service.EntryExitService;
import zl.entry_exit_sys.service.StationService;
import zl.entry_exit_sys.service.Imp.EntryExitServiceImp;
import zl.entry_exit_sys.service.Imp.StationServiceImp;
import zl.entry_exit_sys.util.JdbcUtil;
import zl.entry_exit_sys.util.QRUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;   
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;   
  
import com.google.zxing.BarcodeFormat;   
import com.google.zxing.EncodeHintType;   
import com.google.zxing.MultiFormatWriter;   
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;   
import com.google.zxing.common.BitMatrix;   
import com.google.zxing.qrcode.QRCodeWriter; 


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StationEntity stationEntity = new StationEntity();
		
		stationEntity.setCity("钦州");
		stationEntity.setRegion("浦北");
		stationEntity.setStation("浦北电信大楼");
		
//		StationService service = new StationServiceImp();
//		StationEntity stationEntity = service.findById("23af65cf-3193-4b64-9c96-eab1f7bece73");
		
		EntryExitService service = new EntryExitServiceImp();
		EntryExitRecord record = service.findByStationPhone(stationEntity, "18376666836");

		
		System.out.println(record);

		System.out.println("done");
	}

}
