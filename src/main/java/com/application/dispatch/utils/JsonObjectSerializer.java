package com.application.dispatch.utils;

import com.application.dispatch.entity.Category;
import com.application.dispatch.entity.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class JsonObjectSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object obj, JsonGenerator jgen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {


        jgen.writeStartObject();
        if(obj instanceof Category) {
        	Category category = (Category) obj;
        	jgen.writeNumberField("id", category.getId());
        	jgen.writeStringField("categoryName", category.getCategoryName());
        }
        
        // Iterator for collection of object
        if(obj instanceof Set) {
        	Iterator itr = ((Set) obj).iterator();
            while (itr.hasNext()) {
            	Object itrObject = itr.next();
            	Product product = (Product) itrObject;
				jgen.writeNumberField("id", product.getId());
				jgen.writeStringField("productName", product.getProductName());
            	
            }
        }
        
        jgen.writeEndObject();
		
	}

}
