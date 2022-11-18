package com.simple_dictionary_app.service.impl;

import com.simple_dictionary_app.service.IDistionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DistionaryService implements IDistionaryService {

    private static Map<String, String> distionary = new HashMap<>();

    static{
        distionary.put("hello", "xin chào");
        distionary.put("yellow", "màu vàng");
    }


    @Override
    public String search(String keyWord) {
        if (distionary.get(keyWord) == null){
            return "không tồn tại từ này trong từ điển";
        }else {
            return distionary.get(keyWord);
        }
    }
}
