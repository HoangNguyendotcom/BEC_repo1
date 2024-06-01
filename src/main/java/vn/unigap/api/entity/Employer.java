package vn.unigap.api.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Employer {
    @Id
    @SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", initialValue = 3094562)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    @Column(name = "id")
    private long id;
    @Column(unique = true)
    private String email;
    private String name;
    private int provinceId;
    private String description;
    private LocalDate created_at;
    private LocalDate updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setProvinceId(int provinceId) {
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
