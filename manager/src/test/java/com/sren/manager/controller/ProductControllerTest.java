package com.sren.manager.controller;

import com.sren.entity.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static RestTemplate restTemplate = new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    private static List<Product> normals = new ArrayList<>();

    @BeforeClass
    public static void init() {

    }

    @Test
    public void addProduct() {
    }
}