package ro.softwin.prjmng.model.wrapper;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import ro.softwin.prjmng.model.FileInfo;




/**
 * The file list wrapper
 * @author adobrovolschi
 * @created 07/06/2012
 */
@XmlRootElement
public class Files {
	/** the files info collection */
	private Collection<FileInfo> files;
	
	/**
	 * No-argument constructor
	 */
	public Files() {
		this.files = new ArrayList<FileInfo>();
	}

	/**
	 * Constructor
	 * @param files
	 */
	public Files(Collection<FileInfo> files) {
		this.files = files;
	}

	/**
	 * @return the files
	 */
	public Collection<FileInfo> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(Collection<FileInfo> files) {
		this.files = files;
	}	
}

