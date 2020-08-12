/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import dominion.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author guita
 */
public class Programa {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //cria a conexão com o o manager factory(aqui é o nome da persistencia na classe persistence)
        EntityManager em = emf.createEntityManager(); // da linha de cima até essa é importante para a conexão com o bd
        
            Pessoa p1 = new Pessoa(null, "Pedro Novaes" , "pedro.novaes@gmail.com");
            Pessoa p2 = new Pessoa(null, "Vitor Novaes" , "Vitor.novaes@gmail.com");
            Pessoa p3 = new Pessoa(null, "Lima Novaes" , "Lima.novaes@gmail.com");
            
            em.getTransaction().begin(); //Abri conexão com o BD
    
            em.persist(p1);  //Adc dados as tabelas
            em.persist(p2);
            em.persist(p3);
            
            em.getTransaction().commit(); //encerra a conexão com o BD
            
            System.out.println("Tudo certo!");
            
    }
}
