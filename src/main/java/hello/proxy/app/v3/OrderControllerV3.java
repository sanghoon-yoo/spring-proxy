package hello.proxy.app.v3;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    @Autowired
    OrderControllerV2 orderControllerV2;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/v3/request")
    public String request(String itemId) {
        System.out.println(orderControllerV2.getClass());
        orderService.orderItem(itemId);
        return "OK";
    }

    @GetMapping("/v3/no-log")
    public String noLog() {
        return "OK";
    }
}
