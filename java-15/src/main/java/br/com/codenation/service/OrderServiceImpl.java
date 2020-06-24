package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    /**
     * Calculate the sum of all OrderItems
     */
    @Override
    public Double calculateOrderValue(List<OrderItem> items) {

        Double valor = items.stream()
                .mapToDouble(o -> productRepository.findById(o.getProductId())
                        .map(p -> p.getIsSale() ? (p.getValue() * 0.8) : p.getValue())
                        .orElse(0.0) * o.getQuantity())
                .sum();

        return valor;

    }

    /**
     * Map from idProduct List to Product Set
     */
    @Override
    public Set<Product> findProductsById(List<Long> ids) {

        return ids.stream().map(i -> productRepository.findById(i))
                .filter(p -> p.isPresent())
                .map(p -> p.get())
                .collect(Collectors.toSet());
    }

    /**
     * Calculate the sum of all Orders(List<OrderIten>)
     */
    @Override
    public Double calculateMultipleOrders(List<List<OrderItem>> orders) {

        Double total = orders.stream().mapToDouble(o -> calculateOrderValue(o))
                .sum();

        return total;
    }

    /**
     * Group products using isSale attribute as the map key
     */
    @Override
    public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
        return this.findProductsById(productIds).stream()
                .collect(Collectors.groupingBy(p -> p.getIsSale()));

    }

}