package com.aptproject.SpringLibraryProject.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_rent_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "book_rent_seq_info", allocationSize = 1)

public class BookRentInfo extends GenericModel {
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //у одного пользователя могут быть много арент
    @JoinColumn(name = "user_id", nullable = false,
        foreignKey = @ForeignKey(name = "FK_RENT_BOOK_INFO_USER"))
    private User user;
}
