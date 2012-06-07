package ro.softwin.prjmng.endpoint;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.softwin.prjmng.model.wrapper.Files;
import ro.softwin.prjmng.service.FileService;



@Path("/files")
@Component
public class FileEndpoint {
	/** the file service */
	private FileService fileService;
	
	@Autowired(required = true)
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Files listFiles() {
		return new Files(fileService.listFiles());
	}
	
	@GET
	@Path("/get/{fileName}")
	@Produces("application/file")
	public Response getFile(@PathParam("fileName")String fileName) {
		ResponseBuilder response = null;			
		File fileToDownload = fileService.getFile(fileName);
		
		response = Response.ok((Object) fileToDownload);
		response.header("Content-Disposition",
				"attachment; filename=" + fileToDownload.getName());
		
		return response.build();		

	}
}
