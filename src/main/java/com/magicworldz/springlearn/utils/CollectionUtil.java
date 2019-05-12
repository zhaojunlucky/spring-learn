package com.magicworldz.springlearn.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {
    private CollectionUtil() {

    }


    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> Set<T> merge(Set<T> set1, Set<T> set2) {
        var set = new HashSet<>(set1);
        set.addAll(set2);
        return set;
    }
}