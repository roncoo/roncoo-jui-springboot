<#assign base=request.contextPath />
<div class="pageContent">
	<form action="${base}/admin/rcReport/save" data-toggle="validate" method="post">
        <div class="pageFormContent" layoutH="58">
    		<p>
                <label>：</label>
                <input type="text" name="id" value="" placeholder="" size="20">
            </p>
    		<p>
                <label>状态：</label>
                <input type="text" name="statusId" value="" placeholder="状态" size="20">
            </p>
    		<p>
                <label>创建时间：</label>
                <input type="text" name="createTime" value="" placeholder="创建时间" size="20">
            </p>
    		<p>
                <label>修改时间：</label>
                <input type="text" name="updateTime" value="" placeholder="修改时间" size="20">
            </p>
    		<p>
                <label>排序：</label>
                <input type="text" name="sort" value="" placeholder="排序" size="20">
            </p>
    		<p>
                <label>用户QQ：</label>
                <input type="text" name="userEmail" value="" placeholder="用户QQ" size="20">
            </p>
    		<p>
                <label>用户昵称：</label>
                <input type="text" name="userNickname" value="" placeholder="用户昵称" size="20">
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
