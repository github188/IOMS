<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<script type="text/javascript">
	$(function() {
		$("#tree")
				.tree(
						{
							data : {
								type : "html",
								async : true,
								opts : {
									async : true,
									method : "GET",
									url : "${rootUrl}acl/resource/getByParent.dox"
								}
							},
							callback : {
								beforedata : function(node, tree) {
									if (node == false) {
										tree.settings.data.opts.url = false;
										return false;
									}
									var id = $(node).attr("id") || "-1";
									tree.settings.data.opts.url = "${rootUrl}acl/resource/getByParent.dox";
									if (id.indexOf("MENU_") >= 0) {
										return {
											pType : "MENU",
											pid : id.replace("MENU_", "")
										};
									}
									if (id.indexOf("COLUMN_") >= 0) {
										return {
											pType : "COLUMN",
											pid : id.replace("COLUMN_", "")
										};
									}

								},
								onselect : function(node, tree) {
									$("#listForm").resetForm();
									var id = $(node).attr("id") || "-1";
									if (id.indexOf("TREE_") >= 0) {
										$("#pid").val("");
										$("#pType").val("ROOT");
										$("#add_a")
												.attr("href",
														"${rootUrl }acl/resource/add.do?type=MENU&pid=");
										$("#addLinkName").html("添加菜单");
										$("#add_div").show();
										$("#add_n").attr("href", "#");
										$("#add_no_div").hide();
									} else if (id.indexOf("MENU_") >= 0) {
										$("#pid").val(id.replace("MENU_", ""));
										$("#pType").val("MENU");
										$("#add_a").attr(
												"href",
												"${rootUrl }acl/resource/add.do?type=COLUMN&pid="
														+ id.replace("MENU_",
																""));
										$("#addLinkName").html("添加子菜单");
										$("#add_div").show();

										$("#add_n").attr("href", "#");
										$("#add_no_div").hide();

									} else if (id.indexOf("COLUMN_") >= 0) {
										$("#pid")
												.val(id.replace("COLUMN_", ""));
										$("#pType").val("COLUMN");

										$("#add_a").attr(
												"href",
												"${rootUrl }acl/resource/add.do?type=URL&pid="
														+ id.replace("COLUMN_",
																""));
										$("#addLinkName").html("添加操作");
										$("#add_div").show();

										$("#add_n").attr(
												"href",
												"${rootUrl }acl/resource/add.do?type=DOM&pid="
														+ id.replace("COLUMN_",
																""));
										$("#add_no_div").show();
									} else {//非菜单
										$("#add_a").attr("#");
										$("#addLinkName").html("");
										$("#add_div").hide();

										$("#add_n").attr("href", "#");
										$("#add_no_div").hide();
									}
									$("#queryButton").trigger("click");
									//$(node).trigger("click");
								},
								oncreate : function(NODE, REF_NODE, TYPE,
										TREE_OBJ, RB) {
									$(NODE).find("ins").remove();
								},
								onopen : function(node, tree) {
									//var nodeId = $(node).attr("id");
									//$(node).siblings().each(function(){
									//if(nodeId != $(this).attr("id")){
									//if($(this).hasClass("open")){
									//	$(this).removeClass("open").addClass("closed");
									//}
									//}
									//});
									$("#tree").scrollLeft(
											$(node).parents("li").size() * 30);
									return true;
								},
								onclose : function(node, tree) {
									$("#tree").scrollLeft(
											$(node).parents("li").size() * 30);
									return true;
								}

							}
						});
		$(".boxbon").click(function() {
			if ($("#boxtree").is(":hidden")) {
				$("#boxtree").animate({
					width : 298
				}, 'slow');
			} else {
				$("#boxtree").animate({
					width : 5,
					opacity : 'hide'
				}, "slow");
			}
		});

	});
</script>
<!--tree-->
<div id="boxtree">
	<div class="boxtop">
		<div class="boxbottom">
			<div class="trclear"></div>
			<div id="tree">
				<ul>
					<li id="TREE_root" class="open"><a href="#">资源树</a>
						<ul>
							<c:forEach items="${menuList}" var="menu">
								<c:choose>
									<c:when test="${menu.hasChild}">
										<li id="${menu.type }_${menu.id }" class="closed"><a
											href="#">${menu.name }</a></li>
									</c:when>
									<c:otherwise>
										<li id="${menu.type}_${menu.id }" class="leaf"><a
											href="#">${menu.name }</a></li>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</ul></li>
				</ul>
			</div>
			<div class="trclear"></div>

		</div>
	</div>
</div>
<!--tree end-->
