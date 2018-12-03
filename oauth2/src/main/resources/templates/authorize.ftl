<html>
<head>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>请确认</h2>
    <p>
        你是否在  "${authorizationRequest.redirectUri}"授权"${authorizationRequest.clientId}" 以使用 ${authorizationRequest.scope?join(", ")}
        访问你的应用。
    </p>
    <form id="confirmationForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <#list authorizationRequest.scope as scop>
		    <input type="hidden" name="scope.${scop}" value="true"/>
		</#list>
        <input name="user_oauth_approval" value="true" type="hidden"/>
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Approve（批准）</button>
    </form>
    <form id="denyForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <input name="user_oauth_approval" value="false" type="hidden"/>
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Deny（拒绝）</button>
    </form>
</div>
</body>
</html>