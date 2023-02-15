package com.promineotech.jeep.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/jeeps")
@ComponentScan("com.promineotech.jeep.controller")

public class BasicJeepSalesController implements JeepSalesController {

  @Autowired
  private JeepSalesService jeepSalesService;

  @Override
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<Jeep> fetchJeepList(@RequestParam(required = false) String model,
      @RequestParam(required = false) String trim) {
    log.debug("model={}, trim={}", model, trim);
    return jeepSalesService.fetchJeeps(model, trim);
  }

}
