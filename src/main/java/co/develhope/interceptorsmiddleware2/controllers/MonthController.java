package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.entities.Month;
import co.develhope.interceptorsmiddleware2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    private MonthInterceptor monthInterceptor;

    @GetMapping("/{monthNumber}")
    public Month specificMonth (@PathVariable int monthNumber) {
        List<Month> months = monthInterceptor.getMonths();
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        return new Month(0, "null", "null", "null");
    }
}