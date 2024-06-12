<!DOCTYPE html>
<html lang="en">

<#-- HEAD -->
<head>
    <meta charset="UTF-8">
    <title>DIN Media - Norms App</title>

    <!-- favicon @source https://www.din.de/resource/blob/62430/562536b5ef7f0ffe1474f7743cec9d17/din-favicon.ico -->
    <link rel="shortcut icon" type="image/x-icon" href="https://www.din.de/resource/blob/62430/562536b5ef7f0ffe1474f7743cec9d17/din-favicon.ico">
</head>

<#-- HEADER -->
<header></header>

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
<footer>
    <p id="copyright">© COPYRIGHT 2024 - DIN MEDIA GMBH</p>
</footer>

<#-- STYLE -->
<style>
    <#--  HEADER  -->
    header, footer {
        font-family: Inter, sans-serif;
        background-color: #003f64;
        text-align: center;
        display: flex;
        color: white;
        font-size: 18px;
        padding: 25px 48px;
    }

    header {
        margin-bottom: 30px;
    }


    <#--  BODY  -->
    body {
        font-family: Arial, sans-serif;
        padding: 20px 30px 10px;
        margin: 0;
    }

    h1 {
        color: #333;
    }

    #standards {
        list-style-type: none;
        margin-top: 30px;
        padding: 0;
    }

    .standard {
        background-color: rgba(0, 156, 222, 0.05);
        border: 1px solid #ddd;
        border-radius: 5px;
        margin-bottom: 10px;
        padding: 10px;
    }

    .standard > a {
        color: #007bff;
        text-decoration: none;
    }

    .standard > a:hover {
        text-decoration: underline;
        color: #6a1847;
    }

    <#--  FOOTER  -->
    #copyright {
        flex-basis: auto;
        font-size: 14px;
        flex-grow: 1;
    }
</style>

</html>
