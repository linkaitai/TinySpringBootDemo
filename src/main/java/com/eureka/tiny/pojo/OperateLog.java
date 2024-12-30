package com.eureka.tiny.pojo;

import java.time.LocalDateTime;

public class OperateLog {
    private Integer id;
    private Integer operateEmpId;
    private LocalDateTime operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Long costTime;

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for operateEmpId
    public Integer getOperateEmpId() {
        return operateEmpId;
    }

    public void setOperateEmpId(Integer operateEmpId) {
        this.operateEmpId = operateEmpId;
    }

    // Getter and Setter for operateTime
    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    // Getter and Setter for className
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Getter and Setter for methodName
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    // Getter and Setter for methodParams
    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    // Getter and Setter for returnValue
    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    // Getter and Setter for costTime
    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }
}
