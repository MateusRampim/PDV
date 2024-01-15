package com.example.demo;

import com.example.demo.models.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api/v1/vendedores")
public class VendedorController {
    @PersistenceContext
    private EntityManager entityManager;
    @PostMapping
    @Transactional
    public Vendedor cadastrarVendedor(@RequestBody Vendedor vend) {
        String query = "INSERT INTO Vendedor (id, nome, contato) VALUES (uuid_generate_v4(),  :nome , :contato )";

        entityManager.createNativeQuery(query)
                .setParameter("nome",vend.getNome())
                .setParameter("contato",vend.getContato())
                .executeUpdate();
        return vend;
    }


    @PostMapping("/excluir")
    @Transactional
    public void excluirVendedor(@RequestParam String nome){
        String query = "DELETE FROM vendedor WHERE nome = :nome";
        entityManager.createNativeQuery(query).setParameter("nome",nome).executeUpdate();

    }

    @GetMapping
    public List<Vendedor> buscarVendedor() {
        String query = "SELECT * FROM vendedor;";
        Query procurar = entityManager.createNativeQuery(query, Vendedor.class);

        return procurar.getResultList();
    }
    @GetMapping("/nome")
    @Transactional
    public List<Vendedor> buscarVendedornome(@RequestParam String nome) {
        String query = "SELECT * FROM vendedor WHERE nome LIKE :nome";
        Query procurar = entityManager.createNativeQuery(query, Vendedor.class).setParameter("nome", "%" + nome + "%");
        System.out.println("Consulta SQL: " + procurar.unwrap(org.hibernate.query.Query.class).getQueryString());
        return procurar.getResultList();
    }

}
