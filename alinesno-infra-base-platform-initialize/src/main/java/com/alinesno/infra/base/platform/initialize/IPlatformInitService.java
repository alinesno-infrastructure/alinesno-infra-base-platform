package com.alinesno.infra.base.platform.initialize;

/**
 * 平台初始化服务接口
 */
public interface IPlatformInitService {

    /**
     * 初始化产品类型
     */
    void initProductType() ;

    /**
     * 初始化产品
     */
    void initProduct() ;

    /**
     * 初始化方案类型
     */
    void initPlanType() ;

    /**
     * 初始化方案
     */
    void initPlan() ;

    /**
     * 初始化公告
     */
    void initNotice() ;

    /**
     * 初始化内容
     */
    void initContent() ;

    /**
     * 初始化友情链接
     */
    void initFriendLink() ;

    /**
     * 初步化频道
     */
    void initChannel();

    /**
     * 初始化角色
     */
    void initRole();

}
