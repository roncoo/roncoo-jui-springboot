<#assign base=request.contextPath /> 
<div class="pageContent">
    <div class="pageFormContent" layoutH="58">
        <p>
            <label>状态：</label>${bean.statusId}
        </p>
        <p>
            <label>创建时间：</label>${bean.createTime}
        </p>
        <p>
            <label>修改时间：</label>${bean.updateTime}
        </p>
        <p>
            <label>用户QQ：</label>${bean.userEmail}
        </p>
        <p>
            <label>用户昵称：</label>${bean.userNickname}
        </p>
    </div>
    <div class="formBar">
        <ul>
            <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
        </ul>
    </div>
</div>
