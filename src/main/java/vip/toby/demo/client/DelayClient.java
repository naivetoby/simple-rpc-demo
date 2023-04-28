package vip.toby.demo.client;

import vip.toby.demo.entity.DelayPlusDTO;
import vip.toby.rpc.annotation.RpcClient;
import vip.toby.rpc.annotation.RpcClientMethod;
import vip.toby.rpc.entity.RpcType;

/**
 * @author toby
 */
@RpcClient(value = "delay-plus", type = RpcType.DELAY)
public interface DelayClient {

    @RpcClientMethod
    void delayPlus(DelayPlusDTO delayPlusDTO);

}
