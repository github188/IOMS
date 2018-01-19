package cn.com.atnc.ioms.mng.acl.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.mng.acl.IDiscuzUserService;

import com.fivestars.interfaces.bbs.util.XMLHelper;

/**
 * 类说明：客户服务接口实现
 * 
 * @author 潘涛
 * @date 2014-3-26 上午11:16:39
 * @version:1.0
 */
@Service("DiscuzUserService")
public class DiscuzUserServiceImpl extends BaseService implements
		IDiscuzUserService {
	@Autowired
	private IClientDao userDao;

	public void registerDiscuzMember(BaseUserInfo user) throws ServiceException {
		logger.debug("---------------add Discuz user------------------");
		com.fivestars.interfaces.bbs.client.Client uc = new com.fivestars.interfaces.bbs.client.Client();
		String $returns = uc.uc_user_register(user.getLoginName(),
				user.getPswOrigin(), user.getEmail());
		try {
			int $uid = Integer.parseInt($returns);
			if ($uid <= 0) {
				if ($uid == -1) {
					throw new ServiceException("论坛用户名不合法");
				} else if ($uid == -2) {
					throw new ServiceException("论坛包含要允许注册的词语");
				} else if ($uid == -3) {
					throw new ServiceException("论坛用户名已经存在");
				} else if ($uid == -4) {
					throw new ServiceException("论坛Email格式有误");
				} else if ($uid == -5) {
					throw new ServiceException("论坛Email不允许注册");
				} else if ($uid == -6) {
					throw new ServiceException("论坛 Email已经被注册");
				} else {
					throw new ServiceException("论坛未定义");
				}
			}
		} catch (NumberFormatException e) {
			throw new ServiceException("论坛连接失败");
		}
	}

	public void deleteDiscuzMember(BaseUserInfo user) throws ServiceException {

		logger.debug("---------------delete Discuz user------------------");
		com.fivestars.interfaces.bbs.client.Client uc = new com.fivestars.interfaces.bbs.client.Client();
		String result = uc.uc_get_user(user.getLoginName(), 0);
		logger.debug(result);
		try {
			LinkedList<String> rs = XMLHelper.uc_unserialize(result);

			if (rs.size() > 0) {
				int $uid = Integer.parseInt(rs.get(0));
				if ($uid > 0) {
					String deleteResult = uc.uc_user_delete($uid + "");
					if (Integer.parseInt(deleteResult) > 0) {
						return;
					} else {
						throw new ServiceException("同步删除论坛用户失败！");
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceException("同步删除论坛用户失败！");
		}

	}

	/**
	 * 1 : 修改成功 0 : 没有任何修改 -1 : 旧密码不正确 -4 : email 格式有误 -5 : email 不允许注册 -6 : 该
	 * email 已经被注册 -7 : 没有做任何修改 -8 : 受保护的用户，没有权限修改
	 * 
	 * @see cn.com.atnc.pcsp.mng.clientmng.IDiscuzUserService#updateDiscuzMember(cn.com.atnc.pcsp.entity.acl.Client)
	 */
	public void updateDiscuzMember(BaseUserInfo user) throws ServiceException {
		logger.debug("---------------update Discuz user------------------");
		com.fivestars.interfaces.bbs.client.Client uc = new com.fivestars.interfaces.bbs.client.Client();
		// 经测试邮件变更未更新至discuz中，密码变更有同步
		String result = uc.uc_user_edit(user.getLoginName(), "",
				user.getPswOrigin(), user.getEmail(), 1, "", "");
		switch (result) {
		case "-1":
			throw new ServiceException("论坛用户同步更新失败，旧密码不正确");
		case "-4":
			throw new ServiceException("论坛用户同步更新失败，email 格式有误");
		case "-5":
			throw new ServiceException("论坛用户同步更新失败，email 已经被注册");
		case "-6":
			throw new ServiceException("论坛用户同步更新失败，email 格式有误");
		case "-8":
			throw new ServiceException("论坛用户同步更新失败，受保护的用户，没有权限修改");
		default:
			break;
		}
	}
}
