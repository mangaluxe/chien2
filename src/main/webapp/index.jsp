<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ include file="/WEB-INF/layout/header.jsp" %>

<div class="container mt-5">

    <main class="main">

        <h1 class="h1 center">Page d'accueil</h1>

        <div class="center">
            <img src="${pageContext.request.contextPath}/assets/img/chien.png" alt="Avatar">
        </div>

        <p>Bienvenue dans la gestion des animaux. Vous pouvez ajouter ou voir la liste des animaux dans la BDD ou dans la liste.</p>

    </main>

</div>

<%@ include file="/WEB-INF/layout/footer.jsp" %>