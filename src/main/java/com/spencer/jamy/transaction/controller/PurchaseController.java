package com.spencer.jamy.transaction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/purchase")
public class PurchaseController {

    @PostMapping()
    public ResponseEntity handlePurchasePost(){
        return null;
    }
}
