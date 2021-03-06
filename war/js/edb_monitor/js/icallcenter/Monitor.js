hojo.provide("icallcenter.Monitor");


icallcenter.Monitor.monitorTimersHandle=null;
icallcenter.Monitor.listenNode = null;
icallcenter.Monitor.endListenHandler = null;

hojo.declare("icallcenter.Monitor", null, {

  constructor: function(phone) {
	  this._phone = phone;
      this._statusDesc["stReady"] = "签出";    
      this._statusDesc["stIdle"] = "空闲";
      this._statusDesc["stBusy"] = "忙碌";
      this._statusDesc["stRinging"] = "来电振铃";
      this._statusDesc["stInner"] = "内部通话";
      this._statusDesc["stNormal"] = "普通通话";
      this._statusDesc["stRing"] = "呼叫中";            
      this._statusDesc["stDialout"] = "外呼通话";            
      this._statusDesc["stDialTransfer"] = "外呼转接通话";            
      this._statusDesc["stListen"] = "监听";            
      this._statusDesc["stTransfer"] = "转接通话"; 
      this._statusDesc["stOffline"] = "离线"; 
      this._statusDesc["stUnavaliable"] = "失效"; 
      this._statusDesc["stWebcall"] = "网络来电"; 
      this._statusDesc["stValidate"] = "验证通话"; 
  
      this._init(this._phone);	
 
      // 注册队列状态变化事件
      var evtHandle = this._phone.register("EvtMonitorQueue", this, "onQueueChanged");  
      this._handles.push(evtHandle);                         
      evtHandle = this._phone.register("EvtMonitorPeer", this, "onAgentChanged");
      this._handles.push(evtHandle);                         
      evtHandle = this._phone.register("EvtMonitorServiceNo", this, "onServiceNoChanged");                           
      this._handles.push(evtHandle);  
    },

    destroy: function() {
      for (var i in this._handles) {    
            this._phone.unregister(this._handles[i]);
      }
    },

  
    _phone: null,
    
    _handles: [],
	
	 _statusDesc: [],
	 
	 _busyType: "0",

	 _init:function(phone){
		//初始化ui
		var tblQueues = hojo.byId("monitor.queues");
		var tblAgets = hojo.byId("monitor.agents");
		var tblServiceNos = hojo.byId("monitor.serviceNos");
		if(phone && phone.monitorServiceNos){
			for(var j in phone.monitorServiceNos)	{
				var item=phone.monitorServiceNos[j];
				if(!item || !item.serviceNo)
					continue;
				var tempArray=[item.serviceNo,item.inCalls,item.inLost,item.inComplete];

				var curRow=this.searchQueue(item.serviceNo,tblServiceNos,'serviceNo');
				if(!curRow){
					this.createRowCell(tblServiceNos,item.serviceNo,tempArray,'serviceNo');
					
				}else{
					this.updateRowCell(curRow,item.serviceNo,tempArray,'serviceNo',true);
				}
			}
		}
		
		if(phone && phone.monitorQueues){
			for(var j in phone.monitorQueues)	{
				
				var item=phone.monitorQueues[j];
				if(!item || !item.queueId)
					continue;
				var tempArray=[item.members, item.queueName,item.idleAgentCount,item.totalAgentCount,
				               item.queueWaitCount,(item.totalCalls-item.abadonedCalls)];

				var curRow=this.searchQueue(item.queueId,tblQueues,'queueId');
				if(!curRow){
					this.createRowCell(tblQueues,item.queueId,tempArray,'queueId');

				}else{
					this.updateRowCell(curRow,item.queueId,tempArray,'queueId',true);
				}
			}
		}
		

		
		icallcenter.Monitor.setInterval();
	},


    onServiceNoChanged: function(/*Object*/monitorServiceNo) {//更新服务号
		var self=this;
		if(!monitorServiceNo || !monitorServiceNo.serviceNo)	 return;

		var tblServiceNos = hojo.byId("icc.monitor.serviceNos");
		var tempArray=[monitorServiceNo.serviceNo,monitorServiceNo.inCalls,monitorServiceNo.inLost,monitorServiceNo.inComplete];
		var curRow=self.searchQueue(monitorServiceNo.serviceNo,tblServiceNos,'serviceNo');
		if(!curRow){
			self.createRowCell(tblServiceNos,monitorServiceNo.serviceNo,tempArray,'serviceNo');
		}else{
			self.updateRowCell(curRow,monitorServiceNo.serviceNo,tempArray,'serviceNo');
		}
    },    
    
    onQueueChanged: function(/*Object*/monitorQueue) {//更新队列
    	var self=this;
			//console.dir(monitorQueue);
			//alert(monitorQueues.length +"\n"+hojo.isArray(monitorQueues));
		    if(!monitorQueue || !monitorQueue.queueId)	 return;
			var tblAgents = hojo.byId("icc.monitor.queues");
			var tempArray=[monitorQueue.members, monitorQueue.queueName,monitorQueue.idleAgentCount,monitorQueue.totalAgentCount,
			               monitorQueue.queueWaitCount,(monitorQueue.totalCalls-monitorQueue.abadonedCalls),monitorQueue.totalCalls];
			var curRow=self.searchQueue(monitorQueue.queueId,tblAgents,'queueId');
			if(!curRow){
				self.createRowCell(tblAgents,monitorQueue.queueId,tempArray,'queueId');
			}else{
				self.updateRowCell(curRow,monitorQueue.queueId,tempArray,'queueId');
			}
    },

    onAgentChanged: function(/*Object*/monitorAgent) {//更新坐席
    	if(!monitorAgent.userId){
    		return ;	
    	}
		var self=this;
		if(!monitorAgent) return;
		var tblAgents = hojo.byId("icc.monitor.agents");
		var tempArray=[monitorAgent.DisplayName,monitorAgent.exten,monitorAgent.InComplete,
		               monitorAgent.OutComplete,monitorAgent.callNo,monitorAgent.extenType,
		               monitorAgent.callStatus,monitorAgent.timestamp,monitorAgent.status,0,
		               monitorAgent.channel,monitorAgent.linkedChannel,monitorAgent.login];
		var curRow=self.searchQueue(monitorAgent.userId,tblAgents,'userId');
		if (monitorAgent.user.indexOf('admin') == -1) {
			if (!curRow) {
				self.createRowCell(tblAgents, monitorAgent.userId, tempArray, 'userId');
			}
			else {
				self.updateRowCell(curRow, monitorAgent.userId, tempArray, 'userId');
			}
		}
		//更新坐席统计数据
		this.updatePeerNum();
    },
    
    updatePeerNum: function() {
    	var idleNum = 0;
    	var totalNum = 0;
    	var onlineNum = 0;
    	for(var i in phone.monitorPeers) {
    		var item=phone.monitorPeers[i];
    		var peerState = this.displayStatus(item.userId);
    		if(item.user != null) {
          if(item.user.indexOf('admin') != -1) {
            continue;
          }    		
    		}
    		totalNum++;
    		if(peerState != this._statusDesc["stOffline"] && peerState != this._statusDesc["stUnavaliable"] && peerState != this._statusDesc["stReady"]) {
    			onlineNum++;
    			if(peerState == this._statusDesc["stIdle"]) {
    				idleNum++;
    			}
    		}
    	}
    	hojo.byId("icc.monitor.agents.onlinePeer").innerHTML = onlineNum;
    	hojo.byId("icc.monitor.agents.idlePeer").innerHTML = idleNum;
    	hojo.byId("icc.monitor.agents.totalPeer").innerHTML = totalNum;
    },

	createRowCell:function(tab, qid, arrCellText,key){
    	var htmls = [];
		var userEvents = [];
		htmls.push("<table border=0 cellSpacing=0 cellPadding=0 width=100% >");
		htmls.push("<COLGROUP >");
		if(key == 'userId') {
			htmls.push("<col width='9%' /><col width='7%' /><col width='9%' /><col width='9%' /><col width='11%' /><col width='9%' /><col width='9%' /><col width='9%' /><col width='9%' /><col width='19%' />");	
		} else if(key=='queueId') {
			htmls.push("<COL width='10%' span='6'>");
		} else if(key=='serviceNo') {
			htmls.push("<COL width='10%' span='4'>");
		}
		
		htmls.push("</COLGROUP>");
		htmls.push("<tr "+key+"="+qid+" class='even' >");
		if(key == 'userId') {
			for(var i=0; i<10; i++) {
				if(i==9) {
					htmls.push("<td style='display: none' id='"+qid+"_9' extension='"+arrCellText[0]+"' status='"+arrCellText[6]+"' curChannel='"+arrCellText[10]+"' linkedChannel='"+arrCellText[11]+"' userId='"+qid+"'>");
					var textNode = '<a href="#" >&nbsp;监听&nbsp;</a><a style="display:none" href="#">&nbsp;结束监听&nbsp;</a>' +
						'<a href="#" >&nbsp;强拆&nbsp;</a><a href="#" >&nbsp;抢接&nbsp;</a><a href="#">&nbsp;签出&nbsp;</a><a href="#">&nbsp;签入&nbsp;</a>';
					htmls.push(textNode);
					htmls.push("</td>");
					userEvents.push(qid);
				} else if(i==7) {
					htmls.push("<td id='"+qid+"_7'></td>");
					if(arrCellText[i] && (arrCellText[6] != "Idle" && !arrCellText[12] || arrCellText[12])){
						var date = new Date();
						var identity = date.valueOf();
						var oldTime=((identity-phone.currentServerTime)-parseFloat(arrCellText[i])*1000)/1000;//设定初始值
						if(oldTime<0){
							oldTime=0;
						}
						var countTimer={
							count:oldTime
						}
						monitorTimers[qid]=countTimer;
					}
				} else if(i==6) {
					htmls.push("<td");
					var statusName=this.displayStatus(qid);
					if(statusName==this._statusDesc["stBusy"]){
					 	if(this._phone._peerState._get(this._busyType) != null) {
					 		htmls.push(" style='color:red'");
					 		statusName = this._phone._peerState._get(this._busyType).value;
					 	}
					} else if(statusName==this._statusDesc["stIdle"]){
						htmls.push(" style='color:green'");
					} else if(statusName==this._statusDesc["stWebcall"] || statusName==this._statusDesc["stInner"] 
					                || statusName==this._statusDesc["stRing"] || statusName==this._statusDesc["stRinging"] 
					                || statusName== this._statusDesc["stListen"] || statusName==	this._statusDesc["stNormal"] 
					                || statusName==this._statusDesc["stDialout"] || statusName==this._statusDesc["stDialTransfer"] 
					                || statusName== this._statusDesc["stTransfer"]){
						htmls.push(" style='color:#FF33FF'");
					 }else{

					 }
					 htmls.push(">");
					 htmls.push(statusName);
					 htmls.push("</td>");
				} else if(i==5)	{
					htmls.push("<td>");
					var extenType=this.displayExtenType(qid);
					htmls.push(extenType);
					htmls.push("</td>");
				} else {
					htmls.push("<td>");
					htmls.push(arrCellText[i]);
					htmls.push("</td>");
				}
			}
		} else if(key=='queueId'){
			var tipTitle = "";
			for(var i=0; i<arrCellText.length; i++){
				if(i == 0) {
					for(var j in arrCellText[i]){
						if(this._phone._base._getUserViaSipNum(j) != null) {
							tipTitle += this._phone._base._getUserViaSipNum(j).DisplayName + ",";	
						}
		        	}
					if(tipTitle != "") {
						tipTitle = tipTitle.substring(0, tipTitle.lastIndexOf(","));	
					}
				} else {
					if(i == 3) {
						htmls.push("<td title=" + tipTitle + "> ");
						//htmls.push("<a href='#' class='c5toolTip' title=" + tipTitle + " >");
						htmls.push("<a href='#' >");
						htmls.push(arrCellText[i]);
						htmls.push("</a>"); 
						htmls.push("</td>");
					} else {
						htmls.push("<td ");
						if(i==4&&arrCellText[i]!='0'){
							htmls.push("style='color:red'");
						}
						htmls.push(" >");
						htmls.push(arrCellText[i]);
						htmls.push("</td>");
					}
				}
			}
		} else if(key=='serviceNo'){
			for(var i=0; i<arrCellText.length; i++){
				htmls.push("<td>");
				htmls.push(arrCellText[i]);
				htmls.push("</td>");
			}
		}

		htmls.push("</tr>");
		htmls.push("</table>");
		var row = document.createElement("tr");
		for(i = 0; i< tab.childNodes.length; i++) {
			if(tab.childNodes[i].nodeType == 1) {
				if(tab.childNodes[i].tagName == "TBODY") {
					tab.childNodes[i].appendChild(row);
				}
			}
		}
		
		var cell = document.createElement("th");
		cell.style.paddingLeft = "1px";
		row.appendChild(cell);
		cell.innerHTML = htmls.join("");
		if(userEvents != '') {
			this.connectEvent(userEvents);	
		}
		
    },
    
    connectEvent:function(userEvents) {
    	for(var i=0;i<userEvents.length;i++) {
			hojo.connect(hojo.byId(userEvents[i]+"_9").firstChild, "onclick", this.listen); 
			hojo.connect(hojo.byId(userEvents[i]+"_9").childNodes[1], "onclick", this.endListen); 
			hojo.connect(hojo.byId(userEvents[i]+"_9").childNodes[2], "onclick", this.forceHangup); 
			hojo.connect(hojo.byId(userEvents[i]+"_9").childNodes[3], "onclick", this.loot); 
			hojo.connect(hojo.byId(userEvents[i]+"_9").childNodes[4], "onclick", this.forceKickout); 
			hojo.connect(hojo.byId(userEvents[i]+"_9").childNodes[5], "onclick", this.checkin); 
    	}
    },
	
    updateOtherRowCell:function(row,qid,arrCellText,key,isFirst){
		if(key=='userId'){
			for(var i=0; i<row.cells.length; i++)
			{
				if(i==6){
					row.cells[i].setAttribute("extension", arrCellText[0]);
					row.cells[i].setAttribute("status", arrCellText[4]);
					row.cells[i].setAttribute("curChannel", arrCellText[7]);
					row.cells[i].setAttribute("linkedChannel", arrCellText[8]);
					row.cells[i].setAttribute("userId", qid);
					if(isFirst){
						hojo.connect(row.cells[i].firstChild, "onclick", this.listen); 
						hojo.connect(row.cells[i].childNodes(1), "onclick", this.endListen); 
						hojo.connect(row.cells[i].childNodes(2), "onclick", this.forceHangup); 
						hojo.connect(row.cells[i].childNodes(3), "onclick", this.loot); 
						hojo.connect(row.cells[i].childNodes(4), "onclick", this.forceKickout); 
						hojo.connect(row.cells[i].childNodes(5), "onclick", this.checkin); 
					}
				}			
				else{
					row.cells[i].innerText =arrCellText[i];
				}
			}
		}
	},
	updateRowCell:function(row,qid,arrCellText,key,isFirst){
		//动态更新表格
		if(key=='userId'){
			for(var i=0; i<row.cells.length; i++)
			{
				if(i==7){
					if(arrCellText[i] && (arrCellText[6] != "Idle" && !arrCellText[12] || arrCellText[12])){
						var date = new Date();
						var identity = date.valueOf();
						var oldTime=((identity-phone.currentServerTime)-parseFloat(arrCellText[i])*1000)/1000;//设定初始值
						//alert(phone.currentServerTime+"\n"+identity+"\n"+arrCellText[i]+"\n"+parseFloat(arrCellText[i])*1000+"\n"+oldTime);
						if(oldTime<0){							
							oldTime=0;						
						}
						var countTimer={
							count:oldTime,
							tdNode:row.cells[i]
						}
						monitorTimers[qid]=countTimer;
					}else{
						delete monitorTimers[qid];//清除该分机timer
						row.cells[i].innerText="";
					}
				}else if(i==6){
					var statusName=this.displayStatus(qid);
					if(statusName==this._statusDesc["stBusy"]){
						if(this._phone._peerState._get(this._busyType) != null) {
					 		row.cells[i].style.color='red';
					 		statusName = this._phone._peerState._get(this._busyType).value;
						}
					 }else if(statusName==this._statusDesc["stIdle"]){
					 		row.cells[i].style.color='green';
					 } else if (statusName == this._statusDesc["stWebcall"]
											|| statusName == this._statusDesc["stInner"]
											|| statusName == this._statusDesc["stRing"]
											|| statusName == this._statusDesc["stRinging"]
											|| statusName == this._statusDesc["stListen"]
											|| statusName == this._statusDesc["stNormal"]
											|| statusName == this._statusDesc["stDialout"]
											|| statusName == this._statusDesc["stDialTransfer"]
											|| statusName == this._statusDesc["stTransfer"]) {
					 		row.cells[i].style.color='#FF33FF';
					 }else{
					 		row.cells[i].style.color='';
					 }
					row.cells[i].innerHTML =statusName;
				}else if(i==5){
					var extenType = this.displayExtenType(qid);
					row.cells[i].innerHTML =extenType;
				}else if(i==9){
					row.cells[i].setAttribute("extension", arrCellText[0]);
					row.cells[i].setAttribute("status", arrCellText[6]);
					row.cells[i].setAttribute("curChannel", arrCellText[10]);
					row.cells[i].setAttribute("linkedChannel", arrCellText[11]);
					
//					if(isFirst){
//						hojo.connect(row.cells[i].firstChild, "onclick", this.listen);
//						hojo.connect(row.cells[i].childNodes(1), "onclick", this.endListen);
//						hojo.connect(row.cells[i].childNodes(2), "onclick", this.forceHangup);
//						hojo.connect(row.cells[i].childNodes(3), "onclick", this.loot);
//						hojo.connect(row.cells[i].childNodes(4), "onclick", this.forceKickout);
//						hojo.connect(row.cells[i].childNodes(5), "onclick", this.checkin);
//					}
				}			
				else{
					row.cells[i].innerHTML =arrCellText[i];
				}
			}
		}else if(key=='queueId'){
			var tipTitle = "";
			for(var j in arrCellText[0]){
				//alert(j + ":" + this._phone._base._getUserViaSipNum(j));
				if(this._phone._base._getUserViaSipNum(j) != null) {
					//alert(j + "\n" + this._phone._base._getUserViaSipNum(j).sipNo);
					tipTitle += this._phone._base._getUserViaSipNum(j).DisplayName + ",";	
				}
        	}
			if(tipTitle != "") {
				tipTitle = tipTitle.substring(0, tipTitle.lastIndexOf(","));	
			}
			
			for(var i = 1; i<row.cells.length; i++) {
				if(i == 2) {
					row.cells[i].title = tipTitle;
					//row.cells[i].innerHTML = "<a href='#' class='c5toolTip' title=" + tipTitle + " >" + arrCellText[i] + "</a>";
					row.cells[i].innerHTML = "<a href='#'>" + arrCellText[i + 1] + "</a>";
					//ToolTip.addTips({ width: 200 });
				} else {
					row.cells[i].innerText =arrCellText[i + 1];
					if(i==3 &&arrCellText[i + 1]!='0'){
							row.cells[i].style.color='red';
					}else{
						row.cells[i].style.color='';
					}				
				}
			}
		}else if(key=='serviceNo'){
			for(var i=1; i<row.cells.length; i++)
			{
				row.cells[i].innerText =arrCellText[i];
			}
		}
	},
	searchQueue:function(qid,table,key){
		//查询节点是否已经存在
		for(var i=0; i<table.rows.length; i++)
		{
			var row = table.rows[i].cells[0].firstChild.rows[0];
			var trID=row.getAttribute(key);
			if(qid==trID){
				return table.rows[i].cells[0].firstChild.rows[0];
			}
		}
		return null;
	},
	
	loot:function(event){
		//抢接(通道为LinkedChannel)
		 var o = event.target;
	   var curChannel = o.parentNode.getAttribute("linkedChannel");
	   var status = o.parentNode.getAttribute("status");
   	 var userId = o.parentNode.getAttribute("userId");

	   if (hojo.getObject("phone.extenType")=='none') {
		   alert("执行该操作必须以电话方式登录");
		   return;    
	   }
		 if (userId == phone.userId) {
		   alert("不允许对自身进行该操作");
		   return;
	   }
	   if(icallcenter.Monitor.isPeerSelf()){
		   alert("该状态不允许抢接");
		   return;
	   }
	   
		 phone.lootCall(curChannel);
	},
	forceHangup:function(event){
		//强拆
	  /* if (hojo.getObject("phone.extenType")=='none') {
		   alert("执行该操作必须以电话方式登录");
		   return;    
	   }*/
	
	   var o = event.target;
	   var curChannel = o.parentNode.getAttribute("curChannel");
	   var status = o.parentNode.getAttribute("status");
       if (status != "listen" && status != "Idle") {
           phone.hangupChannel(curChannel);
       }
       else {
           alert("该状态不允许强拆");
       }
	},
	listen:function(event) {
	   var self=this;
	   if (hojo.getObject("phone.extenType")=='none') {
		   alert("执行该操作必须以电话方式登录");
		   return;    
	   }
	   var o = event.target;
	   var phoneNum = o.parentNode.getAttribute("extension");
	   var status = o.parentNode.getAttribute("status");
	   var userId = o.parentNode.getAttribute("userId");
	   var channel = o.parentNode.getAttribute("curChannel");
	   if (userId == phone.userId) {
		   alert("不允许对自身进行该操作");
		   return;
	   }
	  	if(icallcenter.Monitor.isPeerSelf()){
		   alert("该状态不允许监听");
		   return;
	   }
	   
	   if (status != "webcall" && status != "inner" && status!="normal" && status!="dialout" && status!="dialTransfer" && status!="transfer") {
		 		alert("该状态不允许监听");
		 		return;
		 }
	   
       if(phone._peerState._curPeerStateKey == "0") {
	       	alert("请先将电话置为忙碌");
	    	return;
       }

	   //console.debug("监听号码[%s]通道号[%s]", phoneNum,channel);
	   o.style.display = "none";
	   o.nextSibling.style.display = "";
	   icallcenter.Monitor.listenNode = o;
	   icallcenter.Monitor.endListenHandler = phone.register("EvtEndListen", null, function() {icallcenter.Monitor.onEndListen();});                           
	   phone.listen(channel); 
	},

	endListen:function(event) {
	   phone.hangup();
	},

	forceKickout:function(event) {
	   var o = event.target;
	   var sipNo = o.parentNode.getAttribute("extension");
	   var userId = o.parentNode.getAttribute("userId");
	   var username = o.parentNode.getAttribute("username");

	   
	   if (userId == phone.userId) {
		   alert("不允许对自身进行该操作");
		   return;
	   }
		if(phone && phone.monitorPeers){
			var peer=phone.monitorPeers[userId];
			if(!peer.login && peer.extenType!='Local'  && peer.extenType!='gateway'){//离线的可以签出
			 alert("不允许对签出坐席进行该操作");
		   return;
			}
		} 
		phone.kick(userId);
	},
	
	checkin:function(event) {
		   var o = event.target;
		   var sipNo = o.parentNode.getAttribute("extension");
		   var userId = o.parentNode.getAttribute("userId");
		   var username = o.parentNode.getAttribute("username");

		   if (userId == phone.userId) {
			   alert("不允许对自身进行该操作");
			   return;
		   }
			if(phone && phone.monitorPeers){
				var peer=phone.monitorPeers[userId];
				//console.dir(peer);
				if(peer.login){
					alert("不允许对签入坐席进行该操作");
					return;
				} 
				if(!peer.login && peer.extenType == 'Local'){
					return;
				}
			} 
			phone.pick(userId);
		},

	displayStatus:function(/*String*/userId){
		var displayName='';
		if(phone && phone.monitorPeers){
			var peer=	phone.monitorPeers[userId];
			if(peer.login && peer.extenType!='none'){
					if((peer.extenType=='sip' || peer.extenType=='gateway') && peer.register==false){
						displayName=this._statusDesc["stUnavaliable"];
					}else if(peer.callStatus=='Idle'){
						if(peer.busyType != "0")	{
							displayName=this._statusDesc["stBusy"];
							this._busyType = peer.busyType;
						}else{
							displayName=this._statusDesc["stIdle"];	
							this._busyType = "0";
						}
					}else if(peer.callStatus=='Ring'){
						displayName=this._statusDesc["stRing"];
					}else if(peer.callStatus=='Ringing'){
						displayName=this._statusDesc["stRinging"];
					}else if(peer.callStatus=='inner'){
						displayName=this._statusDesc["stInner"];
					}else if(peer.callStatus=='normal'){
						displayName=this._statusDesc["stNormal"];
					}else if(peer.callStatus=='dialout'){
						displayName=this._statusDesc["stDialout"];
					}else if(peer.callStatus=='dialTransfer'){
						displayName=this._statusDesc["stDialTransfer"];
					}else if(peer.callStatus=='transfer'){
						displayName=this._statusDesc["stTransfer"];
					}else if(peer.callStatus=='listen'){
						displayName=this._statusDesc["stListen"];
					}else if(peer.callStatus=='webcall'){
						displayName=this._statusDesc["stWebcall"];
					}else if(peer.callStatus=='validate'){
						displayName=this._statusDesc["stValidate"];
					}else {
						diplayName=peer.callStatus+'ass';
					}
			}else if(peer.login && peer.extenType=='none'){
				displayName='';
			}else{
					if(peer.callStatus=='Ring'){
						displayName=this._statusDesc["stRing"];
					}else if(peer.callStatus=='Ringing'){
						displayName=this._statusDesc["stRinging"];
					}else if(peer.callStatus=='inner'){
						displayName=this._statusDesc["stInner"];
					}else if(peer.callStatus=='normal'){
						displayName=this._statusDesc["stNormal"];
					}else if(peer.callStatus=='dialout'){
						displayName=this._statusDesc["stDialout"];
					}else if(peer.callStatus=='dialTransfer'){
						displayName=this._statusDesc["stDialTransfer"];
					}else if(peer.callStatus=='transfer'){
						displayName=this._statusDesc["stTransfer"];
					}else if(peer.callStatus=='listen'){
						displayName=this._statusDesc["stListen"];
					}else if(peer.callStatus=='webcall'){
						displayName=this._statusDesc["stWebcall"];
					}else if(peer.callStatus=='validate'){
						displayName=this._statusDesc["stValidate"];
					}
					else{
						if(!peer.login && (peer.extenType=='gateway' || peer.extenType=='Local')){
							displayName=this._statusDesc["stOffline"];
						}else{
							displayName=this._statusDesc["stReady"];
						}
					}
			}
		}
		return displayName;
	},
	displayExtenType:function(userId){
		var displayExtenType='';
		if(phone && phone.monitorPeers){
			var peer=	phone.monitorPeers[userId];
			if(peer.extenType=='sip'){
				displayExtenType='软电话';
			}else if(peer.extenType=='gateway'){
				displayExtenType='SIP话机/网关';
			}else if(peer.extenType=='Local'){
				//displayExtenType='直线电话/手机';
				displayExtenType=peer.localNo;
			}else if(peer.extenType=='none'){
				displayExtenType='无电话接入';
			}
			
		}
		return displayExtenType;
	}

});
icallcenter.Monitor.isPeerSelf=function() {
		//判断坐席本身是否在通话中
		var me=phone.userId;
		if(me && phone && phone.monitorPeers){
				var peer=	phone.monitorPeers[me];
				if(peer.callStatus=='Ring' ||peer.callStatus=='Ringing' || peer.callStatus=='inner'
					||peer.callStatus=='normal'||peer.callStatus=='dialout'||peer.callStatus=='dialTransfer'
						||peer.callStatus=='transfer'||peer.callStatus=='listen'){
					return true;
				}
		}

		return false;
	};
icallcenter.Monitor.onEndListen=function() {
	   var o = icallcenter.Monitor.listenNode;
	   o.nextSibling.style.display = "none";
	   o.style.display = "";
	   phone.unregister(icallcenter.Monitor.endListenHandler);
	};
icallcenter.Monitor.getTimer=function(/*number秒数*/countTimer){
	  var minute="0";
	  var second="0";
	  var hour="0";
	  countTimer = parseInt(countTimer)+1;
	  hour=parseInt(countTimer/3600);
	  minute = parseInt((countTimer%3600)/60);
	  second = (countTimer%3600)%60;

	  var mtime = (hour<10)? "0" + hour : hour;
	  mtime += ":";
	  mtime += (minute<10)? "0" + minute : minute;
	  mtime += ":";
	  mtime += (second<10)? "0" + second : second;

	  return mtime;
};
icallcenter.Monitor.doCallTimer=function(){
	if(monitorTimers){
		for(var i in monitorTimers)
		{
			// Another js object inserts timers into this array, I have to filter it.
			// This js object which inserts timers should be found and fixed.
			if(hojo.byId(i+"_7") != null) {
				hojo.byId(i+"_7").innerText = icallcenter.Monitor.getTimer(monitorTimers[i].count);
				//monitorTimers[i].tdNode.innerText=icallcenter.Monitor.getTimer(monitorTimers[i].count);
				monitorTimers[i].count++;
			}
			
		}
	}
};
icallcenter.Monitor.setInterval=function(){
     if (icallcenter.Monitor.monitorTimersHandle) {
         window.clearInterval(icallcenter.Monitor.monitorTimersHandle);
     }
     icallcenter.Monitor.monitorTimersHandle = window.setInterval("icallcenter.Monitor.doCallTimer()",1000);
};



