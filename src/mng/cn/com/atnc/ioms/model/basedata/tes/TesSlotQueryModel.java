/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:03:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.basedata.tes;

import cn.com.atnc.ioms.model.MyPaginModel;


public class TesSlotQueryModel extends MyPaginModel {

//	private String tesNodeCodeLike;
    private String tesNodeCodeEq;
    private String cuLike;
	private String tesNodeIdLike;
	private String excludeId;
	private String tesNodeId;
  
	private String cu;

	public String getTesNodeCodeEq() {
        return tesNodeCodeEq;
    }
    public void setTesNodeCodeEq(String tesNodeCodeEq) {
        this.tesNodeCodeEq = tesNodeCodeEq;
    }
    public String getCuLike() {
        return cuLike;
    }
    public void setCuLike(String cuLike) {
        this.cuLike = cuLike;
    }
    public String getCu() {
		return cu;
	}
	public void setCu(String cu) {
		this.cu = cu;
	}
	public String getTesNodeIdLike() {
		return tesNodeIdLike;
	}
	public String getExcludeId() {
		return excludeId;
	}
	public String getTesNodeId() {
		return tesNodeId;
	}

	public void setTesNodeIdLike(String tesNodeIdLike) {
		this.tesNodeIdLike = tesNodeIdLike;
	}
	public void setExcludeId(String excludeId) {
		this.excludeId = excludeId;
	}
	public void setTesNodeId(String tesNodeId) {
		this.tesNodeId = tesNodeId;
	}
}
