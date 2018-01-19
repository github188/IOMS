<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td><c:if test="${optType eq 'kuequ' }">
			<dd>通讯基地KU室内设备</dd>
		</c:if> <c:if test="${optType eq 'mhjkucheck' }">
			<dd>民航局KU室内设备</dd>
		</c:if> <c:if test="${optType eq 'slhkucheck' }">
			<dd>十里河KU室内设备</dd>
		</c:if></td>
	<!-- ------------------子网10号节点------------------------------ -->
	<td>${vo.slot1}</td>
	<td>${vo.type1}</td>
	<td>${vo.usepor1}</td>
	<td>${vo.surpor1}</td>
	<td>${vo.slot2}</td>
	<td>${vo.type2}</td>
	<td>${vo.usepor2}</td>
	<td>${vo.surpor2}</td>
	<td>${vo.slot3}</td>
	<td>${vo.type3}</td>
	<td>${vo.usepor3}</td>
	<td>${vo.surpor3}</td>
	<td>${vo.slot4}</td>
	<td>${vo.type4}</td>
	<td>${vo.usepor4}</td>
	<td>${vo.surpor4}</td>
	<td>${vo.subnet10Remark}</td>

	<!-- ------------------子网11号节点------------------------------ -->
	<td>0</td>
	<td>${vo.type5}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type6}</td>
	<td>${vo.usepor6}</td>
	<td>${vo.surpor6}</td>
	<td>2</td>
	<td>${vo.type7}</td>
	<td>${vo.usepor7}</td>
	<td>${vo.surpor7}</td>
	<td>3</td>
	<td>${vo.type8}</td>
	<td>${vo.usepor8}</td>
	<td>${vo.surpor8}</td>
	<td>${vo.subnet11Remark}</td>
	<!-- ------------------子网20号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type9}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type10}</td>
	<td>${vo.usepor10}</td>
	<td>${vo.surpor10}</td>
	<td>2</td>
	<td>${vo.type11}</td>
	<td>${vo.usepor11}</td>
	<td>${vo.surpor11}</td>
	<td>3</td>
	<td>${vo.type12}</td>
	<td>${vo.usepor12}</td>
	<td>${vo.surpor12}</td>
	<td>${vo.subnet20Remark}</td>

	<!-- ------------------子网21号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type13}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type14}</td>
	<td>${vo.usepor14}</td>
	<td>${vo.surpor14}</td>
	<td>2</td>
	<td>${vo.type15}</td>
	<td>${vo.usepor15}</td>
	<td>${vo.surpor15}</td>
	<td>3</td>
	<td>${vo.type16}</td>
	<td>${vo.usepor16}</td>
	<td>${vo.surpor16}</td>
	<td>${vo.subnet21Remark}</td>

	<!-- ------------------子网30号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type17}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type18}</td>
	<td>${vo.usepor18}</td>
	<td>${vo.surpor18}</td>
	<td>2</td>
	<td>${vo.type19}</td>
	<td>${vo.usepor19}</td>
	<td>${vo.surpor19}</td>
	<td>3</td>
	<td>${vo.type20}</td>
	<td>${vo.usepor20}</td>
	<td>${vo.surpor20}</td>
	<td>${vo.subnet30Remark}</td>

	<!-- ------------------子网31号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type21}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type22}</td>
	<td>${vo.usepor22}</td>
	<td>${vo.surpor22}</td>
	<td>2</td>
	<td>${vo.type23}</td>
	<td>${vo.usepor23}</td>
	<td>${vo.surpor23}</td>
	<td>3</td>
	<td>${vo.type24}</td>
	<td>${vo.usepor24}</td>
	<td>${vo.surpor24}</td>
	<td>${vo.subnet31Remark}</td>

	<!-- ------------------子网40号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type25}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type26}</td>
	<td>${vo.usepor26}</td>
	<td>${vo.surpor26}</td>
	<td>2</td>
	<td>${vo.type27}</td>
	<td>${vo.usepor27}</td>
	<td>${vo.surpor27}</td>
	<td>3</td>
	<td>${vo.type28}</td>
	<td>${vo.usepor28}</td>
	<td>${vo.surpor28}</td>
	<td>${vo.subnet40Remark}</td>

	<!-- ------------------子网41号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type29}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type30}</td>
	<td>${vo.usepor30}</td>
	<td>${vo.surpor30}</td>
	<td>2</td>
	<td>${vo.type31}</td>
	<td>${vo.usepor31}</td>
	<td>${vo.surpor31}</td>
	<td>3</td>
	<td>${vo.type32}</td>
	<td>${vo.usepor32}</td>
	<td>${vo.surpor32}</td>
	<td>${vo.subnet41Remark}</td>

	<!-- ------------------子网0号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type33}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type34}</td>
	<td>${vo.usepor34}</td>
	<td>${vo.surpor34}</td>
	<td>2</td>
	<td>${vo.type35}</td>
	<td>${vo.usepor35}</td>
	<td>${vo.surpor35}</td>
	<td>3</td>
	<td>${vo.type36}</td>
	<td>${vo.usepor36}</td>
	<td>${vo.surpor36}</td>
	<td>${vo.subnet0Remark}</td>

	<!-- ------------------子网1号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type37}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type38}</td>
	<td>${vo.usepor38}</td>
	<td>${vo.surpor38}</td>
	<td>2</td>
	<td>${vo.type39}</td>
	<td>${vo.usepor39}</td>
	<td>${vo.surpor39}</td>
	<td>3</td>
	<td>${vo.type40}</td>
	<td>${vo.usepor40}</td>
	<td>${vo.surpor40}</td>
	<td>${vo.subnet1Remark}</td>

	<!-- ------------------子网7号节点------------------------------ -->

	<td>0</td>
	<td>${vo.type41}</td>
	<td></td>
	<td></td>
	<td>1</td>
	<td>${vo.type42}</td>
	<td>${vo.usepor42}</td>
	<td>${vo.surpor42}</td>
	<td>2</td>
	<td>${vo.type43}</td>
	<td>${vo.usepor43}</td>
	<td>${vo.surpor43}</td>
	<td>3</td>
	<td>${vo.type44}</td>
	<td>${vo.usepor44}</td>
	<td>${vo.surpor44}</td>
	<td>${vo.subnet7Remark}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_kuequ_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/ku/view.do?id=${vo.id}&optType=${optType}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_kuequ_del']}">
			<a href="${rootUrl}duty/statellite/ku/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sta_check_kuequ_update']}">
				<a
					href="${rootUrl}duty/statellite/ku/update.do?id=${vo.id}&optType=${optType}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>