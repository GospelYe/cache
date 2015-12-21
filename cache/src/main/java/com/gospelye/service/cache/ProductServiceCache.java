package com.gospelye.service.cache;

import com.gospelye.bean.Product;
import com.gospelye.service.ProductService;

import java.util.List;
import java.util.concurrent.*;

/**
 * Author: yewenhai.
 * Date: 15/12/21.
 * Time: 下午5:00.
 */
public class ProductServiceCache implements ProductService {

    private final ConcurrentHashMap<Integer, Future<Product>> cache = new ConcurrentHashMap<>();

    private final ProductService productService;

    public ProductServiceCache(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product queryProductById(int prdId) {
        Future<Product> future = cache.get(prdId);
        if(null == future) {
            FutureTask<Product> ft = new FutureTask<Product>(() -> {
                return productService.queryProductById(prdId);
            });
            future = cache.putIfAbsent(prdId, ft);
            if(null == future) {
                future = ft;
                ft.run();
            }
        }
        try {
            return future.get();
        } catch (InterruptedException e) {
            cache.remove(prdId, future);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> queryAllProduct() {
        return null;
    }
}
