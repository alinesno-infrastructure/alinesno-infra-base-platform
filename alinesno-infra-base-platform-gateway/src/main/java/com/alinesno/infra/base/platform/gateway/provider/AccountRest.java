package com.alinesno.infra.base.platform.gateway.provider;

import com.alinesno.infra.base.platform.api.MenuItemDto;
import com.alinesno.infra.base.platform.service.IAccountPropertiesService;
import com.alinesno.infra.base.platform.service.IAccountSignService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private IAccountPropertiesService accountPropertiesService ;

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
    public R<List<MenuItemDto>> customView(long orgId) {

        List<MenuItemDto> menuItemDtoList = accountPropertiesService.queryConstomView(orgId) ;

        return R.ok(menuItemDtoList);
    }

    /**
     * 保存组织自定义视图查询
      */
    @PostMapping("/saveCustomView")
    public R<Boolean> saveCustomView(@RequestBody List<MenuItemDto> menuItemDtoList , @RequestParam long orgId) {
        accountPropertiesService.saveCustomView(menuItemDtoList , orgId) ;
        return R.ok(true);
    }


}
