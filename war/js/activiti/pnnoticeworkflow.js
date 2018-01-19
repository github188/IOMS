function graphTrace(options) {
	var _defaults = {
		srcEle : this,
		pid : $(this).attr('pid')
	};
	var opts = $.extend(true, _defaults, options);
	// 获取图片资源
	var imageUrl = rootUrl + "workflow/resource/process-instance.dox?pid="
			+ opts.pid + "&type=image";
	$
			.getJSON(
					rootUrl + 'workflow/process/trace.dox?pid=' + opts.pid,
					function(infos) {

						var positionHtml = "";

						// 生成图片
						var varsArray = new Array();
						$.each(infos, function(i, v) {
							var $positionDiv = $('<div/>', {
								'class' : 'activity-attr'
							}).css({
								position : 'absolute',
								left : (v.x + 15),
								top : (v.y),
								width : (v.width - 2),
								height : (v.height - 2),
								backgroundColor : 'black',
								opacity : 0,
								zIndex : $.fn.qtip.zindex - 1
							});

							// 节点边框
							var $border = $('<div/>', {
								'class' : 'activity-attr-border'
							}).css({
								position : 'absolute',
								left : (v.x - 35),
								top : (v.y + 29),
								width : (v.width - 5),
								height : (v.height - 5),
								zIndex : $.fn.qtip.zindex - 2
							});

							if (v.currentActiviti) {
								$border.addClass('ui-corner-all-12').css({
									border : '3px solid red'
								});
							}
							positionHtml += $positionDiv.outerHTML()
									+ $border.outerHTML();
							varsArray[varsArray.length] = v.vars;
						});

						if ($('#workflowTraceDialog').length == 0) {
							$(
									'<div/>',
									{
										id : 'workflowTraceDialog',
										title : '查看流程',
										html : "<div><img src='"
												+ imageUrl
												+ "' style='position:absolute; left:0px; top:55px;' />"
												+ "<div id='processImageBorder'>"
												+ positionHtml + "</div>"
												+ "</div>"
									}).appendTo('body');
						} else {
							$('#workflowTraceDialog img').attr('src', imageUrl);
							$('#workflowTraceDialog #processImageBorder').html(
									positionHtml);
						}

						// 设置每个节点的data
						$('#workflowTraceDialog .activity-attr').each(
								function(i, v) {
									$(this).data('vars', varsArray[i]);
								});

						// 打开对话框
						$('#workflowTraceDialog')
								.dialog(
										{
											modal : true,
											resizable : false,
											dragable : false,
											open : function() {
												$('#workflowTraceDialog')
														.dialog('option',
																'title',
																'查看流程(按ESC关闭)');
												$('#workflowTraceDialog').css(
														'padding', '0.2em');
												$(
														'#workflowTraceDialog .ui-accordion-content')
														.css('padding', '0.2em')
														.height(
																$(
																		'#workflowTraceDialog')
																		.height() - 75);

												// 此处用于显示每个节点的信息，如果不需要可以删除
												$('.activity-attr')
														.qtip(
																{
																	content : function() {
																		var vars = $(
																				this)
																				.data(
																						'vars');
																		var tipContent = "<table class='need-border'>";
																		$
																				.each(
																						vars,
																						function(
																								varKey,
																								varValue) {
																							if (varValue) {
																								tipContent += "<tr><td class='label'>"
																										+ varKey
																										+ "</td><td>"
																										+ varValue
																										+ "<td/></tr>";
																							}
																						});
																		tipContent += "</table>";
																		return tipContent;
																	},
																	position : {
																		at : 'bottom left',
																		adjust : {
																			x : 3
																		}
																	}
																});
												// end qtip
											},
											close : function() {
												$('#workflowTraceDialog')
														.remove();
											},
											width : document.documentElement.clientWidth * 0.8,
											height : document.documentElement.clientHeight * 0.8
										});

					});
}

function getTrace(pid) {
	// 获取图片资源
	var imageUrl = rootUrl + "workflow/resource/process-instance.dox?pid="
			+ pid + "&type=image";
	$
			.getJSON(
					rootUrl + 'workflow/process/trace.dox?pid=' + pid,
					function(infos) {

						var positionHtml = "";

						// 生成图片
						var varsArray = new Array();
						$.each(infos, function(i, v) {
							var $positionDiv = $('<div/>', {
								'class' : 'activity-attr'
							}).css({
								position : 'absolute',
								left : (v.x + 15),
								top : (v.y - 55),
								width : (v.width - 2),
								height : (v.height - 2),
								backgroundColor : 'black',
								opacity : 0,
								zIndex : $.fn.qtip.zindex - 1
							});

							// 节点边框
							var $border = $('<div/>', {
								'class' : 'activity-attr-border'
							}).css({
								position : 'absolute',
								left : (v.x + 15),
								top : (v.y - 55),
								width : (v.width - 4),
								height : (v.height - 3),
								zIndex : $.fn.qtip.zindex - 2
							});

							if (v.currentActiviti) {
								$border.addClass('ui-corner-all-12').css({
									border : '3px solid red'
								});
							}
							positionHtml += $positionDiv.outerHTML()
									+ $border.outerHTML();
							varsArray[varsArray.length] = v.vars;
						});

						if ($('#workflowTraceDialog').length == 0) {
							$(
									'<div/>',
									{
										id : 'workflowTraceDialog',
										title : '查看流程',
										html : "<div><img src='"
												+ imageUrl
												+ "' style='position:absolute; left:0px; top:0px;' />"
												+ "<div id='processImageBorder'>"
												+ positionHtml + "</div>"
												+ "</div>"
									}).appendTo('body');
						} else {
							$('#workflowTraceDialog img').attr('src', imageUrl);
							$('#workflowTraceDialog #processImageBorder').html(
									positionHtml);
						}

						// 设置每个节点的data
						$('#workflowTraceDialog .activity-attr').each(
								function(i, v) {
									$(this).data('vars', varsArray[i]);
								});

						// 打开对话框
						$('#workflowTraceDialog')
								.dialog(
										{
											modal : true,
											resizable : false,
											dragable : false,
											open : function() {
												$('#workflowTraceDialog')
														.dialog('option',
																'title',
																'查看流程(按ESC关闭)');
												$('#workflowTraceDialog').css(
														'padding', '0.2em');
												$(
														'#workflowTraceDialog .ui-accordion-content')
														.css('padding', '0.2em')
														.height(
																$(
																		'#workflowTraceDialog')
																		.height() - 75);

												// 此处用于显示每个节点的信息，如果不需要可以删除
												$('.activity-attr')
														.qtip(
																{
																	content : function() {
																		var vars = $(
																				this)
																				.data(
																						'vars');
																		var tipContent = "<table class='need-border'>";
																		$
																				.each(
																						vars,
																						function(
																								varKey,
																								varValue) {
																							if (varValue) {
																								tipContent += "<tr><td class='label'>"
																										+ varKey
																										+ "</td><td>"
																										+ varValue
																										+ "<td/></tr>";
																							}
																						});
																		tipContent += "</table>";
																		return tipContent;
																	},
																	position : {
																		at : 'bottom left',
																		adjust : {
																			x : 3
																		}
																	}
																});
												// end qtip
											},
											close : function() {
												$('#workflowTraceDialog')
														.remove();
											},
											width : document.documentElement.clientWidth * 0.8,
											height : document.documentElement.clientHeight * 0.5
										});

					});
}

function graphTempCircuitTrace(options) {
	var _defaults = {
		srcEle : this,
		pid : $(this).attr('pid')
	};
	var opts = $.extend(true, _defaults, options);
	// 获取图片资源
	var imageUrl = rootUrl + "workflow/resource/process-instance.dox?pid="
			+ opts.pid + "&type=image";
	$
			.getJSON(
					rootUrl + 'workflow/process/trace.dox?pid=' + opts.pid,
					function(infos) {

						var positionHtml = "";

						// 生成图片
						var varsArray = new Array();
						$.each(infos, function(i, v) {
							var $positionDiv = $('<div/>', {
								'class' : 'activity-attr'
							}).css({
								position : 'absolute',
								left : (v.x + 16),
								top : (v.y + 2),
								width : (v.width - 2),
								height : (v.height - 2),
								backgroundColor : 'black',
								opacity : 0,
								zIndex : $.fn.qtip.zindex - 1
							});

							// 节点边框
							var $border = $('<div/>', {
								'class' : 'activity-attr-border'
							}).css({
								position : 'absolute',
								left : (v.x + 30),
								top : (v.y + 2),
								width : (v.width - 5),
								height : (v.height - 5),
								zIndex : $.fn.qtip.zindex - 2
							});

							if (v.currentActiviti) {
								$border.addClass('ui-corner-all-12').css({
									border : '3px solid red'
								});
							}
							positionHtml += $positionDiv.outerHTML()
									+ $border.outerHTML();
							varsArray[varsArray.length] = v.vars;
						});

						if ($('#workflowTraceDialog').length == 0) {
							$(
									'<div/>',
									{
										id : 'workflowTraceDialog',
										title : '查看流程',
										html : "<div><img src='"
												+ imageUrl
												+ "' style='position:absolute; left:0px; top:55px;' />"
												+ "<div id='processImageBorder'>"
												+ positionHtml + "</div>"
												+ "</div>"
									}).appendTo('body');
						} else {
							$('#workflowTraceDialog img').attr('src', imageUrl);
							$('#workflowTraceDialog #processImageBorder').html(
									positionHtml);
						}

						// 设置每个节点的data
						$('#workflowTraceDialog .activity-attr').each(
								function(i, v) {
									$(this).data('vars', varsArray[i]);
								});

						// 打开对话框
						$('#workflowTraceDialog')
								.dialog(
										{
											modal : true,
											resizable : false,
											dragable : false,
											open : function() {
												$('#workflowTraceDialog')
														.dialog('option',
																'title',
																'查看流程(按ESC关闭)');
												$('#workflowTraceDialog').css(
														'padding', '0.2em');
												$(
														'#workflowTraceDialog .ui-accordion-content')
														.css('padding', '0.2em')
														.height(
																$(
																		'#workflowTraceDialog')
																		.height() - 75);

												// 此处用于显示每个节点的信息，如果不需要可以删除
												$('.activity-attr')
														.qtip(
																{
																	content : function() {
																		var vars = $(
																				this)
																				.data(
																						'vars');
																		var tipContent = "<table class='need-border'>";
																		$
																				.each(
																						vars,
																						function(
																								varKey,
																								varValue) {
																							if (varValue) {
																								tipContent += "<tr><td class='label'>"
																										+ varKey
																										+ "</td><td>"
																										+ varValue
																										+ "<td/></tr>";
																							}
																						});
																		tipContent += "</table>";
																		return tipContent;
																	},
																	position : {
																		at : 'bottom left',
																		adjust : {
																			x : 3
																		}
																	}
																});
												// end qtip
											},
											close : function() {
												$('#workflowTraceDialog')
														.remove();
											},
											width : document.documentElement.clientWidth * 0.8,
											height : document.documentElement.clientHeight * 0.5
										});

					});
}

function getTempCircuitTrace(pid) {
	// 获取图片资源
	var imageUrl = rootUrl + "workflow/resource/process-instance.dox?pid="
			+ pid + "&type=image";
	$
			.getJSON(
					rootUrl + 'workflow/process/trace.dox?pid=' + pid,
					function(infos) {

						var positionHtml = "";
						// 生成图片
						var varsArray = new Array();
						$.each(infos, function(i, v) {
							var $positionDiv = $('<div/>', {
								'class' : 'activity-attr'
							}).css({
								position : 'absolute',
								left : (v.x + 15),
								top : (v.y - 54),
								width : (v.width - 2),
								height : (v.height - 2),
								backgroundColor : 'black',
								opacity : 0,
								zIndex : $.fn.qtip.zindex - 1
							});

							// 节点边框
							var $border = $('<div/>', {
								'class' : 'activity-attr-border'
							}).css({
								position : 'absolute',
								left : (v.x + 15),
								top : (v.y - 54),
								width : (v.width - 4),
								height : (v.height - 3),
								zIndex : $.fn.qtip.zindex - 2
							});

							if (v.currentActiviti) {
								$border.addClass('ui-corner-all-12').css({
									border : '3px solid red'
								});
							}
							positionHtml += $positionDiv.outerHTML()
									+ $border.outerHTML();
							varsArray[varsArray.length] = v.vars;
						});

						if ($('#workflowTraceDialog').length == 0) {
							$(
									'<div/>',
									{
										id : 'workflowTraceDialog',
										title : '查看流程',
										html : "<div><img src='"
												+ imageUrl
												+ "' style='position:absolute; left:0px; top:0px;' />"
												+ "<div id='processImageBorder'>"
												+ positionHtml + "</div>"
												+ "</div>"
									}).appendTo('body');
						} else {
							$('#workflowTraceDialog img').attr('src', imageUrl);
							$('#workflowTraceDialog #processImageBorder').html(
									positionHtml);
						}

						// 设置每个节点的data
						$('#workflowTraceDialog .activity-attr').each(
								function(i, v) {
									$(this).data('vars', varsArray[i]);
								});

						// 打开对话框
						$('#workflowTraceDialog')
								.dialog(
										{
											modal : true,
											resizable : false,
											dragable : false,
											open : function() {
												$('#workflowTraceDialog')
														.dialog('option',
																'title',
																'查看流程(按ESC关闭)');
												$('#workflowTraceDialog').css(
														'padding', '0.2em');
												$(
														'#workflowTraceDialog .ui-accordion-content')
														.css('padding', '0.2em')
														.height(
																$(
																		'#workflowTraceDialog')
																		.height() - 75);

												// 此处用于显示每个节点的信息，如果不需要可以删除
												$('.activity-attr')
														.qtip(
																{
																	content : function() {
																		var vars = $(
																				this)
																				.data(
																						'vars');
																		var tipContent = "<table class='need-border'>";
																		$
																				.each(
																						vars,
																						function(
																								varKey,
																								varValue) {
																							if (varValue) {
																								tipContent += "<tr><td class='label'>"
																										+ varKey
																										+ "</td><td>"
																										+ varValue
																										+ "<td/></tr>";
																							}
																						});
																		tipContent += "</table>";
																		return tipContent;
																	},
																	position : {
																		at : 'bottom left',
																		adjust : {
																			x : 3
																		}
																	}
																});
												// end qtip
											},
											close : function() {
												$('#workflowTraceDialog')
														.remove();
											},
											width : document.documentElement.clientWidth * 0.8,
											height : document.documentElement.clientHeight * 0.5
										});

					});
}