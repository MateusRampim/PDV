package com.example.demo;

import com.example.demo.models.Itens;
import com.example.demo.models.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itens")
public class ItensController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Itens cadastrarItens(@RequestBody Itens iten) {
        String query = "INSERT INTO itens (id, nome, estoque,valor) VALUES (uuid_generate_v4(),  :nome , :estoque,:valor )";

        entityManager.createNativeQuery(query)
                .setParameter("nome",iten.getNome())
                .setParameter("estoque",iten.getEstoque()).setParameter("valor",iten.getValor())
                .executeUpdate();
        return iten;
    }

    @GetMapping("/excluir")
    @Transactional
    public void excluirItem(@RequestParam String nome){
        String query = "DELETE FROM itens WHERE nome = :nome";
        entityManager.createNativeQuery(query).setParameter("nome",nome).executeUpdate();
    }

    @GetMapping
    public List<Itens> buscarItens() {
        String query = "SELECT * FROM itens;";
        Query procurar = entityManager.createNativeQuery(query, Itens.class);

        return procurar.getResultList();
    }

    @GetMapping("/nome")
    @Transactional
    public List<Itens> buscarItensNome(@RequestParam String nome) {
        String query = "SELECT * FROM vendedor WHERE nome LIKE :nome";
        Query procurar = entityManager.createNativeQuery(query, Itens.class).setParameter("nome", "%" + nome + "%");
        return procurar.getResultList();
    }
    @GetMapping("/setaestoque")
    @Transactional
    public List<Itens> defineestoque(@RequestParam int estoque,@RequestParam String nome) {
        String query ="UPDATE Itens SET estoque = :novo WHERE nome = :nome RETURNING *";
        Query procurar = entityManager.createNativeQuery(query, Itens.class)
                .setParameter("nome",  nome )
                .setParameter("novo",estoque);
        return procurar.getResultList();
    }

    @GetMapping("/ajustaestoque")
    @Transactional
    public List<Itens> ajustaestoque(@RequestParam int estoque,@RequestParam String nome) {
        String query ="UPDATE Itens SET estoque = estoque + :novo WHERE nome = :nome RETURNING *";
        Query procurar = entityManager.createNativeQuery(query, Itens.class)
                .setParameter("nome",  nome )
                .setParameter("novo",estoque);
        return procurar.getResultList();
    }

}
