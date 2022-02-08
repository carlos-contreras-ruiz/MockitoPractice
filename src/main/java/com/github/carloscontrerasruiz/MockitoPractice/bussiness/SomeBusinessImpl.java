package com.github.carloscontrerasruiz.MockitoPractice.bussiness;

import com.github.carloscontrerasruiz.MockitoPractice.service.SomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SomeBusinessImpl {

    @Autowired
    SomeDataService someDataService;
    
    public int calculateSum(int[] data){
        if (data == null){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public int calculateSumWithStream(int[] data){
        if (data == null){
            return 0;
        }
        return Arrays.stream(data)
                .reduce(0,Integer::sum);

//        return Arrays.stream(data)
//                .reduce(0, (acc, ele) -> acc + ele);
    }

    public int calculateSumUsingService(){
        int[] data = someDataService.retrieveAllData();
        if (data == null){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
