<#assign base=request.contextPath />
<div class="pageContent">
	<form action="${base}/admin/sysRole/save" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="58">
    		<p>
                <label>主键：</label>
                <input type="text" name="id" value="" placeholder="主键" size="20">
            </p>
    		<p>
                <label>创建时间：</label>
                <input type="text" name="gmtCreate" value="" placeholder="创建时间" size="20">
            </p>
    		<p>
                <label>修改时间：</label>
                <input type="text" name="gmtModified" value="" placeholder="修改时间" size="20">
            </p>
    		<p>
                <label>状态：</label>
                <input type="text" name="statusId" value="" placeholder="状态" size="20">
            </p>
    		<p>
                <label>排序：</label>
                <input type="text" name="sort" value="" placeholder="排序" size="20">
            </p>
    		<p>
                <label>名称：</label>
                <input type="text" name="roleName" value="" placeholder="名称" size="20">
            </p>
    		<p>
                <label>备注：</label>
                <input type="text" name="remark" value="" placeholder="备注" size="20">
            </p>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
	</form>
</div>
