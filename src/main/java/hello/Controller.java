package hello;

import static spark.Spark.get;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void buscarAula() {
		get("/ezgrid/:aula/:periodo/:qtdAulasSemana", new Route() {
			@Override
			public Object handle(final Request req, final Response res) throws UnsupportedEncodingException {

				res.header("Access-Control-Allow-Origin", "*");

				String aula = req.params(":aula");
				String periodo = req.params(":periodo");
				Integer qtdAulasSemana = Integer.parseInt(req.params(":qtdAulasSemana"));

				try {

					Especificacao espec = new Especificacao(aula, periodo, qtdAulasSemana);
					List<Aula> aulasEncontradas = model.buscarEspecificacao(espec);

					JSONArray jsonResult = new JSONArray();

					for (Aula aulas : aulasEncontradas) {
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("codigo", aulas.getCodigo());
						jsonObj.put("aula", aulas.getEspc().getAula());
						jsonObj.put("periodo", aulas.getEspc().getPeriodo());
						jsonObj.put("qtdAulasSemana", aulas.getEspc().getQtdAulasSemana());
						jsonResult.put(jsonObj);

					}

					return jsonResult;

				} catch (JSONException e) {

					e.printStackTrace();
				}

				return null;

			}

		});

	}

	public void buscarCodigo() {
		get("/ezgrid/:codigo", new Route() {
			@Override
			public Object handle(final Request req, final Response res) throws UnsupportedEncodingException {

				res.header("Access-Control-Allow-Origin", "*");

				String codigo = req.params(":codigo");

				try {

					Aula aulasEncontradas = model.buscarCodigo(codigo);

					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObjAula = new JSONObject();

					jsonObjAula.put("codigo", aulasEncontradas.getCodigo());
					jsonObjAula.put("aula", aulasEncontradas.getEspc().getAula());
					jsonObjAula.put("periodo", aulasEncontradas.getEspc().getPeriodo());
					jsonObjAula.put("qtdAulasSemana", aulasEncontradas.getEspc().getQtdAulasSemana());

					jsonResult.put(jsonObjAula);

					return jsonResult;

				}

				catch (JSONException e) {

					e.printStackTrace();
				}

				return null;

			}

		});

	}

	public void buscarPeriodoAula() {
		get("/ezgrid/periodo/:aula", new Route() {
			@Override
			public Object handle(final Request req, final Response res) throws UnsupportedEncodingException {

				res.header("Access-Control-Allow-Origin", "*");

				String aula = req.params(":aula");

				JSONArray jsonResult = new JSONArray();

				try {

					List<Aula> aulasEncontradas = model.buscarPeriodo(aula);

					for (Aula aulas : aulasEncontradas) {
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("codigo", aulas.getCodigo());
						jsonObj.put("aula", aulas.getEspc().getAula());
						jsonObj.put("periodo", aulas.getEspc().getPeriodo());
						jsonObj.put("qtdAulasSemana", aulas.getEspc().getQtdAulasSemana());
						jsonResult.put(jsonObj);

					}

					return jsonResult;

				} catch (JSONException e) {

					e.printStackTrace();
				}

				return null;

			}

		});

	}
}
