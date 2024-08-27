package com.alinesno.infra.base.platform.service;

import com.alinesno.infra.base.platform.entity.AccountSignEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 *
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IAccountSignService extends IBaseService<AccountSignEntity> {

    /**
     * 签到
     *
     * @param accountId
     * @return
     */
    int signIn(long accountId);

    /**
     * 查询用户今天是否签到
     * @param accountId
     * @return
     */
    boolean isSignIn(long accountId);

    /**
     * 签到后返回用户签到天数
     * @param accountId
     * @return
     */
    String sayHello(long accountId);

}
