package com.sren.manager.service;

import com.sren.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    /**
     * 创建产品
     * @param product
     * @return
     */
    Product addProduct(Product product);

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    Product findOne(String id);

    /**
     * 分页查询产品
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    Page<Product> query(List<String> idList,
                        BigDecimal minRewardRate, BigDecimal maxRewardRate,
                        List<String> statusList,
                        Pageable pageable);
}
