package com.xcy.wolf.base;

import lombok.*;

import javax.persistence.*;

/**
 * @author xcy
 * @date 2018/09/10 17:13
 * @description 查询基础对象
 * @since V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class BaseEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer page = 1;

    /**layerUI查询时候要求传limit,而不是rows**/
    @Transient
    private Integer limit = 3;

}
