package servicios;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImagenesServicio {

    public void saveImage(MultipartFile imageFile) throws IOException {
        //String folder = "/imagenes/";
        String folder = "/";
        byte[] bytes = imageFile.getBytes(); //podria ser necesario que el metodo lance una excepcion si hay un problema con la imagen
        Path path = Path.of(folder + imageFile.getOriginalFilename());
        Files.write(path,bytes);
    }

}
