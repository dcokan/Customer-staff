package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ResourcesService;

@Component("resourceConverter")
@Scope("view")
public class ResourceConverter implements Converter, Serializable{

	private static final long serialVersionUID = -8599547038209938495L;
	@Autowired
	private ResourcesService resourceService;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	return resourceService.getResourceById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		return obj == null ? null : String.valueOf(((ResourceDTO)obj).getId());
	}

}
