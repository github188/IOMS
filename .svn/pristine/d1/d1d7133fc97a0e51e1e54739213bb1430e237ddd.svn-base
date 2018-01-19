/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:03:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.basedata.ku;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * @author:HuangYijie
 * @date:2014-3-19 下午8:03:06
 * @version:1.0
 */

public class KuStatQueryModel extends MyPaginModel {

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar endTime;
	private String codeLike;
	private String code;

	private String rxNodeNoLike;
	private String txNodeNoLike;
	private SubnetType subnetTypeRx;
	private SubnetType subnetTypeTx;

	private String txNodeId;
	private KuNode txNode;// 发端节点号
	private String txNodeNo;
	private String txGib;// 发端槽号
	private String txChan;// 发端端口号

	private KuNode rxNode;// 收端节点号
	private String rxNodeNo;
	private String rxGib;// 收端槽号
	private String rxChan;// 收端端口号
	private String rxNodeId;
	private String memo;//其他接收端
	private String usage;
	private String usageLike;
	
	public SubnetType getSubnetTypeRx() {
		return subnetTypeRx;
	}

	public void setSubnetTypeRx(SubnetType subnetTypeRx) {
		this.subnetTypeRx = subnetTypeRx;
	}

	public SubnetType getSubnetTypeTx() {
		return subnetTypeTx;
	}

	public void setSubnetTypeTx(SubnetType subnetTypeTx) {
		this.subnetTypeTx = subnetTypeTx;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	private String excludeId;

	private Boolean complete;

	private KuServiceRateType rateType;

	private String clientId;

	private List<String> clientNodes;

	private String[] ids;

	private String nodeId;
	private String memoLike;

	public String getMemoLike() {
		return HqlStringTools.replaceSpecialChar(memoLike);
	}

	public void setMemoLike(String memoLike) {
		this.memoLike = memoLike;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public List<String> getClientNodes() {
		return clientNodes;
	}

	public void setClientNodes(List<String> clientNodes) {
		this.clientNodes = clientNodes;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public KuServiceRateType getRateType() {
		return rateType;
	}

	public void setRateType(KuServiceRateType rateType) {
		this.rateType = rateType;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public String getExcludeId() {
		return excludeId;
	}

	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}

	public String getTxNodeNo() {
		return txNodeNo;
	}

	public void setTxNodeNo(String txNodeNo) {
		this.txNodeNo = txNodeNo;
	}

	public String getRxNodeNo() {
		return rxNodeNo;
	}

	public void setRxNodeNo(String rxNodeNo) {
		this.rxNodeNo = rxNodeNo;
	}

	public String getCodeLike() {
		return HqlStringTools.replaceSpecialChar(codeLike);
	}

	public void setCodeLike(String codeLike) {
		this.codeLike = codeLike;
	}

	public String getRxNodeNoLike() {
		return HqlStringTools.replaceSpecialChar(rxNodeNoLike);
	}

	public void setRxNodeNoLike(String rxNodeNoLike) {
		this.rxNodeNoLike = rxNodeNoLike;
	}

	public String getTxNodeNoLike() {
		return HqlStringTools.replaceSpecialChar(txNodeNoLike);
	}

	public void setTxNodeNoLike(String txNodeNoLike) {
		this.txNodeNoLike = txNodeNoLike;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTxNodeId() {
		return txNodeId;
	}

	public void setTxNodeId(String txNodeId) {
		this.txNodeId = txNodeId;
	}

	public KuNode getTxNode() {
		return txNode;
	}

	public void setTxNode(KuNode txNode) {
		this.txNode = txNode;
	}

	public String getTxGib() {
		return txGib;
	}

	public void setTxGib(String txGib) {
		this.txGib = txGib;
	}

	public String getTxChan() {
		return txChan;
	}

	public void setTxChan(String txChan) {
		this.txChan = txChan;
	}

	public KuNode getRxNode() {
		return rxNode;
	}

	public void setRxNode(KuNode rxNode) {
		this.rxNode = rxNode;
	}

	public String getRxGib() {
		return rxGib;
	}

	public void setRxGib(String rxGib) {
		this.rxGib = rxGib;
	}

	public String getRxChan() {
		return rxChan;
	}

	public void setRxChan(String rxChan) {
		this.rxChan = rxChan;
	}

	public String getRxNodeId() {
		return rxNodeId;
	}

	public void setRxNodeId(String rxNodeId) {
		this.rxNodeId = rxNodeId;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getUsageLike() {
		return usageLike;
	}

	public void setUsageLike(String usageLike) {
		this.usageLike = usageLike;
	}

}
