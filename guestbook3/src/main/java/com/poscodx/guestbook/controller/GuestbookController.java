package com.poscodx.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.guestbook.repository.GuestbookRepository;
import com.poscodx.guestbook.vo.GuestbookVo;



@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestRepository.insert(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
    public String deleteform(@PathVariable("no") Long no, Model model) {
        model.addAttribute("no", no);
        return "deleteform"; 
    }
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete() {
    	return "delete";
    }
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
    public String delete(@PathVariable("no") Long no, @RequestParam("password") String password) {
        guestRepository.deleteByNoAndPassword(no, password);
        return "redirect:/";
    }
	
}