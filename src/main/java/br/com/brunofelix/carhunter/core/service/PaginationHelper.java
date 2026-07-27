package br.com.brunofelix.carhunter.core.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class PaginationHelper {

    private static final int MAX_PAGES = 100;

    public <T> List<T> fetchAll(IntFunction<List<T>> pageFetcher, Predicate<T> filter) {
        List<T> allItems = new ArrayList<>();
        int pageIndex = 1;
        while (pageIndex <= MAX_PAGES) {
            List<T> items = pageFetcher.apply(pageIndex);
            if (items.isEmpty()) break;
            allItems.addAll(items.stream().filter(filter).collect(Collectors.toList()));
            pageIndex++;
        }
        return allItems;
    }
}
