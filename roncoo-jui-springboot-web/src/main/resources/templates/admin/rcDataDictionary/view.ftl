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
            <label>字段名：</label>${bean.fieldName}
        </p>
        <p>
            <label>字段CODE：</label>${bean.fieldCode}
        </p>
    </div>
    <div class="formBar">
        <ul>
            <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
        </ul>
    </div>
</div>
