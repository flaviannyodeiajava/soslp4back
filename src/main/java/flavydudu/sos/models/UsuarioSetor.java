package flavydudu.sos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuariosetor")
public class UsuarioSetor{
    @Id
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String setor;

    public UsuarioSetor(){}

    public UsuarioSetor(String nome, String email, String senha, String setor){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    @Column(name = "email", nullable = false)
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    @Column(name = "setor", nullable = false)
    public String getSetor(){
        return setor;
    }
    public void setSetor(String setor){
        this.setor = setor;
    }

    @Override
    public String toString(){
        return "Ocorrencia [id=" + id + ", nome = " + nome + ", email = " + email + ", senha = " + senha + ", setor = " + setor + "]";
    }
}