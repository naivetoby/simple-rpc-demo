package vip.toby.demo.server;

import com.alibaba.fastjson2.JSONObject;
import vip.toby.rpc.annotation.RpcServer;
import vip.toby.rpc.annotation.RpcServerMethod;
import vip.toby.rpc.entity.RpcType;
import vip.toby.rpc.entity.ServerResult;

/**
 * @author toby
 */
@RpcServer(value = "rpc-queue-name", type = {RpcType.SYNC, RpcType.ASYNC})
public class Server {

    @RpcServerMethod
    public ServerResult methodName1(JSONObject params) {
        String param1 = params.getString("param1");
        int param2 = params.getIntValue("param2");
        JSONObject result = new JSONObject();
        result.put("param1", param1);
        result.put("param2", param2);
        result.put("result", param1 + param2);
        return ServerResult.buildSuccessResult(result).message("ok");
    }

    @RpcServerMethod("methodName2-alias")
    public ServerResult methodName2(JSONObject params) {
        return ServerResult.buildFailureMessage("失败").errorCode(233);
    }

}
