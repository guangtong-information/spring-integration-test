package com.intergration.test.model.request.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
@ToString(callSuper = true)
public abstract class BaseRequest extends CommonRequest implements Serializable {
    private static final long serialVersionUID = 4928505579346898814L;

    /**
     * 应用编号
     */
    @Getter
    @Setter
    private String appName;

    /**
     * 跳进 integration 的渠道名
     */
    @Getter
    @Setter
    private String integrationChannel;
}
