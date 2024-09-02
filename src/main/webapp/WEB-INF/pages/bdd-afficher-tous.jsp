<%--==================== Afficher tous depuis BDD ====================--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Chien" %>

<div class="container mt-5">

    <main class="main">

        <h1 class="h1 center">Liste des chiens</h1>

        <%
        List<Chien> chiens = (List<Chien>) request.getAttribute("chiens"); // Récupérer la liste des chats depuis l'attribut de requête

        if (chiens != null && !chiens.isEmpty()) {
        %>

            <p>Cliquez sur un chien pour voir les détails :</p>

            <div class="grid-2-col">
                <div class="grid-cell head">Nom</div>
                <div class="grid-cell head">Date de naissance</div>

                <%
                for (Chien chien : chiens) { // for-each pour parcourir la liste des chats
                %>
                    <div class="grid-cell"><a href="un?id=<%= chien.getId() %>"><%= chien.getNom() %></a></div>
                    <div class="grid-cell"><%= chien.getDateNaissance() %></div>
                    <%
                }
                %>
            </div>
        <%
        }
        else {
            %>
            <p class="center">Aucun chien</p>
            <%
        }
        %>

        <a href="ajout">Ajouter un autre chien</a>

    </main>

</div>

<%@ include file="/WEB-INF/layout/footer.jsp" %>