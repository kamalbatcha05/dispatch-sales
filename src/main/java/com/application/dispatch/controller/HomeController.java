package com.application.dispatch.controller;

import com.application.dispatch.service.CategoryService;
import com.application.dispatch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	/*@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView home() {
		*//*ModelAndView modelAndView = new ModelAndView("productListPaging");
        PageRequest pageable = new PageRequest(0, 9);
        Page<Product> productPage = productService.getPaginatedProducts(pageable);
        
        
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed()
            		.collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
            modelAndView.addObject("lastPageNumber", pageNumbers.get(pageNumbers.size() - 1));
        }
        modelAndView.addObject("activeProductList", true);
        modelAndView.addObject("currentPageNumber", 1);
        modelAndView.addObject("productList", productPage.getContent());*//*
		ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
	}
	
	@RequestMapping(value={"/customer/contact-us"}, method = RequestMethod.GET)
	public ModelAndView viewContactUs() {
		ModelAndView modelAndView = new ModelAndView("contact-us");
        return modelAndView;
	}
	
	@RequestMapping(value={"/customer/company-profile"}, method = RequestMethod.GET)
	public ModelAndView viewCompanyProfile() {
		ModelAndView modelAndView = new ModelAndView("company-profile");
        modelAndView.addObject("categories", categoryService.getAllCategories());
        return modelAndView;
	}
	
	@RequestMapping(value = "	{page}")
    public ModelAndView listProductsPageByPage(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("productListPaging");
        PageRequest pageable = new PageRequest(page - 1, 9);
        Page<Product> productPage = productService.getPaginatedProducts(pageable);
        
        
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed()
            		.collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
            modelAndView.addObject("lastPageNumber", pageNumbers.get(pageNumbers.size() - 1));
        }
        modelAndView.addObject("activeProductList", true);
        modelAndView.addObject("currentPageNumber", page);
        modelAndView.addObject("productList", productPage.getContent());
        return modelAndView;
    }*/
	
}
