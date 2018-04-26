package vn.edu.hcmuaf.NongLamAnnounceService.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/img")
public class UploadImgService {

	/**
	 * Upload hình ảnh lên server
	 * @param uploadIS InputStream
	 * @param fileDetail 
	 * @param path đường dẫn đến thư mục chứa hình ảnh của server
	 * @return
	 */
	@POST
	@Path("/{path}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadImg(@FormDataParam("file") InputStream uploadIS,
			@FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("path") String path) {
		if (saveToServer(uploadIS, fileDetail, path)) {
			return "upload success";
		} else {
			return "upload false";
		}

	}

	public boolean saveToServer(InputStream uploadIS, FormDataContentDisposition fileDetail, String path) {
		try {
			OutputStream out = new FileOutputStream(new File(path));
			int read = 0;
			byte[] bytes = new byte[102400];
			while ((read = uploadIS.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
