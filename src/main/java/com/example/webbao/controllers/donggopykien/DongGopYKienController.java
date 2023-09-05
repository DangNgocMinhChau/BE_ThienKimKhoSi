package com.example.webbao.controllers.donggopykien;

import com.example.webbao.models.donggopykien.DongGopYKienDto;
import com.example.webbao.services.donggopykien.DongGopYKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlydonggopykien")
public class DongGopYKienController {

    @Autowired
    private DongGopYKienService dongGopYKienService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return dongGopYKienService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody DongGopYKienDto dongGopYKienDto) {
        return dongGopYKienService.create(dongGopYKienDto);
    }

    @PostMapping("/sendmail")
    public Map<String, Object> sendMail(@RequestParam Long id,
                                        @RequestParam String cauTraLoi
                                         ) throws MessagingException {
        return dongGopYKienService.sendMail(id,cauTraLoi);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody DongGopYKienDto dongGopYKienDto) {
        return dongGopYKienService.update(id, dongGopYKienDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return dongGopYKienService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return dongGopYKienService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return dongGopYKienService.findAll(searchString,pageSize,page,sortData);
    }
}
