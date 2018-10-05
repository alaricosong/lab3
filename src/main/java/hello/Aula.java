package hello;

public class Aula {

	private String codigo;
	private Especificacao espc;
	
	
	public Aula(String codigo, Especificacao espc){
		this.codigo = codigo;
		this.espc = espc;
		
	}
	
	public String getCodigo(){	
		return this.codigo;
	}
	
	public Especificacao getEspc(){
		return espc;
	}
	
	
}
