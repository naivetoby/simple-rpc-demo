package vip.toby.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import vip.toby.demo.entity.DelayPlusDTO;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.R;
import vip.toby.rpc.entity.RpcType;

/**
 * @author toby
 */
@RpcServer(name = "delay-plus", type = RpcType.DELAY)
@Slf4j
public class DelayPlusServer {

    @RpcServerMethod
    public R delayPlus(@Validated DelayPlusDTO delayPlusDTO) {
        final int x = delayPlusDTO.getX();
        final int y = delayPlusDTO.getY();
        final int delay = delayPlusDTO.getDelay();
        final long createTime = delayPlusDTO.getCreateTime();
        final long now = System.currentTimeMillis();
        log.info("delayPlusDTO: {}, result: {}, delay: {}, duration: {}", delayPlusDTO, x + y, delay, now - createTime);
        return R.ok();
    }

}
