/**
 * @ProjectName PCSP
 * @FileName DataSourceFactory.java
 * @PackageName:cn.com.atnc.pcsp.entity.reports
 * @author WangLingbin
 * @date 2015年5月28日下午3:41:24
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.com.atnc.ioms.entity.reports.ATMFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.AutoTelegraphEntity;
import cn.com.atnc.ioms.entity.reports.DataComNetworkEntity;
import cn.com.atnc.ioms.entity.reports.FormalCircuitBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.KUFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceAlarmEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceNodeInfoEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceODUEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceOperEntity;
import cn.com.atnc.ioms.entity.reports.PESFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TESFormalCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphApplyEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphCircuitEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphConfigEntity;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteReortModel;

/**
 * 数据源工厂类
 * 
 * @author WangLingbin
 * @date 2015年5月28日 下午3:41:24
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class DataSourceFactory {

	private static List<TeleGraphApplyEntity> apply = new ArrayList<TeleGraphApplyEntity>();
	private static List<TeleGraphConfigEntity> config = new ArrayList<TeleGraphConfigEntity>();
	private static List<TeleGraphCircuitEntity> circuits = new ArrayList<TeleGraphCircuitEntity>();
	private static List<ATMFormalCircuitEntity> atm = new ArrayList<ATMFormalCircuitEntity>(); // atm
	private static List<KUFormalCircuitEntity> ku = new ArrayList<KUFormalCircuitEntity>(); // ku
	private static List<TESFormalCircuitEntity> tes = new ArrayList<TESFormalCircuitEntity>(); // tes
	private static List<PESFormalCircuitEntity> pes = new ArrayList<PESFormalCircuitEntity>(); // pes
	// 卫星链路参数
	private static List<KuMaintenceOperEntity> links = new ArrayList<KuMaintenceOperEntity>();
	// 设备故障情况
	private static List<KuMaintenceOperEntity> faults = new ArrayList<KuMaintenceOperEntity>();
	// 电路运行情况
	private static List<KuMaintenceOperEntity> opers = new ArrayList<KuMaintenceOperEntity>();
	// 告警情况
	private static List<KuMaintenceAlarmEntity> alarms = new ArrayList<KuMaintenceAlarmEntity>();
	// MODEM参数集合
	private static List<KuMaintenceNodeInfoEntity> nodeInfos = new ArrayList<KuMaintenceNodeInfoEntity>();
	// ODU参数集合
	private static List<KuMaintenceODUEntity> odus = new ArrayList<KuMaintenceODUEntity>();
	static {
		// 转报地址模块
		apply.add(new TeleGraphApplyEntity("1", "beijing", "申请用途", new Date(),
				new Date(), "SITA", "OO", "OO", "wlb", new Date()));
		apply.add(new TeleGraphApplyEntity("2", "shanghai", "申请用途", new Date(),
				new Date(), "其它", "xx", "xx", "SUN", new Date()));
		apply.add(new TeleGraphApplyEntity("3", "shanghai", "申请用途", new Date(),
				new Date(), "其它", "xx", "xx", "SUN", new Date()));
		apply.add(new TeleGraphApplyEntity("4", "shanghai", "申请用途", new Date(),
				new Date(), "其它", "xx", "xx", "SUN", new Date()));
		// apply.add(new TeleGraphApplyEntity("4", "shanghai", new Date(), new
		// Date(), "其它", "xx", "xx", "SUN", new Date()));
		// apply.add(new TeleGraphApplyEntity("4", "shanghai", new Date(), new
		// Date(), "其它", "xx", "xx", "SUN", new Date()));
		config.add(new TeleGraphConfigEntity("1", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		config.add(new TeleGraphConfigEntity("2", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		config.add(new TeleGraphConfigEntity("3", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		config.add(new TeleGraphConfigEntity("4", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		config.add(new TeleGraphConfigEntity("5", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		config.add(new TeleGraphConfigEntity("6", "beijing", "127.0.0.1",
				new Date(), "wlb", "SITA", "127.0.0.1", new Date(), "wlb",
				"SITA"));
		circuits.add(new TeleGraphCircuitEntity("1", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("2", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("3", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("4", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("5", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("6", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		circuits.add(new TeleGraphCircuitEntity("7", "北京", "2", "2", "2",
				"127.0.0.1", "2", "3", "20", "30", "没有队列"));
		// 正式电路模块
		atm.add(new ATMFormalCircuitEntity("1", "开通ATM", "北京", "3", "线路1",
				"8080", "30", "VPI", "上海", "5", "线路2", "80", "10", "LCI", "40",
				"服务", new Date(), "北京哈", "12", "配置线路1", "20", "信令1", "LCI",
				"上海哈", "23", "配置线路2", "30", "信令2", "VPI", "用途", "QOS", "100",
				"备注玩呢", "编号73157"));
		atm.add(new ATMFormalCircuitEntity("2", "开通ATM", "北京", "3", "线路1",
				"8080", "30", "VPI", "上海", "5", "线路2", "80", "10", "LCI", "40",
				"服务", new Date(), "北京哈", "12", "配置线路1", "20", "信令1", "LCI",
				"上海哈", "23", "配置线路2", "30", "信令2", "VPI", "用途", "QOS", "100",
				"备注玩呢", "编号73157"));
		atm.add(new ATMFormalCircuitEntity("3", "开通ATM", "北京", "3", "线路1",
				"8080", "30", "VPI", "上海", "5", "线路2", "80", "10", "LCI", "40",
				"服务", new Date(), "北京哈", "12", "配置线路1", "20", "信令1", "LCI",
				"上海哈", "23", "配置线路2", "30", "信令2", "VPI", "用途", "QOS", "100",
				"备注玩呢", "编号73157"));
		atm.add(new ATMFormalCircuitEntity("4", "开通ATM", "北京", "3", "线路1",
				"8080", "30", "VPI", "上海", "5", "线路2", "80", "10", "LCI", "40",
				"服务", new Date(), "北京哈", "12", "配置线路1", "20", "信令1", "LCI",
				"上海哈", "23", "配置线路2", "30", "信令2", "VPI", "用途", "QOS", "100",
				"备注玩呢", "编号73157"));
		ku.add(new KUFormalCircuitEntity("1", "开通KU", "北京", "1206", "601", "3",
				"上海", "3", "3", "3", "4.8", "异步", "闹完呢", new Date(), "唐山",
				"218", "HD", "1", "0", "V.24", "石家庄", "109", "DLM", "3", "16",
				"V.24", "TSBSJW-D", "9.6", "同步", "自动转报", "V0300255"));
		ku.add(new KUFormalCircuitEntity("2", "开通KU", "河南", "1206", "601", "3",
				"湖北", "3", "3", "3", "4.8", "异步", "闹完呢", new Date(), "河南",
				"218", "HD", "1", "0", "V.24", "湖北", "109", "DLM", "3", "16",
				"V.24", "TSBSJW-D", "9.6", "同步", "自动转报", "V0300256111"));
		ku.add(new KUFormalCircuitEntity("1", "开通KU", "北京", "1206", "601", "3",
				"上海", "3", "3", "3", "4.8", "异步", "闹完呢", new Date(), "唐山",
				"218", "HD", "1", "0", "V.24", "石家庄", "109", "DLM", "3", "16",
				"V.24", "TSBSJW-D", "9.6", "同步", "自动转报", "V0300255"));
		ku.add(new KUFormalCircuitEntity("2", "开通KU", "河南", "1206", "601", "3",
				"湖北", "3", "3", "3", "4.8", "异步", "闹完呢", new Date(), "河南",
				"218", "HD", "1", "0", "V.24", "湖北", "109", "DLM", "3", "16",
				"V.24", "TSBSJW-D", "9.6", "同步", "自动转报", "V0300256111"));
		tes.add(new TESFormalCircuitEntity("1", "开通TES", "北京", "1090", "11",
				"上海", "1010", "22", "333", "异步", new Date(), "满洲里", "6301",
				"3", "RS-232", "呼和浩特", "7025", "1", "RS-232", "MZLHET-1",
				"4.8", "异步", "时钟", "V010493", "用途-转报"));
		tes.add(new TESFormalCircuitEntity("2", "开通TES", "北京", "1090", "11",
				"上海", "1010", "22", "333", "异步", new Date(), "满洲里", "6301",
				"3", "RS-232", "呼和浩特", "7025", "1", "RS-232", "MZLHET-1",
				"4.8", "异步", "时钟", "V010493", "用途-转报"));
		tes.add(new TESFormalCircuitEntity("3", "开通TES", "北京", "1090", "11",
				"上海", "1010", "22", "333", "异步", new Date(), "满洲里", "6301",
				"3", "RS-232", "呼和浩特", "7025", "1", "RS-232", "MZLHET-1",
				"4.8", "异步", "时钟", "V010493", "用途-转报"));
		tes.add(new TESFormalCircuitEntity("4", "开通TES", "北京", "1090", "11",
				"上海", "1010", "22", "333", "异步", new Date(), "满洲里", "6301",
				"3", "RS-232", "呼和浩特", "7025", "1", "RS-232", "MZLHET-1",
				"4.8", "异步", "时钟", "V010493", "用途-转报"));
		tes.add(new TESFormalCircuitEntity("5", "开通TES", "北京", "1090", "11",
				"上海", "1010", "22", "333", "异步", new Date(), "满洲里", "6301",
				"3", "RS-232", "呼和浩特", "7025", "1", "RS-232", "MZLHET-1",
				"4.8", "异步", "时钟", "V010493", "用途-转报"));
		pes.add(new PESFormalCircuitEntity("1", "开通PES", "北京", "1090", "11",
				"TX001", "上海", "1010", "22", "RX001", "333", "异步", "测试1",
				new Date(), "满洲里", "6301", "3", "RS-232", "confTX001", "呼和浩特",
				"7025", "1", "confRX001", "RS-232", "MZLHET-1", "4.8", "异步",
				"V010493", "用途-转报"));
		pes.add(new PESFormalCircuitEntity("2", "开通PES", "北京", "1090", "11",
				"TX002", "上海", "1010", "22", "RX002", "333", "异步", "测试2",
				new Date(), "满洲里", "6301", "3", "RS-232", "confTX002", "呼和浩特",
				"7025", "1", "confRX002", "RS-232", "MZLHET-1", "4.8", "异步",
				"V010493", "用途-转报"));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-01", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-02", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-03", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-04", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-05", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-06", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-07", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-08", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-09", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-10", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-11", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-12", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-13", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-14", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-15", DateUtilTools.PATTERN_DATE_1), -4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-16", DateUtilTools.PATTERN_DATE_1), -5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-17", DateUtilTools.PATTERN_DATE_1), -2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-18", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-19", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-20", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-21", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-22", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-23", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-24", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-25", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-26", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-27", DateUtilTools.PATTERN_DATE_1), 4.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-28", DateUtilTools.PATTERN_DATE_1), 5.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-29", DateUtilTools.PATTERN_DATE_1), 2.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-30", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("接收电平", DateUtilTools.parseDate(
				"2017-01-31", DateUtilTools.PATTERN_DATE_1), -5.0));
		links.add(new KuMaintenceOperEntity("EB/NO", DateUtilTools.parseDate(
				"2017-01-01", DateUtilTools.PATTERN_DATE_1), 7.0));
		links.add(new KuMaintenceOperEntity("EB/NO", DateUtilTools.parseDate(
				"2017-01-02", DateUtilTools.PATTERN_DATE_1), 6.0));
		links.add(new KuMaintenceOperEntity("EB/NO", DateUtilTools.parseDate(
				"2017-01-03", DateUtilTools.PATTERN_DATE_1), 3.0));
		links.add(new KuMaintenceOperEntity("EB/NO", DateUtilTools.parseDate(
				"2017-01-04", DateUtilTools.PATTERN_DATE_1), 1.0));

		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-01", DateUtilTools.PATTERN_DATE_1), 1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-02", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-03", DateUtilTools.PATTERN_DATE_1), 4.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-04", DateUtilTools.PATTERN_DATE_1), 5.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-05", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-06", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-07", DateUtilTools.PATTERN_DATE_1), 7.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-08", DateUtilTools.PATTERN_DATE_1), 4.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-09", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-10", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-11", DateUtilTools.PATTERN_DATE_1), 4.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-12", DateUtilTools.PATTERN_DATE_1), 8.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-13", DateUtilTools.PATTERN_DATE_1), 1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-14", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-15", DateUtilTools.PATTERN_DATE_1), -2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-16", DateUtilTools.PATTERN_DATE_1), -1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-17", DateUtilTools.PATTERN_DATE_1), -2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-18", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-19", DateUtilTools.PATTERN_DATE_1), 1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-20", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-21", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-22", DateUtilTools.PATTERN_DATE_1), 6.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-23", DateUtilTools.PATTERN_DATE_1), 4.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-24", DateUtilTools.PATTERN_DATE_1), 5.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-25", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-26", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-27", DateUtilTools.PATTERN_DATE_1), 4.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-28", DateUtilTools.PATTERN_DATE_1), 2.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-29", DateUtilTools.PATTERN_DATE_1), 1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-30", DateUtilTools.PATTERN_DATE_1), 1.0));
		faults.add(new KuMaintenceOperEntity("WA-FR08故障", DateUtilTools
				.parseDate("2017-01-31", DateUtilTools.PATTERN_DATE_1), -5.0));
		faults.add(new KuMaintenceOperEntity("MODEM故障", DateUtilTools
				.parseDate("2017-01-01", DateUtilTools.PATTERN_DATE_1), 7.0));
		faults.add(new KuMaintenceOperEntity("MODEM故障", DateUtilTools
				.parseDate("2017-01-02", DateUtilTools.PATTERN_DATE_1), 6.0));
		faults.add(new KuMaintenceOperEntity("MODEM故障", DateUtilTools
				.parseDate("2017-01-03", DateUtilTools.PATTERN_DATE_1), 3.0));
		faults.add(new KuMaintenceOperEntity("MODEM故障", DateUtilTools
				.parseDate("2017-01-04", DateUtilTools.PATTERN_DATE_1), 1.0));

		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-01", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -8)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-02", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -6)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-03", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -5)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-04", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -7)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-05", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -8)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-06", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -9)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-07", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -7)));
		opers.add(new KuMaintenceOperEntity("误码率", DateUtilTools.parseDate(
				"2017-01-08", DateUtilTools.PATTERN_DATE_1), Math.pow(10, -8)));

		alarms.add(new KuMaintenceAlarmEntity("WA-FR08链路告警", "10%", 10));
		alarms.add(new KuMaintenceAlarmEntity("Modem板卡链路告警", "20%", 20));
		alarms.add(new KuMaintenceAlarmEntity("WA-FR08状态告警", "30%", 30));
		alarms.add(new KuMaintenceAlarmEntity("Modem板卡状态告警", "40%", 40));

		nodeInfos.add(new KuMaintenceNodeInfoEntity("node1", "12", "60"));
		nodeInfos.add(new KuMaintenceNodeInfoEntity("node2", "22", "50"));

		odus.add(new KuMaintenceODUEntity("50", "60", "12", "15"));
		odus.add(new KuMaintenceODUEntity("50", "60", "15", "18"));

	}
	// 转报
	private static TeleGraphBaseInfoEntity[] baseInfos = { new TeleGraphBaseInfoEntity(
			"天航信", "2015-01-08_DB(ADD)_1_112", "kyg", "15001378378", "新增",
			"天航信", "临时", "北京", "我有用啊", "2", "3", "4", "5", "2015年11月25日", "其它",
			apply, config, circuits) };
	// 正式电路
	private static FormalCircuitBaseInfoEntity[] formalCircuits = { new FormalCircuitBaseInfoEntity(
			"北京",
			"2015-01-08_DLPZ_ATM(ADD)_1",
			"wlb",
			"15001378378",
			"010-81495516",
			"010-81495516",
			"wlb19890913@163.com",
			"create",
			"agree",
			"我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为我i为i为i为Wii我i为",
			"agredd", "bj", "agree", "bj", new Date(), "你说呢", "王凌斌", "小王",
			"小李", "2015年11月25日", atm, ku, tes, pes) };
	// 卫星地球站入网
	private static KuSatelliteReortModel[] baseInfos1 = { new KuSatelliteReortModel(
			"北京天航信民航通信网络发展有限公司北京天航信民航通信", "2015-01-08_RW(WX)_199", "wlb",
			"天航信", "天航信", "wlb", "北京", "海淀区", "1", "1", "1", "1", "1", "1",
			"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
			"北京天航信民航通信网络发展有限公司北京天航信民航通信", "wlb", "通过", "wlb", "15001378378",
			"天航信", "wlb", "通过", "wlb", "15001378378", "2015-09-01", "22", "22",
			"22", "22") };
	// 数据通信网
	private static DataComNetworkEntity[] dataComNetworks = { new DataComNetworkEntity(
			"北京天航信民航通信网络发展有限公司北京天航信民航通信", "2015-01-08_RW(SJ)_201", "wlb",
			"15001378378", "15001378378", "wanglingbin", "2015年11月25日", "北京",
			"海淀区学清路", "浙江金华", "", "北京", "V1", "", "V5", "10", "", "30",
			"北京天航信民航通信网络发展有限公司北京天航信民航通信", "王总", "同意", "wzc", "13800138000",
			"空管局", "李总", "通过", "wxy", "13900139000", "内蒙古127.0.0.1",
			"新疆132.138.7,103", "正常", "可以", "engineer", new Date(), "给力啊",
			"网控领导") };
	// 自动转报网
	private static AutoTelegraphEntity[] autoTelegraphs = { new AutoTelegraphEntity(
			"天航信", "2015-01-08_RW(ZB)_1009", "wlb", "15001378378",
			"15001378378", "wanglingbin", "2015年11月25日", "北京", "海淀区学清路",
			"浙江金华", "", "北京", "V1", "", "V5", "北京天航信", "王总", "同意", "wzc",
			"13800138000", "空管局", "李总", "通过", "wxy", "13900139000") };
	// ku维保
	private static KuMaintenceEntity[] kuMaintenceEntitys = {

	new KuMaintenceEntity(
			"2017年2月",
			"FR08",
			"FR08站点基本情况为3.7米卫星天线，16WODU一套，室内机箱配置为1个VSATPLUS IIE机箱和1个VSATPLUS II。卫星站当前配置有10条电路，本月新增电路10条",
			"故障处理情况:包括故障出现时间，持续时长，处理过程，原因分析",
			"运行情况总结：本月本站运行期间误码率由于0.000001的比例为96%", "运行维护建议：多多巡查，减少断网断电的频率和次数",
			nodeInfos, odus, "100", links, faults, opers, alarms) };

	public static Collection getBeanCollection(List entity) {
		return entity;
	}

	public static Collection getBeanCollection() {
		// return Arrays.asList(baseInfos);
		return Arrays.asList(baseInfos1);
	}

	public static Collection getTeleGraphCollection() {
		return Arrays.asList(baseInfos);
	}

	// 正式电路
	public static Collection getFormalCircuitCollection() {
		return Arrays.asList(formalCircuits);
	}

	// 数据通信网
	public static Collection getDataComNetworkCollection() {
		return Arrays.asList(dataComNetworks);
	}

	// 自动转报网
	public static Collection getAutoTelegraphCollection() {
		return Arrays.asList(autoTelegraphs);
	}

	// ku維保
	public static Collection getKuMaintenceCollection() {
		return Arrays.asList(kuMaintenceEntitys);
	}
}
