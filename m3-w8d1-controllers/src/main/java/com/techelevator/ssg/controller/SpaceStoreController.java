package com.techelevator.ssg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.ssg.model.store.DollarAmount;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;
import com.techelevator.ssg.model.store.shoppingCartItem;

@Controller
@SessionAttributes({"shoppingCart", "grandTotalPrice"})
public class SpaceStoreController {
	
	@Autowired
	ProductDao productdao;
	
	@RequestMapping(path="/spaceStoreListView", method=RequestMethod.GET)
	public String showSpaceStoreListView(HttpServletRequest request) {
		List<Product> products = productdao.getAllProducts();
		request.setAttribute("products", products);
		return "spaceStoreListView";
	}
	
	@RequestMapping(path="/spaceStoreDetailView", method=RequestMethod.GET)
	public String showSpaceStoreDetailView(HttpServletRequest request) {
		String id = request.getParameter("productId");
		Long productId = Long.valueOf(id);
		Product product = productdao.getProductById(productId);
		
		request.setAttribute("product", product);
		return "spaceStoreDetailView";
	}
	
	@RequestMapping(path="/spaceStoreDetailView", method=RequestMethod.POST)
	public String showSpaceStoreShoppingCart(@RequestParam int quantityToBuy, @RequestParam Long productId, ModelMap map, HttpServletRequest request) {
		Product product = productdao.getProductById(productId);
		DollarAmount totalPrice = product.getPrice().multiply(quantityToBuy);
		
		
		shoppingCartItem cartItem = new shoppingCartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantityToBuy);
		cartItem.setTotalPrice(totalPrice);
		
		List<shoppingCartItem> items;
		if(map.containsKey("shoppingCart")) {
			items = (List<shoppingCartItem>)map.get("shoppingCart");
		} else {
			items = new ArrayList<shoppingCartItem>();
			
		}
		items.add(cartItem);
		
		DollarAmount grandTotalPrice = new DollarAmount(0);
		for(shoppingCartItem item : items) {
			grandTotalPrice = grandTotalPrice.plus(item.getTotalPrice());
		}
		map.addAttribute("grandTotalPrice", grandTotalPrice);
		map.addAttribute("shoppingCart", items);
		
		
		return "redirect:/spaceStoreShoppingCart";
	}
	
	@RequestMapping(path="/spaceStoreShoppingCart", method=RequestMethod.GET)
	public String showSpaceStoreShoppingCart(ModelMap map) {
		
		return "spaceStoreShoppingCart";
	}
}
