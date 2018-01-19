/*
 * Translated default messages for the jQuery validation plugin. Language: CN
 * Author: Fayland Lam <fayland at gmail dot com>
 */
// baseUrl,如果应用的部署没有contextPath，将此处的baseUrl改成/
var pathName = window.location.pathname;
var baseUrl = pathName.substr(0, pathName.substr(1).indexOf("/") + 1) + "/";

// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
	var exp = /^[0-9]{11}$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查手机号码");

// 电话号码验证
jQuery.validator
		.addMethod(
				"phone",
				function(value, element) {
					//duanyanlin 调整固定电话格式 010-3212142-000
					//var phone = /^(0[0-9]{2,3}\-)+([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
					var phone = /^(0[0-9]{2,3}-)+([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/;
					return this.optional(element) || (phone.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查电话号码,格式为：区号-号码-分机号");

// 电话号码/手机号码混合验证
jQuery.validator
.addMethod(
		"phoneAndMobile",
		function(value, element) {
			var phone = /^(0[0-9]{2,3}\-)+([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
			var mobile = /^[0-9]{11}$/;
			return this.optional(element) || (phone.test(value))
			|| (mobile.test(value));
		},
		"&nbsp;<img src='"
		+ baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查号码格式：区号-号码(-分机号)或11位手机号码");
// 电话号码/手机号码混合验证
jQuery.validator
.addMethod(
		"phoneIOMS3",
		function(value, element) {
			/** duanyanlin 调整固定电话格式 010-3212142-000 */
			var phone = /^([0-9][0-9\-]{8,18}[0-9])?$/;
			return this.optional(element) || (phone.test(value));
		},
		"&nbsp;<img src='"
		+ baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查号码格式：10-20位数字或'-',且以数字开头和结尾");

// 纯中文
jQuery.validator.addMethod("chinese", function(value, element) {
	var exp = /^[\u4e00-\u9fa5]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入中文");

// 中文名称
jQuery.validator.addMethod("chineseName", function(value, element) {
	var exp = /^[\u4e00-\u9fa5\\\/]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入中文及斜杠");

// 英文名称
jQuery.validator.addMethod("lowerEnglishName", function(value, element) {
	var exp = /^[a-z]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入小写英文");

jQuery.validator.addMethod("englishName", function(value, element) {
	var exp = /^[a-zA-Z]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入英文");

// 英文名称
jQuery.validator.addMethod("english", function(value, element) {
	var exp = /^[a-zA-Z\\\/]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入英文和斜杠");
// resourceId
jQuery.validator
		.addMethod(
				"resourceId",
				function(value, element) {
					var exp = /^[a-z_]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入小写英文和下划线");
// 大小写英文，纯中文
jQuery.validator
		.addMethod(
				"description",
				function(value, element) {
					var exp = /^[0-9\u4e00-\u9fa5a-z_A-Z]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,下划线");

jQuery.validator
		.addMethod(
				"memo",
				function(value, element) {
					var exp = /^[0-9a-z_A-Z\u4e00-\u9fa5\uFE30-\uFFA0\s(\（|\）|\！|\？|\。|\，|\《|\》|\{|\}|\【|\】|\“|\”|\·|\、|\：|\；|\‘|\’|\……|\_|\-|\#|\@|\%|\^|\&|\*|\,|\.|\/|\\|\;|\'|\"|\:|\;|\[|\])+]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,标点符号,空白符");

// 小写英文，数字，纯中文
jQuery.validator
		.addMethod(
				"soleName",
				function(value, element) {
					var exp = /^[0-9a-z\u4e00-\u9fa5]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,小写英文");
// 小写英文，数字
jQuery.validator.addMethod("loginName", function(value, element) {
	var exp = /^[0-9a-z]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,小写英文");

// 密码6-20位
jQuery.validator
		.addMethod(
				"password",
				function(value, element) {
					if (this.optional(element))
						return "dependency-mismatch";
					if (value.length < 6 || value.length > 16) {
						return false;
					}
					var exp = /^[0-9a-zA-Z]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入[6,16]位大小写英文或数字");

// IP验证
jQuery.validator
		.addMethod(
				"ip",
				function(value, element) {
					var tel = /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/;
					return this.optional(element) || (tel.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查IP地址");

// IP验证
jQuery.validator
		.addMethod(
				"uri",
				function(value, element) {
					var uri = /^(\/[a-zA-Z0-9]+)+(\.[a-zA-Z]{2,6})$/;
					;
					return this.optional(element) || (uri.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查URL格式(/a/b.do)");
// 非汉字
jQuery.validator.addMethod("noCharacter", function(value, element) {
	// var reg = /^[\u4e00-\u9fa5]+$/;
	var reg = /^([^\u4e00-\u9fa5])+$/;
	return this.optional(element) || (reg.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;不能输入中文");

// email
jQuery.validator
		.addMethod(
				"email",
				function(value, element) {
					var reg = /^[a-zA-Z0-9]([a-zA-Z0-9]*[-_\.]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$/i;
					return this.optional(element) || (reg.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp; 请检查您的Email");

jQuery.validator.addMethod("noLower", function(value, element) {
	// var reg = /^[\u4e00-\u9fa5]+$/;
	var reg = /^[^a-z]+$/;
	return this.optional(element) || (reg.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;不能输入小写英文字母");

jQuery.validator
		.addMethod(
				"kuServiceCode",
				function(value, element) {
					var exp = /^[0-9A-Z-]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,大写英文,-");

jQuery.validator.addMethod("kuNodeCode", function(value, element) {
	var exp = /^[0-9A-Z]+$/;
	return this.optional(element) || (exp.test(value));
}, "&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,大写英文");

// zipcode邮政编码
jQuery.validator.addMethod("zipcode", function(value, element) {
	var reg = /^[0-9]{6}$/;
	return this.optional(element) || (reg.test(value));
}, "<font color='red'>请正确输入邮政编码</font>");

jQuery.validator
		.addMethod(
				"DLCIVPIVCI",
				function(value, element) {
					var exp = /^[0-9.]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字和（或）.的组合，如123或者2.369");

jQuery.validator
		.addMethod(
				"BUSINESSRATE",
				function(value, element) {
					var exp = /^[0-9a-zA-z.]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字和（或）字母的组合，如123kbps");

jQuery.validator
		.addMethod(
				"VRF",
				function(value, element) {
					var exp = /^[a-zA-Z-]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入字母和（或）-的组合");

jQuery.validator
		.addMethod(
				"KUCIRCUITNAME",
				function(value, element) {
					var exp = /^[0-9a-zA-Z-]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入字母、数字和-的组合，如abcCDE-1,201054-R");

jQuery.validator
		.addMethod(
				"RDRT",
				function(value, element) {
					var exp = /^[0-9:]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字和:的组合，如234:678");

jQuery.validator
		.addMethod(
				"MPLSVPNPORT",
				function(value, element) {
					var exp = /^[a-zA-Z0-9\/.]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入字母、数字和（或）/的组合，如F2/1.103");

jQuery.validator
		.addMethod(
				"MPLSVPNPORTIP",
				function(value, element) {
					var exp = /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)\/[0-9]{1,2}$/;
					if (this.optional(element)) {
						return true;
					} else {
						if (exp.test(value)) {
							var i = parseInt(value.split("/")[1]);
							if (i >= 0 && i <= 32) {
								return true;
							} else {
								return false;
							}
						} else {
							return false
						}
					}
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查!格式为：xxx.xxx.xxx.xxx/aa，xxx取值0-255，aa取值0-32");

jQuery.validator
		.addMethod(
				"KUBOXNUM",
				function(value, element) {
					var exp = /^[0-9]{1,4}$/;
					if (this.optional(element)) {
						return true;
					} else {
						if (exp.test(value)) {
							var i = parseInt(value);
							if (i >= 0 && i <= 1000) {
								return true;
							} else {
								return false;
							}
						} else {
							return false
						}
					}
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请检查!数字，取值0-1000");
