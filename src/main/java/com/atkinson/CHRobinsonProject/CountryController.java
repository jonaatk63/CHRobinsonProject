package com.atkinson.CHRobinsonProject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{code}")
    public List<String> getRoute(@PathVariable String code) {
        return countryService.returnRoute(code);
    }

    @GetMapping("/")
    public String home() {
        return "Use: /{countryCode}, Ex: /PAN | All Codes: CAN, USA, MEX, BLZ, GTM, SLV, HND, NIC, CRI, PAN";
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> invalidCode() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid code, try again. Valid codes: CAN, USA, MEX, BLZ, GTM, SLV, HND, NIC, CRI, PAN");
    }
}
