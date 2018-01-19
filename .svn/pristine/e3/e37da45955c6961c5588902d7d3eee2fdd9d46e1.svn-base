package cn.com.atnc.ioms.dao.clientmng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;

/**
 *类说明
 *@author 潘涛
 *@date 2014-3-19	下午3:47:37
 *@version:1.0
 */
public interface IClientDao extends IBaseDao<Client> {
	/**
	 * 查询封装为分页对象
	 * @author 潘涛
	 * @date:2014年3月19日 16:24:10
	 * */
	Pagination queryPage(ClientQueryModel qm);
	/**
	 * 查询结合
	 * @author 潘涛
	 * @date:2014年3月19日 16:24:37
	 * */
	List<Client> queryList(ClientQueryModel qm);
	/**
	 * 查询单位结合
	 * @author 潘涛
	 * @date:2014年3月19日 16:24:37
	 * */
	List<ClientCompany> queryCompanyList(ClientQueryModel qm);
	/**
	 * 查询注册用户列表
	 * @author duanyanlin
	 * @date 2016年4月19日下午2:30:24
	 * @return
	 */
	List<Client> getTimeUserRegistedList(CsRole role, CsUserStatusEnum status);
}
