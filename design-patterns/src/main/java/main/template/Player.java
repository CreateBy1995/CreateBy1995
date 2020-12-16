package main.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String playerName;
    private Integer ticket;
}
