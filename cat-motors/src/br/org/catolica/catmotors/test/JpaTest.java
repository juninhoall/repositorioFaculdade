package br.org.catolica.catmotors.test;

import br.org.catolica.entity.Cidade;
import br.org.catolica.entity.Contato;
import br.org.catolica.entity.Endereco;
import br.org.catolica.entity.Estabelecimento;
import br.org.catolica.entity.Estado;
import br.org.catolica.entity.Responsavel;
import br.org.catolica.entity.UsuarioOld;

import javax.persistence.EntityManager;

import br.org.catolica.jpa.JPAUtil;

public class JpaTest extends JpaTesteBase {

    public static Estado criaEstado(Estado estado) {

        estado.setNome("Santa Catarina");
        estado.setSigla("SC");

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        // Estado estado = new Estado();
        criaEstado(estado);
        Cidade cidade = new Cidade();
        cidade.setNome("Guaramirim");

        em.persist(estado);

        estado.getCidades().add(cidade);
        cidade.setEstado(estado);
        em.persist(cidade);
        em.getTransaction().commit();

        Endereco endereco = new Endereco();

        endereco.setBairro("rua augusta");
        endereco.setCidade(em.find(Cidade.class, 8L));
        endereco.setComplemento("prox a igreja");
        endereco.setNumero(22);
        endereco.setRua("124E");
        em.persist(endereco);

        return estado;

    }

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Contato contato = new Contato();
        contato.setEmail("rua@rua.com");
        contato.setFacebook("juninhoall");
        contato.setTelefone("asdas");
        em.persist(contato);
        Responsavel resp = new Responsavel();
        resp.setNome("Antonio");
        em.persist(resp);
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome("Zona muito louca");
        estabelecimento.setContato(contato);
        estabelecimento.setEndereco(em.find(Endereco.class, 1L));
        estabelecimento.setResponsavel(resp);

        em.persist(estabelecimento);

        em.getTransaction().commit();

        System.out.println("CRIADO");
    }

    public static UsuarioOld criaUsuario(UsuarioOld usuario) {

        usuario.setNomeUsuario("Santa Catarina");
        usuario.setSenha("SC");

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        System.out.println("CRIADO usuario");
        return usuario;

    }

}
