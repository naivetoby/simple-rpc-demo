package vip.toby.demo.entity;

import lombok.Data;
import vip.toby.rpc.annotation.RpcDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@RpcDTO
public class PlusDTO {

    @NotNull
    @Min(1)
    private int x;
    private int y;

}
