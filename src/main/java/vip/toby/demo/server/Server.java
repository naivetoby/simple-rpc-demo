package vip.toby.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import vip.toby.demo.entity.BizCode;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.R;
import vip.toby.rpc.entity.RpcType;

import java.util.Map;

/**
 * Server
 *
 * @author toby
 */
@RpcServer(name = "rpc-queue-name", type = {RpcType.SYNC, RpcType.ASYNC}, xMessageTTL = 1000, threadNum = 1, partitionNum = 4)
@Slf4j
public class Server {

    @RpcServerMethod
    public R methodName1(@Validated PlusDTO plusDTO) {
        final int x = plusDTO.getX();
        final int y = plusDTO.getY();
        return R.okResult(x + y);
    }

    @RpcServerMethod("methodName2-alias")
    public R methodName2(@Validated PlusDTO plusDTO) {
        return R.build(BizCode.PLUS_ERROR).detail(Map.of("plusDTO", plusDTO.toString(), "message", "methodName2-alias"));
    }

    @RpcServerMethod
    public R methodName3(@Validated PlusDTO plusDTO) {
        final int x = plusDTO.getX();
        final int y = plusDTO.getY();
        final long start = System.currentTimeMillis();
        log.info("async partition methodName3 start, x: {}, y: {}, thread: {}", x, y, Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("async partition methodName3 interrupted, x: {}, y: {}", x, y);
        }
        log.info("async partition methodName3 end, x: {}, y: {}, result: {}, cost: {}", x, y, x + y, System.currentTimeMillis() - start);
        return R.ok();
    }

}
