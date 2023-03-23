package com.demo.client;

import com.alibaba.fastjson2.JSONObject;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcClient;
import vip.toby.rpc.annotation.RpcClientMethod;
import vip.toby.rpc.entity.RpcResult;
import vip.toby.rpc.entity.RpcType;

/**
 * @author toby
 */
@RpcClient(value = "rpc-queue-name-other", type = RpcType.SYNC)
public interface OtherSyncClient {

    @RpcClientMethod
    RpcResult methodName3(PlusDTO plusDTO, JSONObject data, int x, int y);

}
