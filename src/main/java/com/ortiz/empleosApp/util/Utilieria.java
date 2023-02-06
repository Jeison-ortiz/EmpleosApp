package com.ortiz.empleosApp.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Utilieria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		String nombreOriginal = multiPart.getOriginalFilename();
		try {
			File imagenFile = new File(ruta + nombreOriginal);
			System.out.println("Archivo: " + imagenFile.getAbsolutePath());
			multiPart.transferTo(imagenFile);
			return nombreOriginal;
		}catch (Exception e) {
			System.err.println("Error " + e.getMessage());
			return null;
		}
	}
}
