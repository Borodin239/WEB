<#-- @ftlvariable name="u" type="ru.itmo.wp.domain.User" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if u??>
        <div>User ID : ${u.id}</div>
        <div>Login : ${u.login}</div>
        <div>Creation Time : ${u.creationTime}</div>
    <#else>
        <div>No such user</div>
    </#if>
</@c.page>