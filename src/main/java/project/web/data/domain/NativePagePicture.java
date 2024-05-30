package project.web.data.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NativePagePicture {

    @Id
    @Column(name = "papic_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paPicNum;

    @Column(name = "papic_url")
    private String paPicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pa_num")
    @JsonManagedReference
    private NativePage nativePage;
}
