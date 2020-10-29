package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private int companyId;//公司id
    private String companyName;// ofo 哈罗 摩拜
    private Bike[] bikes;//公司持有的单车
    private int sum;//公司单车的数量
    private int count;//公司单车借出的数量
}
