package ro.softwin.prjmng.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ro.softwin.prjmng.model.FileInfo;
import ro.softwin.prjmng.service.FileService;

/**
 * The file service implementation
 * @author adobrovolschi
 * @created 06/07/2012
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

	@Value("${file.rootPath}")
	private String fileRoot;
	
	/*
	 * (non-Javadoc)
	 * @see ro.softwin.prjmng.service.FileService#listFiles()
	 */
	public List<FileInfo> listFiles() {
		List<FileInfo> ret = null;
		File rootFolder = new File(fileRoot);
		
		if (rootFolder.exists() && rootFolder.isDirectory()) {
			File[] fileArray = rootFolder.listFiles();
			ret = new ArrayList<FileInfo>();
			
			for(int i=0;i<fileArray.length;i++) {
				ret.add(new FileInfo(fileArray[i].getName(), new StringBuffer("").append(fileArray[i].length()).append(" bytes").toString()));
			}
		} 
		
		return ret;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ro.softwin.prjmng.service.FileService#getFile(java.lang.String)
	 */
	public File getFile(String fileName) {
		File ret = new File(fileRoot + fileName);
		
		if (!ret.exists()) {
			return null;
		}
		
		return ret;
	}
}
