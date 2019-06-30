package flavydudu.sos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia{
    @Id
    private long id;
    private String hash;
    private String setor;
    private String data;
    private String tipo;
    private String descricao;
    private String informante;
    private String infrator;
    private String status;
    
    public Ocorrencia(){}

    public Ocorrencia(String data, String setor, String hash, String tipo, String descricao, String informante, String infrator, String status){
        this.data = data;
        this.setor = setor;
        this.hash = hash;
        this.tipo = tipo;
        this.descricao = descricao;
        this.informante = informante;
        this.infrator = infrator;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "hash", nullable = false)
    public String getHash(){
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    
    @Column(name = "setor", nullable = false)
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getSetor(){
        return this.setor;
    }

    @Column(name = "data", nullable = false)
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    @Column(name = "tipo", nullable = false)
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    @Column(name = "descricao", nullable = false)
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    @Column(name = "informante", nullable = true)
    public String getInformante(){
        return informante;
    }
    public void setInformante(String informante){
        this.informante = informante;
    }

    @Column(name = "infrator", nullable = false)
    public String getInfrator(){
        return infrator;
    }
    public void setInfrator(String infrator){
        this.infrator = infrator;
    }

    @Column(name = "status", nullable = false)
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Ocorrencia [id=" + id + ", data=" + data + ",setor=" + setor + ", tipo=" + tipo + ", descricao=" + descricao + ", informante=" + informante + ", infrator=" + infrator + ", status=" + status + "]";
    }
}