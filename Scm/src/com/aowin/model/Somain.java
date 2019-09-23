package com.aowin.model;

public class Somain {
    int soid;
    String customerCode;
    String account;
    String createTime;
    String payType;
    float tipFee;
    float productTotal;
    float poTotal;
    float prePayFee;
    int statusx;
    String remark;
    String stockTime;
    String stockUser;
    String payTime;
    String payUser;
    String prePayTime;
    String prePayUser;
    String endTime;
    String endUser;

    public Somain() {
    }

    public Somain(int SOID, String CustomerCode, String Account,
                  String CreateTime, float TipFee, float ProductTotal, float POTotal,
                  String PayType, float PrePayFee, int statusx, String Remark,
                  String StockTime, String StockUser, String PayTime, String PayUser,
                  String PrePayTime, String PrePayUser, String EndTime, String EndUser) {
        this.soid = SOID;
        this.customerCode = CustomerCode;
        this.account = Account;
        this.createTime = CreateTime;
        this.tipFee = TipFee;
        this.productTotal = ProductTotal;
        this.poTotal = POTotal;
        this.prePayFee = PrePayFee;
        this.statusx = statusx;
        this.remark = Remark;
        this.stockTime = StockTime;
        this.stockUser = StockUser;
        this.payTime = PayTime;
        this.payUser = PayUser;
        this.prePayTime = PrePayTime;
        this.prePayUser = PrePayUser;
        this.endTime = EndTime;
        this.endUser = EndUser;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public float getTipFee() {
        return tipFee;
    }

    public void setTipFee(float tipFee) {
        this.tipFee = tipFee;
    }

    public float getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(float productTotal) {
        this.productTotal = productTotal;
    }


    public float getPoTotal() {
        return poTotal;
    }

    public void setPoTotal(float poTotal) {
        this.poTotal = poTotal;
    }

    public float getPrePayFee() {
        return prePayFee;
    }

    public void setPrePayFee(float prePayFee) {
        this.prePayFee = prePayFee;
    }

    public int getStatusx() {
        return statusx;
    }

    public void setStatusx(int statusx) {
        this.statusx = statusx;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStockTime() {
        return stockTime;
    }

    public void setStockTime(String stockTime) {
        this.stockTime = stockTime;
    }

    public String getStockUser() {
        return stockUser;
    }

    public void setStockUser(String stockUser) {
        this.stockUser = stockUser;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getPrePayTime() {
        return prePayTime;
    }

    public void setPrePayTime(String prePayTime) {
        this.prePayTime = prePayTime;
    }

    public String getPrePayUser() {
        return prePayUser;
    }

    public void setPrePayUser(String prePayUser) {
        this.prePayUser = prePayUser;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndUser() {
        return endUser;
    }

    public void setEndUser(String endUser) {
        this.endUser = endUser;
    }


}
