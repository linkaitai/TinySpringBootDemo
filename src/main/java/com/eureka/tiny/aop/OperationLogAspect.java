package com.eureka.tiny.aop;

import com.eureka.tiny.mapper.OperateLogMapper;
import com.eureka.tiny.pojo.OperateLog;
import com.eureka.tiny.pojo.User;
import com.eureka.tiny.service.UserService;
import com.eureka.tiny.utils.ThreadLocalUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Aspect
@Component
public class OperationLogAspect {
    private static final Logger log = LoggerFactory.getLogger(OperationLogAspect.class);

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private UserService userService;
    @Around("@annotation(com.eureka.tiny.anno.Log)") // 修正注解路径
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findUsername(username);

        // 构造操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(user.getId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");
        operateLog.setCostTime(costTime);

        // 记录日志
        log.info("记录操作日志：{}", operateLog);

        // 保存操作日志到数据库
        operateLogMapper.insert(operateLog);

        return result;
    }
}
