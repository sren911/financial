package com.sren.manager.controller;

import com.sren.entity.Product;
import com.sren.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        log.info("创建产品,参数:{}", product);

        Product result = productService.addProduct(product);

        log.info("创建产品,结果:{}", result);
        return result;
    }

    @ApiOperation(value = "查询产品", notes = "根据产品id查询产品")
    @GetMapping(value = "/{id}")
    public Product findOne(@PathVariable String id) {
        log.info("查询单个产品,id={}", id);
        Product product = productService.findOne(id);
        log.info("查询单个产品,结果={}", product);
        return product;
    }

    @GetMapping
    public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewardRate, String status,
                               @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        log.info("查询产品,ids={},minRewardRate={},maxRewardRate={},status,pageNum={},pageSize={}");
        List<String> idList = null, statusList = null;
        if (!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        if (!StringUtils.isEmpty(status)) {
            statusList = Arrays.asList(status.split(","));
        }

        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Product> page = productService.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
        log.info("查询产品,结果={}", page);
        return page;
    }
}
