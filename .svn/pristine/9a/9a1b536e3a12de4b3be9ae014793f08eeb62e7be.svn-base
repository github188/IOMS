$(function(){

	init($("#pro").val(),$("#kind").val(),$("#item").val());
	$("#atm_div_day").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#atm_div_day_div").slideToggle();
		$("#atm_div_month_div").slideUp();
	})
	$("#atm_div_month").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#atm_div_month_div").slideToggle();
		$("#atm_div_day_div").slideUp();
	})
	$("#atm-title").click(function(){
		$(this).addClass("selected");
		$(this).siblings().removeClass("selected");
		$("#atm_div").slideToggle();
		$("#satellite_div,#fax_div,#environment-third,#satellite-forth-day,#satellite_div_month_div,#environment_div_month_div").slideUp();
	})
	$("#satellite_div_tesday").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#satellite_div_tesday_div").slideToggle();
		$("#satellite_div_month_div,#satellite_div_pesday_div").slideUp();
	})
	$("#satellite_div_pesday").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#satellite_div_pesday_div").slideToggle();
		$("#satellite_div_month_div,#satellite_div_tesday_div").slideUp();
	})
	$("#satellite_div_month").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#satellite_div_month_div").slideToggle();
		$("#satellite_div_tesday_div,#satellite_div_pesday_div").slideUp();
	})
	$("#satellite-title").click(function(){
		$(this).addClass("selected");
		$(this).siblings().removeClass("selected");
		$("#satellite_div").slideToggle();
		$("#atm_div,#fax_div,#environment_div,#atm_div_day_div,#atm_div_month_div,#environment_div_month_div").slideUp();
	})
	$("#fax_title").click(function(){
		$(this).addClass("selected");
		$(this).siblings().removeClass("selected");
		$("#fax_div").slideToggle();
		$("#satellite_div,#atm_div,#environment_div").slideUp();
	})
	$("#fax_div_day").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#fax_div_day_div").slideToggle();
		$("#fax_div_month_div,#fax_div_season_div,#fax_div_year_div").slideUp();
	})
	$("#fax_div_month").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#fax_div_month_div").slideToggle();
		$("#fax_div_day_div,#fax_div_season_div,#fax_div_year_div").slideUp();
	})
	$("#fax_div_season").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#fax_div_season_div").slideToggle();
		$("#fax_div_day_div,#fax_div_month_div,#fax_div_year_div").slideUp();
	})
	$("#fax_div_year").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#fax_div_year_div").slideToggle();
		$("#fax_div_day_div,#fax_div_season_div,#fax_div_month_div").slideUp();
	})
	$("#environment-title").click(function(){
		$(this).addClass("selected");
		$(this).siblings().removeClass("selected");
		$("#environment_div").slideToggle();
		$("#satellite_div,#fax_div,#atm_div,#satellite-forth-day,#satellite_div_month_div,#atm_div_day_div,#atm_div_month_div").slideUp();
	})
	$("#environment_div_month").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#environment_div_month_div").slideToggle();
		$("#environment_div_season_div,#environment_div_year_div").slideUp();
	})
	$("#environment_div_season").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#environment_div_season_div").slideToggle();
		$("#environment_div_month_div,#environment_div_year_div").slideUp();
	})
	$("#environment_div_year").click(function(){
		$(this).addClass("selected1");
		$(this).siblings().removeClass("selected1");
		$("#environment_div_year_div").slideToggle();
		$("#environment_div_month_div,#environment_div_season_div").slideUp();
	})
//	$("#environment-third #environment-forth-month .button-4 .tiny").each(function(i,one){
//	    $(one).data("num",i+1);
//	})
//	$("#environment-third #environment-forth-month .button-4 .tiny").click(function(){
//	    var num=$(this).data("num");
//	    $("#environment-second").trigger("click"); 
//	})


});
function init(profession,kind,itemName){
	var pro_div="#"+profession+"_div";
	var second_menu_div="#"+profession+"_div_"+kind+"_div";
	var pro_title="#"+profession+"_title";
	var second_menu_title="#"+profession+"_div_"+kind;
	var item_menu="#"+itemName;
	
	//环境菜单下的 月检、季检、年检 显示
	$(pro_div).css('display','block');
	//月检下的 设备菜单 显示
    $(second_menu_div).css('display','block');
    //选中环境专业菜单
    $(pro_title).addClass("selected");
	//选中环境专业月检菜单
    $(second_menu_title).addClass("selected1");
    //选中月检中某一个 设备菜单
    $(item_menu).addClass("columnon");
}