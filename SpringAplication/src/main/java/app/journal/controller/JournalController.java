package app.journal.controller;

import app.journal.dao.JournalDao;
import app.journal.model.Journal;
import app.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Acer on 11.09.2015.
 */

@Controller
public class JournalController {
    @Autowired
    JournalDao journalDao;

    @RequestMapping("/journalList")
    public String JournalList(ModelMap model) throws SQLException {
        model.addAttribute("journals", journalDao.select());
        return "journalList";
    }
    @RequestMapping("/addJournal")
    public String insert(@ModelAttribute Journal journal){

     journalDao.insert(journal);
        return "redirect:/journalList";}

    @RequestMapping(value = "/journal", method = RequestMethod.GET)
    public String newJournal(ModelMap model) {
        Journal journal = new Journal();
        model.addAttribute("journal",journal);
        return "registrationJournal";
    }

    @RequestMapping("/editJournal")
    public String editJournal(ModelMap modelMap,HttpServletRequest request){
        int JournalId = Integer.parseInt(request.getParameter("id"));
       Journal journal = journalDao.getById(JournalId);
        modelMap.addAttribute("journal",journal);
        return "editJournal";
    }
    @RequestMapping("/updateJournal")
    public  String updateJournale(@ModelAttribute Journal journal){
        journalDao.update(journal);
        return "redirect:/journalList";
    }
    @RequestMapping("/deleteJournal")
    public String deleteJournal(HttpServletRequest request){
        int JournalId= Integer.parseInt(request.getParameter("id"));
        journalDao.delete(JournalId);
        return "redirect:/journalList";
    }
}
