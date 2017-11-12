<#assign base=request.contextPath /> 
<#include "/macro/menu.ftl" />
<div class="pageContent">
    <form method="post" action="${base}/admin/sysMenuRole/set" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="58">
        <input type="hidden" name="roleId" value="${roleId!}">
        <input type="hidden" name="ids" value="${ids!}">
        <ul class="tree treeFolder treeCheck expand">
            <#list menuList as bean>
                <li><a tname="ids" tvalue="${bean.id}">${bean.menuName}</a>
                    <#if bean.list?? && bean.list?size gt 0>
                        <@menuListForRole children=bean.list/>
                    </#if>
                </li>
            </#list>
        </ul>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>
