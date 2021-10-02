package com.altshuler.JnetWorksTestTask.parser;

import com.altshuler.JnetWorksTestTask.reducer.StringPageReducer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageParser {
    private final StringPageReducer spr = new StringPageReducer();

    public String parseToReducedForm(String pageNumber) {
        String reduced = null;
        Pattern p = Pattern.compile("([1-9][0-9]*)(,[1-9][0-9]*)*");
        Matcher m = p.matcher(pageNumber);
        if (m.matches())
            reduced = spr.reduce(pageNumber);
        return reduced;
    }
}
