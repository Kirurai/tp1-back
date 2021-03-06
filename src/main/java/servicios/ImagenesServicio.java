package servicios;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import org.apache.commons.io.FilenameUtils; //sirve para manipular nombres de archivos, podria ser reemplazo con funciones personalizadas de cadenas

public class ImagenesServicio {


    public String saveImage(MultipartFile imageFile) throws IOException {
        String folder = "./imagenes/";

        if(!CrearDirectorioSiNoexiste(folder)){
            throw new IOException("No se pudo crear el directorio");
        }

        byte[] bytes = imageFile.getBytes(); //podria ser necesario que el metodo lance una excepcion si hay un problema con la imagen
        Path path = Path.of(folder + imageFile.getOriginalFilename());
        System.out.println(path.toAbsolutePath()); // devuelve la ruta absoluta for debugging purposes

        Files.write(path,bytes);

        return path.toString();
    }


    public boolean CrearDirectorioSiNoexiste(String directorio){
        File directory = new File(directorio);
        if (! directory.exists()){
           return directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        return true;
    }

}
