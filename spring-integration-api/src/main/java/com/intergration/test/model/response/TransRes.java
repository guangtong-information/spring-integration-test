package com.intergration.test.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
@Data
@ToString
public class TransRes implements Serializable {
    private static final long serialVersionUID = -627826506388299574L;
    private List<String> drinkName;//饮料名称
    private Boolean isComplete;//饮料名称
}
