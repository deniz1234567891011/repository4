package az.developia.az.developia.StudentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;
import az.developia.az.developia.info.FileEntity;
import az.developia.az.developia.Servicee.FileService;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileConstruction {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity savedFileEntity = fileService.uploadFile(file);
            return "Файл успешно загружен: " + file.getOriginalFilename();
        } catch (IOException e) {
            return "Ошибка загрузки файла: " + file.getOriginalFilename();
        }
    }
    @DeleteMapping("/delete/{filename}")
    public String deleteFile(@PathVariable("filename") String filename) {
        try {
            fileService.deleteFile(filename);
            return "Файл успешно удалён: " + filename;
        } catch (IOException e) {
            return "Ошибка удаления файла: " + filename;
        }
    }

    }
