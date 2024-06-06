package project.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.web.data.domain.Native;
import project.web.data.domain.Room;
import project.web.data.dto.NpInsertDTO;
import project.web.data.dto.RegisterRoomDTO;
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
@RequestMapping("/native")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class NativeController {

    private final HotelService hotelService;
    private final NativePageService nativePageService;
    private final NativeService nativeService;
    private final RoomService roomService;
    private static final String UPLOAD_DIR = "./uploads/";

    //   중복되는 세션관련해서 메서드 하나 만듬, id를 가져오는 메서드
    public String sessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        return id;
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

    @PostMapping(value = "/get-room")
    public List<Room> getAllRoom(@RequestParam Long hNum) {
        return roomService.getAll(hNum);
    }

//    현지인이 자신의 상품(호텔의 방)을 삽입하는 메서드
    @PostMapping(value = "/insert-room")
    public String insertRoom(@RequestBody NpInsertDTO npInsertDTO, HttpServletRequest request, Long rNum) {
        String id = sessionId(request);
//        로그인 정보가 없다면 오류(문자열)을 리턴
        if(id == null) {
            return "로그인 정보가 없습니다.";
        } else {
//            해당 방에 대한 상품을 등록하기 위해 방에 대한 정보를 rNum을 이용하여 가져온다.
            Room room = roomService.getOneRoom(rNum);
//            session 정보를 가져와 자신의 정보를 가져옴
            Native aNative = nativeService.getNative(id);
            nativePageService.insertNativePage(npInsertDTO, aNative, room);
        }
        return "작성 성공";
    }

//    상품의 내용을 변경하는 메서드, 5.17기준 만들어야함
    @PostMapping(value = "/update")
    public String update(@RequestBody NpInsertDTO npInsertDTO,HttpServletRequest request) {
        String id = sessionId(request);
//        로그인정보로 자신의 정보를 가져옴
        Native aNative = nativeService.getNative(id);
//        업데이트할 내용이 담긴 npInsertDTO 와 변경하기위해 자신의 정보를 넘김
        nativePageService.updatePage(npInsertDTO, aNative);
        return "수정 성공";
    }

//    자신(로그인한 현지인)이 올린 상품의 정보를 가져오는 매핑. 
//    현재 호텔이름, 방 가격, 올린상품식별번호, 호텔 사진, 상품 등록일을 가져오고있음
    @PostMapping(value = "/register-room")
    public List<RegisterRoomDTO> getRegisterRoom(HttpServletRequest request) {
        String id = sessionId(request);
//        로그인정보로 자신의 정보를 가져옴
        Native aNative = nativeService.getNative(id);
//        자신의 정보를 nativePageService에 넘겨 자신이 작성한 상품에 대한 정보를 가져옴
        List<RegisterRoomDTO> registerRoomDTOS = nativePageService.getRegisterRoom(aNative);

        return registerRoomDTOS;
    }
}

