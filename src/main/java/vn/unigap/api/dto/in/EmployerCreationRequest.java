package vn.unigap.api.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EmployerCreationRequest {
    @Email(message = "Email should be valid")
    @NotNull(message = "Please provide the email")
    @Size(max = 255, message = "The maximum number of characters is 255 characters ")
    private String email;
    @Size(max = 255, message = "The maximum number of characters is 255 characters ")
    @NotNull(message = "Please provide the company name")
    private String name;
    @NotNull(message = "Please provide the provinceId")
    private int provinceId;
    private String description;
    private LocalDate created_at;
    private LocalDate updated_at;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvince(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}