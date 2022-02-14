package com.rei.hue.controller.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookForm implements Serializable {

	private int id;

	@Size(min=1, max=100)
	private String name;

	@Pattern(regexp = "^[0-9]{13}$")
	private String isbn;

	private String description;

	@Size(max=100)
	private String publisher;

	@NotNull
	@Min(0)
	private Integer price;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publication_date;

	private int version;
}