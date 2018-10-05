package hello;

public class Especificacao {

	
	private String aula;
	private String periodo;
	private Integer qtdAulasSemana;
	
	
	public Especificacao(String aula, String periodo, Integer qtdAulasSemana){
		this.aula = aula;
		this.periodo = periodo;
		this.qtdAulasSemana = qtdAulasSemana;
	}
	
	public Integer getQtdAulasSemana(){
		return qtdAulasSemana;
	}
	
	public String getAula(){
		return aula;
	}
	
	public String getPeriodo(){
		return periodo;
	}
	
	public boolean comparar(Especificacao esp){
		if(aula.equals(esp.aula) && qtdAulasSemana.equals(esp.qtdAulasSemana) && periodo.equals(esp.periodo)){
			return true;
		} else {
			return false;
		}
	}
	
}
