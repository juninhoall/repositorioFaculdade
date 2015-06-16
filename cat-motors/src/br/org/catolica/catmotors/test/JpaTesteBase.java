package br.org.catolica.catmotors.test;

public abstract class JpaTesteBase {

	/*public static Modelo criaModelo(String descricao, Integer potencia) {
		Modelo modelo = new Modelo();
		modelo.setDescricao(descricao);
		modelo.setPotencia(potencia);
		return modelo;
	}

	public static Automovel criaAutomovel(Modelo modelo, Integer anoFabricacao,
			Integer anoModelo, Float kilometragem, String observacao) {
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(anoFabricacao);
		automovel.setAnoModelo(anoModelo);
		automovel.setModelo(modelo);
		automovel.setKilometragem(kilometragem);
		automovel.setObservacoes(observacao);
		return automovel;
	}

	public static Marca criaMarca(String descricao) {
		Marca marca = new Marca();
		marca.setNome(descricao);
		return marca;
	}
	
	public static void inicializar() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Marca marca = criaMarca("Chevrolet");
		Modelo modelo1 = criaModelo("Astra", 125);
		 marca.addModelo(modelo1);
		Modelo modelo2 = criaModelo("Corsa", 125);
		marca.addModelo(modelo2);
		
		modelo1.setMarca(marca);
		modelo2.setMarca(marca);

		Automovel astra = criaAutomovel(marca.getModelos().get(0), 1998, 1998,
				250000f, "T� podre");
		Automovel corsa = criaAutomovel(marca.getModelos().get(1), 1995, 1995,
				450000f, "T� muito podre");

		em.persist(marca);
	

		
		em.persist(modelo1);
		em.persist(modelo2);
		
		em.persist(astra);
		em.persist(corsa);
		// TODO - INI - ADICIONAR AQUI OUTRAS MARCAS E AUTOMOVEIS
		
		
		
		
		// FIM
		em.getTransaction().commit();
		em.close();
	}*/

}