package ro.softwin.prjmng.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.softwin.prjmng.service.FileService;

/**
 * The file unit test class
 * @author adobrovolschi
 * @created 07/06/2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
public class FileTest {
	
	/** the project service */
	private FileService fileService;
	
	@Autowired(required = true)
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
	
	@Test
	public void testEmpty() {		
		assert true;
	}	
	
	@Test
	public void testListFiles() {		
		Assert.assertNotNull(fileService.listFiles());
	}
	
	@Test
	public void testGetFile() {		
		Assert.assertNotNull(fileService.getFile("test.txt"));
	}
}
