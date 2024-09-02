<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des animaux</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
<%--    <style><%@include file="../../assets/css/style.css"%></style>--%>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicon.svg" type="image/svg+xml">
</head>
<body>

    <header class="header">

    <div class="header-top">
        <ul class="px-2">
<%--            <li><a href="https://www.mangaluxe.com/forum/">Forum</a></li>--%>
<%--            <li><a href="https://www.mangaluxe.com/chat/">Tchat</a></li>--%>
        </ul>
        <ul class="px-2">
            <li><a href="#" target="_blank" class="icon-f"></a></li>
            <li><a href="#" target="_blank" class="icon-t"></a></li>
            <li><a href="#" target="_blank" class="icon-i"></a></li>
            <li><a href="#" target="_blank" class="icon-y"></a></li>
        </ul>
    </div>

    <div class="header-nav">
        <div class="header-nav-child1">
            <div class="container-burger tablet" id="open_menuburger">
                <div class="container-burger-in">
                    <div>
                        <div class="bar1"></div>
                        <div class="bar2"></div>
                        <div class="bar3"></div>
                    </div>
                    <div>Menu</div>
                </div>
            </div>
            <a href="/" class="logo"><img src="${pageContext.request.contextPath}/assets/img/logo.png" alt=""></a>


            <div id="my_overlay" class="my-overlay">

                <nav class="nav-icon">
                    <ul class="ul-1">
                        <li><a href="tous">Tous les chiens</a></li>
<%--                        <li><a href="ajout">Ajouter un chien</a></li>--%>
                    </ul>
                </nav>

            </div>


        </div>

        <div class="header-nav-child2 nav-icon">
            <a class="icon-search" id="search"></a>

            <div class="search-container">
                <div class="search-content">
                    <div class="search-header"> <!-- Non affiché par défaut -->
                        <span class="close-search"></span>
                        <div class="h4 mb-0">Recherche</div>
                    </div>
                    <form action="recherche" method="get" class="search">
                        <input type="search" id="recherche" name="recherche" placeholder="Recherche">
                        <button type="submit" class="submit"><span class="icon-search"></span></button>
                    </form>
                </div>
            </div>

            <a href="javascript:void(0)" class="icon-user open-connect" rel="nofollow"><span class="txt">Connexion</span></a>
        </div>

    </div>

</header>
<body>
