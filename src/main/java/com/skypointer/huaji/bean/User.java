package com.skypointer.huaji.bean;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User extends BaseBean {
    private static final long serialVersionUID = -3569248846170785967L;

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 账户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;


    /**
     * 电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 逻辑删除状态 0 未删除 1 删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 是否锁定
     *
     * 0 未锁定 1 锁定
     */
    @Column(name = "locked")
    private Integer locked;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date update_time;

    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private java.util.Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreateTime() {
        return create_time;
    }

    public void setCreateTime(Date createTime) {
        this.create_time = createTime;
    }

    public Date getUpdateTime() {
        return update_time;
    }

    public void setUpdateTime(Date updateTime) {
        this.update_time = updateTime;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", deleteStatus=" + deleteStatus +
                ", locked=" + locked +
                ", createTime=" + create_time +
                ", updateTime=" + update_time +
                ", roles=" + roles +
                '}';
    }
}
