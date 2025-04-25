package br.senac.com.ProjetoIntegradorBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.com.ProjetoIntegradorBackend.model.Usuario;
import br.senac.com.ProjetoIntegradorBackend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository r;

    //create

    public Usuario save(Usuario u){
        return r.save(u);
    }

    //read

    public Usuario findById(Integer id){
        return r.findById(id).orElse(null);
    }

    public List<Usuario> findAll(){
        return r.findAll();
    }

    //update

    public Usuario update(Integer id, Usuario u){
        Usuario u1 = r.findById(id).orElse(null);

        updateData(u1, u);

        return r.save(u1);
    }

    private void updateData(Usuario u1, Usuario u){
        u1.setEmail(u.getEmail());
        u1.setNome(u.getNome());
        u1.setSenha(u.getSenha());
        u1.setTelefone(u.getTelefone());
    }

    //delete

    public void deleteById(Integer id){
        r.deleteById(id);
    }
}
