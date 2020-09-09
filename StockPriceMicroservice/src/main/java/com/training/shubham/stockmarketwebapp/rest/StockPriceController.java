package com.training.shubham.stockmarketwebapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.training.shubham.stockmarketwebapp.service.ExcelHelper;
import com.training.shubham.stockmarketwebapp.service.StockPriceService;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {

	@Autowired
	private StockPriceService stockPriceService;

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ExcelHelper.hasExcelFormat(file)) {

			stockPriceService.save(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(message);

		}

		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
}
