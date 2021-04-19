package com.quizz.evaluacion.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class QuizErrorController implements ErrorController {

  @GetMapping("/error")
  public String handleError(Model model, HttpServletRequest httpRequest){
    Object status = httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    String message = "Algo salió mal. Inténte de nuevo por favor";
    if(status != null){
      int errorCode = Integer.parseInt(status.toString());
      //log.info("Errorcode "+errorCode );
      switch (errorCode){
        case 403 : message = "Acceso denegado al recurso"; break;
        case 404 : message = "Recurso no encontrado"; break;
      }
    }
    model.addAttribute("msg", message);
    return "error";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
