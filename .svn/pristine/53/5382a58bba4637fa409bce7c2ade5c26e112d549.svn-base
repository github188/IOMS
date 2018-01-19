package cn.com.atnc.ioms.entity.news;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
/**
 * 类说明:通知通告操作日志记录
 * @author whiteyj
 * @date 2014-5-8 1700
 */
@Entity
@Table(name = "TB_OM_PN_NOTICE_OPTLOG")
public class NewsOptlog extends StringUUIDEntity{
    /**
     */
    private static final long serialVersionUID = -2193142570756211301L;
    // 基本属性
    private News news;      //通知公告
    private NewsStatusEnum newsStatusEnum;   //操作状态
    private NewsStatusEnum inNewsStatusEnum; //变更前状态
    private NewsStatusEnum outNewsStatusEnum;//变更后状态
    private Date optTime;   //操作时间
    private String info;    //描述信息
    private User optUser;   //操作人员
    
    @ManyToOne
    @JoinColumn(name="PN_NOTICE_ID")
    public News getNews() {
        return news;
    }
    public void setNews(News news) {
        this.news = news;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name="OPT")
    public NewsStatusEnum getNewsStatusEnum() {
        return newsStatusEnum;
    }
    public void setNewsStatusEnum(NewsStatusEnum newsStatusEnum) {
        this.newsStatusEnum = newsStatusEnum;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="FROM_STATUS")
    public NewsStatusEnum getInNewsStatusEnum() {
        return inNewsStatusEnum;
    }
    public void setInNewsStatusEnum(NewsStatusEnum inNewsStatusEnum) {
        this.inNewsStatusEnum = inNewsStatusEnum;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="TO_STATUS")
    public NewsStatusEnum getOutNewsStatusEnum() {
        return outNewsStatusEnum;
    }
    public void setOutNewsStatusEnum(NewsStatusEnum outNewsStatusEnum) {
        this.outNewsStatusEnum = outNewsStatusEnum;
    }
    @Column(name="OPT_TIME")
    public Date getOptTime() {
        return optTime;
    }
    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @ManyToOne
    @JoinColumn(name="OPT_USER")
    public User getOptUser() {
        return optUser;
    }
    public void setOptUser(User optUser) {
        this.optUser = optUser;
    }
}
