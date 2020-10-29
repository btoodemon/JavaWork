package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
    private int bid;//单车编号
    private String bname;//单车名称
    private int status;//单车状态 0 已借出 1可借出
    private String borrowTime;//单车借出时间 默认为""

}
