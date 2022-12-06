package aplicaciones.spring.controlador;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicaciones.spring.modelo.Vuelo;
import aplicaciones.spring.servicios.ClienteService;
import aplicaciones.spring.servicios.PasajeService;
import aplicaciones.spring.servicios.RutaService;
import aplicaciones.spring.servicios.VueloService;

@Controller
@RequestMapping("/vuelos")
@SessionAttributes("vuelo")
public class VueloController {
	

	@Autowired
	@Qualifier("ruta")
	RutaService rutaService;
	
	@Autowired
	@Qualifier("pasaje")
	PasajeService pasajeService;
	
	@Autowired
	@Qualifier("cliente")
	ClienteService clienteService;
		
	@Autowired
	@Qualifier("vuelo")
	VueloService vueloService;
	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Vuelo> vuelos = vueloService.listar();
		model.addAttribute("vuelos",vuelos);
		model.addAttribute("titulo","Lista de Vuelos");
		return "vueloListar";
	}	

	@RequestMapping("/form")
	public String formulario(Model model) {
		Vuelo vuelo = new Vuelo();
		model.addAttribute("vuelo", vuelo);
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("rutas", rutaService.listar());
		model.addAttribute("pasajes", pasajeService.listar());
		model.addAttribute("btn", "Registrar Vuelo");
		return "vueloForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("vuelo",vueloService.buscar(id));
		model.addAttribute("rutas", rutaService.listar());
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("pasajes", pasajeService.listar());
		model.addAttribute("btn","Actualizar Vuelo");
		return "vueloForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Vuelo vuelo,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			vuelo = new Vuelo();
			model.addAttribute("vuelo",vuelo);
			model.addAttribute("rutas", rutaService.listar());
			model.addAttribute("clientes", clienteService.listar());
			model.addAttribute("pasajes", pasajeService.listar());
			model.addAttribute("btn", "Crear Ruta");
			return "vueloForm";
		}else {
		vueloService.guardar(vuelo);
		return "redirect:/vuelos/listar";
		}
	}	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		vueloService.eliminar(id);
		return"redirect:/vuelos/listar";
	}	
}
