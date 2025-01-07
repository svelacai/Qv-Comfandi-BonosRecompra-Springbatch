package com.comfandi.bono.recompra.batch.util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.bonos.repository.ICampaingsRepository;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
@Converter
public class UUIDToCampaignConverter implements AttributeConverter<UUID, Campaings> {
	@Autowired
	private ICampaingsRepository iCampaingsRepository;

	@Override
	public Campaings convertToDatabaseColumn(UUID uuid) {
	       if (uuid == null) {
	            return null;
	        }
	        Suponiendo que Campaign tiene un método para buscar por ID
	        return iCampaingsRepository.findCampaignById(uuid);
	}

	@Override
	public UUID convertToEntityAttribute(Campaings campaing) {
	    return campaing != null ? campaing.getId() : null;
	}

}*/
