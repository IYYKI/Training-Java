package com.aowin.model;

public class CategoryId
{
    String id;
    String name;
    String remark;

    public CategoryId()
    {
    }

    public CategoryId(String id, String name, String remark)
    {
        this.id = id;
        this.name = name;
        this.remark = remark;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

}
