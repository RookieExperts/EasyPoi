package com.easypoi.em;

/**
 * Excel枚举类型
 * @author: brb
 * @date: 2020年8月29日
 */
public enum ExcelTypeEnum {

   XLS("xls"), XLSX("xlsx");

   private String value;

   private ExcelTypeEnum(String value) {
       this.value = value;
   }

   public String getValue() {
       return value;
   }

   public void setValue(String value) {
       this.value = value;
   }
}

