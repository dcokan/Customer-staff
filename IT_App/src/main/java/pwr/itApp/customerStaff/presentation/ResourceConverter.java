package pwr.itApp.customerStaff.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ResourcesService;

@FacesConverter("resourceConverter")
public class ResourceConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ResourcesService service = (ResourcesService) fc.getExternalContext().getApplicationMap().get(ResourcesService.class);
                return service.getResourceById(Integer.parseInt(value));
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
