package com.greenshare.site.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.greenshare.site.config.CustomProperties;
import com.greenshare.site.entities.Vehicle;

public class FileUploadUtil {
	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		// 1) converte percorso stringa in un path
		// 2) crea cartella se non esiste dove salvare l'immagine
		// 3) sovrascrive file se già presente con stesso nome

		// 1
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			// 2
			Files.createDirectories(uploadPath); // throws IOException
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName); // percorso file completo
			// 3
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Impossibile salvare immagine: " + fileName, ioe);
		}
	}
	public static void deleteDir(Vehicle trovato) {
		try {
			String dir = CustomProperties.basepath + "/" + trovato.getId();
			
			if (Files.exists(Paths.get(dir))) {
				FileUtils.deleteDirectory(new File(dir));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
