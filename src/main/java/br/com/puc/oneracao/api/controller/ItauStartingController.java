package br.com.puc.oneracao.api.controller;

import br.com.puc.oneracao.api.request.Cliente;
import br.com.puc.oneracao.api.events.KafkaEvents;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/oneracao")
@Tag(name = "/oneracao", description = "API para recepção de payload")
public class ItauStartingController {

    private static final Logger LOG = Logger.getLogger(ItauStartingController.class);

    @Inject
    KafkaEvents kafkaEvents;

    @Operation(description = "API responsável por enviar cliente para o kafka")
    @APIResponses(value = {@APIResponse(responseCode = "201", description = "Retorno OK com a transação criada."),
            @APIResponse(responseCode = "404", description = "Recurso não encontrado"),
            @APIResponse(responseCode = "500", description = "Erro interno, falha ao conectar na aplicação.")})
    @POST
    @Path("/enviar-mensagem")
    @Consumes(MediaType.APPLICATION_JSON)
    public void enviarParaConsumidor(@RequestBody @Valid Cliente cliente) {
        LOG.info("Iniciou a chamada para o puc-producer. " + cliente);
        kafkaEvents.enviarParaFilaClient(cliente);
    }

}