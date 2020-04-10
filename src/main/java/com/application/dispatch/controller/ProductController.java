package com.application.dispatch.controller;

import com.application.dispatch.service.CategoryService;
import com.application.dispatch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	/*@RequestMapping(value={"/customer/products"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("productListPaging");
		List<Category> categories = categoryService.getAllCategories();
        modelAndView.addObject("categories", categories);
        
        return modelAndView;
	}

	 @RequestMapping(value="/add-product", method = RequestMethod.GET)
	    public ModelAndView addProduct(){
	        ModelAndView modelAndView = new ModelAndView();
	        Product product = new Product();
	        modelAndView.addObject("product", product);
	        modelAndView.setViewName("add-product");
	        modelAndView.addObject("categories", categoryService.getAllCategories());
	        return modelAndView;
	 }
	 
	@RequestMapping(value= "/add-product", method= RequestMethod.POST)
	public ModelAndView saveProduct(@Valid Product product, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		product.setStatus(null != product && null != product.getStatus() ?
				product.getStatus() : Constants.ACTIVE);
		if(!bindingResult.hasErrors()) {
			productService.saveProduct(product);
			modelAndView.addObject("successMessage", "Product added successfully");
			modelAndView.addObject("product", new Product());
		}
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("add-product");
        
        return modelAndView;
	}
	
	@RequestMapping(value = "/product-list/page/{page}")
    public ModelAndView listProductsPageByPage(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("productList");
        PageRequest pageable = new PageRequest(page - 1, 4);
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
        
        modelAndView.addObject("products", productPage.getContent());
        return modelAndView;
    }
	
	@RequestMapping(value="/view-product/{id}", method = RequestMethod.GET)
    public ModelAndView viewProduct(@PathVariable("id") int productId){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getProductById(productId);
        modelAndView.addObject("product", product);
        
        List<Category> categories = categoryService.getAllCategories();
        modelAndView.addObject("categories", categories);
        
        modelAndView.setViewName("view-product");
        return modelAndView;
	}
	

	
	@RequestMapping(value="/edit-product/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable("id") int productId){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getProductById(productId);
        String[] statusValues = new String[] {Constants.ACTIVE, Constants.IN_ACTIVE};
		modelAndView.addObject("statusValues", Arrays.asList(statusValues));
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("update-product");
        return modelAndView;
	}
	
	@RequestMapping(value= "/update-product", method= RequestMethod.PUT)
	public ModelAndView updateProduct(@Valid Product product, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		product = productService.updateProduct(product);
        String[] statusValues = new String[] {Constants.ACTIVE, Constants.IN_ACTIVE};
		modelAndView.addObject("statusValues", Arrays.asList(statusValues));
		modelAndView.addObject("successMessage", "Product updated successfully");
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("update-product");
        
        return modelAndView;
	}*/
}
