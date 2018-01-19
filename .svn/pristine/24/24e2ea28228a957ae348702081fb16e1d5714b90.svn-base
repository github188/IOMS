package cn.com.atnc.ioms.mng.clientmng.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.SecurityUtil;
import cn.com.atnc.ioms.dao.acl.IQuestionDao;
import cn.com.atnc.ioms.dao.act.IActMembershipDao;
import cn.com.atnc.ioms.dao.act.IActUserDao;
import cn.com.atnc.ioms.dao.clientmng.IClientCompanyDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.dao.clientmng.IClientQuestionDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientCompany;
import cn.com.atnc.ioms.entity.clientmng.ClientQuestion;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.enums.clientmng.CsRoleType;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;
import cn.com.atnc.ioms.mng.clientmng.IClientCompanyManager;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.clientnotice.IClientNoticeManager;
import cn.com.atnc.ioms.model.clientmng.ClientQuestionForm;
import cn.com.atnc.ioms.model.clientmng.query.ClientQueryModel;

/**
 * 类说明
 * 
 * @author 潘涛
 * @date 2014-3-19 下午4:18:35
 * @version:1.0
 */
@Service("clientManager")
public class ClientManagerImpl extends AbstractService implements
		IClientManager {
	@Autowired
	private IClientDao csClientDao;
	@Autowired
	private IClientQuestionDao clientQuestionDao;
	@Autowired
	private IQuestionDao questionDao;
	@Autowired
	private IDiscuzUserService discuzUserService;
	@Autowired
	private IClientNoticeManager clientNoticeManager;
	@Autowired
	private IClientCompanyManager clientCompanyManager;
	//公司外键
	@Autowired
	private IClientCompanyDao clientCompanyDao;
	@Autowired
	private IActUserDao actUserDao;
	@Autowired
	private IActMembershipDao actMembershipDao;

	@Override
	@Transactional
	public Client add(Client client) throws ServiceException {
		client.setPswRandom(client.getPassword());
		client.setPswOrigin(client.getPassword());
		client.setPassword(SecurityUtil.encryptByMD5(client.getPassword()));
		client.setStatus(CsUserStatusEnum.REGISTED);
		ClientQueryModel qm = new ClientQueryModel();
		qm.setRoleName(CsRoleType.localManager.name());
		qm.setNewCompany(clientCompanyManager.findByID(client.getNewCompany()
				.getId()));
		if (client.getRole().getName().equals(CsRoleType.user.name())
				&& this.queryList(qm).size() == 0) {
			throw new ServiceException("该单位目前暂无领导，请先添加领导！");
		} else {
			Client obj = new Client();
			org.springframework.beans.BeanUtils.copyProperties(client, obj,
					new String[] { "lastLoginTime", "auditReason" });
			// discuzUserService.registerDiscuzMember(obj);
			return this.findByID(this.csClientDao.save(obj));
		}
	}

	@Override
	// @Transactional
	public Client update(Client obj) throws ServiceException {
		ClientQueryModel qm = new ClientQueryModel();
		qm.setRoleName(CsRoleType.localManager.name());
		qm.setNewCompany(clientCompanyManager.findByID(obj.getNewCompany()
				.getId()));
		ClientQueryModel old = new ClientQueryModel();
		Client oldClient = this.findByID(obj.getId());// 原始用户信息
		old.setNewCompany(clientCompanyManager.findByID(oldClient
				.getNewCompany().getId()));
		old.setRoleName(CsRoleType.localManager.name());
		// 进行修改的角色是工程师时，若目标单位没有领导，则不能修改
		if (obj.getRole().getName().equals(CsRoleType.user.name())
				&& this.queryList(qm).size() == 0) {
			throw new ServiceException("该单位目前暂无领导，请先添加领导！");
		}
		/*
		 * 进行修改的角色是领导时，如果是新注册用户进行审批，直接更新， 如果是审批通过用户，则判断是否为单位唯一领导
		 */
		if (obj.getRole().getName().equals(CsRoleType.localManager.name())
				&& StringUtils.equals(oldClient.getStatus().name(), "PASSED")
				&& !StringUtils.equals(oldClient.getNewCompany().getId(), obj
						.getNewCompany().getId())
				&& this.queryList(old).size() <= 1) {
			throw new ServiceException("此客户为其单位唯一领导，请勿修改！");
		} else {
			this.csClientDao.update(obj);
			return obj;
		}

	}

	@Override
	// @Transactional
	public Client block(Client obj) throws ServiceException {
		// String str = "";
		if (obj.getRole().getName().equals(CsRoleType.user.name())) {
			obj.setBlocking(true);
			this.csClientDao.update(obj);
			return obj;
		} else {
			ClientQueryModel qm = new ClientQueryModel();
			qm.setRoleNames(new String[] { CsRoleType.localManager.name() });
			qm.setNewCompany(clientCompanyManager.findByID(obj.getNewCompany()
					.getId()));
			qm.setBlocking(false);
			logger.info("this.queryList(qm).size():"
					+ this.queryList(qm).size());
			if (this.queryList(qm).size() > 1) {
				obj.setBlocking(true);
				this.csClientDao.update(obj);
				return obj;
			} else {
				throw new ServiceException("此客户为其单位唯一领导，请勿冻结！");
			}
			/*
			 * ClientQueryModel qm = new ClientQueryModel();
			 * qm.setPid(obj.getId()); if
			 * (CollectionUtils.isEmpty(this.queryList(qm))) {
			 * obj.setBlocking(true); this.csClientDao.update(obj); return obj;
			 * } else {
			 * 
			 * for (Client client : queryList(qm)) {
			 * 
			 * str += client.getName() + ","; } throw new
			 * ServiceException("有下属员工 : " + str + "存在，不能冻结"); }
			 */
		}
	}

	@Override
	public Pagination queryPage(ClientQueryModel qm) {
		return this.csClientDao.queryPage(qm);
	}

	@Override
	public List<Client> queryList(ClientQueryModel qm) {
		return this.csClientDao.queryList(qm);
	}

	@Override
	public List<ClientCompany> queryCompanyList(ClientQueryModel qm) {
		return this.csClientDao.queryCompanyList(qm);
	}

	@Override
	public Client findByID(Serializable id) {
		return this.csClientDao.findById(id);
	}

	@Override
	public Client findByName(String name) {
		return this.csClientDao.findByParam("loginName", name);
	}

	@Override
	@Transactional
	public void delete(Client client) throws ServiceException {
		
		
		/**
		 * 检查是否有下属
		 * */
		// if (client.getRole().getName().equals(CsRoleType.user)) {
		this.csClientDao.delete(client);
	}

	@Override
	@Transactional
	public Client audit(Client client) throws ServiceException {
		Client old = this.findByID(client.getId());
		if (null != client.getStatus()) {
			old.setStatus(client.getStatus());
		}
		if (!StringUtils.isEmpty(client.getAuditReason())) {
			old.setAuditReason(client.getAuditReason());
		}
		BaseUserInfo baseUserInfo = new BaseUserInfo();
		baseUserInfo.setLoginName(old.getLoginName());
		baseUserInfo.setName(old.getName());
		baseUserInfo.setMobilephone(old.getMobilephone());
		switch (client.getStatus()) {
		case DISABLED:
			discuzUserService.deleteDiscuzMember(old);
			// TODO 操作日志没有验证20140714
			/*clientNoticeManager.sendMessage(old, "尊敬的用户：" + old.getName()
					+ " 您好！您的帐号 " + old.getLoginName() + " 已注销！---[北京天航信网络公司]");*/
			clientNoticeManager.sendMessage(baseUserInfo, "尊敬的用户：" + old.getName()
					+ " 您好！您的帐号 " + old.getLoginName() + " 已注销！---[北京天航信网络公司]");
			break;
		case PASSED:
			//审核通过的情况下  -- 设置密码并以短信的形式发送给用户
			//临时用户的需要重新生成密码
			if(StringUtils.isEmpty(old.getPswRandom())){
				old.setPswOrigin(client.getPassword());
				old.setPswRandom(client.getPassword());
			}
			old.setPassword(SecurityUtil.encryptByMD5(client.getPassword()));
			
			clientNoticeManager.sendMessage(
				/*	old,
					"尊敬的用户：" + old.getName() + " 您好！您的帐号 " + old.getLoginName()
							+ old.getStatus().getValue() + ",初始密码为："
							+ old.getPswRandom()
							+ "  提示:均为英文大写字母，请您及时修改！---[北京天航信网络公司]");*/
					baseUserInfo,
					"尊敬的用户：" + old.getName() + " 您好！您的帐号 " + old.getLoginName()
							+ old.getStatus().getValue() + "，初始密码为："
							+ old.getPswRandom()
							+ "  提示:均为英文大写字母，请您及时修改！---[北京天航信网络公司]");
			break;
		case DENIED:
			clientNoticeManager.sendMessage(
					baseUserInfo,
					"尊敬的用户：" + old.getName() + " 您好！您的帐号 " + old.getLoginName()
							+ old.getStatus().getValue()+ "，原因为：" + old.getAuditReason() + " 请重新申请---[北京天航信网络公司]");
			break;
		default:
			break;
		}
		return this.update(old);
	}

	@Override
	public Integer getUnresolvedCount() {
		ClientQueryModel qm = new ClientQueryModel();
		qm.setStatus(CsUserStatusEnum.REGISTED);
		return this.queryList(qm).size();
	}
	/**
	 * 根据用户ID查询已回答问题
	 * @author duanyanlin
	 * @date 2016年4月19日上午11:09:17
	 * @param clientId
	 * @return
	 */
	public ClientQuestionForm findByClientID(String clientId){
		ClientQuestionForm clientQuestionForm = new ClientQuestionForm(); 
		//查询用户注册时回答的问题
		List<ClientQuestion> clientQuestions = this.clientQuestionDao.searchClientQuestion(clientId);
		if(clientQuestions.size() == 3){
			//封装问题数据
			clientQuestionForm.setSize(3);
			String description1 = this.questionDao.findById(clientQuestions.get(0).getQuestionId()).getDescription();
			String description2 = this.questionDao.findById(clientQuestions.get(1).getQuestionId()).getDescription();
			String description3 = this.questionDao.findById(clientQuestions.get(2).getQuestionId()).getDescription();
			clientQuestionForm.setAnswer1(clientQuestions.get(0).getAnswer());
			clientQuestionForm.setAnswer2(clientQuestions.get(1).getAnswer());
			clientQuestionForm.setAnswer3(clientQuestions.get(2).getAnswer());
			clientQuestionForm.setDescription1(description1);
			clientQuestionForm.setDescription2(description2);
			clientQuestionForm.setDescription3(description3);
		}else{
			//未回答问题的用户，问题数量标记为0
			clientQuestionForm.setSize(0);
		}
		return clientQuestionForm;
	}
	
	/**
	 * 查询未审核的临时用户总数
	 * @author duanyanlin
	 * @date 2016年4月19日 下午2:26:38
	 */
	@Override
	public Integer getTimeUserRegistedCount(CsRole role, CsUserStatusEnum status) {
		List<Client> clientList = this.csClientDao.getTimeUserRegistedList(role, status);
		return clientList.size();
	}
	
	
	/**
	 * 删除用户名下的回答问题记录
	 * @author duanyanlin
	 * @date 2016年4月15日上午8:53:48
	 * @param clientId
	 */
	public void deleteAnswer(String clientId){
		List<ClientQuestion> questions = this.clientQuestionDao.searchClientQuestion(clientId);
		if(questions.size() > 0){
			this.clientQuestionDao.deleteList(questions);
		}
	}
}
