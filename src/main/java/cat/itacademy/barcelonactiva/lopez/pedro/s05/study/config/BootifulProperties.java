package cat.itacademy.barcelonactiva.lopez.pedro.s05.study.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("bootiful")
public class BootifulProperties {
    private String message;
}
