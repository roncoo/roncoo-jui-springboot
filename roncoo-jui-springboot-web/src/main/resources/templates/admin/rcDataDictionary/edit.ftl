<#assign base=request.contextPath /> 
<div class="pageContent">
	<form action="${base}/admin/rcDataDictionary/update" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);>
		<div class="pageFormContent" layoutH="58">
            <input type="hidden" name="id" value="${bean.id}"/>
    		<p>
                <label>状态：</label>
                <input type="text" name="statusId" value="${bean.statusId}" placeholder="状态" size="20">
            </p>
    		<p>
                <label>创建时间：</label>
                <input type="text" name="createTime" value="${bean.createTime}" placeholder="创建时间" size="20">
            </p>
    		<p>
                <label>修改时间：</label>
                <input type="text" name="updateTime" value="${bean.updateTime}" placeholder="修改时间" size="20">
            </p>
    		<p>
                <label>字段名：</label>
                <input type="text" name="fieldName" value="${bean.fieldName}" placeholder="字段名" size="20">
            </p>
    		<p>
                <label>字段CODE：</label>
                <input type="text" name="fieldCode" value="${bean.fieldCode}" placeholder="字段CODE" size="20">
            </p>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
	</form>
</div>
