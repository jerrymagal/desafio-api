package br.com.muxi;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.muxi.converter.impl.TituloConverter;
import br.com.muxi.dao.TituloDao;
import br.com.muxi.model.Titulo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TituloResourceTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private TituloDao dao;
	
	@Autowired
	private ObjectMapper mapper;
	
	private TituloConverter converter;
	
	@Before
	public void init() {
		
		converter = new TituloConverter();
		
		String titulo1 = "11132211;258;PWWIN;1;F04A2E4088B;4;8.00b3;0;16777336;PWWIN";
		String titulo2 = "25655512;256;PWWIN;3;F04A2E4088B;2;8.00b3;0;25566524;PWWIN";
		
		dao.save(converter.toObject(titulo1));
		dao.save(converter.toObject(titulo2));
	}

	@Test
	public void getAll() throws Exception {
		mock.perform(get("/titulo")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].logic", is(11132211)))
		.andExpect(jsonPath("$[1].logic", is(25655512)));
	}
	
	@Test
	public void getOne() throws Exception {
		mock.perform(get("/titulo/11132211")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("logic", is(11132211)))
		.andExpect(jsonPath("serial", is("258")))
		.andExpect(jsonPath("model", is("PWWIN")))
		.andExpect(jsonPath("sam", is(1)))
		.andExpect(jsonPath("ptid", is("F04A2E4088B")))
		.andExpect(jsonPath("plat", is(4)))
		.andExpect(jsonPath("version", is("8.00b3")))
		.andExpect(jsonPath("mxr", is(0)))
		.andExpect(jsonPath("mxf", is(16777336)))
		.andExpect(jsonPath("verfm", is("PWWIN")));
	}
	
	@Test
	public void save() throws Exception {
		mock.perform(post("/titulo").content("46451231;447;PWWIN;8;F04A2E4088B;3;8.00b3;0;44796544;PWWIN")
				.contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("logic", is(46451231)))
		.andExpect(jsonPath("serial", is("447")))
		.andExpect(jsonPath("model", is("PWWIN")))
		.andExpect(jsonPath("sam", is(8)))
		.andExpect(jsonPath("ptid", is("F04A2E4088B")))
		.andExpect(jsonPath("plat", is(3)))
		.andExpect(jsonPath("version", is("8.00b3")))
		.andExpect(jsonPath("mxr", is(0)))
		.andExpect(jsonPath("mxf", is(44796544)))
		.andExpect(jsonPath("verfm", is("PWWIN")));
	}
	
	@Test
	public void saveError() throws Exception {
		
		Titulo titulo = converter.toObject("25655512;111;PWWIN;8;F04A2E4088B;2;8.00b3;9;44796544;PWWIN");
		
		mock.perform(post("/titulo").content(mapper.writeValueAsBytes(titulo))
									.contentType(MediaType.APPLICATION_JSON_UTF8))
									.andExpect(status().isUnsupportedMediaType());
	}
	
	@Test
	public void update() throws Exception {
		
		Titulo titulo = converter.toObject("25655512;111;PWWIN;8;F04A2E4088B;2;8.00b3;9;44796544;PWWIN");
		
		mock.perform(put("/titulo/25655512").content(mapper.writeValueAsString(titulo))
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("logic", is(25655512)))
		.andExpect(jsonPath("serial", is("111")))
		.andExpect(jsonPath("model", is("PWWIN")))
		.andExpect(jsonPath("sam", is(8)))
		.andExpect(jsonPath("ptid", is("F04A2E4088B")))
		.andExpect(jsonPath("plat", is(2)))
		.andExpect(jsonPath("version", is("8.00b3")))
		.andExpect(jsonPath("mxr", is(9)))
		.andExpect(jsonPath("mxf", is(44796544)))
		.andExpect(jsonPath("verfm", is("PWWIN")));
	}
	
	/**
	 * Demonstra que a aplicação não permite o método delete
	 * @throws Exception
	 */
	@Test
	public void deleteError() throws Exception {
		mock.perform(delete("/titulo/{logic}", 25655512)).andExpect(status().isMethodNotAllowed());
	}
	
	@Test
	public void serialRequired() throws Exception {
		mock.perform(post("/titulo").content("46421131;;PWWIN;8;F04A2E4088B;3;8.00b3;0;44796544;PWWIN")
				.contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("statusCode", is(400)))
		.andExpect(jsonPath("erros[0]", is("Serial não pode ser vazio.")));
	}
	
	@Test
	public void modelRequired() throws Exception {
		mock.perform(post("/titulo").content("46421131;225;;8;F04A2E4088B;3;8.00b3;0;44796544;PWWIN")
				.contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("statusCode", is(400)))
		.andExpect(jsonPath("erros[0]", is("Model não pode ser vazio.")));
	}
	
	@Test
	public void versionRequired() throws Exception {
		mock.perform(post("/titulo").content("46421131;225;PWWIN;8;F04A2E4088B;3;;0;44796544;PWWIN")
				.contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("statusCode", is(400)))
		.andExpect(jsonPath("erros[0]", is("Version não pode ser vazio.")));
	}
	
	@Test
	public void samMinValue() throws Exception {
		mock.perform(post("/titulo").content("46421131;225;PWWIN;-8;F04A2E4088B;3;8.00b3;0;44796544;PWWIN")
									.contentType(MediaType.TEXT_PLAIN))
									.andExpect(status().isBadRequest())
									.andExpect(jsonPath("statusCode", is(400)))
									.andExpect(jsonPath("erros[0]", is("Valor do campo sam não pode ser menor que zero.")));
	}

}
