package vip.toby.demo;

import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.toby.demo.client.AsyncClient;
import vip.toby.demo.client.SyncClient;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.EnableSimpleRpc;
import vip.toby.rpc.entity.RpcResult;

/**
 * Application
 *
 * @author toby
 */
@EnableSimpleRpc
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Application {

    private final SyncClient syncClient;
    private final AsyncClient asyncClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void test() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            syncClient.methodName1("param1", 2);
            syncClient.methodName1("param1", 2);
            syncClient.methodName1("dew", 46);
            PlusDTO plusDTO = new PlusDTO();
            plusDTO.setX(1);
            plusDTO.setY(1);
            JSONObject data = new JSONObject();
            data.put("x", 2);
            data.put("y", 2);
            RpcResult rpcResult = syncClient.methodName3(plusDTO, data, 3, 3);
            log.info("result: {}", rpcResult.getServerResult().getResult());
            syncClient.methodName1("yyy", 2121);
            asyncClient.methodName2("sss", 27);
        }).start();
    }

}
