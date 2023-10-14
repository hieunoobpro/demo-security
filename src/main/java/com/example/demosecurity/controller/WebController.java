package com.example.demosecurity.controller;

import com.example.demosecurity.security.AuthenticationFacade;
import com.example.demosecurity.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class WebController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getDashboard() {
        return "Dashboard API - ADMIN, SALE";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUsers() {
        return "User Management API - ADMIN";
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateUser(@PathVariable("id") Long id) {
        return "Update User";
    }

    @GetMapping("/categories")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getCategories() {
        return "Category Management API - ADMIN, SALE";
    }

    @PostMapping("/categories")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String createCategory() {
        return "Create Category API - ADMIN, SALE";
    }

    @PutMapping("/categories/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateCategory(@PathVariable("id") Long id) {
        return "Update Category API - ADMIN, SALE";
    }

    @DeleteMapping("/categories/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String deleteCategory(@PathVariable("id") Long id) {
        return "Delete Category API - ADMIN, SALE";
    }
    @GetMapping("/product")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('SALE')")
    public String getProduct() {
        return "Get product";
    }

    @PutMapping("/product")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('SALE')")
    public String updateProfile() {
        return "Update Product API - USER";
    }

    @GetMapping("/brands")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getBrands() {
        return "Brand Management API - ADMIN, SALE";
    }

    @PostMapping("/brands")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String createBrand() {
        return "Create Brand API - ADMIN, SALE";
    }

    @PutMapping("/brands/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String updateBrand(@PathVariable("id") Long id) {
        return "Update Brand API - ADMIN, SALE";
    }

    @DeleteMapping("/brands/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String deleteBrand(@PathVariable("id") Long id) {
        return "Delete Brand API - ADMIN, SALE";
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String getOrders() {
        return "Order Management API - ADMIN, SALE";
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE')")
    public String createOrder() {
        return "Create Order API - ADMIN, SALE";
    }

    // Tương tự, định nghĩa các API khác tại đây

    @GetMapping("/posts")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String getPosts() {
        return "Post Management API - ADMIN, SALE, AUTHOR";
    }

    @PostMapping("/posts")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String createPost() {
        return "Create Post API - ADMIN, SALE, AUTHOR";
    }

    @PutMapping("/posts/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String updatePost(@PathVariable("id") Long id) {
        return "Update Post API - ADMIN, SALE, AUTHOR";
    }

    @DeleteMapping("/posts/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SALE') or hasAuthority('AUTHOR')")
    public String deletePost(@PathVariable("id") Long id) {
        return "Delete Post API - ADMIN, SALE, AUTHOR";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('USER')")
    public String getProfile() {
        return "User Profile API - USER";
    }

}
