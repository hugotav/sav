package com.controleacessovisitantes.SAV.Service;

import com.controleacessovisitantes.SAV.Model.Setor;
import com.controleacessovisitantes.SAV.Repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public Setor buscarPorId(Long id) {
        return setorRepository.findById(id).orElse(null);
    }

    public void salvar(Setor setor) {
        setorRepository.save(setor);
    }

    public void deletarPorId(Long id) {
        setorRepository.deleteById(id);
    }

    public List<Setor> buscarSetores(String nome, String sigla) {
        return setorRepository.buscarSetores(nome, sigla);
    }
}
