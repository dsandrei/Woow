package ro.softwin.prjmng.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The file model
 * @author adobrovolschi
 * @created 07/06/2012
 */
@XmlRootElement
public class FileInfo {
	/** the file name */
	private String fileName;
	/** the file size */
	private String fileSize;	
	
	/**
	 * No-argument constructor
	 */
	public FileInfo() {
		
	}
	
	/**
	 * Constructor
	 * @param fileName
	 * @param fileSize
	 */
	public FileInfo(String fileName, String fileSize) {
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
}
