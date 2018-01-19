function graphTrace(options) {
	var _defaults = {
		srcEle : this,
		pid : $(this).attr('pid')
	};
	var opts = $.extend(true, _defaults, options);
    // 获取图片资源
    var imageUrl = rootUrl+"news/graph.dox?id="+opts.pid;
    // 打开对话框
    if ($('#workflowTraceDialog').length == 0) {
        $('<div/>', {
            id : 'workflowTraceDialog',
            title : '查看流程',
            html : "<div><img src='" + imageUrl + "' style='position:absolute; left:0px; top:55px;' />"
        }).appendTo('body');
    } else {
        $('#workflowTraceDialog img').attr('src', imageUrl);
        $('#workflowTraceDialog #processImageBorder').html(positionHtml);
    }
    $('#workflowTraceDialog').dialog({
        modal : true,
        resizable : false,
        dragable : false,
        open : function() {
            $('#workflowTraceDialog').dialog('option', 'title', '查看流程(按ESC关闭)');
            $('#workflowTraceDialog').css('padding', '0.2em');
            $('#workflowTraceDialog .ui-accordion-content').css('padding', '0.2em').height($('#workflowTraceDialog').height() - 75);
        },
        close : function() {
            $('#workflowTraceDialog').remove();
        },
        width : document.documentElement.clientWidth * 0.8,
        height : document.documentElement.clientHeight * 0.6
    });
}