package com.example.webbao.controllers.orderform;

import com.example.webbao.models.orderform.OrderFormDto;
import com.example.webbao.services.orderform.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/orderform")
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;


    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return orderFormService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody OrderFormDto orderFormDto) {
        return orderFormService.create(orderFormDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody OrderFormDto orderFormDto) {
        return orderFormService.update(id, orderFormDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return orderFormService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return orderFormService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return orderFormService.findAll(searchString,pageSize,page,sortData);
    }
}
