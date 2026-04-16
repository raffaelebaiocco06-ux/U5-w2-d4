package raffaele.u5w2d1.controller;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import raffaele.u5w2d1.entities.Autore;
import raffaele.u5w2d1.execptionnn.ValidationExeprion;
import raffaele.u5w2d1.payload.AutoreDTO;
import raffaele.u5w2d1.payload.PayloadAutore;
import raffaele.u5w2d1.service.AutoreService;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    private final AutoreService autoreService;

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping
    public List<Autore> findAll() {
        return this.autoreService.findAll();
    }

    @GetMapping("/{id}")
    public Autore findById(@PathVariable long id) {
        return this.autoreService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody @Validated AutoreDTO body, BindingResult validationResult ) {
        if(validationResult.hasErrors()){
            List<String> erroriMadornali= validationResult.getFieldErrors().stream().map(err -> err.getDefaultMessage()).toList();
            throw new ValidationExeprion(erroriMadornali);
        }
        return this.autoreService.salvaAutore(body);
    }

    @PutMapping("/{id}")
    public Autore updateAutore(@PathVariable long id, @RequestBody PayloadAutore body) {
        return this.autoreService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable long id) {
        this.autoreService.findByIdAndDelete(id);
    }
}