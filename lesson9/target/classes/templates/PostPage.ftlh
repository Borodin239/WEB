<#-- @ftlvariable name="post" type="ru.itmo.wp.domain.Post" -->

<#import "commons.ftlh" as c>

<@c.page>
    <#if post??>
        <@c.post post/>
        <#if userId??>
            <div style="padding: 2rem 0">
                <div class="header">Add Comment</div>
                <div class="body">
                    <form method="post" action="/post/${post.id}">
                        <div class="field">
                            <div class="name">
                                <label for="text">Text</label>
                            </div>
                            <div class="value">
                                <textarea id="text" name="text"></textarea>
                            </div>
                        </div>
                        <@c.error "comment.text"/>
                        <div class="button-field">
                            <input type="submit" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </#if>
        <#list post.comments?reverse as comment>
            <div>${comment.user.login}: ${comment.text}</div>
        </#list>
    <#else>
        <div>No such post</div>
    </#if>
</@c.page>