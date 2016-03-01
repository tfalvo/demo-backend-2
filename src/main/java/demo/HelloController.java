package demo;

import demo.domain.Commune;
import demo.domain.Departement;
import demo.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private CommuneService communeService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/departements")
    @ResponseBody
    @Transactional(readOnly = true)
    public List<Departement> departements() {
        return this.communeService.findAllDepartement();
    }

    @RequestMapping("/communes")
    @ResponseBody
    @Transactional(readOnly = true)
    public Page<Commune> communes(@RequestParam("departement") String codeDepartement, Pageable pageable) {
        return this.communeService.findByCodeDepartement(codeDepartement, pageable);
    }

    @RequestMapping("/commune")
    @ResponseBody
    @Transactional(readOnly = true)
    public Commune commune(@RequestParam("code") String code) {
        return this.communeService.find(code);
    }
}