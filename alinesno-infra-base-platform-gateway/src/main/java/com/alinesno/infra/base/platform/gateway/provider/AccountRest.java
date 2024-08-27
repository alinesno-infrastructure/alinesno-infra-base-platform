package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.service.IAccountSignService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户控制器
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/infra/base/platform/provider/account")
public class AccountRest extends SuperController {

    @Autowired
    private IAccountSignService accountSignService ;

    /**
     * 打招呼信息
     */
    @GetMapping("/sayHello")
    public R<String> sayHello(long accountId) {
        return R.ok(accountSignService.sayHello(accountId));
    }

    /**
     * 查询用户今天是否签到
     */
    @GetMapping("/isSignIn")
    public R<Boolean> isSignIn(long accountId) {
        boolean isSignIn = accountSignService.isSignIn(accountId);
        return R.ok(isSignIn);
    }

    /**
     * 用户签到
     */
    @GetMapping("/signIn")
    public R<Integer> signIn(long accountId) {

        int count = accountSignService.signIn(accountId);

        return R.ok(count);
    }

    /**
     * 组织自定义视图查询
     */
    @GetMapping("/customView")
    public R<String> customView(long accountId) {
        return R.ok("查询成功！");
    }

    /**
     * 保存组织自定义视图查询
      */
    @PostMapping("/saveCustomView")
    public R<String> saveCustomView(long accountId) {
        return R.ok("保存成功！");
    }


}
