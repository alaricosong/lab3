package hello;


import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model {
	
	ObjectContainer aulas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/aulas.db4o");
	
	public void addAula(Aula aula){
		aulas.store(aula);
		aulas.commit();
		
	}

	public Aula buscarCodigo(String codigo){
		
		Query query = aulas.query();
		query.constrain(Aula.class);
	    ObjectSet<Aula> allAulas = query.execute();
	    
		for(Aula aula:allAulas){
			if(aula.getCodigo().equals(codigo)) return aula;
		}

		return null;
	}

	public List<Aula> buscarEspecificacao(Especificacao esp){
		List<Aula> aulasEncontradas = new LinkedList<Aula>();

		Query query = aulas.query();
		query.constrain(Aula.class);
	    ObjectSet<Aula> allAulas = query.execute();
		
		for(Aula aula:allAulas){
			 if(esp.comparar(aula.getEspc())) aulasEncontradas.add(aula);
		}
	
		return aulasEncontradas;

	}

	public List<Aula> buscarPeriodo(String periodo){
		List<Aula> aulasEncontradas = new LinkedList<Aula>();
		
		Query query = aulas.query();
		query.constrain(Aula.class);
	    ObjectSet<Aula> allAulas = query.execute();
	    
		for(Aula aula:allAulas) {
			if(aula.getEspc().getPeriodo().equals(periodo)) aulasEncontradas.add(aula);
		}
		return aulasEncontradas;
	}

}
