hojo.provide("icallcenter.stateElement.ringring.innerRinging");hojo.declare("icallcenter.stateElement.ringring.innerRinging",null,{constructor:function(a){this._base=a},_base:null,_callState:"stInnerBelling",_changeToolBarState:function(b){hojo.publish("EvtCallToolBarChange",[b._callState])},_switchCallState:function(c){if(c.Event=="ChannelStatus"){if(c.Exten==this._base._phone.sipNo){if(c.ChannelStatus=="Hangup"){this._base._curCallState=this._base._getInvalid();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}else {if(c.ChannelStatus=="Link"){if(c.LinkedChannel.ChannelType=="threeWayCall"){this._base._curCallState=this._base._getThreeWayCallLink();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}else {if(c.LinkedChannel.ChannelType=="inner"){this._base._curCallState=this._base._getInnerLink();this._changeToolBarState(this._base._curCallState);if(this._base._phone._isRing){this._base._phone.stopSound();this._base._phone._isRing=false}}}}}}}},_publish:function(){}})