package com.controleacessovisitantes.SAV.Controller;

import com.controleacessovisitantes.SAV.Model.Setor;
import com.controleacessovisitantes.SAV.Service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/setores") // URL base para os endpoints da API
public class SetorController {

    @Autowired
    private SetorService setorService;

    // Endpoint para listar todos os setores com parâmetros de filtro
    @GetMapping
    public ResponseEntity<Map<String, Object>> listarSetores(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String sigla) {

        List<Setor> setores = setorService.buscarSetores(nome, sigla);
        Map<String, Object> response = new HashMap<>();
        response.put("data", setores);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para buscar um setor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarSetorPorId(@PathVariable Long id) {
        Setor setor = setorService.buscarPorId(id);
        if (setor != null) {
            return new ResponseEntity<>(setor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para criar um novo setor
    @PostMapping
    public ResponseEntity<Setor> criarSetor(@RequestBody Setor setor) {
        setorService.salvar(setor);
        return new ResponseEntity<>(setor, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um setor existente
    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizarSetor(
            @PathVariable Long id,
            @RequestBody Setor setor) {
        setor.setId(id);
        setorService.salvar(setor);
        return new ResponseEntity<>(setor, HttpStatus.OK);
    }

    // Endpoint para deletar um setor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSetor(@PathVariable Long id) {
        setorService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
