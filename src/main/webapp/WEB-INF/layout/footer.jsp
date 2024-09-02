
    <div class="totop"></div> <!-- Ajout de la class "visible" quand le bouton apparaît -->

    <div id="connect-modal" class="modal-connect-overlay">

        <div class="modal-connect">
            <div class="modal-connect-header">
                <span class="close-connect"></span>
                <div class="h4 mb-0">Connexion</div>
            </div>
            <div class="modal-connect-body">
                <form method="post" action="#">
                    <label for="login_username">Pseudo :<br>
                        <input type="text" name="username" id="login_username" placeholder="Pseudo">
                    </label><br>
                    <label for="login_password">Mot de passe :<br>
                        <input type="password" name="password" id="login_password" placeholder="Mot de passe">
                    </label>
                    <button type="submit" name="login" value="Connecter">Connecter</button>
                </form>
                <div class="center"><a href="#">Inscrire</a> - <a href="#">Mot de passe oublié</a></div>

            </div>
        </div>

    </div>

    <footer class="footer">
        <div class="copyright">Copyright &copy; 2024 Mangaluxe.</div>
    </footer>


    <script src="${pageContext.request.contextPath}/assets/js/script.js"></script>
</body>
</html>