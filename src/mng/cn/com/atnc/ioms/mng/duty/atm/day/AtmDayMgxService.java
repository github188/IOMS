package cn.com.atnc.ioms.mng.duty.atm.day;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;




/**
 * ATM日检交换机Service
 * 
 * @author wangzhipeng
 * @time:2017年2月20日 下午2:36:44
 */

public interface AtmDayMgxService {
  /**
   * 查询
   * 
   * @author wangzhipeng
   * @time:2017年2月21日 上午9:54:38
   * @param queryModel1
   * @return
   */
    Pagination queryPageByModel(AtmDayQueryModelMgx queryModelMgx);
    
    /**
     * 新增
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午9:56:13
     * @param user
     * @param pageModel1
     */
    void save(User user, AtmDayQueryModelMgx pageModelMgx);

    /**
     * 根据ID查找实体
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午9:56:52
     * @param id
     * @return ATMDayMgx
     */
    ATMDayMgx findById(String id);

   /**
    * 删除实体
    * 
    * @author wangzhipeng
    * @time:2017年2月21日 上午9:58:19
    * @param atmDayRoute
    */
    void delete(ATMDayMgx atmDayMgx);

   
    /**
     * 更新
     * 
     * @author wangzhipeng
     * @time:2017年2月28日 下午12:41:20
     * @param user
     * @param atmDayMgx
     * @param pageModel1
     * @return
     */
    ATMDayMgx update(User user, ATMDayMgx atmDayMgx,
            AtmDayQueryModelMgx pageModelMgx);

   /**
    * 审核
    * 
    * @author 王志鹏
    * @time:2017年3月1日 下午4:21:03
    * @param user
    * @param atmDayMgx
    * @param pageModel1
    * @return
    */

    ATMDayMgx audit(User user, ATMDayMgx atmDayMgx, AtmDayQueryModelMgx pageModelMgx);
    
}