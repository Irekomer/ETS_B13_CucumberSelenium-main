package com.eurotech.pages;

import com.eurotech.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class TestingExcel {

    public static void main(String[] args) {
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch13_DevEx.xlsx","Test Data");
        List<Map<String, String>> dataList = excelUtil.getDataList();

        System.out.println("dataList = " + dataList);
        System.out.println("dataList.get(2).get(\"Username\") = " + dataList.get(2).get("Username"));
        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company"));
        System.out.println("dataList.get(6).get(\"Title\") = " + dataList.get(6).get("Title"));

    }
}
