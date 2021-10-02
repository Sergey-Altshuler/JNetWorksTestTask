package com.altshuler.JnetWorksTestTask.reducer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPageReducer {
    public String reduce(String pageNumbers) {
        StringBuilder reducedPages = new StringBuilder();
        String[] numbers = pageNumbers.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String num : numbers) {
            numberList.add(Integer.parseInt(num));
        }
        Collections.sort(numberList);
        boolean isRow = false;
        for (int i = 0; i < numberList.size(); i++) {
            if (i + 1 == numberList.size()) {
                reducedPages.append(numberList.get(i));
            } else {
                if (!isRow) {
                    if ((numberList.get(i + 1)) - 1 == numberList.get(i)) {
                        isRow = true;
                        reducedPages.append(numberList.get(i)).append("-");
                    } else reducedPages.append(numberList.get(i)).append(",");
                } else {
                    if (!((numberList.get(i + 1)) - 1 == numberList.get(i))) {
                        isRow = false;
                        reducedPages.append(numberList.get(i)).append(",");
                    }
                }
            }
        }
        return new String(reducedPages);
    }
}
