<!DOCTYPE html>
<html lang="en">

<#--&lt;#&ndash; STYLE &ndash;&gt;-->
<#--<style>-->
<#--    html, body {-->
<#--        height: 100%;-->
<#--    }-->

<#--    body {-->
<#--        font-family: Roboto, "Helvetica Neue", sans-serif;-->
<#--        display: flex;-->
<#--        padding: 30px;-->
<#--    }-->

<#--    li {-->
<#--        margin-bottom: 10px;-->
<#--    }-->
<#--</style>-->

<#-- HEAD -->
<head>
    <meta charset="UTF-8">
    <title>DIN - Norms App</title>
    <link rel="stylesheet" type="text/css" href="../static/css/standardsView.css" media="screen" />
</head>

<#-- BODY -->
<body class="container" style="padding: 30px">
<h1>DIN Norms List</h1>
<ul>
    <#list standards as standard>
        <li>
            <strong>${standard.dokNr} - ${standard.title}</strong><br>
            Ausgabedatum: ${standard.issueDate}<br>
            Erarbeitendes Gremium: <a href="https://din.de?gremId=${standard.workingGremId}"
                                      target="_blank">${standard.workingGrem}</a>
        </li><br>
    </#list>
</ul>
</body>

</html>
