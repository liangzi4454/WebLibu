<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/top.jsp"%>
<head>
<%@ include file="../common/header.jsp"%>
<title>详情信息</title>
</head>
<body>
	<!--start top-->
	<div class="topwrap">
    	<div class="top">
        	<div class="topwrap_l">
                <form action="" name="loginform" class="loginform">
                    <label>用户名:&nbsp;<input type="text" class="textbox"></label>
                    <label>&nbsp;&nbsp;密码:&nbsp;<input type="password" class="textbox"></label><div>
                    <input type="image" src="<%=basePath%>images/loginbtn.jpg">
                    &nbsp;<a href="#"><img src="<%=basePath%>images/zhcbtn.jpg" width="47" height="23"></a>
                    </div>
                </form>
            </div>
            <div class="toptel">
            	<img src="<%=basePath%>images/toptel.jpg" width="281" height="23">
            </div>
        </div>
    </div>
    
    <div class="logowrap">
    	<div class="logo">
            <img src="<%=basePath%>images/logo.jpg">
            <img src="<%=basePath%>images/index_17.jpg">
        </div>
        <div class="search">
        	<input type="search" class="schtext" value="请输入要查找的内容" onClick="value=''">
            <input class="searchbtn" type="submit" value="搜索">
        </div>
    </div>
    <!--start nav-->
    <div class="navwrap" id="navigation_menu_index"></div>
    <!--end nav-->
    <div class="infonav">
        <img src="<%=basePath%>images/infonavL.jpg" width="2" height="39" style="float:left;">
        <div class="infonav-con">
        	<strong>育儿常识:</strong>
            <a href="#"><span class="infocont" style="background:#ffc29d;">备孕</span></a>
            <a href="#"><span class="infocont" style="background:#feacae;">怀孕</span></a>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3;"></span>
            <span class="nocont" style="background:#ffe7e3; margin-right:3px;"></span>
            <a href="#"><span class="infocont" style="background:#ffd3d4;">11周-20周</span></a>
            <a href="#"><span class="infocont" style="background:#feacae;">21周-30周</span></a>
            <a href="#"><span class="infocont" style="background:#feacae;">31周-40周</span></a>
            <a href="#"><span class="infocont" style="background:#b8d992;">宝宝出生</span></a>
            <a href="#"><span class="infocont" style="background:#a1e3bf;">满月</span></a>
            <a href="#"><span class="infocont" style="background:#aad7f6;">周岁</span></a>
            <a href="#"><span class="infocont" style="background:#c8c9f5;">3周岁</span></a>            
        </div>
        <img src="<%=basePath%>images/infonavR.jpg" width="2" height="39" style="float:right;">
    </div>
<!--end top-->
<!--start 列表-->
    <div class="main">
    	<div class="main-l">
        	<div class="zy-listnav" name="navigate" id="${id}" pId="${pid}"></div>
            <div class="listshow">
            	<div class="showtop">
                	<p class="showtitle">${firstJcwenda.name}</p>
                    <p class="showdate"><s:date name="firstJcdaan.createdDate" format="yyyy-MM-dd HH:mm:ss" /></p>
                </div>
                <div class="showcont">
                    <div style="font-size:14px;">${firstJcdaan.name}</div>
                </div>
            </div>
            <!--分页-->
            <%--<div class="show_next" style="clear:both; padding:30px;">
            	<a href="#" class="pk-title l">上一篇：自身反射性保护机能</a>
                <a href="#" class="pk-title r">下一篇：怀孕1周营养指南</a>
            </div>
            --%><!--分页-->
            <div class="show-about">
            	<h3>相关阅读</h3>
                <ul>
                    <li><a href="#">宝宝冬季吃多少鲜果才合适？</a><span>2015.1.27</span></li>
                    <li><a href="#">宝宝冬季吃多少鲜果才合适？</a><span>2015.1.27</span></li>
                    <li><a href="#">宝宝冬季吃多少鲜果才合适？</a><span>2015.1.27</span></li>
                    <li><a href="#">宝宝成长少不了益智类玩具</a><span>2015.2.8</span></li>
                </ul>
            </div>
        </div>
        <div class="main-r">
        	<div class="main-r-out">
            	<div class="duanxin">
                	<p class="r-title">育婴短信</p>
                    <form>
                    	<div class="dx-l l">
                        	<input type="tel" placeholder="请输入手机号">
                    		<input type="datetime" placeholder="选择宝宝出生日期或预产期">
                        </div>
                    	<input class="duanxinbtn l" type="button">
                    </form>
                </div>
            	<div class="zhinan">
                	<div class="zhinan-top pk">本期短信孕育指南</div>
                    <p>　　孕期生活的贴心顾问，生命健康的科学指南。倡导人口健康,提高生命质量。集权威性、专业性、服务性、娱乐性为一体，营造血脉相传的浓郁亲情和时尚健康的孕育生活理念，重点为有生育计划的家庭、孕产妇家庭以及婴幼儿家庭提供生理、心理卫生健康及优生优育知识服务。</p>
                    <div class="r-tel">
                    	<span class="pk">专业客服热线：</span><img src="<%=basePath%>images/tel.jpg" width="123" height="19">
                    </div>
                </div>
            </div>
            <div class="main-r-out" style="margin-top:15px;">
            	<p class="r-title">儿童体检</p>
                <div class="r-news" id="hotChildArticle_first"></div>
                <ul class="r-newsul" id="hotChildArticle"></ul>
                <div style="clear:both;"></div>
            </div> 
            <div class="zy-rout" style="margin-top:15px;">
            	<p class="r-title">热门排行</p>
                <ul class="zy-rul" id="hotPregnantArticle"></ul>
            </div>
            <div class="mainr-toolf pk">
            	<p>实用小工具</p>
                <ul>
                	<li><a href="#"><img src="<%=basePath%>images/index_36.jpg" width="29" height="27"><span>生辰八字查询</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_39.jpg" width="29" height="27"><span>安全期计算</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_43.jpg" width="29" height="27"><span>怀孕日历表</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_44.jpg" width="29" height="27"><span>胎儿发育图</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_47.jpg" width="29" height="27"><span>生男生女预测</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_51.jpg" width="29" height="27"><span>预产期计算器</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_48.jpg" width="29" height="27"><span>胎儿体重计算</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_52.jpg" width="29" height="27"><span>身高体重计算</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_58.jpg" width="29" height="27"><span>宝宝名字测试</span></a></li>
                    <li><a href="#"><img src="<%=basePath%>images/index_56.jpg" width="29" height="27"><span>宝宝免费起名</span></a></li>
                </ul>
            </div>    
    	</div>
    </div>
<!--end 列表-->
    
<!--合作伙伴-->
	<div class="link">
    	<p>合作伙伴</p>
        <ul>
        	<li><a href="#">河北省妇幼保健院</a></li><li><a href="#">藁城市妇幼保健院</a></li><li><a href="#">石家庄市四院</a></li><li><a href="#">河北省二院</a></li><li><a href="#">石家庄白求恩医院</a></li><li><a href="#">健康百科</a></li><li><a href="#">亲子中心</a></li><li><a href="#">备孕妈妈邦</a></li><li><a href="#">搜狐母婴</a></li><li><a href="#">童装资讯</a></li><li><a href="#">石家庄白求恩医院</a></li><li><a href="#">健康百科</a></li><li><a href="#">辛集市妇幼保健院</a></li><li><a href="#">母婴知识</a></li><li><a href="#">儿科</a></li><li><a href="#">石家庄市四院</a></li><li><a href="#">河北省蕴育医院</a></li>
        </ul>
    </div>
    
    <div class="state">
    	声明：本站信息仅供参考——不能作为诊断及医疗的依据，详情请谨遵医嘱或咨询师。本站不承担由此引起的法律责任。
    </div>
    <div class="footernav">
    	<a href="#"><span>网站简介</span></a>&nbsp;|&nbsp;<a href="#"><span>版权声明</span></a>&nbsp;|&nbsp;<a href="#"><span>联系我们</span></a>&nbsp;|&nbsp;<a href="#"><span>客户服务</span></a>&nbsp;|&nbsp;<a href="#"><span>诚征英才</span></a>&nbsp;|&nbsp;<a href="#"><span>意见反馈</span></a>&nbsp;|&nbsp;<a href="#"><span>快速导航</span></a>&nbsp;|&nbsp;<a href="#"><span>帮助中心</span></a>
    </div>
    <div class="footer">
    	<p>
        Copyright © 2015 libubaby.com Inc. All Rights Reserved. 励步宝宝 版权所有<br>
        不良信息举报电话：0311-87654321 全国免费服务热线：40004-22332 举报邮箱：jubao@libubaobao.com<br>
        提供医院、疾病信息在线咨询服务  未经授权请勿转载
        </p>
    </div>
</body>
<script type="text/javascript">
	expertAnswer.detail_init();
</script>
</html>