package controller;

import entity.Chien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ChienRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


// ==================== Afficher tous, afficher un, ajout ====================

//@WebServlet("/tous") // URL
@WebServlet(name = "bddAfficherTousServlet", value = {"/tous", "/ajout", "/un/*"})
public class BddAfficherTousServlet extends HttpServlet {

    // ----- Propriétés -----

    private ChienRepository chienRepository;
    List<Chien> chiens;


    // ----- Méthodes -----

    @Override
    public void init() throws ServletException {
        chienRepository = new ChienRepository();
    }


    // Méthode doGet() appelée à chaque requête GET sur l'URL
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String pathInfo = req.getPathInfo();
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";

        System.out.println("pathInfo: " + pathInfo); // Récupère le pathInfo dans la console

        switch (pathInfo) {
            case "/ajout":

                req.getRequestDispatcher("/WEB-INF/pages/ajout.jsp").forward(req, resp);

                break;

            case "/un":

                //        int id = 1; // Pour test
                int id = Integer.parseInt(req.getParameter("id")); // Récupérer l'ID du chien à partir d'URL

                Chien chien = chienRepository.getById(id); // Récupérer le chien depuis la BDD

                if (chien != null) {
                    req.setAttribute("chien", chien); // Ajouter le chien à la requête

                    req.getRequestDispatcher("/WEB-INF/pages/bdd-afficher-un.jsp").forward(req, resp);
                }
                else {
                    resp.sendRedirect("tous"); // Si le chien n'existe pas, rediriger vers la liste des chiens
                }

                req.getRequestDispatcher("/WEB-INF/pages/bdd-afficher-un.jsp").forward(req, resp);

                break;

            default:

                chiens = chienRepository.getAll(); // Récup depuis BDD et insère dans une liste

                req.setAttribute("chiens", chiens); // Ajout de la liste de chiens à la requête pour qu'elle soit accessible dans tous.jsp

                req.getRequestDispatcher("/WEB-INF/pages/bdd-afficher-tous.jsp").forward(req, resp);

                break;

        }

    }


    // Méthode doPost() est exécutée lorsqu'une requête POST est envoyée à la servlet (ex. : après envoi de formulaire)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";

        System.out.println("pathInfo: " + pathInfo); // Récupère le pathInfo dans la console

        if (pathInfo == "/ajout") {

            // Récupérer les données du formulaire :
            String nom = req.getParameter("nom");
            String race = req.getParameter("race");
            String dateNaissanceStr = req.getParameter("date_naissance");
//        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr); // Conversion chaîne en objet LocalDate


            // ----- Validation de formulaire -----

            // Tableau pour stocker les messages d'erreur :
            String[] errors = new String[3]; // 0: nom, 1: race, 2: dateNaissance

            // Validation des champs
            if (nom == null || nom.trim().isEmpty()) {
                errors[0] = "Nom obligatoire";
            }
            if (race == null || race.trim().isEmpty()) {
                errors[1] = "Race obligatoire";
            }

            LocalDate dateNaissance = null;
            try {
                dateNaissance = LocalDate.parse(dateNaissanceStr); // Conversion chaîne en objet LocalDate
            }
            catch (Exception e) {
                errors[2] = "Date de naissance obligatoire ou format invalide";
            }

//        boolean hasErrors = false;
//        for (String error : errors) { // Boucle for-each pour vérifier erreurs
//            if (error != null) {
//                hasErrors = true;
//                break;
//            }
//        }

            boolean hasErrors = Arrays.stream(errors).anyMatch(e -> e != null); // Arrays.stream().anyMatch() pour vérifier erreurs

            // S'il y a des erreurs, renvoyer vers le formulaire avec les erreurs
            if (hasErrors) {
                req.setAttribute("errors", errors);

                req.setAttribute("nom", nom);
                req.setAttribute("race", race);
                req.setAttribute("dateNaissance", dateNaissanceStr);

                req.getRequestDispatcher("/WEB-INF/pages/ajout.jsp").forward(req, resp); // Rediriger vers la page du formulaire
                return; // Arrête la méthode ici en cas d'erreur
            }

            // ----- -----


            // Créer un nouvel objet Chien
            Chien chien = Chien.builder()
                    .nom(nom)
                    .race(race)
                    .dateNaissance(dateNaissance)
                    .build();

            chienRepository.createOrUpdate(chien); // Enregistrer le chien dans la BDD

            resp.sendRedirect("tous");
        }


    }

}
