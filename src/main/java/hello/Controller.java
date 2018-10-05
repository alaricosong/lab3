package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	public void buscarAula(){
		get("/ezgrid/:aula/:periodo/:qtdAulasSemana", (req, res) -> {
		
			Especificacao espec = new Especificacao(req.params(":aula"), req.params(":periodo"), Integer.parseInt((req.params(":qtdAulasSemana"))));	
			List<Aula> aulasEncontradas = model.buscarEspecificacao(espec);	
			return new Gson().toJson(aulasEncontradas);
			
		});
	}
	
	
	public void buscarCodigo(){
		get("/ezgrid/:codigo", (req, res) -> {
		
			
			Aula aulasEncontradas = model.buscarCodigo(req.params(":codigo"));	
			return new Gson().toJson(aulasEncontradas);
			
		});
	}
	
	public void buscarPeriodoAula(){
		get("/ezgrid/periodo/:aula", (req, res) -> {
		
			
			List<Aula> aulasEncontradas = model.buscarPeriodo(req.params(":periodo"));	
			return new Gson().toJson(aulasEncontradas);
			
		});
	}

}
