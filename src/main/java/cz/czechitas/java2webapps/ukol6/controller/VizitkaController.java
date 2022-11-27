package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.VizitkaRepository;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class VizitkaController {
    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    /*
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka(1L,'Dita (Přikrylová) Formánková', 'Czechitas z. s.', 'Václavské náměstí 837/11', 'Praha 1', '11000', 'dita@czechitas.cs', '+420 800123456',
                    'www.czechitas.cz')
    );
*/
    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public Object seznam() {
        //TODO načíst seznam osob
        return new ModelAndView("seznam")
                .addObject("vizitky", vizitkaRepository.findAll());
    }

    @GetMapping("/nova")
    public Object novy() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/nova")
    public Object nova(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        //TODO uložit údaj o nové osobě
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable long id) {
        //TODO načíst údaj o osobě
        return new ModelAndView("formular")
                .addObject("vizitka", vizitkaRepository.findById(id).get());
    }

    @PostMapping("/{id:[0-9]+}")
    public Object ulozit(@PathVariable long id, @ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        //TODO uložit údaj o osobě
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @PostMapping(value = "/{id:[0-9]+}", params = "akce=smazat")
    public Object smazat(@PathVariable long id) {
        //TODO smazat údaj o osobě
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }
}
