package com.rei.hue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.rei.hue.controller.form.BookForm;
import com.rei.hue.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping(value = "/book/add")
	public String getAdd(BookForm form, Model model) {
		model.addAttribute("bookForm", form);
		return "book/add";
	}

	@PostMapping(value = "/book/create")
	public String postCreate(@Validated @ModelAttribute BookForm form, BindingResult result, Model model) {
		// ユニーク‐ISBNコード
		if(bookService.existsByIsbn(form.getIsbn())) {
			// エラーフィールド(isbn)、エラーコード(existsIsbn)の設定
			result.rejectValue("isbn", "existsIsbn");
		} 
	
		// エラーがあれば登録フォームを再表示させます。
		if(result.hasErrors()) {
			return getAdd(form, model);
		}
	
		// 登録処理をServiceに委譲します。
		bookService.create(form);
	
		// 検索一覧画面に遷移します。
		return "book/list";
	}	
}