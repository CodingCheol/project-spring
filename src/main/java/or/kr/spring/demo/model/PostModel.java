package or.kr.spring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostModel {
    private String param1;
    private List<Integer> param2;
}
