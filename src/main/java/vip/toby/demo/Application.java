package vip.toby.demo;

import com.demo.client.OtherSyncClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.toby.demo.client.AsyncClient;
import vip.toby.demo.client.DelayClient;
import vip.toby.demo.client.SyncClient;
import vip.toby.demo.entity.DelayPlusDTO;
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

    private final AsyncClient asyncClient;
    private final SyncClient syncClient;
    private final OtherSyncClient otherSyncClient;
    private final DelayClient delayClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void test() {
        new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }

            // 同步调用 1
            final PlusDTO plusDTO = new PlusDTO();
            plusDTO.setX(1);
            plusDTO.setY(1);
            RpcResult rpcResult = syncClient.methodName1(plusDTO);
            log.info("syncClient.methodName1, RStatusOk: {}, RResult: {}", rpcResult.isRStatusOk(), rpcResult.getRResult());

            // 同步调用 1-1
            plusDTO.setX(0);
            rpcResult = syncClient.methodName1(plusDTO);
            log.info("syncClient.methodName1, RStatusOk: {}, ErrorMessage: {}, ErrorCode: {}", rpcResult.isRStatusOk(), rpcResult.getResult()
                    .getMessage(), rpcResult.getResult().getErrorCode());

            // 同步调用 2
            plusDTO.setX(2);
            rpcResult = syncClient.methodName2(plusDTO);
            log.info("syncClient.methodName2, RStatusOk: {}, ErrorMessage: {}, ErrorCode: {}", rpcResult.isRStatusOk(), rpcResult.getResult()
                    .getMessage(), rpcResult.getResult().getErrorCode());

            // 异步调用
            asyncClient.methodName2(plusDTO);

            // 同步调用 3
            rpcResult = otherSyncClient.methodName3(plusDTO);
            log.info("otherSyncClient.methodName3, RStatusOk: {}, RResult: {}", rpcResult.isRStatusOk(), rpcResult.getRResult());

            // 延迟调用, 注意⚠️ RabbitMQ 需要启用插件 https://github.com/rabbitmq/rabbitmq-delayed-message-exchange
            final DelayPlusDTO delayPlusDTO = new DelayPlusDTO();
            delayPlusDTO.setCreateTime(System.currentTimeMillis());
            // 延迟 3 秒后调用
            delayPlusDTO.setDelay(3000);
            delayPlusDTO.setX(5);
            delayPlusDTO.setY(8);
            delayClient.delayPlus(delayPlusDTO);

        }).start();
    }

}
