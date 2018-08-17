package com.example.jpatest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ezreal
 */
@Entity
@Table(name = "report_asin")
public class ReportAsin {

    @Id
    @GeneratedValue
    private Integer id;
    private String campaignName;
    private Integer campaignId;
    @Column(length = 128)
    private String adGroupName;

    private Integer adGroupId;
    private Integer keywordId;
    @Column(length = 128)
    private String keywordText;
    @Column(length = 64)
    private String asin;
    @Column(length = 64)
    private String otherAsin;
    @Column(length = 64)
    private String sku;
    @Column(length = 64)
    private String currency;
    @Column(length = 128)
    private String matchType;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedSales1dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedUnitsOrdered30dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedSales30dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedUnitsOrdered14dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedSales14dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedUnitsOrdered7dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedSales7dOtherSKU;
    @Column(precision = 10, scale = 2)
    private BigDecimal attributedUnitsOrdered1dOtherSKU;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "marketplace")
    private String marketplace;

    @Column(name = "marketplace_id")
    private String marketplaceId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private Integer updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;
    @Column(length = 255)
    private String ext;
    @Column(length = 255)
    private String remark;
}
