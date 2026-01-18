package vip.toby.demo.server;

import org.springframework.validation.annotation.Validated;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.R;
import vip.toby.rpc.entity.RpcType;

/**
 * Server
 *
 * @author toby
 */
@RpcServer(name = "rpc-queue-name", type = {RpcType.SYNC, RpcType.ASYNC}, xMessageTTL = 1000, threadNum = 1)
public class Server {

    @RpcServerMethod
    public R methodName1(@Validated PlusDTO plusDTO) {
        final int x = plusDTO.getX();
        final int y = plusDTO.getY();
        return R.okResult(x + y);
    }

    @RpcServerMethod("methodName2-alias")
    public R methodName2(@Validated PlusDTO plusDTO) {
        return R.failMessage("计算失败").errorCode(-9999);
    }

}
