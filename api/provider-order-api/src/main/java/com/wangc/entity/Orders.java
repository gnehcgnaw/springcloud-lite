package com.wangc.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gnehcgnaw
 * @since 2018-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    private BigDecimal money;

    private String receiverAddress;

    private String receiverName;

    private String receiverPhone;

    private Integer payState;

    private LocalDateTime orderTime;

    private Long userId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
