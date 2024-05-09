package project.web.data.service.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.web.data.domain.User;
import project.web.data.dto.LoginDTO;
import project.web.data.dto.MyPageUserDTO;
import project.web.data.dto.LoginDTORequest;
import project.web.data.dto.UpdatePwDTO;
import project.web.data.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    유효성 검사, 매개변수 id 랑 같은 id가 db에 이있으면 true 리턴 -> 오류 발생
    @Override
    public boolean checkId(String id) {
        return userRepository.existsByuId(id);
    }
    //    유효성 검사, 매개변수 email 랑 같은 email가 db에 이있으면 true 리턴 -> 오류 발생
    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByuEmail(email);
    }
    //    유효성 검사, 매개변수 phone 랑 같은 phone이 db에 이있으면 true 리턴 -> 오류 발생
    @Override
    public boolean checkPhone(String phone) {
        return userRepository.existsByuPhone(phone);
    }

    @Override
    public String insertUser(LoginDTORequest userDTO) {
        String securityPw = encoder.encode(userDTO.getPw());
        userDTO.setPw(securityPw);
        userRepository.save(userDTO.user());

        return "회원가입성공";
    }

    @Override
    public User login(LoginDTO LoginDTO) {
        User user = userRepository.findByuId(LoginDTO.getId());
        if(encoder.matches(LoginDTO.getPw(),user.getUPw())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> getAll = new ArrayList<>();
        getAll.addAll(userRepository.findAll());

        return getAll;
    }

    @Override
    public MyPageUserDTO getUserInfo(String id) {
        return userRepository.findById(id);
    }

    @Override
    public String updatePw(UpdatePwDTO updatePwDTO, String id) {
        if(userRepository.existsByuId(id)) {
            User user = userRepository.findByuId(id);
            if(user.getUPw().equals(updatePwDTO.getOldPw())) {
                user.setUPw(updatePwDTO.getNewPw());
                userRepository.save(user);
                return "변경완료";
            }
            else {
                return "현재 비밀번호가 같지 않습니다";
            }
        }
        return null;
    }

    @Override
    public User getUser(String id) {
        return userRepository.findByuId(id);
    }
}
