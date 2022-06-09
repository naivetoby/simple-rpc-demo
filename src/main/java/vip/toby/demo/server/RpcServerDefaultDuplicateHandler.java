package vip.toby.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vip.toby.rpc.server.RpcServerBaseHandlerInterceptor;

@Component
@Slf4j
public class RpcServerDefaultDuplicateHandler extends RpcServerBaseHandlerInterceptor {

    @Override
    public boolean rpcDuplicateHandle(String method, String correlationId) {
        // log.info("rpcDuplicateHandle...method: {}, correlationId: {}", method, correlationId);
        return false;
    }

    @Override
    public boolean duplicateHandle(String method, Object data) {
        // log.info("duplicateHandle...method: {}, data: {}", method, data);
        return false;
    }

}
