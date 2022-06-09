package vip.toby.demo.client;

import vip.toby.rpc.annotation.RpcClient;
import vip.toby.rpc.annotation.RpcClientMethod;
import vip.toby.rpc.entity.RpcType;

/**
 * @author toby
 */
@RpcClient(value = "rpc-queue-name", type = RpcType.ASYNC)
public interface AsyncClient {

    @RpcClientMethod
    void methodName1(String param1, int param2);

    @RpcClientMethod("methodName2-alias")
    void methodName2(String param1, int param2);

}
