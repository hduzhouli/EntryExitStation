package zl.entry_exit_sys.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRUtil {

	public static void generateQRtoFile(String text, int width, int height,
			String format, File filepath) {
		Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
        BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}     
        try {
			MatrixToImageWriter.writeToFile(bitMatrix, format, filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void generateQRtoFile(String text){
		Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
        BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 500, 500,hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		File filepath = new File("new.png"); 
        try {
			MatrixToImageWriter.writeToFile(bitMatrix, "png", filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
