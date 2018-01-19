package cn.com.atnc.ioms.mng.clientmng;

import java.io.Serializable;
import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.model.clientmng.ClientQuestionForm;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;

/**
 * 类说明:客户服务接口
 * 
 * @author 潘涛
 * @date 2014-3-19 下午3:53:22
 * @version:1.0
 */
public interface IClientManager {
	/**
	 * 保存对象
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:00:23
	 * */
	public Client add(Client obj) throws ServiceException;

	/**
	 * 修改对象
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:00:23
	 * */
	public Client update(Client obj) throws ServiceException;
	
	public Client block(Client obj) throws ServiceException;
	/**
	 * 按逐渐查询
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:21:40
	 * */
	public Client findByID(Serializable id);

    public Client findByName(String name);
	/**
	 * 查询分页对象
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:00:23
	 * */
	public Pagination queryPage(ClientQueryModel qm);

	/**
	 * 查询集合
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:00:23
	 * */
	public List<Client> queryList(ClientQueryModel qm);
	/**
	 * 查询单位集合
	 * 
	 * @author 潘涛
	 * @date:2014年3月19日 16:00:23
	 * */
	public List<ClientCompany> queryCompanyList(ClientQueryModel qm);
	/**
	 * 删除
	 * 
	 * @author 潘涛
	 * @date:2014年4月3日 11:47:36
	 * @param:client 删除的客户对象
	 * @return :void
	 * @throws ServiceException
	 * */
	public void delete(Client client) throws ServiceException;

	/**
	 * 审核
	 * 
	 * @author 潘涛
	 * @date:2014年4月4日 14:56:16
	 * @param:client审核表单对象
	 * @return client 审核后对象
	 * */
	public Client audit(Client client) throws ServiceException;

	/**
	 * 得到未处理的任务总数
	 * */
	public Integer getUnresolvedCount();
	
	/**
	 * 根据用户ID查询已回答问题
	 * @author duanyanlin
	 * @date 2016年4月19日上午11:09:17
	 * @param clientId
	 * @return
	 */
	public ClientQuestionForm findByClientID(String clientId);
	
	/**
	 * 查询未审核的临时用户总数
	 * @author duanyanlin
	 * @date 2016年4月19日下午2:25:46
	 * @return
	 */
	public Integer getTimeUserRegistedCount(CsRole role, CsUserStatusEnum status);
	
	/**
	 * 删除用户名下的回答问题记录
	 * @author duanyanlin
	 * @date 2016年4月15日上午8:53:48
	 * @param clientId
	 */
	public void deleteAnswer(String clientId);

}
