package com.ezreal.category;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CouponCategoryDO {
    private String key;
    private List<CouponCategoryDO> values;

    public CouponCategoryDO() {
    }

    public CouponCategoryDO(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<CouponCategoryDO> getValues() {
        return values;
    }

    public void setValues(List<CouponCategoryDO> values) {
        this.values = values;
    }

    public static void main(String[] args) {
        List<CouponCategoryDO> list = new LinkedList<>();
        CouponCategoryDO couponCategoryDO1 = new CouponCategoryDO();
        couponCategoryDO1.setKey("4");
        couponCategoryDO1.setValues(Arrays.asList(new CouponCategoryDO("401"), new CouponCategoryDO("402")));

        CouponCategoryDO couponCategoryDO2 = new CouponCategoryDO();
        couponCategoryDO2.setKey("5");
        couponCategoryDO2.setValues(Arrays.asList(new CouponCategoryDO("501"), new CouponCategoryDO("503")));

        list.add(couponCategoryDO1);
        list.add(couponCategoryDO2);
        CouponCategoryArr couponCategoryArr = new CouponCategoryArr();
        couponCategoryArr.setList(list);
        String data = JSON.toJSONString(couponCategoryArr);
        System.out.println(data);
        CouponCategoryArr cca = JSON.parseObject(data, CouponCategoryArr.class);
        System.out.println(cca);
    }
}
