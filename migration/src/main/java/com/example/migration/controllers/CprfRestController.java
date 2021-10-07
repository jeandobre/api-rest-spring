package com.example.migration.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/cprf")
public class CprfRestController {
	
	@Autowired
	DocxToPdfConverter converter;
		
	@GetMapping("/{id}/download")
	StreamingResponseBody getSteamingFile(
			@PathVariable Long id, 
			HttpServletResponse response) throws IOException {
		/*
		if (!tokenManager.tokenIsValid(headers.get("token"))) {
			return errorHandlerBuilder.createUnauthorizedApiError()
					.build()
					.buildResponseEntity();
		}*/
				
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"cprf-" + id + ".pdf\"");
		//response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        //response.setHeader("Content-Disposition", "attachment; filename=\"cprf-" + id + ".docx\"");
        
        String file = "https://clicksign-sandbox-content.s3.amazonaws.com/2021/10/06/20/43/36/fded9767-7a84-4376-a352-dfb5979abf95/doc-1.docx?response-content-disposition=attachment&X-Amz-Expires=21601&X-Amz-Date=20211007T005038Z&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEAUaCXVzLWVhc3QtMSJGMEQCIAPCLcy85jNGUrqd%2BESOG75lCjHipvFOI8OKeqy2LG%2FiAiBV4LM3ccOx5VUTwNbEDYkkVLEQKmNSHUVc1LVi5FI23ir6Awh%2BEAEaDDc0MDY2MjI3ODc5MyIMs1VmztO5GWoywUYBKtcDnHchOUAX7qa6GZ%2FMI4BSMJSsbKN%2BdV%2F7ehcfXNncB3k0pQQn3lo%2FsmtLdtrGzKiN7GpcxaqMrb2ZlV5OdiPlPNjwXhtCrhWb%2BkBMBFFFUg15TowToiyMGX%2F%2BNX2%2F9Yg3AL7dgCI7ovyN5C%2FmpY11cFE1GQLnCnChdElVL5ssOFHAyYsQlrjeYC8NJZxQWuFVzJ71cETmrFzXjTvVzev8Aq7vy8PyZQt0XzQrGb4g7kQ%2FFKUIV6avgPq4LSI6QL5fNBYVqiPxA8pmW%2BysUacNEI3QlKe0F19WaTD5R03MfNzaq0WsAey%2FhciE0RtI58YT2iECQ8KG%2FTG3acbLZXx%2BWEthnqx2TKxPv%2Bxmld0RTpTHWKllk5ppH30TbFB1NoM6JM8%2Bms7x0gt2JRGf3Ma1r5ourEDNeuJ86Ao64r5PUZACLQLqRsByPsv0U6BTGApHcbuHhS76Q6pdLREF3YmQqvd92LCT37TKiguJrhzSo3%2FEbBMqA%2BW6fMfoVJ009nRwhRknsKQu0YndBxpZAlpIwSfbieOg%2F3zaN3TZDE60J8XxFRFnmkmJYDFVL1aMUkPTe8%2FD89ykLbGldMwFawV%2FhLt%2FZVleFL8fJqBeJEIAKsneWbBL14Z7MPSL%2BIoGOqYBbDTRGjA5HxzvLIaSlYrWyH0sWGlA2OEm5%2FBEGIaxKqIoXN0PixY4zuMRpzbypYBxWwrgvj86Wo%2Fe250XdELviVMrCvyXR29lYRWvl0fhJNvIPzp4VOkJryclA%2FJAMx4divL2YybZLaE6vKrBkKQtNjmelPUYVH7Xd9bPrkdNOV5NWSb%2FxP4XfbqMkIIqo5NEH3L90HMLkMMHWhuEz%2BWOiQ%2FxCClnpw%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIA2Y4XJPKETMBZFE43%2F20211007%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-SignedHeaders=host&X-Amz-Signature=220c6ee4f1185bac5dc4e69d35b5abe07e276d4cc9cfe0135417332171c9bfdb";
        
        InputStream inputStream = new URL(file).openStream();
        
        OutputStream out = converter.convertToPDFFromInputStream(inputStream);
        /*
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };*/
        
        return outputStream -> {
        	outputStream = out;
        };
		
	}

}
