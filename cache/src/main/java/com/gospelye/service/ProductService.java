package com.gospelye.service;

import com.gospelye.bean.Product;

import java.util.List;

/**
 * 产品操作接口
 * Author: yewenhai.
 * Date: 15/12/21.
 * Time: 下午4:53.
 */
public interface ProductService {

    /**
     * 根据产品ID查询单个产品
     * @param prdId 产品ID
     * @return 产品信息
     */
    Product queryProductById(int prdId);

    /**
     * 查询全部产品
     * @return 产品集合
     */
    List<Product> queryAllProduct();


}
