package com.alinesno.infra.base.platform.enums;

import lombok.Getter;

/**
 * 角色分类
 */
@Getter
public enum OwnerEnums {

    // 包括有平台(platform)/用户(account)
    PLATFORM("platform", "平台"),
    ORG("org", "组织"),
    ACCOUNT("account", "用户")
    ;

    private final String code;
    private final String name;

    OwnerEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OwnerEnums getByCode(String code) {
        for (OwnerEnums value : OwnerEnums.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
