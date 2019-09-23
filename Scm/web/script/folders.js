///////////////////////////////////////////////////////////////// INIT ////////////////////////////////////////////////////////////

//  Init!

var OutlookBar={
"format":
   {"heightpanel":25, "imagewidth":50, "imageheight":50, "arrowheight":17,"heightcell":100,"coloroutlook":"#DBEAF5","arrange_text":"bottom", "rollback":false, "img_arrows_up":"images/pic/arup2.gif","img_arrows_dn":"images/pic/ardn2.gif"},
"panels":
[
   {"text":"系统管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"用户管理","textCSS":"a1", "image":'images/pic/1.gif',    "url":'gztm/admin.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"重新登录","textCSS":"a1","image":'images/pic/2.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"退出系统","textCSS":"a1", "image":'images/pic/3.gif',    "url":'gztm/yc.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"采购管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"供应商管理","textCSS":"a1", "image":'images/pic/4.gif',    "url":'xxwh/admin.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"新添采购单","textCSS":"a1", "image":'images/pic/5.gif',    "url":'xxwh/khxx.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"采购单了结","textCSS":"a1", "image":'images/pic/6.gif',    "url":'xxwh/ccht.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"采购单查询","textCSS":"a1", "image":'images/pic/7.gif',    "url":'gztm/js.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"库存管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"入库登记","textCSS":"a1", "image":'images/pic/8.gif',    "url":'xxcx/spxx.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"出库登记","textCSS":"a1", "image":'images/pic/9.gif',    "url":'xxcx/splb.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"库存更新","textCSS":"a1", "image":'images/pic/10.gif',    "url":'xxcx/dlqy.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"库存查询","textCSS":"a1", "image":'images/pic/11.gif',    "url":'xxcx/ysbj.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"收支管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"收款登记","textCSS":"a1", "image":'images/pic/12.gif',    "url":'szgl/sqdj.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"付款登记","textCSS":"a1","image":'images/pic/13.gif',    "url":'szgl/fqdj.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"收支查询","textCSS":"a1", "image":'images/pic/14.gif',    "url":'szgl/szcx.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"销售管理", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"产品分类管理","textCSS":"a1", "image":'images/pic/15.gif',    "url":'cpflgl/cpflgl.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"产品管理","textCSS":"a1","image":'images/pic/16.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"客户管理","textCSS":"a1", "image":'images/pic/17.gif',    "url":'gztm/dlqy.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"新添销售单","textCSS":"a1","image":'images/pic/18.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"销售单了结","textCSS":"a1", "image":'images/pic/19.gif',    "url":'gztm/yc.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"销售单查询","textCSS":"a1","image":'images/pic/20.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"统计报表", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"月度采购报表","textCSS":"a1", "image":'images/pic/21.gif',    "url":'gztm/th.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"月度收支登记表","textCSS":"a1","image":'images/pic/22.gif',    "url":'szdjb/szdjb.jsp', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"月度入库报表","textCSS":"a1", "image":'images/pic/23.gif',    "url":'gztm/yc.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"月度出库报表","textCSS":"a1","image":'images/pic/24.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"产品库存报表","textCSS":"a1", "image":'images/pic/1.gif',    "url":'gztm/yc.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"月度销售报表","textCSS":"a1","image":'images/pic/2.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   },
   {"text":"网络销售", "panelCSS":"panel" ,"textCSS":"textpanel",
       "items":
       [
          {"text":"客户注册","textCSS":"a1", "image":'images/pic/3.gif',    "url":'gztm/th.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"商品展示","textCSS":"a1","image":'images/pic/4.gif',    "url":'gztm/fh.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"},
          {"text":"网上下单","textCSS":"a1", "image":'images/pic/5.gif',    "url":'gztm/yc.htm', "classCSS":"imgstyle", "overclassCSS":"imgstyle_over"}
      ]
   }
]
}
