package com.aowin.model;

public class Szcx
{
    // 收支查询的Bean
    String time;
    String id;
    String momey;
    String user;
    String payType;

    public Szcx()
    {
    }

    public Szcx(String time, String id, String momey, String user,
                String payType)
    {
        this.time = time;
        this.id = id;
        this.momey = momey;
        this.user = user;
        this.payType = payType;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getMomey()
    {
        return momey;
    }

    public void setMomey(String momey)
    {
        this.momey = momey;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }

}
