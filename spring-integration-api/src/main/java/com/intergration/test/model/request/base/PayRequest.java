package com.intergration.test.model.request.base;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
@Data
@ToString(callSuper = true)
public class PayRequest extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 4928505579346698814L;


    private List<Order> orders;
}
