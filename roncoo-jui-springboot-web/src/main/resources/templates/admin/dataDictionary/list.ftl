<#include "/macro/base.ftl" />

<form id="pagerForm" method="post" action="${base}/admin/dataDictionary/list">
	<@pagerForm />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${base}/admin/dataDictionary/list" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>字段名：</label>
					<input type="text" name="fieldName" value="${(bean.fieldName)!}"/>
				</li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
				</ul>
			</div>
		</div>
	</form>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
			<li><a class="add" href="${base}/admin/dataDictionary/add" target="dialog"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="demo/common/ajaxDone.html?id={sid}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="demo_page4.html?id={sid}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>

	<div id="w_list_print">
		<table class="list" width="100%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
			<thead>
				<tr>
					<th colspan="6" align="center">基本信息</th>
					<th colspan="1">操作</th>
				</tr>
				<tr>
					<th align="center">序号</th>
					<th>字段名</th>
					<th>CODE值</th>
					<th orderField="sort" class="desc">排序</th>
					<th>备注</th>
					<th>创建时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<#if (page)??>
					<#list page.list as bean>
						<tr target="sid" rel="${bean.id}">
							<td>${bean_index+1}</td>
							<td>${bean.fieldName}</td>
							<td>${bean.sort}</td>
							<td>${bean.remark}</td>
							<td>${bean.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
							<td>
								<a class="btn btn-primary btn-xs" href="${ctx}/admin/dataDictionary/view?id=${bean.id}">查看</a>
								<a class="btn btn-info btn-xs" href="${ctx}/admin/dataDictionary/edit?id=${bean.id}">修改</a>
								<a class="btn btn-primary btn-xs" href="${ctx}/admin/dataDictionaryList/list?dId=${bean.id}&fieldCode=${bean.fieldCode}">明细</a>
								<a class="btn btn-danger btn-xs" onClick="delcfm('${ctx}/admin/dataDictionary/delete?id=${bean.id}&fieldCode=${bean.fieldCode}')">删除</a>
							</td>
						</tr>
					</#list>
				<#else>
					<tr>
						<td colspan="7" align="center">暂没记录</td>
					</tr>
				</#if>
			</tbody>
		</table>
	</div>
	<@pages />
</div>
