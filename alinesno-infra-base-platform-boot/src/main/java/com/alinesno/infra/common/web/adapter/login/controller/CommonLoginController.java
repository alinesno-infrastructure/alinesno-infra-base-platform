package com.alinesno.infra.common.web.adapter.login.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CommonLoginController {

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = UUID.randomUUID().toString() ;
        ajax.put(TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {

        Map<String, Object> data = new HashMap<>();
        // 将数据填充到data中...
        data.put("permissions", new String[]{"*:*:*"});

        Map<String, Object> user = new HashMap<>();
        user.put("createBy", "admin");
        user.put("createTime", "2023-04-23 16:11:38");
        user.put("updateBy", null);
        user.put("updateTime", null);
        user.put("remark", "管理员");
        user.put("userId", 1);
        user.put("deptId", 103);
        user.put("userName", "admin");
        user.put("nickName", "AIP技术团队");
        user.put("email", "aip-team@163.com");
        user.put("phonenumber", "15888888888");
        user.put("sex", "1");
        user.put("avatar", "");
        user.put("password", "");
        user.put("status", "0");
        user.put("delFlag", "0");
        user.put("loginIp", "");
        user.put("loginDate", "2023-09-21T16:54:12.000+08:00");

        Map<String, Object> dept = new HashMap<>();
        dept.put("createBy", null);
        dept.put("createTime", null);
        dept.put("updateBy", null);
        dept.put("updateTime", null);
        dept.put("remark", null);
        dept.put("deptId", 103);
        dept.put("parentId", 101);
        dept.put("ancestors", "0,100,101");
        dept.put("deptName", "研发部门");
        dept.put("orderNum", 1);
        dept.put("leader", "AIP技术团队");
        dept.put("phone", null);
        dept.put("email", null);
        dept.put("status", "0");
        dept.put("delFlag", null);
        dept.put("parentName", null);
        dept.put("children", new Object[]{});

        user.put("dept", dept);

        Map<String, Object> role = new HashMap<>();
        role.put("createBy", null);
        role.put("createTime", null);
        role.put("updateBy", null);
        role.put("updateTime", null);
        role.put("remark", null);
        role.put("roleId", 1);
        role.put("roleName", "超级管理员");
        role.put("roleKey", "admin");
        role.put("roleSort", 1);
        role.put("dataScope", "1");
        role.put("menuCheckStrictly", false);
        role.put("deptCheckStrictly", false);
        role.put("status", "0");
        role.put("delFlag", null);
        role.put("flag", false);
        role.put("menuIds", null);
        role.put("deptIds", null);
        role.put("permissions", null);
        role.put("admin", true);

        user.put("roles", new Object[]{role});

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", user.get("roles"));
        ajax.put("permissions", data.get("permissions"));

        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {

                // 平台管理服务
                Menu m1 = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true,  new Menu.Meta("概述", "dashboard", false, null),
                        List.of(
                            new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null))
                        )) ;

                // 产品管理
                Menu m3 = new Menu("Product", "/product", false, "noRedirect", "Layout" , true , new Menu.Meta("产品管理", "redis", false, null),
                        List.of(
                                new Menu("产品类型", "base/platform/product/types", false, false, "productTypes",  new Menu.Meta("产品类型", "search", false, null)),
                                new Menu("产品列表", "base/platform/product/list", false, false, "productList", new Menu.Meta("产品列表", "number", false, null)),
                                new Menu("方案管理", "base/platform/solutionManage/list", false, false, "solutionManage",  new Menu.Meta("方案管理", "row", false, null)),
                                new Menu("方案类型", "base/platform/solutionType/list", false, false, "solutionType",  new Menu.Meta("方案类型", "pdf", false, null)),
                                new Menu("产品访问", "base/platform/productAccess/list", false, false, "productAccess",  new Menu.Meta("产品访问", "redis", false, null))
                        )) ;

                // 智能体管理
                Menu m8 = new Menu("Services", "/services", false, "noRedirect", "Layout" , true ,  new Menu.Meta("智能体管理", "time", false, null),
                        List.of(
                                new Menu("频道管理", "base/platform/agentChannel/list", false, false, "agentChannel",  new Menu.Meta("频道管理", "skill", false, null)),
                                new Menu("用户收藏", "base/platform/accountChannel/list", false, false, "accountChannel", new Menu.Meta("用户收藏", "time", false, null))
                        ));

                // 安全审计
                Menu m9 =  new Menu("Audit", "/audit", false, "noRedirect", "Layout" , true ,  new Menu.Meta("系统管理", "log", false, null),
                        List.of(
                                new Menu("建议反馈", "base/platform/suggest/list", false, false, "suggest",  new Menu.Meta("建议反馈", "tool", false, null)),
                                new Menu("操作日志", "base/platform/audit/operation-logs", false, false, "operationLogs",  new Menu.Meta("操作日志", "log", false, null)),
                                new Menu("访问日志", "base/platform/audit/access-logs", false, false, "accessLogs",  new Menu.Meta("访问日志", "shopping", false, null))
                        ));

                // 内容管理
                Menu m10 = new Menu("Content", "/content", false, "noRedirect", "Layout" , true ,  new Menu.Meta("内容管理", "shopping", false, null),
                        List.of(
                                new Menu("内容管理", "base/platform/content/list", false, false, "contentManagement",  new Menu.Meta("内容管理", "time", false, null)),
                                new Menu("公告管理", "base/platform/announceManage/list", false, false, "announceManage",  new Menu.Meta("公告管理", "shopping", false, null)),
                                new Menu("友情链接", "base/platform/linkPath/list", false, false, "friendLinks",  new Menu.Meta("友情链接", "link", false, null))
                        ));


        // 将所有菜单存储在一个列表中
        List<Menu> menus = List.of(
                m1,
                m3,
                m8,
                m9,
                m10
        );

        return AjaxResult.success(menus) ;
    }
}
