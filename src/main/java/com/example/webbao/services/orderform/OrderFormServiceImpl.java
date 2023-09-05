package com.example.webbao.services.orderform;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.models.lienhequangcao.LienHeQuangCaoDto;
import com.example.webbao.models.orderform.OrderForm;
import com.example.webbao.models.orderform.OrderFormDto;
import com.example.webbao.repositorys.orderform.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    OrderFormRepository orderFormRepository;

    @Autowired
    OrderFormDao orderFormDao;

    @Override
    public OrderForm findById(Long id) {
        return orderFormRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(OrderFormDto orderFormDto) {
        Map<String, Object> result = new HashMap<>();
        OrderFormDto resultCreate = new OrderFormDto();
        try {
            OrderForm orderForm = new OrderForm();
            orderForm.setUrl(orderFormDto.getUrl());
            orderForm.setApi(orderFormDto.getApi());
            orderForm.setFormName(orderFormDto.getFormName());
            orderForm.setTypeForms(orderFormDto.getTypeForms());
            orderForm.setNotes(orderFormDto.getNotes());
            orderForm.setFormMapping(orderFormDto.getFormMapping());

            orderForm.setNgayTaoBanGhi(orderFormDto.getNgayTaoBanGhi());
            orderForm.setFlag(true);
            orderFormRepository.save(orderForm);

            resultCreate.setUrl(orderFormDto.getUrl());
            resultCreate.setApi(orderFormDto.getApi());
            resultCreate.setFormName(orderFormDto.getFormName());
            resultCreate.setTypeForms(orderFormDto.getTypeForms());
            resultCreate.setNotes(orderFormDto.getNotes());
            resultCreate.setFormMapping(orderFormDto.getFormMapping());

            result.put("result", resultCreate);
            result.put("msg", "Đã gửi thông tin thành công");
            result.put("status", true);

        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, OrderFormDto orderFormDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            OrderForm object = orderFormRepository.findById(id).get();
            object.setId(orderFormDto.getId() != null ? orderFormDto.getId() : object.getId());
            object.setUrl(orderFormDto.getUrl() != null ? orderFormDto.getUrl() : object.getUrl());
            object.setApi(orderFormDto.getApi() != null ? orderFormDto.getApi() : object.getApi());
            object.setFormName(orderFormDto.getFormName() != null ? orderFormDto.getFormName() : object.getFormName());
            object.setTypeForms(orderFormDto.getTypeForms() != null ? orderFormDto.getTypeForms() : object.getTypeForms());
            object.setNotes(orderFormDto.getNotes() != null ? orderFormDto.getNotes() : object.getNotes());
            object.setFormMapping(orderFormDto.getFormMapping() != null ? orderFormDto.getFormMapping() : object.getFormMapping());
            object.setNgayChinhSua(orderFormDto.getNgayChinhSua());
            orderFormRepository.save(object);
            result.put("result", object);
            result.put("msg", "Sửa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Sửa thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        OrderForm orderForm = orderFormRepository.findById(id).orElse(null);
        OrderFormDto orderFormDto = new OrderFormDto();
        try {
            if (orderForm != null) {
                orderFormDto.setId(orderForm.getId());
                orderFormDto.setUrl(orderForm.getUrl());
                orderFormDto.setApi(orderForm.getApi());
                orderFormDto.setFormName(orderForm.getFormName());
                orderFormDto.setTypeForms(orderForm.getTypeForms());
                orderFormDto.setNotes(orderForm.getNotes());
                orderFormDto.setFormMapping(orderForm.getFormMapping());
                result.put("result", orderFormDto);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrderForm> list = orderFormRepository.findAll();
            List<OrderFormDto> listDto = new ArrayList<>();
            for (OrderForm orderForm : list) {
                OrderFormDto orderFormDto = new OrderFormDto();
                orderFormDto.setId(orderForm.getId());
                orderFormDto.setUrl(orderForm.getUrl());
                orderFormDto.setApi(orderForm.getApi());
                orderFormDto.setFormName(orderForm.getFormName());
                orderFormDto.setTypeForms(orderForm.getTypeForms());
                orderFormDto.setNotes(orderForm.getNotes());
                orderFormDto.setFormMapping(orderForm.getFormMapping());

                if (orderForm.getFlag()) {
                    listDto.add(orderFormDto);
                }
            }
            result.put("result", listDto);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }


    @Override
    public Map<String, Object> delete(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            OrderForm orderForm = orderFormRepository.findById(listIds[i]).orElse(null);
            orderForm.setFlag(false);
            orderFormRepository.save(orderForm);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrderForm> listId= new ArrayList<>();
            for (Long id : listIds) {
                Optional<OrderForm> listOptional = orderFormRepository.findById(id);
                if (listOptional.isPresent()) {
                    listId.add(listOptional.get());
                }
            }
            result.put("msg", "Xóa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Xóa thất bại !");
            result.put("status", false);
        }
        return result;
    }
    @Override
    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            if (sortData == null) {
                sortData = "id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null) {
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page, pageSize, orderFormDao.count(searchString)));
            }

            List<OrderForm> list = orderFormDao.getList(searchString, pageable, sortData);
            List<OrderFormDto> listDto = new ArrayList<OrderFormDto>();
            for (OrderForm orderForm : list) {
                OrderFormDto orderFormDto = new OrderFormDto();
                orderFormDto.setId(orderForm.getId());
                orderFormDto.setUrl(orderForm.getUrl());
                orderFormDto.setApi(orderForm.getApi());
                orderFormDto.setFormName(orderForm.getFormName());
                orderFormDto.setTypeForms(orderForm.getTypeForms());
                orderFormDto.setNotes(orderForm.getNotes());
                orderFormDto.setFormMapping(orderForm.getFormMapping());

                listDto.add(orderFormDto);
            }
            mapResult.put("result", listDto);
            mapResult.put("status", true);
            mapResult.put("msg", "Lấy danh sách thành công !");

        } catch (Exception e) {
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("status", false);
            mapResult.put("msg", "Lấy danh sách thất bại");
        }
        return mapResult;
    }
}
