package com.xcy.wolf.wrapper;

/**
 * @author xcy
 * @date 2018/11/16 14:49
 * @description 返回list结果
 * @since V1.0.0
 */
public class BackResult {

    private static final String FAILURE_CODE = "0";
    private static final String SUCCESS_CODE = "1";
    private static final String SUCCESS_MESSAGE = "success";
    /**返回结果 编码 1：成功 0：失败*/
    protected String code;
    /**返回结果 描述信息*/
    private String message = SUCCESS_MESSAGE;
    /**返回结果*/
    private Object res = "";

    public BackResult(){

    }

    public BackResult(String code, String message, Object res) {
        this.code = code;
        this.message = message;
        this.res = res;
    }

    /**返回成功*/
    public static BackResult successBack(Object res){
        return new BackResult(SUCCESS_CODE, SUCCESS_MESSAGE, res);
    }
    /**返回成功 空数据*/
    public  static BackResult successBack(){
        return new BackResult(SUCCESS_CODE,SUCCESS_MESSAGE,"");
    }
    /**返回失败*/
    public static BackResult failureBack(String message){
        return new BackResult(FAILURE_CODE,message,null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }
}
