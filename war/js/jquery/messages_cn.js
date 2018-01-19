/*
 * Translated default messages for the jQuery validation plugin.
 * Language: CN
 * Author: Fayland Lam <fayland at gmail dot com>
 */
//baseUrl,如果应用的部署没有contextPath，将此处的baseUrl改成/
var pathName = window.location.pathname;
var baseUrl = pathName.substr(0,pathName.substr(1).indexOf("/")+1)+"/";
jQuery.extend(jQuery.validator.messages, {
        required: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项",
		remote: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;输入值已存在",
		equalTo: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请再次输入相同的值",
		
		url: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查网址",
		date: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查日期",
		dateISO: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查日期 (ISO).",
		number: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字",
		digits: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入非负整数",
		accept: "&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入拥有合法后缀名的字符串",
		zipcode:"&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查邮政编码",
		
		maxlength: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入最多 {0}个字符"),
		minlength: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入最少 {0} 个字符"),
		rangelength: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		range: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入一个介于 {0} 和 {1} 之间的值"),
		max: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入一个最大为 {0} 的值"),
		min: jQuery.validator.format("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入一个最小为 {0} 的值")
});
