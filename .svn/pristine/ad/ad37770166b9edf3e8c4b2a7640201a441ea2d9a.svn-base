package cn.com.atnc.ioms.mng.maintain.alarminfo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.maintain.alarminfo.IFtpLinkDao;
import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.maintain.alarminfo.FtpLink;
import cn.com.atnc.ioms.enums.basedata.AlarmStatusEnum;
import cn.com.atnc.ioms.mng.basedata.resource.IProxyManager;
import cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IFTPAlarmManager;
import cn.com.atnc.ioms.mng.systemmng.param.ISystemConfigManager;
import cn.com.atnc.ioms.model.maintain.alarminfo.AlarmInfoQueryModel;

/**
 * FTP站点告警Service实现
 *
 * @author wangzhicheng
 * @date 2015-7-15 上午9:50:54
 * @since 1.0.0
 */
@Service
@Transactional
public class FTPAlarmManagerImpl extends AbstractService implements
		IFTPAlarmManager {

	@Autowired
	private IFtpLinkDao ftpLinkDao;
	@Autowired
	private IProxyManager proxyManager;
	@Autowired
	private ISiteManager siteManager;
	@Autowired
	@Qualifier(value = "SystemConfigFileManagerImpl")
	private ISystemConfigManager systemConfigManager;

	@Override
	public List<FtpLink> getAll() {
		return ftpLinkDao.getAll();
	}

	@Override
	public Pagination queryPage(AlarmInfoQueryModel queryModel)
			throws ServiceException {
		Pagination pagn = proxyManager.queryPage(queryModel);
		List<Proxy> pli = (List<Proxy>) pagn.getResult();
		List<AlarmInfoQueryModel> aqmli = new ArrayList<AlarmInfoQueryModel>();
		// 循环设置页面信息
		for (int i = 0; i < pli.size(); i++) {

			AlarmInfoQueryModel aqm = new AlarmInfoQueryModel();
			aqm.setProxy(pli.get(i));

			FtpLink ftpLink = this.findByProxyId(pli.get(i).getId());
			aqm.setSatelliteSite(siteManager.findById(pli.get(i)
					.getSatelliteId()));
			aqm.setFtpLink(ftpLink);
			// ftp告警状态
			if (ObjectUtils.equals(ftpLink, null)
					|| ObjectUtils.equals(ftpLink.getStatus(),
							AlarmStatusEnum.unnormal)) {
				aqm.setStatus("告警");
			} else {
				aqm.setStatus("正常");
			}

			/*
			 * //获取系统配置的限制时间（分钟） String ftpLinkAlarmMin =
			 * systemConfigManager.getModel().getFtpLinkAlarmMin(); Long min =
			 * Long.valueOf(StringUtils.isEmpty(ftpLinkAlarmMin) ? "10" :
			 * ftpLinkAlarmMin); //判断站点对应的ftp文件是否存在 if(ftpLink ==null){
			 * aqm.setStatus("告警"); }else{ //得到ftp更新或者添加时间 Date ftpDate =
			 * ftpLink.getRecordTime();
			 * 
			 * //计算出ftp更新或者添加时间与系统时间相差（分钟） Calendar nowCalender =
			 * Calendar.getInstance(); Calendar ftpCalender =
			 * Calendar.getInstance(); ftpCalender.setTime(ftpDate); Long minnum
			 * = (nowCalender.getTimeInMillis() -
			 * ftpCalender.getTimeInMillis())/(60 * 1000); //根据相差时间判断站点是否正常
			 * if(minnum<min && minnum >= 0 && min >= 0){ aqm.setStatus("正常");
			 * }else{ aqm.setStatus("告警"); } }
			 */
			aqmli.add(aqm);
		}
		pagn.setResult(aqmli);
		return pagn;
	}

	private FtpLink findByProxyId(String id) {
		return ftpLinkDao.findByProxyId(id);
	}

	@Override
	public FtpLink findById(String id) {
		return ftpLinkDao.findById(id);
	}

}
