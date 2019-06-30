package flavydudu.sos.controllers;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flavydudu.sos.models.UsuarioSetor;
import flavydudu.sos.repository.UsuarioSetorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UsuarioSetorController {
    @Autowired
    private UsuarioSetorRepository usuarioSetorRepository;

    @GetMapping("/usuariosetor")
    public List<UsuarioSetor> getAllOcorrencia() {
        return usuarioSetorRepository.findAll();
    }

    @GetMapping("/usuariosetor/{setor}")
    public ResponseEntity<UsuarioSetor> getUsuarioSetorbySetor(@PathVariable(value = "setor") String setor){
        UsuarioSetor usuarioSetor = usuarioSetorRepository.findBySetor(setor);
        return ResponseEntity.ok().body(usuarioSetor);
    }

    @PostMapping("/usuariosetor")
    public UsuarioSetor createUsuarioSetor(@Valid @RequestBody UsuarioSetor usuarioSetor) {
        return usuarioSetorRepository.save((UsuarioSetor) usuarioSetor);
    }
}