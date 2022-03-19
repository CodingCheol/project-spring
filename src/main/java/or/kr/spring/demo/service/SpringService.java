package or.kr.spring.demo.service;

import or.kr.spring.demo.model.PostModel;
import or.kr.spring.demo.model.RequestModel;
import or.kr.spring.demo.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public class SpringService {

    //RequestModel -> ResponseModel 만드는 역할
    public ResponseModel test(RequestModel model){
        /*
            Integer param1 = model.getParam1()
            Integer param2 = model.getParam2();
            Integer param3 = model.getParam3();

            ResponseModel response = new ResponseModel();
            response.setParam1(param1);
            response.setParam2(param2);
            response.setParam3(param3);
            return response;
        */

        return ResponseModel.builder()
                .param1(model.getParam1())
                .param2(model.getParam2())
                .param3(model.getParam3())
                .build();
    }
    public String test2(String request){
        return request;
    }
    public PostModel test3(PostModel request){
        return request;
    }

}
