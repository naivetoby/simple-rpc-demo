package vip.toby.demo.client;

import com.alibaba.fastjson2.JSONObject;
import vip.toby.demo.entity.PlusDTO;
import vip.toby.rpc.annotation.RpcClient;
import vip.toby.rpc.annotation.RpcClientMethod;
import vip.toby.rpc.entity.RpcResult;
import vip.toby.rpc.entity.RpcType;

/**
 * @author toby
 */
@RpcClient(value = "rpc-queue-name", type = RpcType.SYNC)
public interface SyncClient {

	@RpcClientMethod
	RpcResult methodName1(String param1, int param2);

	@RpcClientMethod("methodName2-alias")
	RpcResult methodName2(String param1, int param2);

    @RpcClientMethod
    RpcResult methodName3(PlusDTO plusDTO, JSONObject data, int x, int y);

}
