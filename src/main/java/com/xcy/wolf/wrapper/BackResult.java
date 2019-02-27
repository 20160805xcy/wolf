package com.xcy.wolf.wrapper;

import com.github.pagehelper.PageInfo;

/**
 * @author xcy
 * @date 2018/11/16 14:49
 * @description 返回list结果
 * @since V1.0.0
 */
public class BackResult {
    private static final Integer FAILURE_CODE = 1;
    private static final Integer SUCCESS_CODE = 0; //layerUI规定返回成功必须是0
    private static final String SUCCESS_MESSAGE = "success";
    /** 返回结果 编码 0:成功 1:失败 */
    protected Integer code;
    /** 返回结果 描述信息 */
    private String msg = SUCCESS_MESSAGE;
    /** 数量 **/
    private Long count;
    /** 返回结果 */
    private Object data = "";

    public BackResult() {

    }

    public BackResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * layUI table返回数据格式
     * @param code
     * @param message
     * @param count
     * @param data
     */
    public BackResult(Integer code, String message, Long count, Object data) {
        this.code = code;
        this.msg = message;
        this.count = count;
        this.data = data;
    }

    /** 返回成功 */
    public static BackResult successBack(Object pageInfo) {
        PageInfo page = (PageInfo) pageInfo;
        Long count = page.getTotal();
        Object data = page.getList();
        return new BackResult(SUCCESS_CODE, SUCCESS_MESSAGE, count, data);
    }

    /** 返回成功 空数据 */
    public static BackResult successBack() {
        return new BackResult(SUCCESS_CODE, SUCCESS_MESSAGE, "");
    }

    /** 返回失败 错误码+错误消息 */
    public static BackResult failureBack(String message) {
        return new BackResult(FAILURE_CODE, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}


