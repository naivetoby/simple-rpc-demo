package vip.toby.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import vip.toby.demo.entity.DelayPlusDTO;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.RpcType;
import vip.toby.rpc.entity.ServerResult;

/**
 * @author toby
 */
@RpcServer(value = "delay-plus", type = RpcType.DELAY)
@Slf4j
public class DelayPlusServer {

    @RpcServerMethod
    public ServerResult delayPlus(@Validated DelayPlusDTO delayPlusDTO) {
        final int x = delayPlusDTO.getX();
        final int y = delayPlusDTO.getY();
        final int delay = delayPlusDTO.getDelay();
        final long createTime = delayPlusDTO.getCreateTime();
        final long now = System.currentTimeMillis();
        log.info("delayPlusDTO: {}, result: {}, delay: {}, duration: {}", delayPlusDTO, x + y, delay, now - createTime);
        return ServerResult.buildSuccess();
    }

}
