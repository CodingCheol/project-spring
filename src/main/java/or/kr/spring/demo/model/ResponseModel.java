package or.kr.spring.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok -> java 사용자는 많이 쓴다.
@Getter
@Setter
@Builder
public class ResponseModel {
    private Integer param1;
    private Integer param2;
    private Integer param3;
}
