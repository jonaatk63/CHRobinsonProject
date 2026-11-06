package com.atkinson.CHRobinsonProject;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;


@Service
public class CountryService {

    private static final Map<String, List<String>> borderGrouping = Map.of(
            "CAN", List.of("USA", "CAN"),
            "USA", List.of("USA"),
            "MEX", List.of("USA", "MEX"),
            "BLZ", List.of("USA", "MEX", "BLZ"),
            "GTM", List.of("USA", "MEX", "GTM"),
            "SLV", List.of("USA", "MEX", "GTM", "SLV"),
            "HND", List.of("USA", "MEX", "GTM", "HND"),
            "NIC", List.of("USA", "MEX", "GTM", "HND", "NIC"),
            "CRI", List.of("USA", "MEX", "GTM", "HND", "NIC", "CRI"),
            "PAN", List.of("USA", "MEX", "GTM", "HND", "NIC", "CRI", "PAN")

    );

    public List<String> returnRoute(String code) {
        String codeTrimmed = code.trim().toUpperCase();
        if (!borderGrouping.containsKey(codeTrimmed)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid code");
        }
        return borderGrouping.get(codeTrimmed);
    }




}
