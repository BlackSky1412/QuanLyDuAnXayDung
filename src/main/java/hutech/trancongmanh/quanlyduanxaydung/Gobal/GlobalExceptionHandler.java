package hutech.trancongmanh.quanlyduanxaydung.Gobal;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SizeLimitExceededException.class)
    public ModelAndView handleSizeLimitExceeded(SizeLimitExceededException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", "File size exceeds the allowed limit.");
        return modelAndView;
    }
}
