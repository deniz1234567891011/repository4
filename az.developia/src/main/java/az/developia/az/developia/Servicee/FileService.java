package az.developia.az.developia.Servicee;

import az.developia.az.developia.info.FileEntity;
import az.developia.az.developia.repository.FileReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class FileService {
   
	@Value("${file.path}")
	private String update;


    @Autowired
    private FileReposetory fileRepository;

    public FileEntity uploadFile(MultipartFile file) throws IOException {
        String filePath = update +"\\"+ file.getOriginalFilename();
        Files.write(Paths.get(filePath), file.getBytes());
        FileEntity fileEntity = new FileEntity(file.getOriginalFilename(), file.getContentType(), filePath);
        return fileRepository.save(fileEntity);
    }
    public void deleteFile(String fileName) throws IOException {
    	Optional<FileEntity> fileEntityOptional = fileRepository.findByFileName(fileName);
    	if (fileEntityOptional.isPresent()) {
    	    FileEntity fileEntity = fileEntityOptional.get();
    	    Files.deleteIfExists(Paths.get(fileEntity.getFilePath()));
    	    fileRepository.delete(fileEntity);
    	} else {
    	    throw new RuntimeException("Файл не найден: " + fileName);
    	}

        }
       
    }
