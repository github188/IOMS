/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午11:38:54
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web.basedata;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.enums.basedata.AtmBureau;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.NetworkType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.mng.basedata.atm.node.IAtmNodeManager;
import cn.com.atnc.ioms.mng.basedata.atm.service.IAtmServiceManager;
import cn.com.atnc.ioms.mng.basedata.atm.type.IAtmTypeManager;
import cn.com.atnc.ioms.mng.basedata.equip.IEquipService;
import cn.com.atnc.ioms.mng.basedata.ku.IKuNodeManager;
import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.mng.basedata.satellite.antenna.IAntennaManager;
import cn.com.atnc.ioms.mng.basedata.satellite.site.ISiteManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesNodeManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesServiceManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesSlotManager;
import cn.com.atnc.ioms.mng.operstat.atm.IAtmCardRunInfoService;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.atm.type.AtmTypeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.model.basedata.satellite.site.SiteQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * @author:HuangYijie
 * @date:2014-3-24 上午11:38:54
 * @version:1.0
 */
@Controller
public class BasedataController extends MyBaseController {
	@Autowired
	private ISiteManager siteManager;
	@Autowired
	private IKuNodeManager kuNodeManager;
	@Autowired
	private IKuServiceManager kuServiceManager;
	@Autowired
	private IAtmNodeManager atmNodeManager;

	// add heyuejiao 20140415
	@Autowired
	private ITesNodeManager tesNodeManager;
	@Autowired
	private ITesSlotManager tesSlotManager;

	@Autowired
	private ITesServiceManager tesServiceManager;
	@Autowired
	private IAntennaManager antennaManager;
	@Autowired
	private IEquipService equipService;
	@Autowired
	private IAtmCardRunInfoService atmCardRunInfoService;
	@Autowired
	private IAtmTypeManager atmTypeManager;
	@Autowired
	private IAtmServiceManager atmServiceManager;

	@RequestMapping("/basedata/sitecode.dox")
	public String siteCode(Model model, @RequestParam("term") String term)
			throws UnsupportedEncodingException {
		SiteQueryModel qm = new SiteQueryModel();
		qm.setSiteLike(term);
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(siteManager.queryListByParam(qm)));
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}

	// add by heyuejiao 20140616
	@RequestMapping("/basedata/tesNodecode.dox")
	public String tesNodeCode(Model model, @RequestParam("term") String term)
			throws UnsupportedEncodingException {

		TesNodeQueryModel qm = new TesNodeQueryModel();
		qm.setTesNodeCodeLike(term);
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(tesNodeManager.queryListByParam(qm)));
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}

	@RequestMapping("/basedata/tesSlot.dox")
	public String tesSlot(Model model, @RequestParam("term") String term)
			throws UnsupportedEncodingException {
		TesSlotQueryModel qm = new TesSlotQueryModel();
		qm.setTesNodeCodeEq(term);
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(tesSlotManager.queryListByParam(qm)));
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}

	@RequestMapping("/basedata/checkKuNode.dox")
	public String checkKuNodeNo(Model model, KuNodeQueryModel queryModel) {
		if (StringTools.hasText(queryModel.getKuNodeNo())) {
			queryModel.setKuNodeNo(""
					+ Integer.parseInt(queryModel.getKuNodeNo()));
		}
		if (kuNodeManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";

	}

	@RequestMapping("/basedata/checkKuService.dox")
	public String checkKuService(Model model, KuStatQueryModel queryModel) {
		if (kuServiceManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";

	}

	@RequestMapping("/basedata/kuNodeExist.dox")
	public String kuNodeExist(Model model, KuNodeQueryModel queryModel) {
		if (!StringTools.hasText(queryModel.getKuNodeNoLike())) {
			model.addAttribute("returnStr", false);
		}
		if (kuNodeManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", true);
		} else {
			model.addAttribute("returnStr", false);
		}
		return "returnnote";

	}

	@RequestMapping("/basedata/kunode.dox")
	public String getKuNodeList(Model model, KuNodeQueryModel queryModel) {
		try {
			model.addAttribute("returnStr",
					JacksonTools.toJsonStr(kuNodeManager.queryList(queryModel)));
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}

	@RequestMapping("/basedata/checkAtmNode.dox")
	public String checkAtmNodeNo(Model model, AtmNodeQueryModel queryModel)
			throws UnsupportedEncodingException {
		if (atmNodeManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";

	}

	// add:heyuejiao
	@RequestMapping("/basedata/checkTesNode.dox")
	public String checkTesNodeCode(Model model, TesNodeQueryModel queryModel) {
		if (tesNodeManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";
	}

	// add:heyuejiao
	@RequestMapping("/basedata/checkTesService.dox")
	public String checkTesServiceCircuteName(Model model,
			TesServiceQueryModel queryModel) {
		if (tesServiceManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";
	}

	// add:heyuejiao
	@RequestMapping("/basedata/tesNodeExist.dox")
	public String tesNodeExist(Model model, TesNodeQueryModel queryModel) {
		if (!StringTools.hasText(queryModel.getTesNodeCode())) {
			model.addAttribute("returnStr", false);
		}
		if (tesNodeManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", true);
		} else {
			model.addAttribute("returnStr", false);
		}
		return "returnnote";
	}

	@RequestMapping("/basedata/checkAntenna.dox")
	public String checkAntenna(Model model, AntennaQueryModel queryModel) {
		if (antennaManager.querySize(queryModel) > 0) {
			model.addAttribute("returnStr", false);
		} else {
			model.addAttribute("returnStr", true);
		}
		return "returnnote";
	}

	@RequestMapping("/basedata/equipnode.dox")
	public String getEquipNodeList(@RequestParam("circuitType") String ct,
			Model model) {
		EquipQueryModel queryModel = new EquipQueryModel();
		try {
			CircuitType circuitType = CircuitType.valueOf(ct);
			switch (circuitType) {
			case FRATM:
			case MPLSVPN:
				queryModel.setType(NetworkType.ATM);
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(equipService.queryList(queryModel)));
				break;
			case TESDATA:
			case TESBROADCAST:
			case TESVOICE:
				queryModel.setType(NetworkType.TES);
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(equipService.queryList(queryModel)));
				break;
			case KUDATA:
			case KUBROADCAST:
				queryModel.setType(NetworkType.KU);
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(equipService.queryList(queryModel)));
				break;
			}
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}
	@RequestMapping("/basedata/atmnode.dox")
	public String getAtmNode(@RequestParam("atmBureau") AtmBureau atmBureau,
			Model model) {
		//System.out.println("oooooo");
		//System.out.println(atmBureau);
		AtmNodeQueryModel queryModel = new AtmNodeQueryModel();
		Bureau bur = Bureau.string2Enum(atmBureau.getValue());
		queryModel.setBureau(bur);
		//List lis = equipService.atmNoteList(queryModel);
		//System.out.println(lis.size());
		System.out.println(queryModel.getBureau());
		try {
			//System.out.println("xxL");
			switch (atmBureau) {
			case ZWWW:
			case ZLXY:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmNodeManager.queryList(queryModel)));
				break;
			case ZUUU:
			case ZBAA:
			case ZSSS:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmNodeManager.queryList(queryModel)));
				break;
			case ZGGG:
			case ZYTX:
			case ZBBB:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmNodeManager.queryList(queryModel)));
				break;
			}
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
			//System.out.println("xxx");
		}
		return "returnnote";
	}
	@RequestMapping("/basedata/atmcard.dox")
	public String getAtmCard(@RequestParam("atmBureau") String atmBureau,
			Model model) {
		System.out.println("oooooo");
		System.out.println(atmBureau);
		AtmCardRunInfoModel queryModel = new AtmCardRunInfoModel();
		//List lis = equipService.atmNoteList(queryModel);
		//System.out.println(lis.size());
		queryModel.setBureau(atmBureau);
		Bureau bu = Bureau.getBureauByValue(atmBureau);
		System.out.println(queryModel.getBureau());
		try {
			//System.out.println("xxL");
			switch (bu) {
			case ZWWW:
			case ZLXY:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmCardRunInfoService.atmCardList(queryModel)));
				break;
			case ZUUU:
			case ZBAA:
			case ZSSS:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmCardRunInfoService.atmCardList(queryModel)));
				break;
			case ZGGG:
			case ZYTX:
			case ZBBB:
				model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmCardRunInfoService.atmCardList(queryModel)));
				break;
			case ZSPD:
			case ZBHQ:
			case ZBKG:
			case VHMT:
			case OVERSEAS:
				break;
			}
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
			//System.out.println("xxx");
		}
		return "returnnote";
	}
	@RequestMapping("/basedata/servicetype.dox")
	public String getServiceType(Model model) {
		//System.out.println("oooooo");
		AtmTypeQueryModel queryModel = new AtmTypeQueryModel();
		try {
		    //System.out.println("xxL");
			System.out.println(atmTypeManager.serviceTypeList(queryModel).size());
			model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmTypeManager.serviceTypeList(queryModel)));
			
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}
	@RequestMapping("/basedata/atmservice.dox")
	public String getAtmService(Model model) {
		//System.out.println("1");
		AtmNodeQueryModel queryModel = new AtmNodeQueryModel();
		try {
		    //System.out.println("xxL");
			System.out.println(atmNodeManager.queryList(queryModel).size());
			model.addAttribute("returnStr", JacksonTools
						.toJsonStr(atmNodeManager.queryList(queryModel)));
			
		} catch (IOException e) {
			model.addAttribute("returnStr", "[]");
		}
		return "returnnote";
	}
}
