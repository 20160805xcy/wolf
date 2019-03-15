package com.xcy.wolf.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "api_request_log")
public class ApiRequestLog {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 请求时间
     */
    @Column(name = "request_date")
    private Date requestDate;

    /**
     * 请求状态
     */
    private String status;

    /**
     * 请求者IP地址
     */
    private String ip;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    private Long responseTime;

    /**
     * 请求访问路径
     */
    @Column(name = "request_url")
    private String requestUrl;

    /**
     * 是否是ajax请求
     */
    @Column(name = "ajax_request_flag")
    private Boolean ajaxRequestFlag;

    /**
     * 请求方法(GET/POST)
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 请求方法名称
     */
    @Column(name = "request_method_name")
    private String requestMethodName;

    /**
     * 请求参数
     */
    @Column(name = "request_params")
    private String requestParams;

    /**
     * 客户ID
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 客户名称
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 网页sessionId
     */
    @Column(name = "request_session_id")
    private String requestSessionId;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取请求时间
     *
     * @return request_date - 请求时间
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * 设置请求时间
     *
     * @param requestDate 请求时间
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * 获取请求状态
     *
     * @return status - 请求状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置请求状态
     *
     * @param status 请求状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取请求者IP地址
     *
     * @return ip - 请求者IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置请求者IP地址
     *
     * @param ip 请求者IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取响应时间
     *
     * @return response_time - 响应时间
     */
    public Long getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间
     *
     * @param responseTime 响应时间
     */
    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取请求访问路径
     *
     * @return request_url - 请求访问路径
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 设置请求访问路径
     *
     * @param requestUrl 请求访问路径
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * 获取是否是ajax请求
     *
     * @return ajax_request_flag - 是否是ajax请求
     */
    public Boolean getAjaxRequestFlag() {
        return ajaxRequestFlag;
    }

    /**
     * 设置是否是ajax请求
     *
     * @param ajaxRequestFlag 是否是ajax请求
     */
    public void setAjaxRequestFlag(Boolean ajaxRequestFlag) {
        this.ajaxRequestFlag = ajaxRequestFlag;
    }

    /**
     * 获取请求方法(GET/POST)
     *
     * @return request_method - 请求方法(GET/POST)
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 设置请求方法(GET/POST)
     *
     * @param requestMethod 请求方法(GET/POST)
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * 获取请求方法名称
     *
     * @return request_method_name - 请求方法名称
     */
    public String getRequestMethodName() {
        return requestMethodName;
    }

    /**
     * 设置请求方法名称
     *
     * @param requestMethodName 请求方法名称
     */
    public void setRequestMethodName(String requestMethodName) {
        this.requestMethodName = requestMethodName;
    }

    /**
     * 获取请求参数
     *
     * @return request_params - 请求参数
     */
    public String getRequestParams() {
        return requestParams;
    }

    /**
     * 设置请求参数
     *
     * @param requestParams 请求参数
     */
    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    /**
     * 获取客户ID
     *
     * @return customer_id - 客户ID
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户ID
     *
     * @param customerId 客户ID
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取客户名称
     *
     * @return customer_name - 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置客户名称
     *
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取网页sessionId
     *
     * @return request_session_id - 网页sessionId
     */
    public String getRequestSessionId() {
        return requestSessionId;
    }

    /**
     * 设置网页sessionId
     *
     * @param requestSessionId 网页sessionId
     */
    public void setRequestSessionId(String requestSessionId) {
        this.requestSessionId = requestSessionId;
    }
}