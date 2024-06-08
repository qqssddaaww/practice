package project.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import project.web.data.domain.Native;
import project.web.data.domain.User;
import project.web.data.dto.LoginDTO;
import project.web.data.dto.LoginDTORequest;
import project.web.data.service.nativeP.NativeService;
import project.web.data.service.user.UserService;
import java.util.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final NativeService nativeService;
    private final HttpServletRequest request;

    @PostMapping(value = "/login")
    public boolean login(@RequestBody LoginDTO LoginDTO) {
        HttpSession session = request.getSession();

//        user에서 login을 처리했을 때 로그인이 되면 true를 반환 실패하면 false를 반환
        boolean loginU = userService.login(LoginDTO);
//      user 와 현지인이 로그인할 때
        if (loginU) {
//            로그인 성공 시 user 정보를 가져와 session에 저장
            User user = userService.getUser(LoginDTO.getId());
            session.setAttribute("id", LoginDTO.getId());
            session.setAttribute("name", user.getUName());
            session.setAttribute("native", "0");
            return true;
        } else {
//            위와 같이 native도 같음
            boolean loginN = nativeService.login(LoginDTO);
            if (loginN) {
//                로그인 성공 시 native 정보를 가져와 session에 저장
                Native aNative = nativeService.getNative(LoginDTO.getId());
                session.setAttribute("id", LoginDTO.getId());
                session.setAttribute("name", aNative.getNName());
                session.setAttribute("native", "1");
                return true;
            } else {
                // user 와 native 모두 로그인 실패시 처리
               return false;
            }
        }
    }

    @PostMapping("/session")
    public Map<String, String> checkSession() {
        HttpSession session = request.getSession();
        Map<String, String> loginInfo = new HashMap<>();

        if (session.getAttribute("id") != null) {
            //  해당 session 을 map 에 담아 리턴 해준다.
            loginInfo.put("id", (String)session.getAttribute("id"));
            loginInfo.put("name", (String)session.getAttribute("name"));
            loginInfo.put("native",(String) session.getAttribute("native"));
            return loginInfo;
        } else {
            return null;
        }
    }


    @PostMapping(value = "/join")
    public String join(@Valid @RequestBody LoginDTORequest info, BindingResult bindingResult) {
// 유효성 검사 -> id , email, phone( 유니크 키로 구성 되어있음 )
        if(userService.checkId(info.getId()) || nativeService.checkId(info.getId())) {
            bindingResult.addError(new FieldError("user","id","중복된 아이디가 있습니다."));
        }
        if(userService.checkEmail(info.getEmail()) || nativeService.checkEmail(info.getEmail())){
            bindingResult.addError(new FieldError("user","email","중복된 이메일이 있습니다."));
        }
        if(userService.checkPhone(info.getPhone()) || nativeService.checkPhone(info.getPhone())) {
            bindingResult.addError(new FieldError("user","phone","중복된 전화번호가 있습니다."));
        }

        if (bindingResult.hasErrors()) {
            if(bindingResult.getFieldErrorCount() == 1) {
//              단일 오류일 시
                return bindingResult.getFieldError().getDefaultMessage();
            } else {
//              단일 오류가 아닌 오류가 여러개 일때
                StringBuilder errors = new StringBuilder();
                List<ObjectError> allErrors = bindingResult.getAllErrors();
                for (ObjectError error : allErrors) {
                    errors.append(error.getDefaultMessage()).append("\n");
                }
                return errors.toString();
            }
        }
//      야매로 LoginDTORequest에 location 정보가 없으면 user 저장, 정보가 있으면 native 저장 
        if(info.getLocation() == null) {
            userService.insertUser(info);
            return "유저 가입 성공";
        } else {
            nativeService.insertNative(info);
            return "현지인 가입 성공";
        }
    }

    @GetMapping(value = "/logout")
    public String logout() {
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        session.removeAttribute("name");
        session.removeAttribute("native");
        return "로그아웃";
    }


}
