package com.gospelye.service.impl;

import com.gospelye.bean.Product;
import com.gospelye.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品serviceImpl
 * Author: yewenhai.
 * Date: 15/12/21.
 * Time: 下午4:58.
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public Product queryProductById(int prdId) {
        return new Product();
    }

    @Override
    public List<Product> queryAllProduct() {
        List<Product> prds = new ArrayList<>();
        prds.add(new Product());

        return prds;
    }
}
