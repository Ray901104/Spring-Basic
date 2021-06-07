package org.zerock.controller;

import java.net.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic.................");
	}//basic
	
	@GetMapping("/jex01")
	public String jex01(SampleDTO sDTO) {
		log.info("" + sDTO);
		return "jex01";
	}
	
	@GetMapping("/jex02")
	public String jex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "jex02";
	}
	
	@GetMapping("/jex02List")
	public String jex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : " + ids);
		
		return "jex02List";
	}
	
	@GetMapping("/jex02Array")
	public String jex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		
		return "jex02Array";
	}
	
	@GetMapping("/jex02Bean")
	public String jex02Bean(SampleDTOList list) {
		log.info("list dtos : " + list);
		
		return "jex02Bean";
	}
	
	@GetMapping("/jex03")
	public String jex03(TodoDTO todo) {
		log.info("todo : " + todo);
		
		return "jex03";
	}
	
	@GetMapping("/jex04")
	public String jex04(SampleDTO sDTO, @ModelAttribute("page") int page) {
		log.info("sDTO : " + sDTO);
		log.info("page : " + page);
		
		return "/sample/jex04";
	}
	
	@GetMapping("/jex05")
	public void jex05() {
		log.info("/jex05..........");
	}
	
	@GetMapping("/jex06")
	public @ResponseBody SampleDTO jex06() {
		log.info("/jex06..........");
		
		SampleDTO sDTO = new SampleDTO();
		sDTO.setAge(10);
		sDTO.setName("홍길동");
		
		return sDTO;
	}
	
	@GetMapping("/jex07")
	public ResponseEntity<String> jex07(){
		log.info("/jex07..........");
		
		// {"name" : "홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";
		
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/jexUpload")
	public void jexUpload() {
		log.info("/jexUpload.........");
	}
	
	@PostMapping("/jexuploadPost")
	public void jexUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("------------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
}//class
