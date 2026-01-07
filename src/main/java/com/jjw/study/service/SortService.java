package com.jjw.study.service;

import java.util.List;
import java.util.Map;

public interface SortService {

    List<Map<Integer, Integer>> execSort(String sortTarget,String sortOrder);
}
