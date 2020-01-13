package br.com.lojasrenner.infrastructure.entity;


import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString
public class Price {
    @Id
    private int productId;
    private String description;
    private String diff;
    private String diffDesc;
    private BigDecimal priceInit;
    private BigDecimal priceLiquid;
    private BigDecimal priceRegular;
    private BigDecimal priceUnity;
    private Boolean settled;
    private BigDecimal sku;
}

