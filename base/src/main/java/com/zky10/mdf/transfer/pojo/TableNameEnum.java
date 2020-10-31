package com.zky10.mdf.transfer.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 11:32
 * @Description:
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TableNameEnum {

    BD_HY("BD_HY");

    private String name;

    public static TableNameEnum getInstanceByName(String name) {
        for (TableNameEnum reportStatusEnum : TableNameEnum.values()) {
            if (reportStatusEnum.getName().equals(name)) {
                return reportStatusEnum;
            }
        }
        return null;
    }

}
