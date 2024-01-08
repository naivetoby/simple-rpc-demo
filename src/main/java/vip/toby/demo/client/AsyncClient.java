package vip.toby.demo.client;

import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcClient;
import vip.toby.rpc.annotation.RpcClientMethod;
import vip.toby.rpc.entity.RpcType;

/**
 * AsyncClient
 *
 * @author toby
 */
@RpcClient(value = "rpc-queue-name", type = RpcType.ASYNC)
public interface AsyncClient {

    @RpcClientMethod
    void methodName1(PlusDTO plusDTO);

    @RpcClientMethod("methodName2-alias")
    void methodName2(PlusDTO plusDTO);

}
