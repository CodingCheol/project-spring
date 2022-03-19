package or.kr.spring.demo.controller;

import or.kr.spring.demo.model.PostModel;
import or.kr.spring.demo.model.RequestModel;
import or.kr.spring.demo.model.ResponseModel;
import or.kr.spring.demo.service.SpringService;
import org.springframework.web.bind.annotation.*;

// RestAPI -> CRUD HttpMethod
// RestFullAPI -> URI와 더불어 CRUD HttpMethod 이용한 작업이 정확하게 이뤄져야지 RestFull
// HttpMethod  -> GET:조회(R) / POST:생성(C) / PATCH:부분 업데이트(U) / PUT:전체 업데이트(U) / DELETE:삭제(D)
// PATCH, PUT 의 차이 -> Table(a,b,c) -> PATCH 로 요청 : a 만 바꿔도 됨.,전체를 바꿀 수 있다.  or 2개이상을 바꿀때 사용할 수도 있다.
//                                     PUT 으로 요청 : a, b, c 를 전부를 바꿀때 사용한다. or 2개이상을 바꿀때 사용할 수도 있다. (규칙)
// GET 주면 -> 암호화가 안된다고 합니다. Why? URL parameter 가 노출이 되어있는 형태니깐. payload 라는 request body를 사용하기에 부적절한 Http Method.
// POST,PATCH,PUT,DELETE -> 데이터 정보가 Request Body (Payload)에 던져짐. ===> 모든 데이터가 Byte 형식으로 던져짐. -> 안녕 나는 다은이야. -> B9435bddfsf23jkdfj138r
@RestController //RestAPI 사용시에 많이 사용하는 Controller 형태 Why? @ResponseBody 를 지울 수 있어. view까지 안가고 내 응답을 HttpServletResponse 으로 바로 처리해줘
@RequestMapping("/api")
public class SpringController{

    private final SpringService springService;

    public SpringController(SpringService springService) {
        this.springService = springService;
    }

    /**
        //DispatchServlet -> Controller Mapping
        // 아래의 메소드 사용. (형식의 맞춰서 요청에 대한  값 넣어주고.)
        ResponseModel ss = test(1,2,3);
        // 응답(ResponseModel)을 `HttpServletResponse` 로 자동으로 랩핑해서 응답값으로 던짐.
    */
    //Request -> localhost:9090/api/test?a=2&b=3&c=4
    /*
    Controller 로 사용
    @RequestMapping("/test")
    public @ResponseBody ResponseModel test(
            @RequestParam(value = "a") Integer param1, // 2
            @RequestParam(value = "b") Integer param2, // 3
            @RequestParam(value = "c") Integer param3 // 4
    ){
        RequestModel request = RequestModel.builder()
                .param1(param1)
                .param2(param2)
                .param3(param3)
                .build();
        ResponseModel response = springService.test(request);
        return response;
    }
    */
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    @PostMapping("/test")
//    @PatchMapping("/test")
    @GetMapping("/test")
    public ResponseModel test(
            @ModelAttribute RequestModel request
    ){
        return springService.test(request);
    }
    @PostMapping("/test2")
    public String test2(
            @RequestBody String request
    ){
        return springService.test2(request);
    }
    @PostMapping("/test3")
    public PostModel test3(
            @RequestBody PostModel request
    ){
        return springService.test3(request);
    }

}
