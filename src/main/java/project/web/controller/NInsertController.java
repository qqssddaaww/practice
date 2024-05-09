package project.web.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.web.data.dto.TestDTO;
import project.web.data.service.hotel.HotelService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insert")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class NInsertController {

    private final HotelService hotelService;
    private static final String UPLOAD_DIR = "./uploads/";

    public NInsertController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(value = "/upload-img")
    public String uploadImg(List<MultipartFile> files) {
        List<String> urlName = new ArrayList<>();
        try {
            if (files.isEmpty()) {
                return "업로드 파일이 비었습니다.";
            }
            for (int i = 0; i < files.size(); i++) {
                if (files.isEmpty()) {
                    continue; // 빈 파일은 스킵
                }
                if (!files.get(i).getContentType().startsWith("image/")) {
                    return "이미지 파일만 업로드할 수 있습니다.";
                }
                Path uploadDirPath = Paths.get(UPLOAD_DIR);
                if(!Files.exists(uploadDirPath)) {
                    Files.createDirectories(uploadDirPath);
                }

                Path path ;
                if(i == 0) {
                    String fileNameWithoutExtension = FilenameUtils.removeExtension(files.get(i).getOriginalFilename());
                    path = Paths.get(UPLOAD_DIR + fileNameWithoutExtension + "_main.png");
                    urlName.add("..\\." + path);
                } else{
                    path = Paths.get(UPLOAD_DIR + files.get(i).getOriginalFilename());
                    urlName.add("..\\." + path);
                }
                Files.copy(files.get(i).getInputStream(), path);
            }

            hotelService.insertHotelPic(urlName, 1L);

            return "업로드 성공";

        } catch (Exception e) {
            e.printStackTrace();
            return "업로드 에러 " + e.getMessage();
        }
    }

    @GetMapping(value = "/url")
    public List<TestDTO> getUrl() {
        List<TestDTO> a = hotelService.getUrl();

        return a;
    }

}

