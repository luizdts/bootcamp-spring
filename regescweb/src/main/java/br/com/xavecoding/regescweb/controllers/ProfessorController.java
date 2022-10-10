package br.com.xavecoding.regescweb.controllers;

import br.com.xavecoding.regescweb.dto.RequisicaoFormProfessorDTO;
import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.StatusProfessor;
import br.com.xavecoding.regescweb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("")
    public ModelAndView index(){

        List<Professor> professores = this.professorRepository.findAll();
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);

        return mv;
    }
    @GetMapping("/new")
    public ModelAndView nnew(RequisicaoFormProfessorDTO requisicao){
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("status", StatusProfessor.values());

        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid RequisicaoFormProfessorDTO requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatus", StatusProfessor.values());
            return mv;
        }
        else {
            Professor professor = requisicao.toProfessor();
            this.professorRepository.save(professor);
            return new ModelAndView("redirect:/professores/" + professor.getId());
        }
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Professor> optional = this.professorRepository.findById(id);

        if(optional.isPresent()){
            Professor professor = optional.get();

            ModelAndView mv = new ModelAndView("professores/show");
            mv.addObject("professor", professor);

            return mv;
        }
        else {
            return this.returnError("SHOW ERROR: Professor #" + id + " não encontrado no banco.");
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoFormProfessorDTO requisicao){
        Optional<Professor> optional = this.professorRepository.findById(id);
        if(optional.isPresent()){
            Professor professor = optional.get();
            requisicao.fromProfessor(professor);
            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", professor.getId());
            mv.addObject("listaStatus", StatusProfessor.values());

            return mv;
        }
        else{
            return this.returnError("EDIT ERROR: Professor #" + id + " não encontrado no banco.");
        }

    }
    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoFormProfessorDTO requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", id);
            mv.addObject("listaStatus", StatusProfessor.values());
            return mv;

        }
        else{
            Optional<Professor> optional = this.professorRepository.findById(id);
            if(optional.isPresent()){
                Professor professor = requisicao.toProfessor(optional.get());
                this.professorRepository.save(professor);

                return new ModelAndView("redirect:/professores/" + professor.getId());
            }
            else{
                ModelAndView mv = this.returnError("UPDATE ERROR: Professor #" + id + " não encontrado no banco.");
                return mv;
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/professores");
        try {
            this.professorRepository.deleteById(id);
            mv.addObject("mensagem", "Professor #" + id + " deletado com sucesso");
            mv.addObject("erro", false);
        }
        catch(EmptyResultDataAccessException e){
            mv = this.returnError("DELETE ERROR: Professor #" + id + " não encontrado no banco.");
        }
        return mv;
    }

    private ModelAndView returnError(String msg){
        ModelAndView mv = new ModelAndView("redirect:/professores");
        mv.addObject("mensagem", msg);
        mv.addObject("erro", true);
        return mv;
    }
}
