hojo.provide("icallcenter.stateElement.ringring.normalRinging");hojo.declare("icallcenter.stateElement.ringring.normalRinging",null,{constructor:function(a){this._base=a},_base:null,_callState:"stBelling",_changeToolBarState:function(b){hojo.publish("EvtCallToolBarChange",[b._callState])},_switchCallState:function(c){if(c.Event=="ChannelStatus"){if(c.Exten==this._base._phone.sipNo){if(c.ChannelStatus=="Hangup"){this._base._curCallState=this._base._getInvalid();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}else {if(c.ChannelStatus=="Link"){if(c.LinkedChannel.ChannelType=="normal"){this._base._curCallState=this._base._getNormalLink();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}else {if(c.LinkedChannel.ChannelType=="threeWayCall"){this._base._curCallState=this._base._getThreeWayCallLink();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}else {if(c.LinkedChannel.ChannelType=="transfer"){this._base._curCallState=this._base._getNormalLink();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}}}}}}}},_publish:function(){}})