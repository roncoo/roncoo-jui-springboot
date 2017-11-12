<#assign base=request.contextPath /> 
<div class="pageContent">
	<form action="${base}/admin/sysUser/update" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
            <input type="hidden" name="id" value="${bean.id}"/>
    		<p>
                <label>用户手机：</label>
                <input type="text" name="userPhone" value="${bean.userPhone}" placeholder="用户手机" size="20">
            </p>
    		<p>
                <label>用户邮箱：</label>
                <input type="text" name="userEmail" value="${bean.userEmail}" placeholder="用户邮箱" size="20">
            </p>
    		<p>
                <label>真实姓名：</label>
                <input type="text" name="userRealname" value="${bean.userRealname}" placeholder="真实姓名" size="20">
            </p>
    		<p>
                <label>用户昵称：</label>
                <input type="text" name="userNickname" value="${bean.userNickname}" placeholder="用户昵称" size="20">
            </p>
    		<p>
                <label>性别：</label>
                <input type="text" name="userSex" value="${bean.userSex}" placeholder="性别" size="20">
            </p>
            <p>
                <label>用户状态：</label>
                <input type="text" name="userStatus" value="${bean.userStatus}" placeholder="用户状态" size="20">
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
