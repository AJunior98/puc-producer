package br.com.puc.oneracao.api.events.impl;

import br.com.puc.oneracao.api.request.Cliente;
import br.com.puc.oneracao.api.events.KafkaEvents;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaEventsImpl implements KafkaEvents {

    private static final Logger LOG = Logger.getLogger(KafkaEventsImpl.class);

    @Inject
    @Channel("cliente")
    Emitter<Cliente> clienteEmitter;

    @Override
    public void enviarParaFilaClient(Cliente clienteRequest) {
        LOG.info("Enviado para fila!");
        clienteEmitter.send(Message.of(clienteRequest));
    }

}