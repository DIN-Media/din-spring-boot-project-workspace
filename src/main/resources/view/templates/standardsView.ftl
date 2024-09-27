<!DOCTYPE html>
<html lang="de">

<#-- STYLE -->
<style>
    <#include "static/css/standardsView.css"/>
</style>

<#-- HEAD -->
<head>
    <meta charset="UTF-8">
    <title>DIN Media - Norms App</title>

    <!-- favicon @source https://www.din.de/resource/blob/62430/562536b5ef7f0ffe1474f7743cec9d17/din-favicon.ico -->
    <link rel="shortcut icon" type="image/x-icon"
          href="https://www.din.de/resource/blob/62430/562536b5ef7f0ffe1474f7743cec9d17/din-favicon.ico">
</head>

<#-- HEADER -->
<#include "components/header.ftl"/>

<#-- BODY -->
<body>
<h1>DIN Norms List</h1>

<div id="standards">
    <#list standards as standard>
        <div id="${standard.dokNr}" class="standard">
            <strong>${standard.dokNr} - ${standard.title}</strong><br>
            Ausgabedatum: ${standard.issueDate}<br>
            Erarbeitendes Gremium: <a href="https://din.de?gremId=${standard.workingGremId}"
                                      target="_blank">${standard.workingGrem}</a>
        </div><br>
    </#list>
</div>
</body>


<#-- FOOTER -->
<#include "components/footer.ftl"/>

</html>
