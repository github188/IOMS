package cn.com.atnc.ioms.dao.operstat.atm.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmCardRunInfoDao;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfo;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;

/**
 * @author Chenwei
 * @date 2014-8-26 上午11:38:17
 * @version 1.0
 */
@Repository("atmCardRunInfo")
public class AtmCardRunInfoDaoImpl extends MyBaseDao<CardRunInfo> implements
		IAtmCardRunInfoDao {

	@Override
	public Pagination queryPage(AtmCardRunInfoModel queryModel) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("from CardRunInfo where 1=1 ");
		List<Object> queryParams = new ArrayList<Object>();
		if (StringUtils.hasText(queryModel.getBureau())) {
			hql.append("and card.node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		if (StringUtils.hasText(queryModel.getAtmNodeCodeLike())) {
			hql.append(" and card.node.atmNodeCode like ? escape '/'");
			queryParams.add("%" + queryModel.getAtmNodeCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getCardTypeLike())) {
			hql.append(" and cardType like ? escape '/'");
			queryParams.add("%" + queryModel.getCardTypeLike().toUpperCase()
					+ "%");
		}

		hql.append("and cardFbState != ? ");
		queryParams.add("Empty");

		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by card.node.bureau, card.node.atmNodeCode , cardSlot asc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<CardRunInfo> queryList(AtmCardRunInfoModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from CardRunInfo where 1=1");

		List<Object> queryParams = new ArrayList<Object>();
		if (StringUtils.hasText(queryModel.getBureau())) {
			hql.append(" and card.node.bureau = ? ");
			queryParams.add(Bureau.getBureauByValue(queryModel.getBureau()));
		}
		if (StringUtils.hasText(queryModel.getAtmNodeCodeLike())) {
			hql.append(" and card.node.atmNodeCode like ? escape '/'");
			queryParams.add("%" + queryModel.getAtmNodeCodeLike().toUpperCase()
					+ "%");
		}
		if (StringUtils.hasText(queryModel.getCardTypeLike())) {
			hql.append(" and cardType like ? escape '/'");
			queryParams.add("%" + queryModel.getCardTypeLike().toUpperCase()
					+ "%");
		}
		hql.append(" and cardFbState != ? ");
		queryParams.add("Empty");

		hql.append(" order by  id asc");
		return (List<CardRunInfo>) super.queryList(hql.toString(),
				queryParams.toArray());

	}

}
