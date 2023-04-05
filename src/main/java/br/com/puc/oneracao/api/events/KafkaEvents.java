package br.com.puc.oneracao.api.events;

import br.com.puc.oneracao.api.request.Cliente;

public interface KafkaEvents {

    void enviarParaFilaClient(Cliente cliente);

}
