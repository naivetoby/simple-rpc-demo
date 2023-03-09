package vip.toby.demo.entity;

import lombok.Data;
import vip.toby.rpc.annotation.RpcDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
@RpcDTO
public class PlusDTO {

    @NotNull
    @Min(1)
    private int x;
    private int y;

}
