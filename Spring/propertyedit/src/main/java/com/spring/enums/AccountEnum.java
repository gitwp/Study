package com.spring.enums;

public enum AccountEnum {
	VALID("有效", 1), INVALID("无效", 2);
    // 成员变量  
    private String name;  
    private int index;  
    // 构造方法  
    private AccountEnum(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    // 普通方法  
    public static String getName(int index) {  
        for (AccountEnum c : AccountEnum.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    public String getName() {  
        return name;  
    }  
    public int getIndex() {  
        return index;  
    }  
}
