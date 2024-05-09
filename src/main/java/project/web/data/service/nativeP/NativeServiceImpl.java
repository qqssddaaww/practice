package project.web.data.service.nativeP;

import org.springframework.stereotype.Service;
import project.web.data.domain.Native;
import project.web.data.dto.LoginDTO;
import project.web.data.dto.LoginDTORequest;
import project.web.data.dto.NativeDTO;
import project.web.data.repository.NativeRepository;

@Service
public class NativeServiceImpl implements NativeService {
    private final NativeRepository nativeRepository;

    public NativeServiceImpl(NativeRepository nativeRepository) {
        this.nativeRepository = nativeRepository;
    }

    @Override
    public String insertNative(LoginDTORequest join) {
        nativeRepository.save(join.aNative());
        return "현지인 가입 성공";
    }

    @Override
    public Native login(LoginDTO loginDTO) {
        Native na = nativeRepository.findBynId(loginDTO.getId());
        boolean login = na.getNId().equals(loginDTO.getId()) && na.getNPw().equals(loginDTO.getPw());

        if (login) {
            return na;
        }
        return null;
    }

    @Override
    public boolean checkId(String id) {
        return nativeRepository.existsBynId(id);
    }

    @Override
    public boolean checkEmail(String email) {
        return nativeRepository.existsBynEmail(email);
    }

    @Override
    public boolean checkPhone(String phone) {
        return nativeRepository.existsBynPhone(phone);
    }
}
