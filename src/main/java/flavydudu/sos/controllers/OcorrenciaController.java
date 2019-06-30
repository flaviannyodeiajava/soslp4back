package flavydudu.sos.controllers;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import flavydudu.sos.exception.ResourceNotFoundException;
import flavydudu.sos.models.Ocorrencia;
import flavydudu.sos.repository.OcorrenciaRepository;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping("/ocorrencia")
    public List<Ocorrencia> getAllOcorrencia() {
        return ocorrenciaRepository.findAll();
    }

    @GetMapping("/ocorrencia/s/{setor}")
    public List<Ocorrencia> getOcorrenciaByTipo(@PathVariable(value = "setor") String setor) {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        ocorrencias = ocorrenciaRepository.findBySetor(setor);
        System.out.println(setor+ocorrencias);
        return ocorrencias;
    }

    @GetMapping("/ocorrencia/h/{hash}")
    public ResponseEntity<Ocorrencia> getOcorrenciaByHash(@PathVariable(value = "hash") String hash){
        Ocorrencia ocorrencia = ocorrenciaRepository.findByHash(hash);
        System.out.println(ocorrencia);
        return ResponseEntity.ok().body(ocorrencia);
    }

    @PostMapping("/ocorrencia")
    public Ocorrencia createOcorrencia(@Valid @RequestBody Ocorrencia ocorrencia) {
        System.out.println(ocorrencia);
        return ocorrenciaRepository.save((Ocorrencia) ocorrencia);
    }

    @PutMapping("/ocorrencia/{id}")
    public ResponseEntity<Ocorrencia> updateStatus(@PathVariable(value = "id") Long ocorrenciaId,
            @Valid @RequestBody String ocorrenciaStatus) throws ResourceNotFoundException {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(ocorrenciaId)
        .orElseThrow(() -> new ResourceNotFoundException("ocorrencia not found for this id :: " + ocorrenciaId));
        
        ocorrencia.setStatus(ocorrenciaStatus);
        
        final Ocorrencia updatedOcorencia = ocorrenciaRepository.save(ocorrencia);

        System.out.println(ocorrenciaStatus+ocorrenciaId+updatedOcorencia);
        return ResponseEntity.ok(updatedOcorencia);
    }
}