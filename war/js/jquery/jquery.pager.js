﻿/*
* jQuery pager plugin
* Version 1.0 (12/22/2008)
* @requires jQuery v1.2.6 or later
*
* Example at: http://jonpauldavies.github.com/JQuery/Pager/PagerDemo.html
*
* Copyright (c) 2008-2009 Jon Paul Davies
* Dual licensed under the MIT and GPL licenses:
* http://www.opensource.org/licenses/mit-license.php
* http://www.gnu.org/licenses/gpl.html
*
* Read the related blog post and contact the author at http://www.j-dee.com/2008/12/22/jquery-pager-plugin/
*
* This version is far from perfect and doesn't manage it's own state, therefore contributions are more than welcome!
*
* Usage: .pager({ pagenumber: 1, pagecount: 15, buttonClickCallback: PagerClickTest });
*
* Where pagenumber is the visible page number
*       pagecount is the total number of pages to display
*       buttonClickCallback is the method to fire when a pager button is clicked.
*
* buttonClickCallback signiture is PagerClickTest = function(pageclickednumber)
* Where pageclickednumber is the number of the page clicked in the control.
*
* The included Pager.CSS file is a dependancy but can obviously tweaked to your wishes
* Tested in IE6 IE7 Firefox & Safari. Any browser strangeness, please report.
*/
(function($) {

    $.fn.pager = function(options) {

        var opts = $.extend({}, $.fn.pager.defaults, options);

        return this.each(function() {

        	// empty out the destination element and then render out the pager with the supplied options
            $(this).empty();
            if(opts.add){
            	var $addButton = $('<div><a href="'+addUrl+'" class="boxadd"/>添加</a></div>');
            	$addButton.click(addButtonCallback);
            	$(this).append($addButton);
            }
            $(this).append(renderpager(parseInt(options.pagenumber), parseInt(options.pagecount),parseInt(options.totalcount), options.buttonClickCallback));

            // specify correct cursor activity
           // $('.pager span').mouseover(function() { document.body.style.cursor = "pointer"; }).mouseout(function() { document.body.style.cursor = "auto"; });
        });
    };

    // render and return the pager with the supplied options
    function renderpager(pagenumber, pagecount,totalcount, buttonClickCallback) {
    	
    	var $pager = $('<div style="float:right"><span class="page_other">共<label class="totalcount">'+totalcount+'</label>条</span></div>');
    	var $first = $('<span class="page_other">首页</span>');
    	if(pagenumber > 1){
    		$first.addClass("page_break");
    		$first.click(function() { buttonClickCallback(1); });
    	}
    	$pager.append($first);
    	
    	if(pagenumber > 5){
    		var $backMuti = $('<span class="page_break">后至'+(pagenumber-5)+'页</span>');
    		$backMuti.click(function() { buttonClickCallback(pagenumber-5); });
    		$pager.append($backMuti);
    	}
    	
    	if(pagenumber > 1){
    		var $backOne = $('<span class="page_break">上一页</span>');
    		$backOne.click(function() { buttonClickCallback(pagenumber-1); });
    		$pager.append($backOne);
    	}
    	
    	var startPoint = 1;
    	var endPoint = 5;
    	
    	if(pagenumber > 3){
    		startPoint = pagenumber - 2;
    		endPoint = pagenumber + 2;
    	}
    	
    	if(endPoint > pagecount){
    		startPoint = pagecount - 4;
    		endPoint = pagecount;
    	}
    	if(startPoint < 1){
    		startPoint = 1;
    	}
    	
    	for(var page = startPoint;page<=endPoint;page++){
    		var currentSpan;
    		if(page == pagenumber){
    			currentSpan = $('<span class="page_current">'+(page)+'</span>');
    		}else{
    			currentSpan = $('<span class="page_break">'+(page)+'</span>');
    			currentSpan.click(function(){buttonClickCallback(this.firstChild.data);});
    		}
    		$pager.append(currentSpan);
    	}
    	
    	if(pagenumber < pagecount){
    		var $backOne = $('<span class="page_break">下一页</span>');
    		$backOne.click(function() { buttonClickCallback(pagenumber+1); });
    		$pager.append($backOne);
    	}
    	
    	if(pagecount - pagenumber > 5){
    		var $backMuti = $('<span class="page_break">前至'+(pagenumber+5)+'页</span>');
    		$backMuti.click(function() { buttonClickCallback(pagenumber+5); });
    		$pager.append($backMuti);
    	}
    	
    	var $last = $('<span class="page_other" >末页</span>');
    	if(pagenumber < pagecount){
    		$last.addClass("page_break");
    		$last.click(function() { buttonClickCallback(pagecount); });
    	}
    	$pager.append($last);
    	
    	var $totalpage =$('<span class="page_other">第'+pagenumber+'页/共'+pagecount+'页</span>'); 
    	$pager.append($totalpage);
    	return $pager;
    }

    function my_back_page(pagenumber, pagecount,totalcount, buttonClickCallback){
    	// setup $pager to hold render
        var $pager = $('<ul class="pages"></ul>');


        // add in the previous and next buttons
        $pager.append(renderButton('first', pagenumber, pagecount, buttonClickCallback)).append(renderButton('prev', pagenumber, pagecount, buttonClickCallback));

        // pager currently only handles 10 viewable pages ( could be easily parameterized, maybe in next version ) so handle edge cases
        var startPoint = 1;
        var endPoint = 9;

        if (pagenumber > 4) {
            startPoint = pagenumber - 4;
            endPoint = pagenumber + 4;
        }

        if (endPoint > pagecount) {
            startPoint = pagecount - 8;
            endPoint = pagecount;
        }

        if (startPoint < 1) {
            startPoint = 1;
        }

        // loop thru visible pages and render buttons
        for (var page = startPoint; page <= endPoint; page++) {

            var currentButton = $('<li class="page-number">' + (page) + '</li>');

            page == pagenumber ? currentButton.addClass('pgCurrent') : currentButton.click(function() { buttonClickCallback(this.firstChild.data); });
            currentButton.appendTo($pager);
        }

        // render in the next and last buttons before returning the whole rendered control back.
        $pager.append(renderButton('next', pagenumber, pagecount, buttonClickCallback)).append(renderButton('last', pagenumber, pagecount, buttonClickCallback));
        $pager.append('<span>共<label class="totalcount">'+totalcount+'</label>条记录&nbsp;&nbsp;当前'+pagenumber+'页/共'+pagecount+'页</span>');
        return $pager;

    }

    // renders and returns a 'specialized' button, ie 'next', 'previous' etc. rather than a page number button
    function renderButton(buttonLabel, pagenumber, pagecount, buttonClickCallback) {

        var $Button  ;

        var destPage = 1;

        // work out destination page for required button type
        switch (buttonLabel) {
            case "first":
                destPage = 1;
                $Button = $('<li class="pgNext">首页 </li>');
                break;
            case "prev":
                destPage = pagenumber - 1;
                $Button = $('<li class="pgNext">上一页</li>');
                break;
            case "next":
                destPage = pagenumber + 1;
                $Button = $('<li class="pgNext">下一页 </li>');
                break;
            case "last":
                destPage = pagecount;
                $Button = $('<li class="pgNext">末页 </li>');
                break;
        }

        // disable and 'grey' out buttons if not needed.
        if (buttonLabel == "first" || buttonLabel == "prev") {
            pagenumber <= 1 ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        }
        else {
            pagenumber >= pagecount ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        }

        return $Button;
    }

    // pager defaults. hardly worth bothering with in this case but used as placeholder for expansion in the next version
    $.fn.pager.defaults = {
        pagenumber: 1,
        pagecount: 1,
        totalcount:0,
        add:false,
        addUrl:""
    };

})(jQuery);





