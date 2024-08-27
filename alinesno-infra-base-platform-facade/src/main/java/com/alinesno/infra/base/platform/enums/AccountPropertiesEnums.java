package com.alinesno.infra.base.platform.enums;

public enum AccountPropertiesEnums {

    // 用户属性和属性描述(自定义组织视图/自定义用户视图)
    USER_VIEW("user_view", "自定义用户视图"),

    // 组织属性和属性描述(自定义组织视图)
    ORGANIZATION_VIEW("organization_view", "自定义组织视图");

    private final String code;
    private final String name;

    AccountPropertiesEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static AccountPropertiesEnums getByCode(String code) {
        for (AccountPropertiesEnums value : AccountPropertiesEnums.values()) {
            if (value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
}
