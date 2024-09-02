<%--==================== Ajout dans BDD ou liste ====================--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>

<div class="container mt-5">

    <main class="main">

        <h1 class="h1 center">Ajouter un animal</h1>

        <form method="post" action="">

            <div>
                <label for="nom">Nom :
                    <input type="text" name="nom" id="nom" value="${nom}" class="form-control">
                </label>
                <c:if test="${errors[0] != null}">
                    <p class="warning i">${errors[0]}</p>
                </c:if>
            </div>

            <div>
                <label for="race">Race :
                    <input type="text" name="race" id="race" value="${race}" class="form-control">
                </label>
                <c:if test="${errors[1] != null}">
                    <p class="warning i">${errors[1]}</p>
                </c:if>
            </div>

            <div>
                <label for="date_naissance">Date de naissance :
                    <input type="date" name="date_naissance" id="date_naissance" value="${dateNaissance}" class="form-control">
                </label>
            </div>
            <c:if test="${errors[2] != null}">
                <p class="warning i">${errors[2]}</p>
            </c:if>

            <button name="ajout" value="Envoyer" class="btn">Envoyer</button>

        </form>

    </main>

</div>

<%@ include file="/WEB-INF/layout/footer.jsp" %>