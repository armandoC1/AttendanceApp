package org.esfe.controladores;

import org.esfe.modelos.Grupo;
import org.esfe.servicios.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    private IGrupoService grupoService;

    @GetMapping
    public String Index(Model model, @RequestParam("page")Optional<Integer> page , @RequestParam("size") Optional<Integer> size){

        int currentPage = page.orElse(1)-1; //si no esta seteado se asigna 0
        int pageSize = size.orElse(5); //tamaño de la pagina 5
        Pageable pageable = (Pageable) PageRequest.of(currentPage, pageSize);

        Page<Grupo> grupos = grupoService.buscarTodosPaginados(pageable);
        model.addAttribute("grupos", grupos);

        int totalPages = grupos.getTotalPages();
        if (totalPages>0){
            List<Integer> pageNumbers = (List<Integer>) IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "grupo/index";
    }

    //muestra el envio de formulario
    @GetMapping("/create")
    public String create(Grupo grupo){
        return "grupo/create";
    }

    @PostMapping("/save")
    public String save(Grupo grupo, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
            model.addAttribute(grupo);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error");
            return "grupo/create";
        }

        grupoService.crearOEditra(grupo);
        attributes.addFlashAttribute("msg", "Grupo guardado exitosamente");
        return "redirect:/grupos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Grupo grupo = grupoService.buscarPorId(id).get();
        model.addAttribute("grupo", grupo);
        return "grupo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Grupo grupo = grupoService.buscarPorId(id).get();
        model.addAttribute("grupo", grupo);
        return "grupo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Grupo grupo = grupoService.buscarPorId(id).get();
        model.addAttribute("grupo", grupo);
        return "grupo/delete";
    }

    @PostMapping("/delete")
    public String delete(Grupo grupo, RedirectAttributes attributes){
        grupoService.eliminarPorId(grupo.getId());
        attributes.addFlashAttribute("msg", "Grupo eliminado exitosamente");
        return "redirect:/grupos";
    }

}
