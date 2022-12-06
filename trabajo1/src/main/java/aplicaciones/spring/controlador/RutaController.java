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

import aplicaciones.spring.modelo.Ruta;
import aplicaciones.spring.servicios.ClienteService;
import aplicaciones.spring.servicios.PasajeService;
import aplicaciones.spring.servicios.RutaService;
@Controller
@RequestMapping("/rutas")
@SessionAttributes("ruta")
public class RutaController {
	

	@Autowired
	@Qualifier("ruta")
	RutaService rutaService;
	
	@Autowired
	@Qualifier("pasaje")
	PasajeService pasajeService;
	
	@Autowired
	@Qualifier("cliente")
	ClienteService clienteService;
		
	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Ruta> rutas = rutaService.listar();
		model.addAttribute("rutas",rutas);
		model.addAttribute("titulo","Lista de Rutas");
		return "rutaListar";
	}	

	@RequestMapping("/form")
	public String formulario(Model model) {
		Ruta ruta = new Ruta();
		model.addAttribute("ruta", ruta);
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("pasajes", pasajeService.listar());
		model.addAttribute("btn", "Registrar Rutas");
		return "rutaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("ruta",rutaService.buscar(id));
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("pasajes", pasajeService.listar());
		model.addAttribute("btn","Actualiza Ruta");
		return "rutaForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Ruta ruta,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			ruta = new Ruta();
			model.addAttribute("ruta",ruta);
			model.addAttribute("clientes", clienteService.listar());
			model.addAttribute("pasajes", pasajeService.listar());
			model.addAttribute("btn", "Crear Ruta");
			return "rutaForm";
		}else {
		rutaService.guardar(ruta);
		return "redirect:/rutas/listar";
		}
	}	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		rutaService.eliminar(id);
		return"redirect:/rutas/listar";
	}	
}
