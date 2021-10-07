package com.example.migration.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/cprf")
public class CprfRestController {
			
	@GetMapping("/{id}/download")
	StreamingResponseBody getSteamingFile(
			@PathVariable Long id, 
			HttpServletResponse response) throws IOException {
		/*
		if (!tokenManager.tokenIsValid(headers.get("token"))) {
			return errorHandlerBuilder.createUnauthorizedApiError()
					.build()
					.buildResponseEntity();
		}
		*/
								
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"cprf-" + id + ".pdf\"");
		//response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        //response.setHeader("Content-Disposition", "attachment; filename=\"cprf-" + id + ".docx\"");
        
        //String docx = "https://clicksign-sandbox-content.s3.amazonaws.com/2021/10/06/20/43/36/fded9767-7a84-4376-a352-dfb5979abf95/doc-1.docx?response-content-disposition=attachment&X-Amz-Expires=21601&X-Amz-Date=20211007T005038Z&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEAUaCXVzLWVhc3QtMSJGMEQCIAPCLcy85jNGUrqd%2BESOG75lCjHipvFOI8OKeqy2LG%2FiAiBV4LM3ccOx5VUTwNbEDYkkVLEQKmNSHUVc1LVi5FI23ir6Awh%2BEAEaDDc0MDY2MjI3ODc5MyIMs1VmztO5GWoywUYBKtcDnHchOUAX7qa6GZ%2FMI4BSMJSsbKN%2BdV%2F7ehcfXNncB3k0pQQn3lo%2FsmtLdtrGzKiN7GpcxaqMrb2ZlV5OdiPlPNjwXhtCrhWb%2BkBMBFFFUg15TowToiyMGX%2F%2BNX2%2F9Yg3AL7dgCI7ovyN5C%2FmpY11cFE1GQLnCnChdElVL5ssOFHAyYsQlrjeYC8NJZxQWuFVzJ71cETmrFzXjTvVzev8Aq7vy8PyZQt0XzQrGb4g7kQ%2FFKUIV6avgPq4LSI6QL5fNBYVqiPxA8pmW%2BysUacNEI3QlKe0F19WaTD5R03MfNzaq0WsAey%2FhciE0RtI58YT2iECQ8KG%2FTG3acbLZXx%2BWEthnqx2TKxPv%2Bxmld0RTpTHWKllk5ppH30TbFB1NoM6JM8%2Bms7x0gt2JRGf3Ma1r5ourEDNeuJ86Ao64r5PUZACLQLqRsByPsv0U6BTGApHcbuHhS76Q6pdLREF3YmQqvd92LCT37TKiguJrhzSo3%2FEbBMqA%2BW6fMfoVJ009nRwhRknsKQu0YndBxpZAlpIwSfbieOg%2F3zaN3TZDE60J8XxFRFnmkmJYDFVL1aMUkPTe8%2FD89ykLbGldMwFawV%2FhLt%2FZVleFL8fJqBeJEIAKsneWbBL14Z7MPSL%2BIoGOqYBbDTRGjA5HxzvLIaSlYrWyH0sWGlA2OEm5%2FBEGIaxKqIoXN0PixY4zuMRpzbypYBxWwrgvj86Wo%2Fe250XdELviVMrCvyXR29lYRWvl0fhJNvIPzp4VOkJryclA%2FJAMx4divL2YybZLaE6vKrBkKQtNjmelPUYVH7Xd9bPrkdNOV5NWSb%2FxP4XfbqMkIIqo5NEH3L90HMLkMMHWhuEz%2BWOiQ%2FxCClnpw%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIA2Y4XJPKETMBZFE43%2F20211007%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-SignedHeaders=host&X-Amz-Signature=220c6ee4f1185bac5dc4e69d35b5abe07e276d4cc9cfe0135417332171c9bfdb";
        String filePdf = "https://clicksign-sandbox-content.s3.amazonaws.com/2021/10/07/20/42/55/1e0fed50-c9ca-448b-8c3b-eadb416b3f90/doc-1.docx%20-%20Clicksign.pdf?response-content-disposition=attachment&X-Amz-Expires=21600&X-Amz-Date=20211007T204338Z&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEBwaCXVzLWVhc3QtMSJGMEQCIHnMyjFf6ia3hCkcIKQjHEY%2FwjgnA%2BThaEahB5WzEpzwAiAxvK7dX%2B8rbaHzJZ0H2JpxlMG%2Bqt5h63ZCJKII0R64LCqDBAiV%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAEaDDc0MDY2MjI3ODc5MyIMAzoc%2FtwATSTua2J8KtcDIrGPfqVDoyN%2F98tqdQtLJueuo1Mt4SQUHIQG3DCq249jhmB4Wkz688iITjSKEueA2OFi5hhdVegc%2BCKJjjCkRcAVGivEXiJL%2FYtvbTueecdkYCw3%2BP2%2B6jXvh5BLIHD0saBh3PRyqdKXkl%2BHPd5ul3nxU6i25SCAgZWRw2rbV6j4dD1EWs4%2B1BDKfTIkMXvV9qqm1PjGHRCkewcC4L%2BTpyRd0n87c%2B1t90XajmI%2FqinrdPrI9PI3GQk4fGsoL3ZHpoMlb7zp9PyeW1InG%2F3%2BcKZUMFwMPdujWNmreHzXI9tS5nXjF2AoSLEGIG3bHVPx614FgFpbVSnDfCVhR7083MfaobHhrCjcQOpexzgQL8qCiR9Y2c5J0LE%2FIwKNI%2FCmxQZgyKQIuyhSsmieVflX9IMgZvGX2%2FPVRBBU8S5O0i%2FOdsaNg%2F9CxfWp1Ia4HtigNV9bGmJxtNEtY5CKiJp3d0RksmRoLUe%2BU6AehwfCwNksSnX66Ft2GBqXn0rsTk3BUUWdWo3FS1ZVotvRvbKgQvO%2BGvL96CQgCeSFhFsGZ1dAEuTQ0GxEfA%2FdSe3HIejrEv%2FVhIYgUjL2BeaIEtrlZfVjMjiZcoY0dFcqH7tND0hd8HKiDR7IMMGS%2FYoGOqYB39paJq0NYKeo69ztddCLHBh6k2kFy3JvgKuU94WRmaGHau4oFr8FMR09PZR84i7BQ5jE0%2Ffj86tK8tg%2BsdIO%2FIEzGXSMc62cw97IqXWlqL6OGjriauVc%2BULn4iMQY9S5BlavRNAdtLj5YNVjKeXuoBQBw7ScWvb1Ct2BZvpw3aTptNs4e9fZNZrxu0no6YtqDOTSFDGfx5sxYNnUUvi7oHKqp7Uchg%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIA2Y4XJPKEXTYQMHIH%2F20211007%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-SignedHeaders=host&X-Amz-Signature=463ec4c0f4f4203ce78ff8fdf0881f1af31a77d4566d0920495f78ba273ea20c";
		
		
        InputStream inputStream = new URL(filePdf).openStream();
                
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };       		
	}
}
