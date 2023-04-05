package br.com.puc.oneracao.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Objeto de transporte para o envio de um cliente.")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "CPF do Beneficiário")
    @NotNull(message = "Informar o CPF.")
    @JsonProperty(value = "nrCpf")
    private Long numeroCpf;

    @NotNull(message = "Informar o código do banco de destino.")
    @Schema(description = "Código do banco destino")
    @JsonProperty(value = "nrAgencia")
    private Long numeroAgencia;

    @NotNull(message = "Informar a agência de destino.")
    @Schema(description = "Agência de destino")
    @JsonProperty(value = "nrConta")
    private Integer numeroConta;

    @NotNull(message = "Informar a conta de destino.")
    @Schema(description = "Conta de destino")
    @JsonProperty(value = "digito")
    private Integer digitoConta;

    @NotNull(message = "Informar o nome do Favorecido.")
    @Schema(description = "Nome do Favorecido")
    @JsonProperty(value = "nmTitular")
    private String nomeTitularConta;

}