package com.bangba.project730.controller;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bangba.project730.model.dto.AlcoholDto;
import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.IngredientDto;
import com.bangba.project730.model.dto.TagDto;
import com.bangba.project730.model.service.ArticleService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:7300")
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@ApiOperation(value = "레시피 작성", response = String.class)
	@PostMapping(value = "/create",  headers = { "Content-type=application/json" })
	public String createArticle(@RequestBody Map<String, String> map, Model model) throws Exception {
		try {
			articleService.createArticle(map);
			model.addAttribute("msg", "레시피 작성 완료");
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "레시피 작성중 문제가 발생했습니다.");
			return "error";
		}
	}

	@ApiOperation(value = "레시피 검색", response = String.class)
	@PostMapping("/keyword")
	public List<ArticleDto> searchArticle(@RequestBody Map<String, String> map , Model model) throws Exception {
		try {
			List<ArticleDto> dto = articleService.searchArticle(map);
			for(ArticleDto a:dto)
				System.out.println(a.getTitle_kor());
			model.addAttribute("msg", "레시피 검색 완료");
			return articleService.searchArticle(map);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "레시피 검색중 문제가 발생했습니다.");
		}
		return null;
	}
	
	@ApiOperation(value = "레시피 수정", response = String.class)
	@PutMapping("/recipe/{pk_article}")
	public String updateArticle(@RequestBody Map<String, String> map, Model model) throws Exception {
		try {
			articleService.updateArticle(map);
			model.addAttribute("msg", "레시피 수정 완료");
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "레시피 수정중 문제가 발생했습니다.");
			return "error";
		}
	}
	@ApiOperation(value = "레시피 삭제", response = String.class)
	@DeleteMapping("/recipe/{pk_article}")
	public String deleteArticle(@RequestParam Integer pk_article, Model model) throws Exception {
		try {
			articleService.deleteArticle(pk_article);
			model.addAttribute("msg", "레시피 삭제 완료");
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "레시피 삭제중 문제가 발생했습니다.");
			return "error";
		}
	}
	@ApiOperation(value = "주류 검색", response = String.class)
	@PostMapping("/alcohol/{searchtxt}")
	public List<AlcoholDto> searchAlcohol(@RequestParam String searchtxt, Model model) throws Exception {
		try {
			model.addAttribute("msg", "주류 검색 완료");
			return articleService.searchAlcohol(searchtxt);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "주류 검색중 문제가 발생했습니다.");
			return null;
		}
	}
	@ApiOperation(value = "재료 추가", response = String.class)
	@PostMapping("/ingredient")
	public String createIngredient(@RequestParam String ingredient, Model model) throws Exception {
		try {
			articleService.createIngredient(ingredient);
			articleService.createTag(ingredient,2);
			model.addAttribute("msg", "재료 추가 완료");
			model.addAttribute("msg", "태그 추가 완료");
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "재료 추가중 문제가 발생했습니다.");
			return "error";
		}
	}
	@ApiOperation(value = "재료 검색", response = String.class)
	@PostMapping("/ingredient/{searchtxt}")
	public List<IngredientDto>  searchIngredient(@RequestParam String searchtxt, Model model) throws Exception {
		try {
			model.addAttribute("msg", "재료 검색 완료");
			return articleService.searchIngredient(searchtxt);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "재료 검색중 문제가 발생했습니다.");
			return null;
		}
	}
	@ApiOperation(value = "태그 추가", response = String.class)
	@PostMapping("/tag")
	public String createTag(@RequestParam String tag, Model model) throws Exception {
		try {
			articleService.createTag(tag,3);
			model.addAttribute("msg", "태그 추가 완료");
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "태그 추가중 문제가 발생했습니다.");
			return "error";
		}
	}	
	@ApiOperation(value = "태그 검색", response = String.class)
	@PostMapping("/tag/{searchtxt}")
	public List<TagDto> searchTag(@RequestParam String searchtxt, Model model) throws Exception {
		try {
			model.addAttribute("msg", "태그 검색 완료");
			return articleService.searchTag(searchtxt);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "태그 검색중 문제가 발생했습니다.");
			return null;
		}
	}
	@ApiOperation(value = "레시피 상세", response = String.class)
	@PostMapping("/detail/{pk_article}")
	public Map<String,String> detailArticle(@RequestParam int pk_article, Model model) throws Exception {
		try {
			model.addAttribute("msg", "레시피 상세 검색 완료");
			return articleService.detailArticle(pk_article);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "레시피 상세 검색중 문제가 발생했습니다.");
			return null;
		}
	}

	
	@PostMapping("/photo")
    public String upload(@RequestParam("file") MultipartFile file) {
 
        System.out.println("파일 이름 : " + file.getOriginalFilename());
        System.out.println("파일 크기 : " + file.getSize());
        // 데이터 베이스에 정보를 저장하는 건
        // 이렇게 file의 get 메소드를 활용해 필요한 정보들을 가져오고 
        // 그걸 DTO에 담아 insert하면 된다. 
        // 간단한거니 후의 과정은 생략하고 파일로 서버에 저장하는 걸 보자면
 
        try (
                // 맥일 경우
                // FileOutputStream fos = new FileOutputStream("/tmp/" +file.getOriginalFilename());
                // 윈도우일 경우
                FileOutputStream fos = new FileOutputStream("C:/Users/Jin/Downloads/USER_SIGNUP, LOGIN, LOGOUT/backend/imgs/" + file.getOriginalFilename());
                // 파일 저장할 경로 + 파일명을 파라미터로 넣고 fileOutputStream 객체 생성하고
                InputStream is = file.getInputStream();) {
                // file로 부터 inputStream을 가져온다.
        	
	        System.out.println("파일 경로 : C:/Users/Jin/Downloads/USER_SIGNUP, LOGIN, LOGOUT/backend/imgs/" + file.getOriginalFilename());
            int readCount = 0;
            byte[] buffer = new byte[1024];
            // 파일을 읽을 크기 만큼의 buffer를 생성하고
            // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)
            
            while ((readCount = is.read(buffer)) != -1) {
                //  파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고
                
                fos.write(buffer, 0, readCount);
                // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }
 
        return "uploadok";
    }

}