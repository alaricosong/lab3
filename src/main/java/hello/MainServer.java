package hello;

import static spark.Spark.*;


public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

		staticFileLocation("/static");

		inicializarAulas();

		Controller controller = new Controller(model);
		
		controller.buscarCodigo();
		controller.buscarAula();
		controller.buscarPeriodoAula();
		
    }
    
    public static void inicializarAulas(){
    	
    	model.addAula(new Aula("01", new Especificacao("PP", "Notuno", 2)));
    }
}
