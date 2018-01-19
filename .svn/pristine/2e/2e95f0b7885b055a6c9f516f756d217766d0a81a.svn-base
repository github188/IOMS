/**
 * jQuery manage plugins
 * Version 1.19 (2010.11.16)
 * @requires jQuery v1.4 or later,
 * 			 pager v1.0 (jQuery plugin) 改进版
 *           tablesorter (jQuery plugin)
 *           form v2.18(jQuery plugin)
 *           validate v1.5.5(jQuery plugin)
 *           nyroModal v1.6.2(jQuery plugin)
 *           metadata v2.1(jQuery plugin)
 *
 *  @author: Tom (tomesc@msn.com)
 *
 * 
 *
 *  简单使用： .manage()
 *
 *  参数说明：(与默认值一致的参数可省略不传)
 *     pagerForm: 分页查询form表单的id,默认为 '#listForm'。
 *     pagerUrl:分页查询form表单的action,默认值为false,不执行查询；
 *     	设为true，执行查询；
 *     	设为url，直接设置到form的action上，不建议使用此种方式，留此选择为向下兼容。
 *     
 *     pagerButton:分页查询form表单的查询按钮id,默认值'#queryButton'。
 *     refresh:分页栏中是否显示 刷新按钮，默认不显示 <目前还没有实现的选项>。
 *
 *     add:添加是否使用弹出层的方式，默认值 false,
 *         如果为需要使用弹出层的话，请注意将 add所在的a标签的class设置为 'my_add',add值的设置方式如下：
 *         		1.如果使用弹出层大小自适应或者与修改、查看一样，请设置此值为true,
 *         		2.如果add使用单独的大小，并且所有的add使用一样的，请设置为 {boxwidth:xxx,boxheight:yyy},其中xxx,yyy为要设置的宽和高
 *          	3.如果有多个添加弹出层，并且大小不一样，请设置为 '{"my_add1":{"boxwidth":"xxx","boxheight":"yyy"},...}',
 *          		其中 my_add1为相对应的按钮的class,xxx、yyy为要设置的宽和高；多个建议使用 my_add1,my_add2的方式来区别，
 *          		也可以使用 my_add_user,my_add_role等更具有描述性的词来区分
 *              4.如果有多个添加弹出层，并且大小不一样，还可以如下设置：(since 1.19)
 *                  将add设置为true,
 *                  将add所在的a 标签的class设置为 'my_add {boxwidth:xxx,boxheight:yyy}'
 *     addCallback:添加完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *     
 *     edit:修改是否使用弹出层方式,默认值 false，
 *     		 如果为需要使用弹出层的话，请注意将 edit所在的a标签的class设置为 'my_edit',edit值的设置方式如下：
 *         		1.如果使用弹出层大小自适应或者与添加、查看一样，请设置此值为true,
 *         		2.如果edit使用单独的大小，并且所有的edit使用一样的，请设置为 {boxwidth:xxx,boxheight:yyy},其中xxx,yyy为要设置的宽和高
 *          	3.如果有多个添加弹出层，并且大小不一样，请设置为 '{"my_edit1":{"boxwidth":"xxx","boxheight":"yyy"},...}',
 *          		其中 my_edit1为相对应的按钮的class,xxx、yyy为要设置的宽和高；多个建议使用 my_edit1,my_edit2的方式来区别，
 *          		也可以使用 my_edit_usr,my_edit_role等更具有描述性的词来区分
 *              4.如果有多个弹出层，并且大小不一样，还可以如下设置：(since 1.19)
 *                  将edit设置为true,
 *                  将edit所在的a 标签的class设置为 'my_edit {boxwidth:xxx,boxheight:yyy}'
 *     editCallback:修改完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *     
 *     view:显示详情页是否使用弹出方式，默认值true,
 *         如果为需要使用弹出层的话，请注意将 view所在的a标签的class设置为 'my_view',view值的设置方式如下：
 *         		1.如果使用弹出层大小自适应或者与添加、查看一样，请设置此值为true,
 *         		2.如果view使用单独的大小，并且所有的view使用一样的，请设置为 {boxwidth:xxx,boxheight:yyy},其中xxx,yyy为要设置的宽和高
 *          	3.如果有多个添加弹出层，并且大小不一样，请设置为 '{"taii_view1":{"boxwidth":"xxx","boxheight":"yyy"},...}',
 *          		其中 my_view1为相对应的按钮的class,xxx、yyy为要设置的宽和高；多个建议使用 my_view1,my_view2的方式来区别，
 *          		也可以使用 my_view_usr,my_view_role等更具有描述性的词来区分
 *          	4.如果有多个弹出层，并且大小不一样，还可以如下设置：(since 1.19)
 *                  将view设置为true,
 *                  将view所在的a 标签的class设置为 'my_view {boxwidth:xxx,boxheight:yyy}'
 *     boxwidth:添加，修改，显示详情中弹出层的最小宽度，默认值为false，自适应。如果各不相同，请单独设置.设置方法参见各自的说明
 *     boxheight:添加，修改，显示详情中弹出层的最小高度，默认值为false,自适应 。如果各不相同，请单独设置.设置方法参见各自的说明
 *
 *     del:是否使用ajax进行删除操作，默认值,false
 *     如果为true的话，请注意将del所在的标签 onclick设为 "delSubmit({id:'${vo.intValue}'})",
 *     其中{}中为需要传值的部分,使用标准的jQuery格式;<以后可能会改为使用 <a href="" class="my_remove">的方式来进行>
 *	   $$$$$$不建议使用这个del模式了，已经可以使用改为使用 <a href="" class="my_remove">的方式来进
 *		delCallback:del完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *
 *	   remove:<del的升级版>是否使用ajax进行删除操作，默认值,false
 *		如果需要确认，请将确认信息写在update所在的a标签的confirm_message里
 *		如果为true,请将delete所在的a标签的class设置为 "my_remove"
 *		removeCallback:删除完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *
 *     popupRemove:是否使用弹出层来执行操作并在操作成功的情况下删除当前行，默认值：false
 *      		如果为需要使用弹出层的话，请注意将 popupRemove所在的a标签的class设置为 'my_popupRemove',popupRemove值的设置方式如下：
 *         			1.如果使用弹出层大小自适应或者与添加、修改、查看一样，请设置此值为true, 
 *         			2.如果popupRemove使用单独的大小，并且所有的popupRemove使用一样的，请设置为 {boxwidth:xxx,boxheight:yyy},其中xxx,yyy为要设置的宽和高
 *          		3.如果有多个添加弹出层，并且大小不一样，请设置为 '{"taii_popupRemove1":{"boxwidth":"xxx","boxheight":"yyy"},...}',
 *          			其中 my_popupRemove1为相对应的按钮的class,xxx、yyy为要设置的宽和高；多个建议使用 my_popupRemove1,my_popupRemove2的方式来区别，
 *          			也可以使用 my_popupRemove_usr,my_popupRemove_role等更具有描述性的词来区分
 *          		4.如果有多个弹出层，并且大小不一样，还可以如下设置：(since 1.19)
 *                  	将edit设置为true,
 *                  	将edit所在的a 标签的class设置为 'my_edit {boxwidth:xxx,boxheight:yyy}'
 *     popupRemoveCallback:删除完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *
 *	   operate:是否使用ajax进行其他类型的操作，默认值，false
 *	      如果为true,请将operate所在的a标签的class设置为 'my_operate'.
 *		如果需要确认，请将确认信息写在update所在的a标签的confirm_message里
 *       与remove的区别在于不删除当前行
 *		operateCallback:operate完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *
 *		update:是否使用ajax进行操作，并行操作完成之后更新当前行，默认值，false
 *		如果为true,请将update所在的a标签的class设置为'my_update'.
 *      如果需要确认，请将确认信息写在update所在的a标签的confirm_message里
 *		与operate的区别在于更新当前行
 *		updateCallback:update完成之后，页面进行特殊处理(将服务器返回的数据作为参数调用)
 *
 *     noteInfo:删除,添加，修改操作成功或失败之后信息显示的标签id，默认值为'#noteInfo'。
 *
 *     dataTabale:分页查询结果 table的id,为了使用页面排序功能，请按示例代码设置dataTable的thead,tbody等。
 *
 *     sortable:是否使用页面排序,默认值为 false,不使用页面排序。
 *     sortConifg:排序的配置,格式为{ 0: { sorter: "digit"}, 5: {sorter: false}}，
 *     			    其中前一个数字为列的排序,后一个为排序的方式：false为不排序,"digit"为数字
 *
 *
 *  与页面的约定：
 *     1.查询结果页面，在需要显示分页的地方使用<div class="pager" totalcount="" pagecount=""></div>,可以在多个地方使用，
 *       其中 totalcount 与pagecount属性是为了给 pager插件传 总记录数和总页数而设，请务必传入正确的值。
 *     2.使用页面排序的时候，查询结果页面的table必须包含 thead 与tbody标签。
 *
 *     3.添加页面，验证的
 *      submitHandler: function(form) {
 *			parent.addSubmit(form);
 *		}
 *
 *	   4.修改页面，验证的
 *     submitHandler: function(form) {
 *			parent.editSubmit(form);
 *		}
 *
 *     5.查询之后 返回的页面遵循如下的格式：
 *     其中 <div class="pager".....> 是分页导航用的，可以只有一个
 *      <div class="pager" totalcount="${pagn.totalCount}" pagecount="${pagn.pageCount}"></div>
 *			<table id="my_resultTable" >
 *				<thead>
 *					<tr>
 *						<th>整型11111111</th>
 *						<th>浮点型</th>
 *						<th>日期型</th>
 *						<th>文本型</th>
 *						<th>布尔型</th>
 *						<th>操作</th>
 *					</tr>
 *				</thead>
 *				<tbody>
 *					<c:forEach items="${pagn.result}" var="entity" varStatus="voStatus">
 *						<%@ include file="/WEB-INF/jsp/samples/jquery14/row.jsp"%>
 *					</c:forEach>
 *				</tbody>
 *			</table>
 *		<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
 *
 *     6.添加，修改,删除之后 之后如果需要及时在页面显示 则遵循如下格式，
 *     其中 row.jsp页面是页面显示的一行数据，
 *     noteInfo.jsp是标准文件，一个项目只需要一份，使用时直接从ccc-common项目中拷贝
 *      <div>
 *			<%@ include file="/WEB-INF/jsp/noteInfo.jsp"%>
 *			<table id="my_resultData">
 *				<%@ include file="/WEB-INF/jsp/samples/jquery14/row.jsp"%>
 *			</table>
 *		</div>
 *
 *
*/
var pathName = window.location.pathname;
var baseUrl = pathName.substr(0,pathName.substr(1).indexOf("/")+1)+"/";
(function($){
	var $mymanage;
	var clicked;
	
	$.extend($.fn,{
		manage : function(options){
			$mymanage = new $.mymanage(options,this[0]);
			return $mymanage;
		}
	});
	
	$.mymanage = function(options,targetDiv){//选项
		this.init(options,targetDiv);
	};
	

	//添加操作完成之后，页面显示提示信息和数据
	addSubmit=function(targetform,option){
		var options = {
				success:function SubmitSuccess(responseText){
					var result = $(responseText).find("#my_resultMessage");
					if($(result).hasClass("my_success")){
						if(clicked){
							$(clicked).removeClass("ui-click");
						}
						clicked = $(responseText).find("#my_resultData > tbody > tr")
						.addClass("ui-click").hover(function(e){
							$(e.target).parents("tbody > tr").addClass("ui-mouseover");
						},function(e){
							$(e.target).parents("tbody > tr").removeClass("ui-mouseover");
						}).bind("click",$mymanage.processClick);
						$($mymanage.settings.dataTable).children("tbody").prepend($(clicked));
						$($mymanage.settings.dataTable).trigger("update");
						$mymanage.configeNyroModal();
						$mymanage.settings.totalcount++;
						$(".totalcount").html($mymanage.settings.totalcount);
					}

					$($mymanage.settings.noteInfo).html(result);
					if($mymanage.settings.addCallback instanceof Function){
						$mymanage.settings.addCallback(responseText);
					}
					$.nyroModalRemove();//关闭层
				}
			};
			$.extend(options,option);
			$(targetform).ajaxSubmit(options);
	}

	//异步删除,不推荐使用了
	delSubmit=function(datas){
		createLoading();
		$.ajax({
			url:$mymanage.settings.delUrl,
			type:"POST",
			data:datas,
			dataType:'html',
			success:function(responseText){
				var result = $(responseText).find("#my_resultMessage");
				$($mymanage.settings.noteInfo).html(result);
				if($(result).hasClass("my_success")){
					$(clicked).remove();
					clicked = "";
					$($mymanage.settings.dataTable).trigger("update");
					$mymanage.settings.totalcount--;
					$(".totalcount").html($mymanage.settings.totalcount);
				}
				if($mymanage.settings.delCallback instanceof Function){
					$mymanage.settings.delCallback(responseText);
				}
				removeLoading();
			}
		});
	}
	
	downloadSubmit = function(event){
		var $a = checkUrl(event.target);
		var myUrl = $a.attr("href");
		if(!myUrl) return false;
		var confirm_message = $a.attr("confirm_message");
		if(confirm_message){
			if(!confirm(confirm_message)){
				return false;
			}
		}
		createLoading();
		$.ajax({
			url:myUrl,
			type:"POST",
			dataType:'html',
			success:function(responseText){
				var result = $(responseText).find("#my_resultMessage");
				$($mymanage.settings.noteInfo).html(result);
				if($(result).hasClass("my_success")){
					$(clicked).remove();
					clicked = "";
					$($mymanage.settings.dataTable).trigger("update");
					$mymanage.settings.totalcount--;
					$(".totalcount").html($mymanage.settings.totalcount);
				}
				if($mymanage.settings.removeCallback instanceof Function){
					$mymanage.settings.removeCallback(responseText);
				}
				removeLoading();
			}
		});
		return false;
	}

		//异步删除,del的改进版
	removeSubmit=function(event){
		var $a = checkUrl(event.target);
		var myUrl = $a.attr("href");
		if(!myUrl) return false;
		var confirm_message = $a.attr("confirm_message");
		if(confirm_message){
			if(!confirm(confirm_message)){
				return false;
			}
		}
		createLoading();
		$.ajax({
			url:myUrl,
			type:"POST",
			dataType:'html',
			success:function(responseText){
				var result = $(responseText).find("#my_resultMessage");
				$($mymanage.settings.noteInfo).html(result);
				if($(result).hasClass("my_success")){
					$(clicked).remove();
					clicked = "";
					$($mymanage.settings.dataTable).trigger("update");
					$mymanage.settings.totalcount--;
					$(".totalcount").html($mymanage.settings.totalcount);
				}
				if($mymanage.settings.removeCallback instanceof Function){
					$mymanage.settings.removeCallback(responseText);
				}
				removeLoading();
			}
		});
		return false;
	}
	
	//弹出层进行处理，处理成功则删除当前行
	popupRemoveSubmit=function(targetform,option){
		var options = {
				success:function SubmitSuccess(responseText){
					var result = $(responseText).find("#my_resultMessage");
					if($(result).hasClass("my_success")){
						$(clicked).remove();
						clicked = "";
						$($mymanage.settings.dataTable).trigger("update");
						$mymanage.settings.totalcount--;
						$(".totalcount").html($mymanage.settings.totalcount);
					}
					$($mymanage.settings.noteInfo).html(result);
					if($mymanage.settings.popupRemoveCallback instanceof Function){
						$mymanage.settings.popupRemoveCallback(responseText);
					}
					$.nyroModalRemove();//关闭层
				}
			};
			$.extend(options,option);
			$(targetform).ajaxSubmit(options);
	}
	
	function createLoading(target){
		var $top = document.body.clientHeight / 2 - 20;
		var $left = document.body.clientWidth /2 - 150;
		$("body").append('<div id="operate_loading" class="my_loading" style="vertical-align:middle;position:absolute;z-index:999;top:'+$top+'px;left:'+$left+'px;width:500px;height:42px;"><img src="'+baseUrl+'images/loading3.gif" style="vertical-align: middle;"/><strong><a style="font-size:x-large;color: red;font-weight:bold">操作进行中，请稍候…</a>…</strong></div>');
	}
	
	function removeLoading(){
		$("#operate_loading").remove();
	}

	//异步操作，不删除也不更新当前选择的行
	operateSubmit = function(event){
		var $a = checkUrl(event.target);
		var myUrl = $a.attr("href");
		if(!myUrl) return false;
		var confirm_message = $a.attr("confirm_message");
		if(confirm_message){
			if(!confirm(confirm_message)){
				return false;
			}
		}
		createLoading();
		$.ajax({
			url:myUrl,
			type:"POST",
			datType:"html",
			success:function(responseText){
				var result = $(responseText).find("#my_resultMessage");
				$($mymanage.settings.noteInfo).html(result);
				if($(result).hasClass("my_success")){
					var theTr = $(responseText).find("#my_resultData > tbody > tr");
					if(theTr && theTr.length > 0){
						clicked = $(theTr).addClass("ui-click").hover(function(e){
							$(e.target).parents("tbody > tr").addClass("ui-mouseover");
						},function(e){
							$(e.target).parents("tbody > tr").removeClass("ui-mouseover");
						}).bind("click",$mymanage.processClick).replaceAll($(clicked));
						$mymanage.configeNyroModal();
						$($mymanage.settings.dataTable).trigger("update");
					}
				}
				if($mymanage.settings.operateCallback instanceof Function){
					$mymanage.settings.operateCallback(responseText);
				}
				removeLoading();
			}
		})
		return false;
	}

	//异步操作，更新当前选择的行
	updateSubmit = function(event){
		var $a = checkUrl(event.target);
		var myUrl = $a.attr("href");
		if(!myUrl) return false;
		var confirm_message = $a.attr("confirm_message");
		if(confirm_message){
			if(!confirm(confirm_message)){
				return false;
			}
		}
		createLoading();
		$.ajax({
			url:myUrl,
			type:"POST",
			datType:"html",
			success:function(responseText){
				var result = $(responseText).find("#my_resultMessage");
				$($mymanage.settings.noteInfo).html(result);
				if($(result).hasClass("my_success")){
					var theTr = $(responseText).find("#my_resultData > tbody > tr");
					if(theTr && theTr.length > 0){
						clicked = $(theTr).addClass("ui-click").hover(function(e){
							$(e.target).parents("tbody > tr").addClass("ui-mouseover");
						},function(e){
							$(e.target).parents("tbody > tr").removeClass("ui-mouseover");
						}).bind("click",$mymanage.processClick).replaceAll($(clicked));
						$mymanage.configeNyroModal();
						$($mymanage.settings.dataTable).trigger("update");
					}
				}
				if($mymanage.settings.updateCallback instanceof Function){
					$mymanage.settings.updateCallback(responseText);
				}
				removeLoading();
			}
			
		})
		return false;
	}
	
	function checkUrl(theNode){
		var theNodeName = theNode.nodeName.toLowerCase();
		var $a = $(theNode);
		if(theNodeName != 'a'){
			$a = $(theNode).parent();
		}
		return $a;
	}

	//修改操作完成之后，页面显示提示信息和数据
	editSubmit=function(targetForm,option){
		var options = {
				success:function SubmitSuccess(responseText){
					var result = $(responseText).find("#my_resultMessage");
					if($(result).hasClass("my_success")){
						clicked = $(responseText).find("#my_resultData > tbody > tr").addClass("ui-click").hover(function(e){
							$(e.target).parents("tbody > tr").addClass("ui-mouseover");
						},function(e){
							$(e.target).parents("tbody > tr").removeClass("ui-mouseover");
						}).bind("click",$mymanage.processClick).replaceAll($(clicked));
						$mymanage.configeNyroModal();
						$($mymanage.settings.dataTable).trigger("update");
					}
					$($mymanage.settings.noteInfo).html(result);
					$.nyroModalRemove();//关闭弹出层
					if($mymanage.settings.editCallback instanceof Function){
						$mymanage.settings.editCallback(responseText);
					}
				}
			};
			$.extend(options,option);
			$(targetForm).ajaxSubmit(options);
		return false;	
	}

	

$.extend($.mymanage,{
	prototype:{
		init:function(options,targetDiv){
			this.settings = $.extend({},$.fn.manage.defaults,options);
			this.settings.dataDiv = targetDiv;
			this.configeNyroModal();//配置弹出层
			if(this.settings.pagerUrl && this.settings.pagerUrl != true){
				$(this.settings.pagerForm).attr("action",this.settings.pagerUrl);
			}
			var theRules = this.settings.pagerFormValidateRules;
			$(this.settings.pagerForm).validate({
				rules: theRules,
				submitHandler:function(){
					$mymanage.searchSubmit();
				}
			});	
			if(this.settings.pagerUrl){//如果pagerUrl设置为true或者真实的URL，则执行查询
				this.searchSubmit();              //执行第一次查询
			}else{//否则不执行查询，但是设置table的样式
				var myThis = this;
				$(this.settings.dataTable).children("tbody")
				.children("tr")
				.each(function(n){
					$(this).hover(function(e){
						$(e.target).parents("tbody > tr")
						.addClass("ui-mouseover");
					},function(e){
						$(e.target).parents("tbody > tr")
						.removeClass("ui-mouseover");
					}).bind("click",myThis.processClick);
				});
			}
			//设置如果是在文本框中回车，直接提交查询
			$(this.settings.pagerForm).find("input:text").keydown(function(even){
				if(even.keyCode == '13'){
					$mymanage.searchSubmit();
					return false;
				}
			});
			$(this.settings.pagerButton).live("click",function(){
				$mymanage.searchSubmit();
			});
		},
		configeNyroModal:function(){
			if(this.settings.view){
				$(".my_view").click(this.processClick);
				this.myNyroModal("my_view",this.settings.view,this.settings.view.boxwidth,this.settings.view.boxheight);
			}
			if(this.settings.edit){
				$(".my_edit").click(this.processClick);
				this.myNyroModal("my_edit",this.settings.edit,this.settings.edit.boxwidth,this.settings.edit.boxheight);
			}
			if(this.settings.popupRemove){
				$(".my_popupRemove").click(this.processClick);
				this.myNyroModal("my_popupRemove",this.settings.popupRemove,this.settings.popupRemove.boxwidth,this.settings.popupRemove.boxheight);
			}
			if(this.settings.add){
				this.myNyroModal("my_add",this.settings.add,this.settings.add.boxwidth,this.settings.add.boxheight);
			}
			if(this.settings.operate){
				$(".my_operate").unbind("click.manage");
				$(".my_operate").bind("click.manage",this.processClick).bind("click.manage",operateSubmit);
			}
			if(this.settings.update){
				$(".my_update").unbind("click.manage");
				$(".my_update").bind("click.manage",this.processClick).bind("click.manage",updateSubmit);
			}
			if(this.settings.remove){
				$(".my_remove").unbind("click.manage");
				$(".my_remove").bind("click.manage",this.processClick).bind("click.manage",removeSubmit);
			}
			if(this.settings.download){
				$(".my_download").unbind("click.manage");
				$(".my_download").bind("click.manage",this.processClick).bind("click.manage",downloadSubmit);
			}
		},
		myNyroModal: function(className,json,aboxwidth,aboxheight){
			var obj = jQuery.parseJSON(json);
			var myThis = this;
			if(obj){
				$("[class^='"+className+"']").each(function(){
					if(obj[$(this).attr("class")]){
						var theBoxwidth = obj[$(this).attr("class")]['boxwidth'];
						var theBoxheight = obj[$(this).attr("class")]['boxheight'];
						$(this).nyroModal({
				    		forceType:"iframe",
				    		minWidth:theBoxwidth,
				    		minHeight:theBoxheight,
				    		closeButton:null,
				    		bgColor:myThis.settings.bgColor
				    	});
					}else{
						$(this).nyroModal({
				    		forceType:"iframe",
				    		closeButton:null,
				    		minWidth:myThis.settings.boxwidth,
				    		minHeight:myThis.settings.boxheight,
				    		bgColor:myThis.settings.bgColor
				    	});
					}
				});
			}else{
				var theBoxwidth = myThis.settings.boxwidth;
				if(aboxwidth){
					theBoxwidth = aboxwidth; 
				}
				var theBoxheight = myThis.settings.boxheight;
				if(aboxheight){
					theBoxheight = aboxheight; 
				}
				var opts = {boxwidth:theBoxwidth,boxheight:theBoxheight};
				$("[class^='"+className+"']").each(function(){
					$this = $(this);
					var o = $.metadata ? $.extend({}, opts, $this.metadata()) : opts;
					$this.nyroModal({
			    		forceType:"iframe",
			    		closeButton:null,
			    		minWidth:o.boxwidth,
			    		minHeight:o.boxheight,
			    		bgColor:myThis.settings.bgColor
			    	});
				});
			}
		},
		searchSubmit:function() {//页面加载完成之后，执行查询
			var myThis = this;
		    var options = {
		            success: function SubmitSuccess(responseText){
		    			$(myThis.settings.dataDiv).html(responseText);
		    			myThis.settings.totalcount = $(".pager").attr("totalcount");
		    			myThis.settings.pagecount = $(".pager").attr("pagecount");
				        $(myThis.settings.noteInfo).html("");
				        myThis.processSearchResult(1);
				        if(myThis.settings.searchCallback){
				        	myThis.settings.searchCallback();
						}
		            }
		        };
		    	$(myThis.settings.dataDiv).html('<div  style="padding:20px;text-align: center;"><img src="'+baseUrl+'images/loading.gif" style="vertical-align: middle;"/>数据加载中……</div>');
		        $(myThis.settings.pagerForm).ajaxSubmit(options);
		},
		processSearchResult:function(pageclickednumber){
			var myThis = this;
			if(this.settings.sortable){
				$(this.settings.dataTable).tablesorter({
					headers:this.settings.sortConfig
				}).addClass("tablesorter");
			}
			$(this.settings.dataTable).children("tbody")
			.children("tr")
			.each(function(n){
				$(this).hover(function(e){
					$(e.target).parents("tbody > tr")
					.addClass("ui-mouseover");
				},function(e){
					$(e.target).parents("tbody > tr")
					.removeClass("ui-mouseover");
				}).bind("click",myThis.processClick);
			});
			this.configeNyroModal();
		    $(".pager").pager({ 
		    	pagenumber: pageclickednumber, 
		    	pagecount: this.settings.pagecount,
		    	totalcount:this.settings.totalcount, 
		    	buttonClickCallback: this.pageClick 
		    });
			this.currentPage = pageclickednumber;
		},
		pageClick : function (pageclickednumber){
	   		 var options = {
		    		data:{pageNo:pageclickednumber},
		            success: function SubmitSuccess(responseText){
		    			$($mymanage.settings.dataDiv).html(responseText);
		    			$mymanage.processSearchResult(pageclickednumber);
		    			 if($mymanage.settings.searchCallback instanceof Function){
		    				 $mymanage.settings.searchCallback();
							}
		            }
		        };
	   		$($mymanage.settings.dataDiv).html('<div  style="padding:20px;text-align: center;"><img src="'+baseUrl+'images/loading.gif" style="vertical-align: middle;"/>数据加载中……</div>');
		    $($mymanage.settings.pagerForm).ajaxSubmit(options);
	   	},
		processClick:function  (e){
			$($mymanage.settings.dataTable).children("tbody").children("tr").removeClass("ui-click");
			clicked = $(e.target).parents("tbody > tr");
			$(clicked).addClass("ui-click");
		}
		
	}
	
});

$.fn.manage.defaults = {
	pagerForm:'#listForm', //分页查询form的id
	pagerFormValidateRules:{},
	pagerUrl:false,           //分页查询的Url
	searchCallback:function(){},
	pagerButton:"#queryButton", //分页查询form提交按钮的id
	refresh:false,
	add:false,                //添加是否使用弹出层，如果为true,请将 添加标签的class设置为 my_add
	addCallback:function(){},
	edit:false,				  //修改是否使用弹出层，如果为true,请将 修改标签的class设置为 my_edit
	editCallback:function(){},
	view:false,               //查看是否使用弹出层，如果为true,请将 查看标签的class设置为 my_view
	del:false,                //删除是否使用局部刷新
	delUrl:false,
	delCallback:function(){},
	remove:false,				//删除异步操作的改进版，对页面的影响降低了
	removeCallback:function(){},
	popupRemove:false,
	popupRemoveCallback:function(){},
	operate:false,			  //异步操作，与del区别在于不删除当前行
	operateCallback:function(){},
	update:false,			   //异步操作，与operate的区别在于
	updateCallback:function(){},
	download:false,
	downloadCallback:function(){},
	dataTable:"#dataTable",   //查询之后，返回结果table的id

	boxwidth:false,             //默认弹出层最小宽度
	boxheight:false,            //默认弹出层最小高度

	noteInfo:"#noteInfo",     //显示操作成功与否信息的标签id
	bgColor:"#4f4f4f",
	sortable:false,//是否使用页面排序功能
	sortConfig:{}, //页面排序的配置
	
	debug:false//是否启用DEBUG模式，true启用;false不启用
};

})(jQuery);