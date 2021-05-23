package teste;

import java.util.ArrayList;
import java.util.List;

import dao.JogoDAO;
import dao.PlataformaDAO;
import model.Jogo;
import model.Plataforma;

public class teste {

	public static void main(String[] args) {
		
	
	
		Plataforma plataforma = new Plataforma();
		
		plataforma.setNome("Super Nintendo");
		
		
		Jogo jogo1 = new Jogo();
		Jogo jogo2 = new Jogo();
		
		
		jogo1.setNome("Super Metroid");
		jogo2.setNome("Donkey Kong Country");
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		jogos.add(jogo1);
		jogos.add(jogo2);
		
		plataforma.setJogos(jogos);
		
		PlataformaDAO platao = new PlataformaDAO();
		platao.salvarPlataforma(plataforma);

	}

}
