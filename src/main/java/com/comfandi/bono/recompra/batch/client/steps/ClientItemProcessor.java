package com.comfandi.bono.recompra.batch.client.steps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.client.enties.Client;



public class ClientItemProcessor implements ItemProcessor<Client, Client> {
    @Override
    public Client process(Client item) throws Exception {
        // Lógica de procesamiento
        return item;
    }
}
