package hello;


import java.util.List;
import java.util.LinkedList;

public class Model {

	private List<Aula> aulas = new LinkedList<Aula>();

	public void addAula(Aula aula){
		aulas.add(aula);
	}

	public Aula buscarCodigo(String codigo){
		for(Aula aula:aulas){
			if(aula.getCodigo().equals(codigo)) return aula;
		}

		return null;
	}

	public List<Aula> buscarEspecificacao(Especificacao esp){
		List<Aula> aulasEncontradas = new LinkedList<Aula>();

		for(Aula aula:aulas){
			 if(esp.comparar(aula.getEspc())) aulasEncontradas.add(aula);
		}
	
		return aulasEncontradas;

	}

	public List<Aula> buscarPeriodo(String periodo){
		List<Aula> aulasEncontradas = new LinkedList<Aula>();
		for(Aula aula:aulas) {
			if(aula.getEspc().getPeriodo().equals(periodo)) aulasEncontradas.add(aula);
		}
		return aulasEncontradas;
	}

	public List<Aula> getAulas(){
		return aulas;
	}

}
