package app.discipline.controller;

import app.discipline.dao.DisciplineDao;
import app.discipline.model.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class DisciplineController {
    @Autowired
    DisciplineDao disciplineDao;

    @RequestMapping("/disciplineList")
    public String getList(ModelMap modelMap){
modelMap.addAttribute("disciplines",disciplineDao.getDisciplineList());
        return "disciplineList";
    }

    @RequestMapping("/addDiscipline")
    public String insert (@ModelAttribute Discipline discipline){
        disciplineDao.insert(discipline);
        return "redirect:/disciplineList";
    }
    @RequestMapping(value = "/discipline", method = RequestMethod.GET)
    public String newDiscipline(ModelMap modelMap){
        Discipline discipline = new Discipline();
        modelMap.addAttribute("discipline",discipline);
        return  "registrationDiscipline";
    }
    @RequestMapping("/updateDiscipline")
   public String update(@ModelAttribute Discipline discipline){

        disciplineDao.update(discipline);
        return "redirect:/disciplineList";
    }


    @RequestMapping("/deleteDiscipline")
    public String delete(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
       disciplineDao.delete(id);
        return "redirect:/disciplineList";
    }

    @RequestMapping("/editDiscipline")
   public String editDiscipline(ModelMap modelMap,HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Discipline discipline=disciplineDao.getById(id);
        modelMap.addAttribute("discipline",discipline);
        return  "editDiscipline";
    }
}
