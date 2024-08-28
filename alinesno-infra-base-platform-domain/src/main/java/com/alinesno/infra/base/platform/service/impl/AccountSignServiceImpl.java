package com.alinesno.infra.base.platform.service.impl;

import com.alinesno.infra.base.platform.entity.AccountSignEntity;
import com.alinesno.infra.base.platform.mapper.AccountSignMapper;
import com.alinesno.infra.base.platform.service.IAccountSignService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class AccountSignServiceImpl extends IBaseServiceImpl<AccountSignEntity, AccountSignMapper> implements IAccountSignService {

    private static final Random RANDOM = new Random();

    @Override
    public int signIn(long accountId) {

        if(!isSignIn(accountId)){
            AccountSignEntity entity = new AccountSignEntity() ;

            entity.setAccountId(accountId);
            entity.setHasDaySign(1);
            entity.setSignDayCount(1);
            entity.setGrowthValue(1);

            save(entity) ;
            log.info("签到成功");
        }

        // 查询出用户所有签到的天数
        LambdaQueryWrapper<AccountSignEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AccountSignEntity::getAccountId, accountId);

        return (int) count(wrapper);
    }

    /**
     * 通过addTime查询今天是否有签到记录
     * @param accountId
     * @return
     */
    @Override
    public boolean isSignIn(long accountId) {

        // 获取今天的开始时间和结束时间
        LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        LambdaQueryWrapper<AccountSignEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AccountSignEntity::getAccountId, accountId)
                .ge(AccountSignEntity::getAddTime, todayStart)
                .le(AccountSignEntity::getAddTime, todayEnd);

        return count(wrapper) > 0;
    }

    @Override
    public String sayHello(long accountId) {

        String username = "李四" ;

        if (isSignIn(accountId)) {
            return getGreeting(username);
        } else {
            return getGreeting(username) + "，今天还没有签到，请签到！";
        }

    }

    /**
     * 根据当前时间返回不同的随机问候和鼓励语。
     *
     * @param name 需要问候的人的名字。
     * @return 返回包含随机问候和鼓励语的字符串。
     */
    public String getGreeting(String name) {
        LocalTime currentTime = LocalTime.now();

        List<String> greetings = new ArrayList<>();

        if (currentTime.isBefore(LocalTime.of(12, 0))) {
            greetings.add("早上好，" + name + "，新的一天充满活力！");
            greetings.add("早安，" + name + "，希望你今天有美好的开始！");
            greetings.add("嗨，" + name + "，今天也要元气满满哦！");
            greetings.add("早安，" + name + "，愿你的心情像早晨的阳光一样灿烂！");
            greetings.add("嗨，" + name + "，早上的空气总是那么清新！");
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            greetings.add("下午好，" + name + "，继续加油！");
            greetings.add("嘿，" + name + "，午后的阳光总是那么美好！");
            greetings.add("你好，" + name + "，午后时光总是那么惬意！");
            greetings.add("嗨，" + name + "，午后的时光总是那么美妙！");
            greetings.add("嘿，" + name + "，午后的微风总是那么舒适！");
        } else if (currentTime.isBefore(LocalTime.of(22, 0))) {
            greetings.add("晚上好，" + name + "，那么晚了还在学习，你真厉害！");
            greetings.add("嘿，" + name + "，夜晚的学习时光总是那么充实！");
            greetings.add("嗨，" + name + "，夜晚的宁静让人更加专注！");
            greetings.add("晚上好，" + name + "，夜晚的星光伴你前行！");
            greetings.add("嘿，" + name + "，夜晚的凉风总是那么宜人！");
        } else {
            greetings.add("深夜好，" + name + "，早点休息，明天又是元气满满的一天！");
            greetings.add("嗨，" + name + "，这么晚还不睡，是在思考人生吗？");
            greetings.add("嘿，" + name + "，熬夜对身体不好哦，记得早点休息！");
            greetings.add("深夜好，" + name + "，祝你有个好梦！");
            greetings.add("嘿，" + name + "，夜深人静，好好休息吧！");
        }

        // 从列表中随机选择一条问候语
        return greetings.get(RANDOM.nextInt(greetings.size()));
    }
}
