package project.web.data.service.NativePage;

import org.springframework.stereotype.Service;
import project.web.data.repository.NativePageRepository;

@Service
public class NativePageImpl implements NativePageService{

    private final NativePageRepository nativePageRepository ;

    public NativePageImpl(NativePageRepository nativePageRepository) {
        this.nativePageRepository = nativePageRepository;
    }


}
