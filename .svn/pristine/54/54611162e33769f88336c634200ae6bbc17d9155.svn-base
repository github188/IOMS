//editable vars
var goalAmount = 100;//how much are you trying to get
//var currentAmount = 1267;//how much do you currently have (if you want to define in js, not html)
var animationTime = 500;//in milliseconds
var numberPrefix = "";//what comes before the number (set to "" if no prefix)
var numberSuffix = "";//what goes after the number
var tickMarkSegementCount = 2;//each segement adds 40px to the height
var widthOfNumbers = 10;//the width in px of the numbers on the left

//standard resolution images
var glassTopImg = rooturl+"images/weath/glassTop.png";
var glassBodyImg = rooturl+"images/weath/glassBody.png";
var redVerticalImg = rooturl+"images/weath/redVertical.png";
var tooltipFGImg = rooturl+"images/weath/tickShine.png";
var glassBottomImg = rooturl+"images/weath/glassBottom.png";
var tootipPointImg = rooturl+"images/weath/tooltipPoint.png";
var tooltipMiddleImg = rooturl+"images/weath/tooltipMiddle.png";
var tooltipButtImg = rooturl+"images/weath/tooltipButt.png";

//high res images
var glassTopImg2x = rooturl+"images/weath/glassTop2x.png";
var glassBodyImg2x = rooturl+"images/weath/glassBody2x.png";
var redVerticalImg2x = rooturl+"images/weath/redVertical2x.png";
var tooltipFGImg2x = rooturl+"images/weath/tickShine2x.png";
var glassBottomImg2x = rooturl+"images/weath/glassBottom2x.png";
var tootipPointImg2x = rooturl+"images/weath/tooltipPoint2x.png";
var tooltipMiddleImg2x = rooturl+"images/weath/tooltipMiddle2x.png";
var tooltipButtImg2x = rooturl+"images/weath/tooltipButt2x.png";

/////////////////////////////////////////
// ------ don't edit below here ------ //
/////////////////////////////////////////

var arrayOfImages;
var imgsLoaded = 0;
var tickHeight = 40;
var mercuryHeightEmpty = 0;
var numberStartY = 6;
var thermTopHeight = 13;
var thermBottomHeight = 51;
var tooltipOffset = 15; 
var heightOfBody;
var mercuryId;
var tooltipId;
var resolution2x = false;

function init(){
    arrayOfImages;
    imgsLoaded = 0;
    tickHeight = 40;
    mercuryHeightEmpty = 0;
    numberStartY = 6;
    thermTopHeight = 13;
    thermBottomHeight = 51;
    tooltipOffset = 15; 
    heightOfBody;
    mercuryId;
    tooltipId;
    resolution2x = false;
}
//start once the page is loaded
/*$( document ).ready(function() {
	determineImageSet();
});*/

//this checks if it's the high or normal resolution images
function determineImageSet(){
	resolution2x = window.devicePixelRatio == 2;//check if resolution2x
	
	if(resolution2x){	
		//switch the regular for 2x res graphics
		glassTopImg = glassTopImg2x;
		glassBodyImg = glassBodyImg2x;
		redVerticalImg = redVerticalImg2x;
		glassBottomImg = glassBottomImg2x;
		tootipPointImg = tootipPointImg2x;
		tooltipButtImg = tooltipButtImg2x;	
	}
	
	createGraphics();
}

//visually create the thermometer
function createGraphics(){
    // 清空div中元素
    $("#goal-thermometer").empty();
    // 初始化数据
    init();
    //add the html
	$("#goal-thermometer").html(
		"<div id='therm-numbers'>" + 
		"</div>" + 
		"<div id='therm-graphics'>" + 
			"<img id='therm-top' src='"+glassTopImg+"'></img>" + 
			"<img id='therm-body-bg' src='"+glassBodyImg+"' ></img>" + 
			"<img id='therm-body-mercury' src='"+redVerticalImg+"'></img>" + 
			"<div id='therm-body-fore'></div>" + 
			"<img id='therm-bottom' src='"+glassBottomImg+"'></img>" + 
			"<div id='therm-tooltip'>" + 
				"<img class='tip-left' src='"+tootipPointImg+"'></img>" + 
				"<div class='tip-middle'><p>"+numberPrefix+"0</p></div>" + 
				"<img class='tip-right' src='"+tooltipButtImg+"'></img>" + 
			"</div>" + 
		"</div>"
	);
	
	//preload and add the background images
	$('<img/>').attr('src', tooltipFGImg).load(function(){
		$(this).remove();
		$("#therm-body-fore").css("background-image", "url('"+tooltipFGImg+"')");
		checkIfAllImagesLoaded();
	});
	
	$('<img/>').attr('src', tooltipMiddleImg).load(function(){
		$(this).remove();
		$("#therm-tooltip .tip-middle").css("background-image", "url('" + tooltipMiddleImg + "')");
		checkIfAllImagesLoaded();
	});
	
	//adjust the css
	heightOfBody = tickMarkSegementCount * tickHeight;
	$("#therm-graphics").css("left", widthOfNumbers)
	$("#therm-body-bg").css("height", heightOfBody);
	$("#goal-thermometer").css("height",  heightOfBody + thermTopHeight + thermBottomHeight);
	$("#therm-body-fore").css("height", heightOfBody);
	$("#therm-bottom").css("top", heightOfBody + thermTopHeight);
	mercuryId = $("#therm-body-mercury");
	mercuryId.css("top", heightOfBody + thermTopHeight);
	tooltipId = $("#therm-tooltip");
	tooltipId.css("top", heightOfBody + thermTopHeight - tooltipOffset);
	
	//add the numbers to the left
	var numbersDiv = $("#therm-numbers");
	var countPerTick = goalAmount/tickMarkSegementCount;
	var commaSepCountPerTick = commaSeparateNumber(countPerTick);
	
	//add the number
	for ( var i = 0; i < tickMarkSegementCount; i++ ) {
		
		var yPos = tickHeight * i + numberStartY;
		var style = $("<style>.pos" + i + " { top: " + yPos + "px; width:"+widthOfNumbers+"px }</style>");
		$("html > head").append(style);
		var dollarText = commaSeparateNumber(goalAmount - countPerTick * i);
		$( numbersDiv ).append( "<div class='therm-number pos" + i + "'>" +dollarText+ "</div>" );
		
	}
	
	//check that the images are loaded before anything
	arrayOfImages = new Array( "#therm-top", "#therm-body-bg", "#therm-body-mercury", "#therm-bottom", ".tip-left", ".tip-right");
	preload(arrayOfImages);
	
};

//check if each image is preloaded
function preload(arrayOfImages) {
	
	for(i=0;i<arrayOfImages.length;i++){
		$(arrayOfImages[i]).load(function() {   checkIfAllImagesLoaded();  });
	}
    
}

//check that all the images are preloaded
function checkIfAllImagesLoaded(){
	imgsLoaded++;
	if(imgsLoaded == arrayOfImages.length+2){
		$("#goal-thermometer").fadeTo(1000, 1, function(){
			animateThermometer();
		});
	}
}


//animate the thermometer
function animateThermometer(){
	
	var percentageComplete = currentAmount/goalAmount;
	var mercuryHeight = Math.round(heightOfBody * percentageComplete); 
	var newMercuryTop = heightOfBody + thermTopHeight - mercuryHeight;
	
	mercuryId.animate({height:mercuryHeight +1, top:newMercuryTop }, animationTime);
	tooltipId.animate({top:newMercuryTop - tooltipOffset}, {duration:animationTime});
	
	var tooltipTxt = $("#therm-tooltip .tip-middle p");
	
	//change the tooltip number as it moves
	$({tipAmount: 0}).animate({tipAmount: currentAmount}, {
		duration:animationTime,
		step:function(){
			tooltipTxt.html(commaSeparateNumber(this.tipAmount));
		}
	});
	
	
}

//format the numbers with $ and commas
function commaSeparateNumber(val){
	val = Math.round(val);
    while (/(\d+)(\d{3})/.test(val.toString())){
      val = val.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
    }
    return numberPrefix + val + numberSuffix;
}
