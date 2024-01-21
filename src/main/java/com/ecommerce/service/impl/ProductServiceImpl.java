package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		// Generate random product Id
		String productId = UUID.randomUUID().toString();
		productDto.setProductId(productId);
		// Added Date
		productDto.setAddedDate(new Date());
		// productDto to Entity
		Product product = mapper.map(productDto, Product.class);
		// save product
		Product savedProduct = productRepository.save(product);
		return mapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(String productId, ProductDto productDto) {
		// Get product By Id
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found By Given Id !!"));
		product.setTitle(productDto.getTitle());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		Product updatedProduct = productRepository.save(product);
		return mapper.map(updatedProduct, ProductDto.class);
	}

	@Override
	public void deleteProduct(String productId) {
		// Get product By Id
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found By Given Id !!"));
		productRepository.delete(product);

	}

	@Override
	public ProductDto getById(String productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found By Given Id !!"));
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAll() {
		List<Product> prouducts = productRepository.findAll();
		List<ProductDto> productDtos=new ArrayList<>();
		for(Product product:prouducts) {
			productDtos.add(mapper.map(product, ProductDto.class));
		}
		return productDtos;
	}

	@Override
	public List<ProductDto> searchByTiltle(String title) {
		List<Product> products = productRepository.findByTitleContaining(title);
		List<ProductDto> productDtos=new ArrayList<>();
		for(Product product:products) {
			productDtos.add(mapper.map(product, ProductDto.class));	
		}
		return productDtos;
	}

}
