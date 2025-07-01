package com.example.Simone.client;

import com.example.Simone.model.CatFact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cat-client", contextId = "catFeignClient", url = "${cat-path}")
public interface CatFactClient {
    @GetMapping(path = "/fact")
    ResponseEntity<CatFact> getCatFact();
}
