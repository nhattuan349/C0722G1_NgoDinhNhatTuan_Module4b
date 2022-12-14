package com.md4_casestudy_furame.controller;

import com.md4_casestudy_furame.dto.IContractDetailDto;
import com.md4_casestudy_furame.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contract/v1")
public class RestContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<IContractDetailDto>> showAll(@PathVariable int id) {
        List<IContractDetailDto> list = iContractDetailService.showAll(id);

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
