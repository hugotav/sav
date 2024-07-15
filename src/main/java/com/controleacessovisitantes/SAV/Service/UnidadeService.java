package com.controleacessovisitantes.SAV.Service;

import com.controleacessovisitantes.SAV.Model.Unidade;
import com.controleacessovisitantes.SAV.Repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> listarTodos() {
        return unidadeRepository.findAll();
    }

    public Unidade buscarPorId(Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    public void salvar(Unidade unidade) {
        unidadeRepository.save(unidade);
    }

    public void deletarPorId(Long id) {
        unidadeRepository.deleteById(id);
    }

    public List<Setor> buscarUnidades(String nome) {
        return unidadeRepository.buscarUnidades(nome);
    }
}
