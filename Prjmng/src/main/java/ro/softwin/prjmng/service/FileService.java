package ro.softwin.prjmng.service;

import java.io.File;
import java.util.List;

import ro.softwin.prjmng.model.FileInfo;

/**
 * The file service interface
 * @author adobrovolschi
 * @created 07/06/2012
 */
public interface FileService {
	
	/**
	 * 
	 * @return
	 */
	List<FileInfo> listFiles();
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	File getFile(String fileName);
}
