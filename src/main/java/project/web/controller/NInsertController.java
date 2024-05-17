package project.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.web.data.domain.Hotel;
import project.web.data.domain.Native;
import project.web.data.domain.Room;
import project.web.data.dto.NpInsertDTO;
import project.web.data.service.NativePage.NativePageService;
import project.web.data.service.hotel.HotelService;
import project.web.data.service.nativeP.NativeService;
import project.web.data.service.room.RoomService;

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
    private final NativePageService nativePageService;
    private final NativeService nativeService;
    private final RoomService roomService;
    private static final String UPLOAD_DIR = "./uploads/";

    public NInsertController(HotelService hotelService, NativePageService nativePageService, NativeService nativeService, RoomService roomService) {
        this.hotelService = hotelService;
        this.nativePageService = nativePageService;
        this.nativeService = nativeService;
        this.roomService = roomService;
    }

    @PostMapping(value = "/upload-img")
    public String uploadImg(List<MultipartFile> files, @RequestParam Long hNum) {
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
                    urlName.add("" + path);
                } else{
                    path = Paths.get(UPLOAD_DIR + files.get(i).getOriginalFilename());
                    urlName.add("" + path);
                }
                Files.copy(files.get(i).getInputStream(), path);
            }

            hotelService.insertHotelPic(urlName, hNum);

            return "업로드 성공";

        } catch (Exception e) {
            e.printStackTrace();
            return "업로드 에러 " + e.getMessage();
        }
    }

//    현지인이 자신의 상품(호텔의 방)을 삽입하는 메서드
    @PostMapping(value = "/insert-room")
    public String insertRoom(@RequestBody NpInsertDTO npInsertDTO, HttpServletRequest request, Long rNum) {
        HttpSession session = request.getSession();
        if(session.getAttribute("id") == null) {
            return "로그인 정보가 없습니다.";
        } else {
            String id = (String) session.getAttribute("id");
//        session 정보를 가져와 자신의 정보를 가져옴
            Room room = roomService.getOneRoom(rNum);
            Native aNative = nativeService.getNative(id);

            nativePageService.insertNativePage(npInsertDTO, aNative, room);
        }


        return "작성 성공";
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody NpInsertDTO npInsertDTO) {

        return "수정 성공";
    }


}

