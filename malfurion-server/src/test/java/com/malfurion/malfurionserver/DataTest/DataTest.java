package com.malfurion.malfurionserver.DataTest;

import com.malfurion.malfurionserver.common.utils.http.HttpUtils;
import com.malfurion.malfurionserver.system.service.impl.ArticleInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataTest {
    @Autowired
    ArticleInfoServiceImpl articleInfoService;

    @Test
    void insertData() {
        String s = HttpUtils.sendGet("http://localhost:8080/category", null, "utf-8");
        System.out.println(s);
    }
}
