package org.luo.mybatisplus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class HelloController {

    private static final String template = ":Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Map index(@RequestParam(value = "name", defaultValue = "World") String name) {
        String s = String.format(template, name);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", counter.getAndIncrement());
        resultMap.put("msg", s);
        log.debug(s);
        log.info(s);
        log.warn(s);
        log.error(s);
        return resultMap;
    }

}
