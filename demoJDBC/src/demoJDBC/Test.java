package demoJDBC;

import java.util.List;

import ma.projet.beans.Client;
import ma.projet.connexion.Connexion;
import ma.projet.service.ClientService;

public class Test {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        
        clientService.create(new Client("SAFI", "Ali"));
        clientService.create(new Client("ALAOUI", "Widane"));
        clientService.create(new Client("RAMI", "Amine"));
        clientService.create(new Client("ALAMI", "Kamal"));
        clientService.create(new Client("SELAMI", "Mohamed"));
        
       
        
        // Affichage du client avec l'ID 3
        Client clientWithId3 = clientService.findById(3);
        if (clientWithId3 != null) {
            System.out.println("Client avec ID 3 : " + clientWithId3.getNom() + " " + clientWithId3.getPrenom());
        } else {
            System.out.println("Aucun client trouvé avec l'ID 3");
        }
        

        // Suppression du client avec l'ID 3
        Client clientToDelete = clientService.findById(3);
        if (clientToDelete != null) {
            clientService.delete(clientToDelete);
            System.out.println("Client avec ID 3 supprime avec succes");
        } else {
            System.out.println("Aucun client trouvé avec l'ID 3, suppression impossible");
        }

        // Modification du client avec l'ID 2
        Client clientToUpdate = clientService.findById(2);
        if (clientToUpdate != null) {
            clientToUpdate.setNom("isslem");
            clientToUpdate.setPrenom("Ziedi");
            clientService.update(clientToUpdate);
            System.out.println("Client avec ID 2 mis à jour avec succès");
        } else {
            System.out.println("Aucun client trouvé avec l'ID 2, mise à jour impossible");
        }
        
        // Affichage de tous les clients
        List<Client> allClients = clientService.findAll();
        System.out.println("Liste de tous les clients :");
        for (Client client : allClients) {
            System.out.println(client.getNom() + " " + client.getPrenom());
        }
        
    }
}
