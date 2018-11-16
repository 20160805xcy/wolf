package com.xcy.wolf.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "customer_child")
public class CustomerChild {
    /**
     * 自动ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登入名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登入密码
     */
    @Column(name = "login_pswd")
    private String loginPswd;

    /**
     * 客户ID
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 供应商ID
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "crt_by")
    private Integer crtBy;

    @Column(name = "crt_by_name")
    private String crtByName;

    @Column(name = "crt_dtm")
    private Date crtDtm;

    @Column(name = "mdy_by")
    private Integer mdyBy;

    @Column(name = "mdy_by_name")
    private String mdyByName;

    @Column(name = "mdy_dtm")
    private Date mdyDtm;

    private Integer voided;

    @Column(name = "voided_by")
    private Integer voidedBy;

    @Column(name = "voided_by_name")
    private String voidedByName;

    @Column(name = "voided_dtm")
    private Date voidedDtm;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * QQ
     */
    private String qq;

    /**
     * 公司名称
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 使用特殊模板
     */
    @Column(name = "specialTemplate")
    private Integer specialtemplate;

    /**
     * 已整理收货地址
     */
    @Column(name = "isCheckAddr")
    private Integer ischeckaddr;

    /**
     * 激活人
     */
    @Column(name = "activate_by")
    private String activateBy;

    /**
     * 激活时间
     */
    @Column(name = "activate_dtm")
    private Date activateDtm;

    /**
     * 是否默认发送回执(0，否；1，是）
     */
    @Column(name = "isReceipt")
    private Integer isreceipt;

    /**
     * 是否默认接收邮件(0,不接收；1，接收)
     */
    @Column(name = "isSendEmail")
    private Integer issendemail;

    /**
     * 是否有邮箱的纸质授权文件（0,否；1，是）
     */
    @Column(name = "isAuth")
    private Integer isauth;

    /**
     * 短信验证码
     */
    private Integer code;

    /**
     * 是否为管理员( 0否，1是)
     */
    private Integer role;

    /**
     * 帐户状态（0正常  1禁用）
     */
    private Integer status;

    /**
     * 已展示版本号
     */
    @Column(name = "showVersion")
    private String showversion;

    /**
     * 修改邮箱时间
     */
    @Column(name = "emailTime")
    private Date emailtime;

    /**
     * 是否给15天宽限期（0不给  1给）默认为0
     */
    @Column(name = "isEditor")
    private Integer iseditor;

    /**
     * 抄送邮箱a
     */
    private String emaila;

    /**
     * 抄送邮箱B
     */
    private String emailb;

    /**
     * 协议是否确认 （0未  1有）
     */
    @Column(name = "isSure")
    private Integer issure;

    /**
     * 已展示版本号
     */
    @Column(name = "showMessage")
    private String showmessage;

    /**
     * 积分海报弹出次数
     */
    @Column(name = "showPointNum")
    private Integer showpointnum;

    /**
     * 获取自动ID
     *
     * @return id - 自动ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自动ID
     *
     * @param id 自动ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登入名
     *
     * @return login_name - 登入名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登入名
     *
     * @param loginName 登入名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取登入密码
     *
     * @return login_pswd - 登入密码
     */
    public String getLoginPswd() {
        return loginPswd;
    }

    /**
     * 设置登入密码
     *
     * @param loginPswd 登入密码
     */
    public void setLoginPswd(String loginPswd) {
        this.loginPswd = loginPswd;
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
     * 获取供应商ID
     *
     * @return supplier_id - 供应商ID
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商ID
     *
     * @param supplierId 供应商ID
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return crt_by
     */
    public Integer getCrtBy() {
        return crtBy;
    }

    /**
     * @param crtBy
     */
    public void setCrtBy(Integer crtBy) {
        this.crtBy = crtBy;
    }

    /**
     * @return crt_by_name
     */
    public String getCrtByName() {
        return crtByName;
    }

    /**
     * @param crtByName
     */
    public void setCrtByName(String crtByName) {
        this.crtByName = crtByName;
    }

    /**
     * @return crt_dtm
     */
    public Date getCrtDtm() {
        return crtDtm;
    }

    /**
     * @param crtDtm
     */
    public void setCrtDtm(Date crtDtm) {
        this.crtDtm = crtDtm;
    }

    /**
     * @return mdy_by
     */
    public Integer getMdyBy() {
        return mdyBy;
    }

    /**
     * @param mdyBy
     */
    public void setMdyBy(Integer mdyBy) {
        this.mdyBy = mdyBy;
    }

    /**
     * @return mdy_by_name
     */
    public String getMdyByName() {
        return mdyByName;
    }

    /**
     * @param mdyByName
     */
    public void setMdyByName(String mdyByName) {
        this.mdyByName = mdyByName;
    }

    /**
     * @return mdy_dtm
     */
    public Date getMdyDtm() {
        return mdyDtm;
    }

    /**
     * @param mdyDtm
     */
    public void setMdyDtm(Date mdyDtm) {
        this.mdyDtm = mdyDtm;
    }

    /**
     * @return voided
     */
    public Integer getVoided() {
        return voided;
    }

    /**
     * @param voided
     */
    public void setVoided(Integer voided) {
        this.voided = voided;
    }

    /**
     * @return voided_by
     */
    public Integer getVoidedBy() {
        return voidedBy;
    }

    /**
     * @param voidedBy
     */
    public void setVoidedBy(Integer voidedBy) {
        this.voidedBy = voidedBy;
    }

    /**
     * @return voided_by_name
     */
    public String getVoidedByName() {
        return voidedByName;
    }

    /**
     * @param voidedByName
     */
    public void setVoidedByName(String voidedByName) {
        this.voidedByName = voidedByName;
    }

    /**
     * @return voided_dtm
     */
    public Date getVoidedDtm() {
        return voidedDtm;
    }

    /**
     * @param voidedDtm
     */
    public void setVoidedDtm(Date voidedDtm) {
        this.voidedDtm = voidedDtm;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取QQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取公司名称
     *
     * @return customer_name - 公司名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置公司名称
     *
     * @param customerName 公司名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取使用特殊模板
     *
     * @return specialTemplate - 使用特殊模板
     */
    public Integer getSpecialtemplate() {
        return specialtemplate;
    }

    /**
     * 设置使用特殊模板
     *
     * @param specialtemplate 使用特殊模板
     */
    public void setSpecialtemplate(Integer specialtemplate) {
        this.specialtemplate = specialtemplate;
    }

    /**
     * 获取已整理收货地址
     *
     * @return isCheckAddr - 已整理收货地址
     */
    public Integer getIscheckaddr() {
        return ischeckaddr;
    }

    /**
     * 设置已整理收货地址
     *
     * @param ischeckaddr 已整理收货地址
     */
    public void setIscheckaddr(Integer ischeckaddr) {
        this.ischeckaddr = ischeckaddr;
    }

    /**
     * 获取激活人
     *
     * @return activate_by - 激活人
     */
    public String getActivateBy() {
        return activateBy;
    }

    /**
     * 设置激活人
     *
     * @param activateBy 激活人
     */
    public void setActivateBy(String activateBy) {
        this.activateBy = activateBy;
    }

    /**
     * 获取激活时间
     *
     * @return activate_dtm - 激活时间
     */
    public Date getActivateDtm() {
        return activateDtm;
    }

    /**
     * 设置激活时间
     *
     * @param activateDtm 激活时间
     */
    public void setActivateDtm(Date activateDtm) {
        this.activateDtm = activateDtm;
    }

    /**
     * 获取是否默认发送回执(0，否；1，是）
     *
     * @return isReceipt - 是否默认发送回执(0，否；1，是）
     */
    public Integer getIsreceipt() {
        return isreceipt;
    }

    /**
     * 设置是否默认发送回执(0，否；1，是）
     *
     * @param isreceipt 是否默认发送回执(0，否；1，是）
     */
    public void setIsreceipt(Integer isreceipt) {
        this.isreceipt = isreceipt;
    }

    /**
     * 获取是否默认接收邮件(0,不接收；1，接收)
     *
     * @return isSendEmail - 是否默认接收邮件(0,不接收；1，接收)
     */
    public Integer getIssendemail() {
        return issendemail;
    }

    /**
     * 设置是否默认接收邮件(0,不接收；1，接收)
     *
     * @param issendemail 是否默认接收邮件(0,不接收；1，接收)
     */
    public void setIssendemail(Integer issendemail) {
        this.issendemail = issendemail;
    }

    /**
     * 获取是否有邮箱的纸质授权文件（0,否；1，是）
     *
     * @return isAuth - 是否有邮箱的纸质授权文件（0,否；1，是）
     */
    public Integer getIsauth() {
        return isauth;
    }

    /**
     * 设置是否有邮箱的纸质授权文件（0,否；1，是）
     *
     * @param isauth 是否有邮箱的纸质授权文件（0,否；1，是）
     */
    public void setIsauth(Integer isauth) {
        this.isauth = isauth;
    }

    /**
     * 获取短信验证码
     *
     * @return code - 短信验证码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置短信验证码
     *
     * @param code 短信验证码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取是否为管理员( 0否，1是)
     *
     * @return role - 是否为管理员( 0否，1是)
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置是否为管理员( 0否，1是)
     *
     * @param role 是否为管理员( 0否，1是)
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取帐户状态（0正常  1禁用）
     *
     * @return status - 帐户状态（0正常  1禁用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置帐户状态（0正常  1禁用）
     *
     * @param status 帐户状态（0正常  1禁用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取已展示版本号
     *
     * @return showVersion - 已展示版本号
     */
    public String getShowversion() {
        return showversion;
    }

    /**
     * 设置已展示版本号
     *
     * @param showversion 已展示版本号
     */
    public void setShowversion(String showversion) {
        this.showversion = showversion;
    }

    /**
     * 获取修改邮箱时间
     *
     * @return emailTime - 修改邮箱时间
     */
    public Date getEmailtime() {
        return emailtime;
    }

    /**
     * 设置修改邮箱时间
     *
     * @param emailtime 修改邮箱时间
     */
    public void setEmailtime(Date emailtime) {
        this.emailtime = emailtime;
    }

    /**
     * 获取是否给15天宽限期（0不给  1给）默认为0
     *
     * @return isEditor - 是否给15天宽限期（0不给  1给）默认为0
     */
    public Integer getIseditor() {
        return iseditor;
    }

    /**
     * 设置是否给15天宽限期（0不给  1给）默认为0
     *
     * @param iseditor 是否给15天宽限期（0不给  1给）默认为0
     */
    public void setIseditor(Integer iseditor) {
        this.iseditor = iseditor;
    }

    /**
     * 获取抄送邮箱a
     *
     * @return emaila - 抄送邮箱a
     */
    public String getEmaila() {
        return emaila;
    }

    /**
     * 设置抄送邮箱a
     *
     * @param emaila 抄送邮箱a
     */
    public void setEmaila(String emaila) {
        this.emaila = emaila;
    }

    /**
     * 获取抄送邮箱B
     *
     * @return emailb - 抄送邮箱B
     */
    public String getEmailb() {
        return emailb;
    }

    /**
     * 设置抄送邮箱B
     *
     * @param emailb 抄送邮箱B
     */
    public void setEmailb(String emailb) {
        this.emailb = emailb;
    }

    /**
     * 获取协议是否确认 （0未  1有）
     *
     * @return isSure - 协议是否确认 （0未  1有）
     */
    public Integer getIssure() {
        return issure;
    }

    /**
     * 设置协议是否确认 （0未  1有）
     *
     * @param issure 协议是否确认 （0未  1有）
     */
    public void setIssure(Integer issure) {
        this.issure = issure;
    }

    /**
     * 获取已展示版本号
     *
     * @return showMessage - 已展示版本号
     */
    public String getShowmessage() {
        return showmessage;
    }

    /**
     * 设置已展示版本号
     *
     * @param showmessage 已展示版本号
     */
    public void setShowmessage(String showmessage) {
        this.showmessage = showmessage;
    }

    /**
     * 获取积分海报弹出次数
     *
     * @return showPointNum - 积分海报弹出次数
     */
    public Integer getShowpointnum() {
        return showpointnum;
    }

    /**
     * 设置积分海报弹出次数
     *
     * @param showpointnum 积分海报弹出次数
     */
    public void setShowpointnum(Integer showpointnum) {
        this.showpointnum = showpointnum;
    }
}