package main.java.com.controleacessovisitantes.SAV.Controller;

import com.controleacessovisitantes.SAV.Model.Unidade;
import com.controleacessovisitantes.SAV.Service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/unidades") // URL base para os endpoints da API
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarUnidades(
            @RequestParam(required = false) String nome) {

        List<Unidade> unidades = unidadeService.buscarUnidades(nome);
        Map<String, Object> response = new HashMap<>();
        response.put("data", unidades);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarUnidadePorId(@PathVariable Long id) {
        Unidade unidade = setorService.buscarPorId(id);
        if (unidade != null) {
            return new ResponseEntity<>(unidade, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Unidade> criarUnidade(@RequestBody Unidade unidade) {
        unidadeService.salvar(unidade);
        return new ResponseEntity<>(unidade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizarUnidade(
            @PathVariable Long id,
            @RequestBody Unidade unidade) {
        unidade.setId(id);
        unidadeService.salvar(unidade);
        return new ResponseEntity<>(unidade, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUnidade(@PathVariable Long id) {
        unidadeService.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
