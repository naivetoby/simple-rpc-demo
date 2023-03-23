package vip.toby.demo.server;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.validation.annotation.Validated;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.RpcType;
import vip.toby.rpc.entity.ServerResult;

/**
 * @author toby
 */
@RpcServer(value = "rpc-queue-name-other", type = RpcType.SYNC)
public class OtherServer {

    @RpcServerMethod
    public ServerResult methodName3(@Validated PlusDTO plusDTO) {
        int x = plusDTO.getX();
        int y = plusDTO.getY();
        JSONObject result = new JSONObject();
        result.put("x", x);
        result.put("y", y);
        result.put("result", x + y);
        return ServerResult.buildSuccessResult(result).message("ok");
    }

}
