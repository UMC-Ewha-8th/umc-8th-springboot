package yooni.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import yooni.spring.domain.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Region extends BaseEntity {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<Store> storeList;
}
